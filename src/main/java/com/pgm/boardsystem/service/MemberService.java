package com.pgm.boardsystem.service;

import com.pgm.boardsystem.domain.MemberVO;

public interface MemberService {
	public void join(MemberVO member);
	public int idCheck(String id);
	public MemberVO loginCheck(String id);

}
