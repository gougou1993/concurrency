package com.zhong;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
/**
 * Semaphore（信号量）是用来控制同时访问特定资源的 >>>>线程数量<<<<<，
 * 它通过协调各个线程，以保证合理的使用公共资源。很多年以来，我都觉得从字面上很难理解Semaphore所表达的含义，只能把它比作是控制流量的红绿灯，比如XX马路要限制流量，只允许同时有一百辆车在这条路上行使，其他的都必须在路口等待，所以前一百辆车会看到绿灯，可以开进这条马路，后面的车会看到红灯，不能驶入XX马路，但是如果前一百辆中有五辆车已经离开了XX马路，那么后面就允许有5辆车驶入马路，
 * 这个例子里说的车就是线程，驶入马路就表示线程在执行，离开马路就表示线程执行完成，看见红灯就表示线程被阻塞，不能执行。
 * @author admin
 *
 */
public class SemaphoreTest {

	private static final int THREAD_COUNT = 30;

	private static ExecutorService threadPool = Executors.newFixedThreadPool(THREAD_COUNT);
	private static Semaphore s = new Semaphore(10);

	public static void main(String[] args) {
		for (int i = 0; i < THREAD_COUNT; i++) {
			threadPool.execute(new Runnable() {
				@Override
				public void run() {
					try {
						s.acquire();// Acquires a permit from this semaphore, blocking until one is available
						System.out.println("save data");
						s.release();//Releases a permit, returning it to the semaphore. 
					} catch (InterruptedException e) {
					}
				}
			});
		}

		threadPool.shutdown();
	
	}
}
