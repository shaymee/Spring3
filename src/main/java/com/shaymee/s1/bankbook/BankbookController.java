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

@Controller
@RequestMapping("/bankbook/*")
public class BankbookController {
	
	@Autowired
	private BankbookService bankbookService;
	
	@RequestMapping("bankbookList")
	public ModelAndView list(ModelAndView mv) {
		List<BankbookDTO> ar = bankbookService.getList();
		mv.addObject("list", ar);
		mv.setViewName("bankbook/bankbookList"); // "mv.setViewName을 통해 jsp의 경로를 적어주세요"
		return mv;
	}
	
	@RequestMapping("bankbookSelect")
	public void select(BankbookDTO bankbookDTO, Model model) { //void라고 하면 어떤 jsp를 찾아가는지? 요청한 URL을 경로로 삼는다
		bankbookDTO = bankbookService.getSelect(bankbookDTO);
		model.addAttribute("dtov", bankbookDTO);
		
		//controller의 메서드의 return은 ModelAndView 객체로 만들어서 감
	}
	
	@RequestMapping(value="bankbookInsert", method = RequestMethod.GET)
	public void insert() {}
	
	@RequestMapping(value="bankbookInsert", method = RequestMethod.POST)
	public String insert(BankbookDTO bankbookDTO) {
		int result = bankbookService.setInsert(bankbookDTO);
		
		return "redirect:./bankbookList";
	}
	
	@RequestMapping(value="bankbookDelete")
	public String delete(Long bookNumber) {
		int result = bankbookService.setDelete(bookNumber);
		
		return "redirect:./bankbookList";
	}
	
}
