package oblig2;

import java.util.ArrayList;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.util.ArrayList;

/**
 * 
 */

public class StreamReader {
	private LineNumberReader lnr;
	private String thisLine;
	private int counter;
	private ArrayList<Integer> myPositions = new ArrayList<Integer>();
	
	public void searchPhrase() {
		try {
			ProgramFile streamer = new ProgramFile();
			lnr = streamer.openStream();
			counter = 0;
			while((thisLine = lnr.readLine()) != null) {
				if(thisLine.contains("Horatio")) {
					myPositions.add(lnr.getLineNumber());
					counter = counter + 1;
				}
			}
			lnr.close();
		} catch(FileNotFoundException e) {
			System.out.println("File not found!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	} 
	public void searchWord(){
		
	}
	
	
	public void readFile() throws IOException{
		ProgramFile streamer = new ProgramFile();
		lnr = streamer.openStream();
		while((thisLine = lnr.readLine()) != null){
			lnr.readLine();
		}

	}
	
	public void printPositions() {
		for(Integer i : myPositions) {
			System.out.println(i);
		}
		for(int i = 0; i < 10; i++) {
			System.out.println(myPositions.get(i));
		}
		System.out.println("found string " + counter + " times!");
		System.out.println("done!");
	}
}

