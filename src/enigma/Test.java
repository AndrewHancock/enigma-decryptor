package enigma;

public class Test {

		public static void main(String[] args)
		{			
			EnigmaMachine machine = EnigmaFactory.buildEnigmaMachine();
			
			String test = "AAAAAAAAAAAAAAAAAAAAAAAAAAA";			
			System.out.println(test);
			
			machine.setRotors(5,  9, 14);
			System.out.println(machine.encodeLine(test));
		}
}
