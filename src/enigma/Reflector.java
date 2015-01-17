package enigma;

public class Reflector {
	private char[] wiring = new char[Symbol.MAX];
	
	public Reflector(String s){
		for(int i = 0; i < s.length(); i++){
			char currentChar = s.charAt(i);
			wiring[i] = currentChar;			
		}	
	}
	
	public char encode(char c)
	{
		return wiring[Symbol.getOffset(c)];
	}
}
