package com.zhong;
/**
 * 
 * @author admin
 *假如有这样一个需求，当我们需要解析一个Excel里多个sheet的数据时，
 *可以考虑使用多线程，每个线程解析一个sheet里的数据，等到所有的sheet都解析完之后，
 *程序需要提示解析完成。
 *在这个需求中，要实现主线程等待所有线程完成sheet的解析操作，最简单的做法是使用join
 */
public class JoinCountDownLatchTest {
	public static void main(String[] args) throws InterruptedException {
		Thread parser1 = new Thread(new Runnable() {
			@Override
			public void run() {
			}
		});

		Thread parser2 = new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println("parser2 finish");
			}
		});

		parser1.start();
		parser2.start();
		
		parser1.join();//等待parser1线程执行完毕
		parser2.join();//等待parser2线程执行完毕
		
		System.out.println("all parser finish");
	}

}
