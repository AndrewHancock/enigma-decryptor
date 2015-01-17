package enigma;

public class EnigmaMachine {
	private Rotor r1;
	private Rotor r2;
	private Rotor r3;
	private Reflector r;
	
	public EnigmaMachine(Rotor r1, Rotor r2, Rotor r3, Reflector r)
	{
		this.r1 = r1;
		this.r2 = r2;
		this.r3 = r3;
		this.r = r;
	}
	
	private void incrementRotors()
	{
		if(r1.inc())
			if(r2.inc())
				r3.inc();
	}
	
	private char encodeChar(char ch)
	{
		char lr = r.encode(r3.encodeLR(r2.encodeLR(r1.encodeLR(ch))));		
		char rl = r1.encodeRL(r2.encodeRL(r3.encodeRL(lr)));
		incrementRotors();
		return rl;
	}
	
	private StringBuilder sb = new StringBuilder();
	public String encodeLine(String s)
	{
		sb.setLength(0);
		for(int i = 0; i < s.length(); i++)
		{
			char currentChar = s.charAt(i);
			if(!Symbol.ignoreSymbol(currentChar))
				currentChar = encodeChar(currentChar);
			sb.append(currentChar);
		}
		return sb.toString();
	}
	
	public void setRotors(int a, int b, int c)
	{
		r1.set(a);
		r2.set(b);
		r3.set(c);
	}
	
}
