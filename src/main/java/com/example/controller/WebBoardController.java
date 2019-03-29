package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.dto.WebBoard;
import com.example.page.PageVO;
import com.example.persistence.WebBoardRepository;

import lombok.extern.java.Log;

@Controller
@RequestMapping("/boards/")
@Log
public class WebBoardController {
	
	/*
	 * @PageableDefault 어노테이션을 이용하면 간단하게 Pageable 타입의 객체를 생성할 수 있다.
	 * 하지만 페이지 번호가 0부터 시작한다는 점과 사용자가 임의로 값을 조절하여 보안에 취약하다는 단점들이 있다.
	 * 
	 * @PageableDefault를 이용하는 방식보다는 별도로 파라미터를 수집해서 처리하는 객체를 생성하는 방식(list2() 메소드)이 보다 좋은 방식이다.
	 * 브라우저에서 전달되는 파라미터들은 자동으로 PageVO로 처리된다.
	 * 이때 페이지 번호(page)와 페이지당 개수(size)가 처리되고 정렬방향과 정렬 대상의 칼럼은 컨트롤러에서 처리된다. 
	 * */
//	@GetMapping("/list")
//	public void list(@PageableDefault(direction = Sort.Direction.DESC, sort = "bno", size = 10, page = 0) Pageable page) {
//		log.info("list() called..." + page);
//	}
	
//	@GetMapping("/list")
//	public void list2(PageVO pageVO) {
//		Pageable pageable = pageVO.makePageable(0, "bno");
//		log.info("" + pageable);
//	}
	
	@Autowired
	private WebBoardRepository webBoardRepository;
	
	// 파라미터로 Model을 전달 받고 WebBoardRepository를 이용해서 페이지 처리를 진행한 결과를 result에 담는다.
	@GetMapping("/list")
	public void list(PageVO vo, Model model) {
		Pageable page = vo.makePageable(0, "bno");
		
		Page<WebBoard> result = webBoardRepository.findAll(webBoardRepository.makePredicate(null, null), page);
		
		log.info("" + page);
		log.info("" + result);
		
		model.addAttribute("result", result);
	}
}
