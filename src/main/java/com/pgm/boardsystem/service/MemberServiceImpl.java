package com.pgm.boardsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pgm.boardsystem.domain.MemberVO;
import com.pgm.boardsystem.mapper.MemberMapper;

@Service
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberMapper memberMapper;
	
	@Override
	public void join(MemberVO member) {
		// TODO Auto-generated method stub
		memberMapper.join(member);

	}

	@Override
	public int idCheck(String id) {
		// TODO Auto-generated method stub
		return memberMapper.idCheck(id);
	}

	@Override
	public MemberVO loginCheck(String id) {
		// TODO Auto-generated method stub
		return memberMapper.loginCheck(id);
	}

}
