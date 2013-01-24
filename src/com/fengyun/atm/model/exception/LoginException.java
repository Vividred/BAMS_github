package com.fengyun.atm.model.exception;

public class LoginException extends ATMException
{

	/**
	 * 原来写这篇代码的时候，只有我和上帝知道它是干嘛的
	 * 现在只有上帝知道了
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public LoginException()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public LoginException(String message, Throwable cause)
	{
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public LoginException(String message)
	{
		super(message);
		// TODO Auto-generated constructor stub
	}

	public LoginException(Throwable cause)
	{
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
