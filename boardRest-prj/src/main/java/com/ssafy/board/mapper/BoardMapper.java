package com.ssafy.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ssafy.board.model.Board;

@Mapper
public interface BoardMapper {
	
	//@Param : 해당 패러미터를 xml에서 ("이름")으로 갖다쓸수있음
	public List<Board> select(@Param("keyword") String keyword);
	
	public int update(Board board);
	
	public int delete(@Param("no") int no);
	
	public int insert(Board board);
	
	public void increaseViewCnt(@Param("no") int no);
	
	public Board findByNo(@Param("no") int no);
	

}
