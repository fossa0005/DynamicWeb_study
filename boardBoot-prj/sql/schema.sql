CREATE DATABASE BoardPRJ;

use BoardPRJ;

DROP TABLE board;
DROP TABLE member;


CREATE TABLE member (
    member_id int NOT NULL AUTO_INCREMENT PRIMARY KEY,
    id VARCHAR(100) NOT NULL,
    pw VARCHAR(255) NOT NULL
);

CREATE TABLE board (
    no INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(200) NOT NULL,
    content VARCHAR(200) NOT NULL,
    member_id INT NOT NULL,
    reg_date datetime NOT NULL DEFAULT CURRENT_TIMESTAMP,
    view_cnt INT NOT NULL DEFAULT 0
);

ALTER TABLE Board ADD CONSTRAINT fk_board_member 
FOREIGN KEY (member_id) REFERENCES member(member_id);



INSERT member (id, pw) VALUES ("admin", 1111);
INSERT member (id, pw) VALUES ("maria", 1111);
INSERT member (id, pw) VALUES ("fossa", 1111);

INSERT board (title, content, member_id) VALUES ("1빠", "1빠임", 2);
INSERT board (title, content, member_id) VALUES ("2빠", "2빠임", 3);
INSERT board (title, content, member_id) VALUES ("공지", "공지입니다", 1);
