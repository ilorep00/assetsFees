package es.unileon.ulebank.web;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import es.unileon.ulebank.assets.Loan;
import es.unileon.ulebank.assets.strategy.loan.AmericanMethod;
import es.unileon.ulebank.assets.strategy.loan.FrenchMethod;
import es.unileon.ulebank.assets.strategy.loan.GermanMethod;
import es.unileon.ulebank.assets.strategy.loan.ItalianMethod;
import es.unileon.ulebank.assets.strategy.loan.ProgressiveMethod;
import es.unileon.ulebank.assets.strategy.loan.ScheduledPayment;
import es.unileon.ulebank.service.ChangeMethod;

@Controller
@RequestMapping(value="/changemethod.htm")
public class ChangeMethodFormController {
	
	/** Logger for this class and subclasses */
    protected final Log logger = LogFactory.getLog(getClass());
    
    @Autowired
    private Loan loan;
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@Valid ChangeMethod changeMethod, BindingResult result)
    {
    	
        if (result.hasErrors()) {
            return new ModelAndView("changemethod");
        }
		
        int type = changeMethod.getType();
        logger.info("Type selected: " + type);
        
        String now = (new Date()).toString();
        logger.info("Returning hello view with " + now);
        
        Map<String, Object> myModel = new HashMap<String, Object>();
        
        myModel.put("now", now);

        if(type == 1){
        	AmericanMethod am = new AmericanMethod(loan, 12);
        	
        	ArrayList<ScheduledPayment> payments = am.doCalculationOfPayments();
            
            myModel.put("products", payments);
            
            return new ModelAndView("hello", "model", myModel);
        }
        else if(type == 2){
        	FrenchMethod fm = new FrenchMethod(loan);
        	
        	ArrayList<ScheduledPayment> payments = fm.doCalculationOfPayments();
            
            myModel.put("products", payments);
            
            return new ModelAndView("hello", "model", myModel);
        }
        else if(type == 3){
        	GermanMethod gm = new GermanMethod(loan);
        	
        	ArrayList<ScheduledPayment> payments = gm.doCalculationOfPayments();
            
            myModel.put("products", payments);
            
            return new ModelAndView("hello", "model", myModel);
        }
        else if(type == 4){
        	ItalianMethod im = new ItalianMethod(loan);
        	
        	ArrayList<ScheduledPayment> payments = im.doCalculationOfPayments();
            
            myModel.put("products", payments);
            
            return new ModelAndView("hello", "model", myModel);
        }
        else if(type == 5){
        	ProgressiveMethod pm = new ProgressiveMethod(loan, 5);
        	
        	ArrayList<ScheduledPayment> payments = pm.doCalculationOfPayments();
            
            myModel.put("products", payments);
            
            return new ModelAndView("hello", "model", myModel);
        }
        else{
        	return null;
        }
    }
    
    @RequestMapping(method = RequestMethod.GET)
    protected ChangeMethod formBackingObject(HttpServletRequest request) throws ServletException {
    	ChangeMethod changeMethod = new ChangeMethod();
    	changeMethod.setType(1);
    	
        return changeMethod;
    }
}
