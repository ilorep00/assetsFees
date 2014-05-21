package es.unileon.ulebank.assets;

import es.unileon.ulebank.account.Account;
import es.unileon.ulebank.assets.exceptions.LoanException;
import es.unileon.ulebank.assets.financialproducts.InterestRate;
import es.unileon.ulebank.assets.handler.Handler;
import es.unileon.ulebank.assets.support.PaymentPeriod;

public class VariableLoan extends Loan{

	public VariableLoan(Handler idLoan, double initialCapital, double interest,
			PaymentPeriod paymentPeriod, int amortizationTime, Account account,
			InterestRate interestRate, PaymentPeriod recalcOfInterset)
			throws LoanException {
		super(idLoan, initialCapital, interest, paymentPeriod, amortizationTime,
				account);
		
	}

}
