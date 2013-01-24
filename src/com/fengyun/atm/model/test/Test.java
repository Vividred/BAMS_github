package com.fengyun.atm.model.test;

import com.fengyun.atm.model.entity.Account;
import com.fengyun.atm.model.exception.LoginException;
import com.fengyun.atm.model.exception.RegisterException;
import com.fengyun.atm.model.service.Bank;

public class Test
{
	public static void main(String[] args) throws RegisterException, LoginException {
		// TODO Auto-generated method stub
		Bank bank = Bank.newInstance();
		
		Account acc1 = bank.register("12345","zhangsan","320504","asd@gmail.comm",1);	
		
		Account acc2 = bank.register("12121","laohuang","32050419","mai@gmail.com",0);
		
		Account acc3 = bank.register("12345","liuling","555555","asd@gmail.comm",1);

		Account acc4 = bank.register("12345","zhangsan","320504","asd@gmail.comm",1);

		

		bank.setCeiling(acc1.getId(), 100);
		bank.setCeiling(acc3.getId(), 200);
		bank.setCeiling(acc4.getId(), 2000);
		
		Account acc = bank.login(acc1.getId(), "12345");
		Account acc_1 = bank.login(acc2.getId(), "12121");
		
		System.out.println(acc);
		System.out.println(acc2);
		System.out.println(acc3);
		System.out.println(acc4);
		
		System.out.println("======LINE=======");
		acc1.deposit(1000);
		acc2.deposit(90000);
		acc3.deposit(200);
		acc4.deposit(5000);
		System.out.println("所有账户余额为"+bank.sumAllBalance());
		System.out.println(acc);
		System.out.println(acc_1);
		System.out.println(acc3);
		System.out.println(acc4);
		System.out.println("======LINE=======");
		System.out.println("所有账户透支额度总额为"+bank.sumCreditCeiling());
		System.out.println("======LINE=======");
		bank.userRank();
	}
}
