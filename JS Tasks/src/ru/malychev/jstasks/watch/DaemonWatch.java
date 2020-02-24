package ru.malychev.jstasks.watch;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DaemonWatch {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat formatTimeNow = new SimpleDateFormat("HH:mm:ss");

		Thread watch = new Thread(() -> { while (true) {
			System.out.print(formatTimeNow.format(new Date()) + "\r");
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					System.out.println("\nДемон убит!");
				}
			}
		});
		watch.setDaemon(true);
		watch.start();
		reader.read();
	}
}
