package com.shaymee.s1.bankbook;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.shaymee.s1.util.Pager;

@Controller
@RequestMapping("/bankbook/**")
public class BankbookController {
	
	@Autowired
	private BankbookService bankbookService;
	
	
	//////////// list /////////////////
	@RequestMapping("bankbookList")
	public ModelAndView list(ModelAndView mv, Pager pager) { //pn이라는 멤버변수를 갖고있는 Pager 클래스 타입으로 선언해도 됨
		
		List<BankbookDTO> ar = bankbookService.getList(pager);
		
		mv.addObject("pager", pager); // 계산이 끝난 pager객체를 담아서 jsp로 보내기
		
		mv.addObject("list", ar);
		mv.setViewName("bankbook/bankbookList"); // "mv.setViewName을 통해 jsp의 경로를 적어주세요"
		return mv;
	}
	
	/////////// select //////////////
	@RequestMapping("bankbookSelect")
	public void select(BankbookDTO bankbookDTO, Model model) { //void라고 하면 어떤 jsp를 찾아가는지? 요청한 URL을 경로로 삼는다
		bankbookDTO = bankbookService.getSelect(bankbookDTO);
		model.addAttribute("dtov", bankbookDTO);
		
		//controller의 메서드의 return은 ModelAndView 객체로 만들어서 감
	}
	
	///////////// insert ///////////////
	@RequestMapping(value="bankbookInsert", method = RequestMethod.GET)
	public void insert() {}
	
	
	@RequestMapping(value="bankbookInsert", method = RequestMethod.POST)
	public String insert(BankbookDTO bankbookDTO) {
		int result = bankbookService.setInsert(bankbookDTO);
		
		return "redirect:./bankbookList";
	}
	
	////////// delete ///////////////
	@RequestMapping(value="bankbookDelete")
	public String delete(Long bookNumber) {
		int result = bankbookService.setDelete(bookNumber);
		
		return "redirect:./bankbookList";
	}
	
	/////////// update //////////////
	@RequestMapping(value="bankbookUpdate", method=RequestMethod.GET)
	public ModelAndView update(BankbookDTO bankbookDTO) {
		bankbookDTO = bankbookService.getSelect(bankbookDTO);
		ModelAndView mv = new ModelAndView();
		mv.setViewName("bankbook/bankbookUpdate"); // jsp의 경로명 setting하기
		mv.addObject("dto", bankbookDTO);
		
		return mv;
	}
	
	@RequestMapping(value="bankbookUpdate", method = RequestMethod.POST)
	public ModelAndView update(BankbookDTO bankbookDTO, ModelAndView mv) {
		int result = bankbookService.setUpdate(bankbookDTO);
		mv.setViewName("redirect:./bankbookList");
		
		return mv;
	}
	
}
