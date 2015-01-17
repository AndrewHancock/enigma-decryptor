package enigma;

public class Rotor {
	private int position;
	
	protected char[] leftToRightWiring = new char[Symbol.MAX];
	protected char[] rightToLeftWiring = new char[Symbol.MAX];
	
	public Rotor(String s){
		for(int i = 0; i < s.length(); i++){
			char currentChar = s.charAt(i);
			leftToRightWiring[i] = currentChar;
			

			rightToLeftWiring[Symbol.getOffset(currentChar)] = (char)(Symbol.getSymbolAtOffset(i));			
		}	
	}
		
	public char encodeLR(char c)
	{
		int index = Symbol.getOffset(c) + position;
		if(index > Symbol.MAX - 1)
			index -= Symbol.MAX;
		return leftToRightWiring[index];
	}
		
	public char encodeRL(char c){
		int index = Symbol.getOffset(c);
		if(index < 0)
			index = Symbol.MAX + index;
		int result = Symbol.getOffset((char)(rightToLeftWiring[index] - position));
		if(result < 0)
			result = Symbol.MAX  + result; 
		return (char)Symbol.getSymbolAtOffset(result);
	}
	
	public boolean inc()
	{
		if(position == Symbol.MAX - 1)
		{
			position = 0;
			return true;
		}
		else
		{
			position++;
		}
		return false;
	}
	
	public void set(int n)
	{
		position = n;
	}
}
