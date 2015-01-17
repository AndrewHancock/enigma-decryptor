package enigma;

public class Symbol {
	// The maximum number of symbols considered for encryption
	public static final int MAX = 26;
	private static final int ASCII_OFFSET = 65;

	// The offset for a particular symbol.
	// e.g., A->0, B->1...Z->25
	public static int getOffset(char symbol)
	{
		return symbol - ASCII_OFFSET;
	}
	
	// The Symbol corresponding to a particular offset.
	// e.g., 0->A, 1->B... 25->Z
	public static int getSymbolAtOffset(int offset)
	{
		return (char)(offset + ASCII_OFFSET);
	}	
	
	// Return true if symbol is ignored for encryption (punctuation, spaces, etc.)
	public static boolean ignoreSymbol(char symbol)
	{
		return symbol < 'A' || symbol > 'Z';
	}

}
