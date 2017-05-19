package com.dvsmedeiros.datacubeparallel;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DataCubeParallelApplication {

	public static void main(String[] args) throws InterruptedException {
		SpringApplication.run(DataCubeParallelApplication.class, args);

		readWithStream("D12_T1M_S0_C1K_100.txt");
		readWithBufferedReader("D12_T1M_S0_C1K_100.txt");

	}

	public static void readWithStream(String path) {
		long start = System.currentTimeMillis();

		try (Stream<String> stream = Files.lines(Paths.get(path))) {

			List<String> list = stream.collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("STREAM: " + (end - start));
	}

	public static void readWithBufferedReader(String path) {
		long start = System.currentTimeMillis();

		try (BufferedReader br = Files.newBufferedReader(Paths.get(path))) {

			List<String> list = br.lines().collect(Collectors.toList());

		} catch (IOException e) {
			e.printStackTrace();
		}

		long end = System.currentTimeMillis();
		System.out.println("BUFFERED READER: " + (end - start));
	}
}
