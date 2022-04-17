package algorithm;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardOpenOption;
import java.util.List;
import java.util.stream.Collectors;

public class Test02 {
	final static int[][] board = {
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,9,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0},
			{0,0,0,0,0,0,0,0,0}
	};
	final static int total = 1;
	public static void main(String[] args) {
		
		for(int i = 0; i < total; i++) {
			try {
				getAvg();
			} catch (Exception e) {
				e.printStackTrace();
			}
			
		}
	}
		
	public static void getAvg() throws IOException {
		ThermoSudoku t = new ThermoSudoku(board);
		long startTime = System.nanoTime();
		t.solve();
		t.printBoard();
		long endTime = System.nanoTime();
		double total = (endTime-startTime)/1000000;
		System.out.println(total);
		
		File file = new File("C:\\Users\\nicol\\Desktop\\Time.txt");
	    List<String> out = Files.lines(file.toPath())
	                        .filter(line -> !line.contains("Average:"))
	                        .collect(Collectors.toList());
	    Files.write(file.toPath(), out, StandardOpenOption.WRITE, StandardOpenOption.TRUNCATE_EXISTING);
	    long count = Files.lines(file.toPath()).count();
		Files.writeString(file.toPath(), count + "= "+ total+"\n", StandardOpenOption.APPEND);
		double avg = Files.lines(file.toPath()).map(e -> {
			return Double.valueOf(e.replaceFirst("^\\d*.\\s", ""));
			}).mapToDouble(e -> e).average().getAsDouble();
		Files.writeString(file.toPath(), "Average: "+ avg + "\n", StandardOpenOption.APPEND);
	}
}
