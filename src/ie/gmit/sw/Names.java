package ie.gmit.sw;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Names {

	private Random rand;
	private List<String> nameOne, nameTwo;
	private String[] randNameOne, randNameTwo;
	private String line;
	private static final String nameFile1 = "names1.txt";
	private static final String nameFile2 = "names2.txt";
	private BufferedReader br1, br2;

	
	public Names() {
		rand = new Random();
		nameOne = new ArrayList<String>();
		nameTwo = new ArrayList<String>();
	}
	
	public String[] setRandNameOne() {
		randNameOne = new String[nameOne.size()];
		return randNameOne;
	}
	
	public String[] setRandNameTwo() {
		randNameTwo = new String[nameTwo.size()];
		return randNameTwo;
	}
	
	public void createRandomName() {
		for (int i = 0; i < nameOne.size(); i++) {
			randNameOne[i] = nameOne.get(rand.nextInt(nameOne.size())); 
			randNameTwo[i] = nameTwo.get(rand.nextInt(nameTwo.size())); 
		}
	}
	
	public void gatherFileData(BufferedReader bufferedReader, String nameFile, List<String> nameList) throws Exception {		
		bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(nameFile)));
		
		while( (line = bufferedReader.readLine()) != null) {
			String[] stuff = line.split(" ");
			nameList.add(stuff[0]);
		}
		bufferedReader.close();
	}
	
	
	public void readFiles() throws Exception {
		gatherFileData(br1, nameFile1, nameOne);
		gatherFileData(br2, nameFile2, nameTwo);
	}
	
	public void displayNames(){
		for (int i = 0; i < nameOne.size(); i++) {
			System.out.println(randNameOne[i] + " " + randNameTwo[i]);
		}
	}
	
	public void displayOneName(){
		System.out.println("Your Random Name is: " + randNameOne[0] + " " + randNameTwo[0]);
	}
}