package com.kh.ktkimc.board.controller;

import java.io.File;
import java.util.List;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.kh.ktkimc.board.model.domain.Board;
import com.kh.ktkimc.board.model.service.BoardService;

@Controller
//@RequestMapping(value="/board")	// 연속해서 나오기도 함 밑에 있는 것들과 연결해서 사용 한다.
public class BoardController {

	@Autowired
	private BoardService bService;
	
	@RequestMapping(value="/writeForm.do", method = RequestMethod.GET)
	public String boardInsertForm(ModelAndView mv) {
		return "board/writeForm";
	}
	

	@RequestMapping(value="/bInsert.do", method =  RequestMethod.POST)
	public ModelAndView boardInsert(Board b, @RequestParam(name="upfile") MultipartFile report, HttpServletRequest request, ModelAndView mv) {
		
		if(report!=null && !report.equals("")) {
			saveFile(report, request);
		}
		b.setBoard_file(report.getOriginalFilename());
		bService.insertBoard(b);
		mv.setViewName("redirect:bList.do");
		return mv;
	}
	
	@RequestMapping(value="/bList.do")
	public ModelAndView boardListService(ModelAndView mv) {
		mv.addObject("list", bService.selectList());
		mv.setViewName("board/bList");
		return mv;
	}
	
	private void saveFile(MultipartFile report, HttpServletRequest request) {

		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\uploadFiles";
		File folder = new File(savePath);

		if (!folder.exists()) {
			folder.mkdir();
		}
		String filePath = null;

		try	{         
		    System.out.println(report.getOriginalFilename() + "을 저장합니다.");         
		    System.out.println("저장 경로 : " + savePath);
		    	 
		    filePath = folder + "\\" + report.getOriginalFilename(); 
		    	 
		    report.transferTo(new File(filePath)); 
		    System.out.println("파일 명 : " + report.getOriginalFilename());         
		    System.out.println("파일 경로 : " + filePath);         
		    System.out.println("파일 전송이 완료되었습니다.");      
		} catch (Exception e) {         
			System.out.println("파일 전송 에러 : " + e.getMessage());      
		}   
	}
	
	private void removeFile(String board_file, HttpServletRequest request) {
		String root = request.getSession().getServletContext().getRealPath("resources");
		String savePath = root + "\\uploadFiles";
		String filePath = savePath+"\\" + board_file;
		try {
			File delFile = new File(filePath);
			delFile.delete();
			System.out.println(board_file + "을 삭제합니다.");
			System.out.println("기존 저장 경로");
		} catch(Exception e) {
			System.out.println("파일 삭제 에러 : " + e.getMessage());
		}
	}
	
	@RequestMapping(value="/bDetail.do")
	public ModelAndView boardDetail(@RequestParam(name="board_num") String board_num, 
			@RequestParam(name="page", defaultValue = "1") int page, ModelAndView mv) {
		mv.addObject("board", bService.selectOne(board_num));
		mv.setViewName("board/bDetail");
		return mv;
	}
	
	@RequestMapping(value="/bRenew.do")
	public ModelAndView boardDetail(@RequestParam(name="board_num") String board_num, ModelAndView mv) {
		mv.addObject("board", bService.selectOne(board_num));
		mv.setViewName("board/bRenew");
		return mv;
	}
	
	@RequestMapping(value="/bUpdate.do", method = RequestMethod.POST)
	public ModelAndView boardUpdate(Board b, @RequestParam(name="upfile") MultipartFile report, HttpServletRequest request, ModelAndView mv) {
		
		if(report!=null && !report.equals("")) {
			removeFile(b.getBoard_file(), request);
			saveFile(report, request);
			b.setBoard_file(report.getOriginalFilename());
		}
		if(bService.updateBoard(b)!=null) {
			mv.addObject("board_num", bService.updateBoard(b).getBoard_num());
			mv.setViewName("redirect:bDetail.do");
		}else {
			
		}
		
		return mv;
	}
	
	
//	int updateBoard(Board d);
//	int deleteBoard(String board_num);
}
