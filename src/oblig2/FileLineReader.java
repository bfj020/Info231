package oblig2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileLineReader extends FileReader {
	
	private String line ="";
	int tempLine;
	public FileLineReader(File file) throws FileNotFoundException{
		super(file);
	}
	public String line(String line) throws IOException{
		while((tempLine=read())!='\n'){
			if(tempLine==-1)
				return line;
				line+=(char) tempLine +"";
}
		return line;
}}