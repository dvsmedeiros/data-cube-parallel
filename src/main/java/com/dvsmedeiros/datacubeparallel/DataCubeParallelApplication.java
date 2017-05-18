package com.dvsmedeiros.datacubeparallel;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataCubeParallelApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DataCubeParallelApplication.class, args);

		Thread.sleep(60000);
	}
}
