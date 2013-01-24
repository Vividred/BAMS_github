package com.fengyun.atm.model.entity;

import com.fengyun.atm.model.exception.BalanceNotEnoughException;
import com.fengyun.atm.model.exception.LoanException;

//
//requestLoan:贷款,参数money
//payLoan:还贷,参数money
//getLoan:获取用户贷款总额

public interface Loanable
{
	public abstract void requestLoan(double money);
	public abstract void payLoan(double money) throws LoanException, BalanceNotEnoughException;
	public abstract double getLoan();

}
