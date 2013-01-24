package com.fengyun.atm.model.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;

import com.fengyun.atm.model.entity.Account;
import com.fengyun.atm.model.entity.CreditAccount;
import com.fengyun.atm.model.entity.SavingAccount;
import com.fengyun.atm.model.exception.ATMException;
import com.fengyun.atm.model.exception.LoginException;
import com.fengyun.atm.model.exception.RegisterException;


public class Bank
{
	private HashMap<Long, Account> arrs;
	private static Long aid;

	private static Bank bank = new Bank();

	private Bank()
	{
		this.arrs = new HashMap<Long, Account>();
		this.aid = 10000L;
	}

	public static Bank newInstance()
	{
		return bank;
	}

	// 1. 用户开户(register)
	// 参数:id,密码(2),姓名,身份证号码,邮箱,账户类型；
	// 返回新创建的Account对象

	public Account register(String password, String name, String personId,
			String email, int type) throws RegisterException
	{
		Account acc = null;
		if (type == 0)
		{
			acc = new SavingAccount(aid++, password, name, personId, email, 0);
		} else if (type == 1)
		{
			acc = new CreditAccount(aid++, password, name, personId, email, 0);
		} else
		{
			throw new RegisterException("输入错误");
		}
		this.arrs.put(acc.getId(), acc);
		return acc;
	}

	// 2. 用户登录(login)
	// 参数:id,密码
	// 返回Account对象

	public Account login(Long id, String password) throws LoginException
	{
		if (arrs.containsKey(id))
		{
			Account account = arrs.get(id);
			if (password == account.getPassword())
			{
				System.out.println("登陆成功");
				return account;
			} else
			{
				throw new LoginException("密码错误");
			}
		}
		throw new LoginException("无此用户");
	}

	// 存款
	public Account deposit(Long id, double money)
	{
		Account account = arrs.get(id);
		account.deposit(money);

		return account;
	}

	// 取款
	public Account withdraw(Long id, double money) throws ATMException
	{
		Account account = arrs.get(id);
		account.withdraw(money);
		return account;
	}

	// 5. 设置透支额度()
	public Account setCeiling(Long id, double ceiling)
	{
		Account account = arrs.get(id);
		if (account instanceof CreditAccount)
		{
			CreditAccount ca = (CreditAccount) account;
			ca.setCeiling(ceiling);
		} else
		{
			throw new RuntimeException("该账户不是信用账户");
		}

		return account;
	}

	// 6. 转账功能transfer(long from, long to, double money)
	// 参数：from转出账户，to转入账户，money要转账的金额
	// 返回值：boolean

	public boolean transfer(long from, long to, double money) throws ATMException
	{
		Account accountFrom = null;
		Account accountTo = null;

		if (arrs.containsKey(from) && arrs.containsKey(to))
		{
			accountFrom = arrs.get(from);
			accountTo = arrs.get(to);
			accountFrom.withdraw(money);
			accountTo.deposit(money);

			return true;
		} else
		{
			throw new RuntimeException("转账失败，请检查账户ID");
		}

	}

	// 1.统计银行所有账户余额总数
	public long sumAllBalance()
	{
		long sum = 0;
		// Collection collection = arrs.values();
		// Iterator iterator = collection.iterator();
		// while (iterator.hasNext())
		// {
		// Account account = (Account) iterator.next();
		// sum += account.getBalance();
		// }

		Set set = arrs.keySet();
		for (Object obj : set)
		{
			sum += arrs.get(obj).getBalance();
		}

		return sum;
	}

	// 2.统计所有信用账户透支额度总数
	public long sumCreditCeiling()
	{
		long sum = 0;
		Set set = arrs.keySet();
		for (Object obj : set)
		{
			if (arrs.get(obj) instanceof CreditAccount)
			{
				CreditAccount creditAccount = (CreditAccount) arrs.get(obj);
				sum += creditAccount.getCeiling();
			}
		}
		return sum;
	}

	// 为Bank类添加一个方法，能够打印所有用户的总资产排名（提高部分）
	// 说明:
	// 1）、一个用户可能会有多个账号,以身份证号为准.
	// 2）、总资产指多个账户余额的总和,不需要考虑贷款账户的贷
	public void userRank()
	{
		Set<Long> set = arrs.keySet();
		HashMap<String, Double> hm_balance = new HashMap<String, Double>();
		HashMap<String, String> hm_name = new HashMap<String, String>();
		Comparator<? super rankAccount> Comparator =
		null;
		TreeSet<rankAccount> rankArrs = new TreeSet<Bank.rankAccount>(
				Comparator);
		for (Object obj : set)
		{
			if (hm_balance.containsKey(arrs.get(obj).getPersonId()))
			{
				double ban = hm_balance.get(arrs.get(obj).getPersonId());
				hm_balance.put(arrs.get(obj).getPersonId(), ban
						+ arrs.get(obj).getBalance());
			} else
			{
				hm_balance.put(arrs.get(obj).getPersonId(), arrs.get(obj)
						.getBalance());
			}

			hm_name.put(arrs.get(obj).getPersonId(), arrs.get(obj).getName());
		}

		Set<String> set_rank = hm_balance.keySet();
		for (Object obj : set_rank)
		{
			rankArrs.add(new rankAccount((String) obj, hm_name.get(obj),
					hm_balance.get(obj)));
		}

		for (Entry<String, Double> entry : hm_balance.entrySet())
		{
			System.out.println(entry.getKey() + ",  " + entry.getValue());
		}
		for (Entry<String, String> entry : hm_name.entrySet())
		{
			System.out.println(entry.getKey() + ",  " + entry.getValue());
		}
		int i = 1;
		for (Object object : rankArrs)
		{
			System.out.print("第" + i++ + "名 ");
			System.out.println(object);
		}

	}

	private class rankAccount implements Comparable<rankAccount>
	{
		private String personID;
		private String name;
		private double balance;

		private rankAccount(String personID, String name, double balance)
		{
			super();
			this.personID = personID;
			this.name = name;
			this.balance = balance;
		}

		public String getPersonID()
		{
			return personID;
		}

		public void setPersonID(String personID)
		{
			this.personID = personID;
		}

		public String getName()
		{
			return name;
		}

		public void setName(String name)
		{
			this.name = name;
		}

		public double getBalance()
		{
			return balance;
		}

		public void setBalance(double balance)
		{
			this.balance = balance;
		}

		@Override
		public String toString()
		{
			return "身份证号=" + personID + ", 姓名=" + name + ", 存款=" + balance;
		}

		@Override
		public int compareTo(rankAccount o)
		{
			// TODO Auto-generated method stub
			
			if (o == this)
			{
				return 0;
			}

			if (o instanceof rankAccount
					&& this instanceof rankAccount)
			{
				rankAccount rank1 = (rankAccount) o;
				rankAccount rank2 = (rankAccount) this;

				int result = (int) ((rank1.getBalance() - rank2
						.getBalance()) * 100);

				if (result == 0)
				{
					result = rank1.getName().compareTo(
							rank2.getName());
				}

				return result;
			} else
			{
				// return 0;
				throw new RuntimeException("没有可比性！");
			}
		}

	}

}
