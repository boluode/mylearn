package com.boluo.mylearn.concurrent;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * mylearn - com.boluo.mylearn.concurrent
 *
 * @author liyanlong
 * @date 2018/2/27 17:08.
 * @since JDK 1.8
 */
public class MyBlockingQueue {

	public static void main(String[] args) throws Exception {

		BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(10);
		Producer producer1 = new Producer(blockingQueue);
		Producer producer2 = new Producer(blockingQueue);
		Producer producer3 = new Producer(blockingQueue);
		Consumer consumer = new Consumer(blockingQueue);

		ExecutorService executorService = Executors.newCachedThreadPool();
		executorService.execute(producer1);
		executorService.execute(producer2);
		executorService.execute(producer3);
		executorService.execute(consumer);

		Thread.sleep(1 * 2 * 1000);
		producer1.close();
		producer2.close();
		producer3.close();

		Thread.sleep(2 * 1000);
		executorService.shutdown();
	}

	public static class Consumer implements Runnable {

		private BlockingQueue<String> queue;

		public Consumer(BlockingQueue<String> blockingQueue) {

			this.queue = blockingQueue;
		}

		public void run() {

			System.out.println("start consume...");
			boolean isRunning = true;
			try {
				while (isRunning) {

					System.out.println("get data from queue.");
					String data = queue.poll(2, TimeUnit.SECONDS);
					if (data == null) {
						isRunning = false;
					} else {
						System.out.println("get data:" + data);
						System.out.println("consume data:" + data);
						Thread.sleep(1000);
					}
				}
				System.out.println("end consume...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static class Producer implements Runnable {

		private BlockingQueue<String> queue;
		private volatile boolean isRunning = true;
		private static AtomicInteger count = new AtomicInteger();

		public Producer(BlockingQueue<String> blockingQueue) {
			this.queue = blockingQueue;
		}

		public void run() {

			System.out.println("start producer...");
			try {
				while (isRunning) {

					String data = "data_" + count.getAndDecrement();
					System.out.println("produce data:" + data);
					boolean isOffer = queue.offer(data, 2, TimeUnit.MINUTES);
					if(isOffer) {
						System.out.println("offer data success.");
					} else {
						System.out.println("offer data unsuccess.");
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		public void close() {
			isRunning = false;
		}
	}
}
