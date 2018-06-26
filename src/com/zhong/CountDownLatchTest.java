package com.zhong;

import java.util.concurrent.CountDownLatch;
/**
 * CountDownLatch 允许一个或多个线程等待其他线程完成操作。
 * @author admin
 *
 */
public class CountDownLatchTest {
	
	static CountDownLatch c = new CountDownLatch(2);

	public static void main(String[] args) throws InterruptedException {
		new Thread(new Runnable() {
			@Override
			public void run() {
				System.out.println(1);
				c.countDown(); // 减一
				System.out.println(2);
				c.countDown();// 计数减一
			}
		}).start();

		
		c.await(); //main线程等其他线程完成后继续执行
		
		System.out.println("3");
	}
}
