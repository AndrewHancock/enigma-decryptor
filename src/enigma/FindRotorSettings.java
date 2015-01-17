package enigma;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FindRotorSettings {
	private static final int ERRORS_ALLOWED = 4;
	private static final double MULTIPLIER = 1.0;
	private static final int NUMBER_OF_LINES = 3;
	
	public static void main(String[] args) throws FileNotFoundException{
		long startTime = System.currentTimeMillis();
		String[] lines = new String[3];
		Scanner scanner = new Scanner(new File(args[0]));		
		for(int i = 0; i < NUMBER_OF_LINES; i++)
		{
			lines[i] = scanner.nextLine();
		}
		
		scanner.close();
		
		EnigmaMachine machine = EnigmaFactory.buildEnigmaMachine();
		English english = new English(ERRORS_ALLOWED, MULTIPLIER);		
		for(int i = 0; i < Symbol.MAX; i++)
			for(int j = 0; j < Symbol.MAX; j++)
				for(int k = 0; k < Symbol.MAX; k++){
					machine.setRotors(i, j, k);
					
					for(int lineCounter = 0; lineCounter < lines.length; lineCounter++)
					{
						String line = machine.encodeLine(lines[lineCounter]);
						english.addLine(line);
					}
					if(english.isEnglish())
					{
						System.out.println("Potential rotor settings: " + i + ", " + j + ", " + k);
					}
					
					english.reset();
				}
		
		System.out.println("Execution time:" + (System.currentTimeMillis() - startTime) + " ms");
	}
	

}
