package oblig2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.LineNumberReader;

public class ProgramFile {

	private String filename ="C:\\Users\\BF\\Desktop\\pg100.txt";
	private LineNumberReader lnr;

	public LineNumberReader openStream() {
		try {
			File file = new File(filename);
			FileReader fr = new FileReader(file);
			lnr = new LineNumberReader(fr);
		} catch(FileNotFoundException e) {
			System.out.println("File not found!");
		}
		return lnr;
	}
}
