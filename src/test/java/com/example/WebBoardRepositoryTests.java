package com.example;

import java.util.stream.IntStream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.dto.WebBoard;
import com.example.persistence.WebBoardRepository;

import lombok.extern.java.Log;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log
@Commit
public class WebBoardRepositoryTests {
	
	@Autowired
	WebBoardRepository webBoardRepository;
	
//	@Test
//	public void insertBoardDummies() {
//		IntStream.range(0, 300).forEach(i -> {
//			WebBoard webBoard = new WebBoard();
//			
//			webBoard.setTitle("테스트 게시물 제목" + i);
//			webBoard.setContent("테스트 게시물 내용..." + i);
//			webBoard.setWriter("user0" + (i % 10));
//			
//			webBoardRepository.save(webBoard);
//		});
//	}
	
//	@Test
//	public void testList1() {
//		Pageable pageable = PageRequest.of(0, 20, Direction.DESC, "bno");
//		
//		Page<WebBoard> result = webBoardRepository.findAll(webBoardRepository.makePredicate(null, null), pageable);
//		
//		log.info("PAGE : " + result.getPageable());
//		
//		log.info("---------------");
//		
//		result.getContent().forEach(board -> log.info("" + board));
//	}
	
	@Test
	public void testList2() {
		Pageable pageable = PageRequest.of(0, 20, Direction.DESC, "bno");
		
		Page<WebBoard> result = webBoardRepository.findAll(webBoardRepository.makePredicate("t", "10"), pageable);
		
		log.info("PAGE : " + result.getPageable());
		
		log.info("---------------");
		
		result.getContent().forEach(board -> log.info("" + board));
	}
}
