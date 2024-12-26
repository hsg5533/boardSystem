package com.pgm.boardsystem.controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pgm.boardsystem.domain.MemberVO;
import com.pgm.boardsystem.service.MemberService;

import lombok.extern.java.Log;

@Log
@Controller
@RequestMapping("/member/*")
public class MemberController {
	@Autowired
	private MemberService memberService;

	@GetMapping("join")
	public void join() {

	}

	public String idCheck(String id) {
		System.out.println("idChecking");
		int cnt = memberService.idCheck(id);
		System.out.println("cnt"+cnt);
		if (cnt != 0) {
			return "true";
		} else {
			return "false";
		}

	}

	// 자바스크립트의 ajax가 전송한 회원가입 정보들을 해당 메소드가 받음
	@PostMapping("join")
	@ResponseBody
	public String join(@RequestBody MemberVO member) {
		log.info("33" + member);
		// member의 getId() 메소드로 아이디 값을 받아서 memberService의 idCheck() 메소드로 해당 아이디를 검색한다.
		// 입력된 아이디가 중복된 값인지를 확인
		int cnt = memberService.idCheck(member.getId());
		// cnt의 값이 ture이면 1의 값을 가지므로 아래의 if문에 해당함.
		if (cnt != 0) {
			return "fail";
		}
		memberService.join(member);
		return "success";
	}

	@GetMapping("login")
	public void login() {

	}

	// 자바스크립트에서 ajax가 전송한 회원가입 정보들을 해당 메소드가 받는다.
	@PostMapping("login")
	@ResponseBody
	public String login(String id, String pass, HttpSession session) {
		MemberVO member = memberService.loginCheck(id);
		String result = "no"; // 회원아닐때
		// member가 null이 아니면. 입력된 id가 있고 sql구문을 통해서 검색된 member의 값이 있을 경우.
		if (member != null) {
			// 입력된 비밀번호가 저장된 비밀번호와 일치할 경우.
			if (member.getPass().equals(pass)) {
				System.out.println("로그인:"+member.getId() + ":" + pass); // 로그인 정보 출력
				// 새로운 세션을 생성한다. 세션은 로그인이 유지되는 것을 말한다.
				session.setAttribute("sMember", member);
				result = "success";
			} else {
				result = "passFail";
			}
		}
		return result;
	}

	// 로그아웃 메소드
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.invalidate();
		// /board/list.jsp로 제자리 걸음.
		return "redirect:/board/list";
	}

}
