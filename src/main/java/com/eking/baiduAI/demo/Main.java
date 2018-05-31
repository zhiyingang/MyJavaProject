
package com.eking.baiduAI.demo;

import java.util.Random;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.stream.IntStream;

public class Main {

	/**
	 * ThreadPoolExecutor
	 *   corePoolSize 核心线程数，默认情况下核心线程会一直存活，即使处于闲置状态也不会受存keepAliveTime限制。除非将allowCoreThreadTimeOut设置为true。
	 *   maximumPoolSize 线程池所能容纳的最大线程数。超过这个数的线程将被阻塞。当任务队列为没有设置大小的LinkedBlockingDeque时，这个值无效。
	 *   keepAliveTime 非核心线程的闲置超时时间，超过这个时间就会被回收。
	 *   ArrayBlockingQueue 线程池中的任务队列。ArrayBlockingQueue + corePoolSize = 总共能使用的线程数量
	 */
	public static ThreadPoolExecutor pool = new ThreadPoolExecutor(20, 50, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));

	public static int threadIndex = 0;

	public static void main(String[] args) {
		try {
			//循环执行的次数
			IntStream.range(0, 1000).forEach(o -> {
				//如果线程的数量不足1000，则等待3s
				while (!(pool.getQueue().size() < 1000)) {
					try {
						System.out.println("pool size max: " + pool.getQueue().size() + ",wait for 3000 ms");
						Thread.sleep(3000);
					} catch (Exception e) {}
				}
				pool.submit(() -> {
					final Integer index = ++threadIndex;
					try {
						System.out.println(index + " start");

						//Thread.sleep(new Random().nextInt(5000));
						
						//测试身份证识别
						//IdCardOcr obj = new IdCardOcr();
						//obj.idRecognition();
						
						//测试人像比对
						FaceMatch faceMatch = new FaceMatch();
						faceMatch.testFaceMeth();

						System.out.println(index + " end");
					} catch (Exception e) {

						System.out.println(index + " error , error message:" + e.getMessage());
					}
					return index;
				});
			});
			pool.shutdown();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
