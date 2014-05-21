package es.unileon.ulebank.web;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.assets.Loan;
import es.unileon.ulebank.assets.strategy.loan.DefaultLoanStrategy;
import es.unileon.ulebank.assets.strategy.loan.ScheduledPayment;

@Controller
public class LoanController {
	protected final Log logger = LogFactory.getLog(getClass());
	
	@Autowired
	private Loan loan;
	
	@RequestMapping(value="/hello.htm")
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
		
		String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        
        myModel.put("now", now);
        
        DefaultLoanStrategy dls = new DefaultLoanStrategy(loan);
        
        ArrayList<ScheduledPayment> payments = dls.doCalculationOfPayments();
        
        myModel.put("products", payments);
        
        return new ModelAndView("hello", "model", myModel);
	}
	
	public void setLoan(Loan loan){
		this.loan = loan;
	}
}
