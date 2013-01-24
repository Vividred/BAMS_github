package com.fengyun.atm.model.entity;

import com.fengyun.atm.model.exception.BalanceNotEnoughException;
import com.fengyun.atm.model.exception.LoanException;

public class LoanSavingAccount extends SavingAccount implements Loanable
{

	private double loan;
	
	public LoanSavingAccount()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public LoanSavingAccount(Long id, String password, String name,
			String personId, String email, double balance)
	{
		super(id, password, name, personId, email, balance);
		// TODO Auto-generated constructor stub
	}

//	requestLoan:贷款,参数money
	@Override
	public void requestLoan(double money)
	{
		// TODO Auto-generated method stub
		loan += money;
		
	}
//	payLoan:还贷,参数money
	@Override
	public void payLoan(double money) throws LoanException, BalanceNotEnoughException
	{
		// TODO Auto-generated method stub
		if(loan<money)
		{
			throw new LoanException("您不需要还这么多钱。");
		}
		else if(this.getBalance()>=money){
			this.setBalance(this.getBalance()-money);
			loan -= money;
		}
		else {
			throw new BalanceNotEnoughException("余额不足");
		}

		
		
	}
//	getLoan:获取用户贷款总额
	public double getLoan()
	{
		return loan;
	}

	public void setLoan(double loan)
	{
		this.loan = loan;
	}

	@Override
	public String toString()
	{
		return "LoanSavingAccount [getLoan()=" + getLoan() + ", getId()="
				+ getId() + ", getPassword()=" + getPassword() + ", getName()="
				+ getName() + ", getPersonId()=" + getPersonId()
				+ ", getEmail()=" + getEmail() + ", getBalance()="
				+ getBalance() + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = super.hashCode();
		long temp;
		temp = Double.doubleToLongBits(loan);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoanSavingAccount other = (LoanSavingAccount) obj;
		if (Double.doubleToLongBits(loan) != Double
				.doubleToLongBits(other.loan))
			return false;
		return true;
	}
	
}
	
