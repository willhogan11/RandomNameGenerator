package ie.gmit.sw;

public class Runner {

	public static void main(String[] args) throws Exception {
		
		Names names = new Names();
		
		names.readFiles();
		names.setRandNameOne();
		names.setRandNameTwo();
		names.createRandomName();
		
		names.displayOneName();
	}
}