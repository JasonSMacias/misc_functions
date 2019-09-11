package csv_reader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class CsvReader {
	private String fLocation = "C:\\Users\\jmaci\\Desktop\\Tutorial_Reading_Practice\\cracking\\Java\\Miscellaneous\\src\\csv_reader\\resources\\deniro.txt";
	private File file = new File(fLocation);
	
	public CsvReader() {}
	
	public List<String[]> readCsv() throws IOException {
		FileReader fReader = null;
		try {
			fReader = new FileReader(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		BufferedReader bReader = new BufferedReader(fReader);
		
		String header = bReader.readLine();
		
		String[] headers = header.split(",");
		
		List<String[]> strRowsList = new ArrayList<>();
		strRowsList.add(headers);
		
		rows: while(true ) {
			String next = bReader.readLine();
			if (next == null) {
				break rows;
			}
			else {
				String[] rowArr = next.split(",");
				strRowsList.add(rowArr);
			}
		}
		
		return strRowsList;
	}
}
