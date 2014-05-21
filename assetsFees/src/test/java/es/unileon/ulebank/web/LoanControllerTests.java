package es.unileon.ulebank.web;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Test;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.assets.Loan;
import es.unileon.ulebank.assets.handler.FinancialProductHandler;
import es.unileon.ulebank.assets.support.PaymentPeriod;
import es.unileon.ulebank.bank.Bank;
import es.unileon.ulebank.handler.GenericHandler;
import es.unileon.ulebank.office.Office;
import es.unileon.ulebank.transacionManager.TransactionManager;

public class LoanControllerTests {

	@Test
	public void testLoanController() {
		LoanController controller = new LoanController();
		
		try {
			Bank bank = new Bank(new TransactionManager(), new GenericHandler("1234"));
			Office office = new Office(new GenericHandler("1234"), bank);
			Account account = new Account(office, bank, "0000000000");
			
			controller.setLoan(new Loan(new FinancialProductHandler("LN", "ES"), 100000, 0.08, PaymentPeriod.MONTHLY, 10, account));
			
			ModelAndView modelAndView = controller.handleRequest(null, null);
			
			assertEquals("hello", modelAndView.getViewName());
	        assertNotNull(modelAndView.getModel());
	        
	        @SuppressWarnings("unchecked")
	        Map<String, Object> modelMap = (Map<String, Object>) modelAndView.getModel().get("model");
	        
	        String nowValue = (String) modelMap.get("now");
	        
	        assertNotNull(nowValue);
		} 
		catch (Exception e) {
			e.printStackTrace();
	    }
	}
}
