package com.shaymee.s1.bankbook;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller// bankbookController의 객체를 대신만들어달라는 어노테이션
@RequestMapping("/bankbook/*")
public class BankbookController {
	//pojo (Plain Old Java Object: 어떤 외부Library도 상속받지 않은 순수한 Java 클래스)
	
	@RequestMapping(value="bankbookList.do", method=RequestMethod.GET)
	public ModelAndView list(Integer[] num, ModelAndView mv) {
		for(Integer i : num) {
			System.out.println(i);
		}
		System.out.println("This page is Bankbook List");
		
		ModelAndView mv2 = new ModelAndView();
		mv2.setViewName("bankbook/bankbookList");
		
		return mv2;
	}
	
	@RequestMapping("bankbookSelect")
	public void select(@RequestParam(defaultValue="1", value = "n") Integer[] num, Model model) {
		System.out.println("This page is Bankbook Select");
//		String value = request.getParameter("num"); // "num"이라고 보내는 parameter값을 받기
		System.out.println("Value : "+num);
		System.out.println("Name : ");
		BankbookDTO bankbookDTO = new BankbookDTO();
		bankbookDTO.setBookName("아프니까청춘이다ㅋㅋ");
		model.addAttribute("test", "iu");//@@ 매개변수로 선언해주면 return 안해도 같이 넘어감!!
		model.addAttribute("bookName", bankbookDTO);
		
//		return "bankbook/bankbookSelect";
// 		return을 void로 했을 땐 요청uri가 view의 경로명이 됨+return을 안해줘도 됨		
	}
	
	@RequestMapping("bankbookInsert.do")
	public String insert(BankbookDTO bankbookDTO) {
		System.out.println(bankbookDTO.getBookName());
		System.out.println("insert");			
		return "redirect:../?num=1"; //redirect도 주소창에 직접 쳐서 들어오는 방식이기에 get방식임
									// parameter도 미리줘서 보낼 수 있음
	}
	
}
