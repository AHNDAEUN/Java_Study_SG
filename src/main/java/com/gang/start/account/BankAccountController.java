package com.gang.start.account;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.gang.start.members.BankMembersDTO;


@Controller
@RequestMapping(value= "/bankaccount/*")
public class BankAccountController {

	@Autowired
	private BankAccountService bankAccountService;
		
				@RequestMapping(value = "add.gang", method = RequestMethod.GET ) 
		public String add(BankAccountDTO bankAccountDTO , HttpSession session ) throws Exception{
			
			System.out.println(" account add 실행");
			
			BankMembersDTO bankMembersDTO = (BankMembersDTO) session.getAttribute("member");
			
			bankAccountDTO.setUserName(bankMembersDTO.getUserName());
			int result = this.bankAccountService.add(bankAccountDTO);
			
			return "redirect../bankbook/list.gang";
			 
}

}
