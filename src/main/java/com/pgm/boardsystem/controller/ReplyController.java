package com.pgm.boardsystem.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pgm.boardsystem.domain.ReplyVO;
import com.pgm.boardsystem.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.java.Log;

@RestController
@RequestMapping("/replies/*")
@Log
@AllArgsConstructor
public class ReplyController {
	private ReplyService replyService;
	
	// 댓글을 추가하는 메소드
	@PostMapping(value = "/new", consumes = "application/json")
	public ResponseEntity<String> create(@RequestBody ReplyVO vo) {
		log.info("ReplyVO" + vo);
		int insertCount = replyService.register(vo);
		log.info("Reply insert count:" + insertCount);

		return insertCount == 1 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>("fail", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 해당 게시글의 댓글들을 출력하는 메소드
	@GetMapping("getList/{bno}")
	public ResponseEntity<List<ReplyVO>> getList(@PathVariable("bno") int bno) {
		log.info("getList");
		return new ResponseEntity<List<ReplyVO>>(replyService.getList(bno), HttpStatus.OK);
	}
	
	// 하나의 댓글을 가져오는 메소드
	@GetMapping(value = "/{rno}")
	public ResponseEntity<ReplyVO> get(@PathVariable("rno") int rno) {
		log.info("getReply():" + rno);
		return new ResponseEntity<ReplyVO>(replyService.read(rno), HttpStatus.OK);
	}
	
	// 댓글을 삭제하는 메소드
	@DeleteMapping(value = "/{rno}")
	public ResponseEntity<String> remove(@PathVariable("rno") int rno) {
		log.info("remove:" + rno);
		return replyService.remove(rno) == 1 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	// 댓글을 수정하는 메소드
	@PutMapping(value="/{rno}",consumes = "application/json")
	public ResponseEntity<String> modify(@RequestBody ReplyVO vo, @PathVariable("rno") int rno) {
		vo.setRno(rno);
		log.info("rno:" + rno);
		log.info("modify:" + vo);
		return replyService.modify(vo) == 1 ? new ResponseEntity<String>("success", HttpStatus.OK)
				: new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
