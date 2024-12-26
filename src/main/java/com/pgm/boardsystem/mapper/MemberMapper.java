package com.pgm.boardsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import com.pgm.boardsystem.domain.MemberVO;




@Mapper
public interface MemberMapper {

	public void join(MemberVO member);
	public int idCheck(String id);
	public MemberVO loginCheck(String id);

}
