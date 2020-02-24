package ru.malychev.jstasks.watch;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Watch {
	public static void main(String[] args) throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		SimpleDateFormat formatTimeNow = new SimpleDateFormat("HH:mm:ss");

		ScheduledExecutorService watch = Executors.newSingleThreadScheduledExecutor();
		watch.scheduleWithFixedDelay(() -> System.out.print(formatTimeNow.format(new Date()) +"\r"),
				0, 1, TimeUnit.SECONDS);
		reader.read();
		watch.shutdown();
	}
}
