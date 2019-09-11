package csv_reader;

import java.io.IOException;
import java.util.List;

public class Driver {
	private static CsvReader cReader = new CsvReader();

	public static void main(String[] args) throws IOException {
		List<String[]> cArr = cReader.readCsv();
		for (String[] sArr : cArr) {
			for (String s : sArr) {
				System.out.print(s);
			}
			System.out.println("");
		}
	}

}
