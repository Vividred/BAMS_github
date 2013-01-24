package com.fengyun.atm.model.entity;

import com.fengyun.atm.model.exception.ATMException;

/**
 *  写一个账户类(Account),属性并且完全封装(注意:要辨别每个属性的set/get方法是否需要公开):  id:账户号码 长整数 
 * password:账户密码  name:真实姓名  personId:身份证号码 字符串类型  email:客户的电子邮箱 
 * balance:账户余额
 * 
 *  方法:  deposit: 存款方法,参数是double型的金额,返回Account对象 
 * withdraw:取款方法,参数是double型的金额, 返回Account对象
 * 
 *  构造方法:  有参和无参,有参构造方法用于设置必要的属性
 */

public abstract class Account
{
	private Long id;
	private String password;
	private String name;
	private String personId;
	private String email;
	private double balance;

	public Account()
	{

	}

	public Account(Long id, String password, String name, String personId,
			String email, double balance)
	{
		super();
		this.id = id;
		this.password = password;
		this.name = name;
		this.personId = personId;
		this.email = email;
		this.balance = balance;
	}

	public Long getId()
	{
		return id;
	}

	public String getPassword()
	{
		return password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getPersonId()
	{
		return personId;
	}

	public void setPersonId(String personId)
	{
		this.personId = personId;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public double getBalance()
	{
		return balance;
	}

	public void setBalance(double balance)
	{
		this.balance = balance;
	}

	// 存款
	public final Account deposit(double money)
	{
		this.balance += money;
		return this;
	}

	// 取款
	public abstract Account withdraw(double money) throws ATMException;

	@Override
	public String toString()
	{
		return "Account [id=" + id + ", password=" + password + ", name="
				+ name + ", personId=" + personId + ", email=" + email
				+ ", balance=" + balance + "]";
	}

	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		if (id == null)
		{
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}
	
	

}
