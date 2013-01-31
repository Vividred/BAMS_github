package com.fengyun.atm.model.client.frame;

public class testfornet
{
	public static void main(String[] args)
	{
		Thread t1 = new Thread01();
		Thread t2 = new Thread02();
		t1.start();
		t2.start();
	}

}

class Thread01 extends Thread
{
	@Override
	public void run()
	{
		synchronized ("hello")
		{
			System.out.println("t01获得了hello锁");
			synchronized ("world")
			{
				System.out.println("t01获得了world锁");
			}

		}

	}
}

class Thread02 extends Thread
{
	@Override
	public void run()
	{
		synchronized ("world")
		{
			System.out.println("t02获得了world锁");
			synchronized ("hello")
			{
				System.out.println("t02获得了hello锁");
			}

		}

	}
}
