import java.io.*;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.util.*;

/**
 * 배틀싸피 After 버전 — 원본 Python 코드의 한글 주석을 Java 구조에 맞게 옮긴 코드.
 * 원본의 동작 방식과 명령어를 유지합니다.
 */
public class BattleSSAFYAfter {
    //////////////////////////////
    // 메인 프로그램 통신 변수 정의
    //////////////////////////////
    static final String HOST = "127.0.0.1";
    static final int PORT = 8747;
    static final String NICKNAME = "기본코드";
    static final String START_SYMBOL = "M";
    static final String TARGET_SYMBOL = "X";
    static final String WALL_SYMBOL = "R";
    static final String WATER_SYMBOL = "W";

    // 경로 탐색 변수 정의: 오른쪽, 아래, 왼쪽, 위 순서
    static final int[][] DIRS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    static final String[] MOVE_CMDS = {"R A", "D A", "L A", "U A"};
    static final String[] FIRE_CMDS = {"R F", "D F", "L F", "U F"};

    // 소켓 통신에 사용하는 변수
    static Socket socket;
    static InputStream in;
    static OutputStream out;
    static String argsPrefix = "";
    static String gameData;
    //////////////////////////////
    // 입력 데이터 변수 정의
    //////////////////////////////
    // 맵 정보. 예) mapData[0][1] : [0, 1]의 지형/지물
    static String[][] mapData = new String[0][0];
    // 아군 정보. 예) myAllies.get("M") : 플레이어 본인의 정보
    static final Map<String, List<String>> myAllies = new LinkedHashMap<>();
    // 적군 정보. 예) enemies.get("X") : 적 포탑의 정보
    static final Map<String, List<String>> enemies = new LinkedHashMap<>();
    // 주어진 암호문. 예) codes.get(0) : 첫 번째 암호문
    static final List<String> codes = new ArrayList<>();

    //////////////////////////////
    // 메인 프로그램 통신 함수 정의
    //////////////////////////////

    // 메인 프로그램 연결 및 초기화
    static String init(String nickname) {
        try {
            System.out.println("[STATUS] Trying to connect to " + HOST + ":" + PORT + "...");
            socket = new Socket(HOST, PORT);
            in = socket.getInputStream();
            out = socket.getOutputStream();
            System.out.println("[STATUS] Connected");
            return submit("INIT " + nickname);
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to connect. Check whether the game is waiting for connection.");
            e.printStackTrace();
            return null;
        }
    }

    // 메인 프로그램으로 데이터(명령어) 전송
    static String submit(String command) {
        try {
            byte[] data = (argsPrefix + command + " ").getBytes(StandardCharsets.UTF_8);
            out.write(data);
            out.flush();
            return receive();
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to send data: " + e.getMessage());
            return null;
        }
    }

    // 메인 프로그램으로부터 데이터 수신
    static String receive() {
        try {
            byte[] buffer = new byte[1024]; // matches the original Python recv(1024)
            int length = in.read(buffer);
            if (length <= 0) return null;
            String data = new String(buffer, 0, length, StandardCharsets.UTF_8);
            if (!data.isEmpty() && Character.isDigit(data.charAt(0)) && data.charAt(0) != '0') {
                return data;
            }
            System.out.println("[STATUS] No receive data from the main program.");
            return null;
        } catch (IOException e) {
            System.err.println("[ERROR] Failed to receive data: " + e.getMessage());
            return null;
        }
    }

    // 연결 해제
    static void close() {
        try {
            if (socket != null) socket.close();
            System.out.println("[STATUS] Connection closed");
        } catch (IOException e) {
            System.err.println("[ERROR] Network connection has been corrupted.");
        }
    }

    //////////////////////////////
    // 입력 데이터 파싱
    //////////////////////////////

    // 입력 데이터를 파싱하여 각각의 배열/맵/리스트에 저장
    static void parseData(String raw) {
        // 입력 데이터를 행으로 나누기
        String[] lines = raw.split("\\r?\\n");
        int index = 0;
        // 첫 번째 행 데이터 읽기
        String[] header = lines[index++].trim().split("\\s+");
        // 맵의 세로 크기
        int height = Integer.parseInt(header[0]);
        // 맵의 가로 크기
        int width = Integer.parseInt(header[1]);
        // 아군의 수
        int allyCount = Integer.parseInt(header[2]);
        // 적군의 수
        int enemyCount = Integer.parseInt(header[3]);
        // 암호문의 수
        int codeCount = Integer.parseInt(header[4]);

        // 기존의 맵 정보를 초기화하고 다시 읽어오기
        mapData = new String[height][width];
        for (int r = 0; r < height; r++) {
            String[] cells = lines[index++].trim().split("\\s+");
            System.arraycopy(cells, 0, mapData[r], 0, width);
        }
        // 기존의 아군 정보를 초기화하고 다시 읽어오기
        myAllies.clear();
        for (int i = 0; i < allyCount; i++) {
            String[] tokens = lines[index++].trim().split("\\s+");
            myAllies.put(tokens[0], Arrays.asList(tokens).subList(1, tokens.length));
        }
        // 기존의 적군 정보를 초기화하고 다시 읽어오기
        enemies.clear();
        for (int i = 0; i < enemyCount; i++) {
            String[] tokens = lines[index++].trim().split("\\s+");
            enemies.put(tokens[0], Arrays.asList(tokens).subList(1, tokens.length));
        }
        // 기존의 암호문 정보를 초기화하고 다시 읽어오기
        codes.clear();
        for (int i = 0; i < codeCount; i++) codes.add(lines[index++]);
    }

    // 파싱한 데이터를 화면에 출력
    static void printData() {
        System.out.println("\\n----------입력 데이터----------\\n" + gameData + "\\n----------------------------");
        System.out.println("[맵 정보] (" + mapData.length + " x " + mapData[0].length + ")");
        for (String[] row : mapData) System.out.println(String.join(" ", row));
        System.out.println("[아군 정보] (아군 수: " + myAllies.size() + ")");
        for (Map.Entry<String, List<String>> e : myAllies.entrySet())
            System.out.println(e.getKey() + " : " + e.getValue());
        System.out.println("[적군 정보] (적군 수: " + enemies.size() + ")");
        for (Map.Entry<String, List<String>> e : enemies.entrySet())
            System.out.println(e.getKey() + " : " + e.getValue());
        System.out.println("[암호문 정보] (암호문 수: " + codes.size() + ")");
        for (String code : codes) System.out.println(code);
    }

    ///////////////////////////////////
    // 알고리즘 함수/메서드 부분 구현 시작
    ///////////////////////////////////

    // 출발지와 목적지의 위치 찾기 (심볼을 입력받아 해당 좌표를 반환)
    static int[] findPosition(String symbol) {
        for (int r = 0; r < mapData.length; r++)
            for (int c = 0; c < mapData[r].length; c++)
                if (symbol.equals(mapData[r][c])) return new int[]{r, c};
        return null;
    }

    // BFS 큐에 저장할 좌표 및 해당 좌표까지의 행동 기록
    static class Node {
        int row, col;
        List<String> actions;
        Node(int row, int col, List<String> actions) {
            this.row = row;
            this.col = col;
            this.actions = actions;
        }
    }

    // 경로 탐색 알고리즘
    // 적 포탑 X의 바로 옆에 도달하면 해당 방향으로 발사 명령을 반환
    // 바위(R)와 물(W)을 지나갈 수 없는 지형으로 취급
    static List<String> bfs(int[] start, int[] target) {
        int rows = mapData.length;
        int cols = mapData[0].length;
        boolean[][] visited = new boolean[rows][cols];
        // BFS 시작점 등록 및 방문 표시
        Queue<Node> queue = new ArrayDeque<>();
        queue.offer(new Node(start[0], start[1], new ArrayList<>()));
        visited[start[0]][start[1]] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            // 현재 위치에 인접한 칸이 목적지라면 이동 대신 발사
            for (int d = 0; d < 4; d++) {
                int nr = cur.row + DIRS[d][0];
                int nc = cur.col + DIRS[d][1];
                if (nr == target[0] && nc == target[1]) {
                    List<String> result = new ArrayList<>(cur.actions);
                    result.add(FIRE_CMDS[d]);
                    return result;
                }
            }
            // 상하좌우 이동 가능한 칸을 탐색하여 큐에 추가
            for (int d = 0; d < 4; d++) {
                int nr = cur.row + DIRS[d][0];
                int nc = cur.col + DIRS[d][1];
                if (nr < 0 || nr >= rows || nc < 0 || nc >= cols) continue;
                if (visited[nr][nc] || WALL_SYMBOL.equals(mapData[nr][nc])  || WATER_SYMBOL.equals(mapData[nr][nc])) continue;
                visited[nr][nc] = true;
                List<String> nextActions = new ArrayList<>(cur.actions);
                nextActions.add(MOVE_CMDS[d]);
                queue.offer(new Node(nr, nc, nextActions));
            }
        }
        return new ArrayList<>();
    }

    ///////////////////////////////////
    // 알고리즘 함수/메서드 부분 구현 끝
    ///////////////////////////////////

    public static void main(String[] args) {
        // Python의 sys.argv[1]에 대응하는 선택적 실행 인자
        if (args.length > 0) argsPrefix = args[0];
        try {
            //////////////////////////////
            // 닉네임 설정 및 최초 연결
            //////////////////////////////
            gameData = init(NICKNAME);
            if (gameData == null) return;
            // 최초 데이터 파싱
            parseData(gameData);
            // 출발지점, 목표지점의 위치 확인
            int[] start = findPosition(START_SYMBOL);
            int[] target = findPosition(TARGET_SYMBOL);
            if (start == null || target == null) {
                System.err.println("[ERROR] Start or target not found in map");
                return;
            }
            // 최초 경로 탐색
            List<String> actions = bfs(start, target);
            // 반복문: 메인 프로그램 <-> 클라이언트 간 순차 데이터 송수신(동기 처리)
            while (gameData != null) {
                ///////////////////////////////////
                // 알고리즘 메인 부분 구현 시작
                ///////////////////////////////////
                // 파싱한 데이터를 화면에 출력하여 확인
                printData();
                // 이전 경로 탐색 결과가 존재하지 않을 경우 다시 탐색
                if (actions.isEmpty()) {
                    start = findPosition(START_SYMBOL);
                    target = findPosition(TARGET_SYMBOL);
                    actions = start != null && target != null ? bfs(start, target) : new ArrayList<>();
                }
                // 탱크를 제어할 명령어를 output에 저장 (문자열)
                String output = actions.isEmpty() ? "A" : actions.remove(0);
                // 메인 프로그램에서 명령을 처리할 수 있도록 submit()으로 전송
                gameData = submit(output);
                // submit()의 반환값으로 받은 갱신된 데이터를 다시 파싱
                if (gameData != null) parseData(gameData);
                ///////////////////////////////////
                // 알고리즘 메인 구현 끝
                ///////////////////////////////////
            }
        } catch (RuntimeException e) {
            System.err.println("[ERROR] Invalid game data: " + e.getMessage());
            e.printStackTrace();
        } finally {
            // 반복문을 빠져나왔을 때 연결을 완전히 해제
            close();
        }
    }
}
