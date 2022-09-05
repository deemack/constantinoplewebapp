package enigma;

import java.util.ArrayList;

public class TakeInput {
	
	public String takeInput(String codeword, int dayOfMonth, String message, String encodeOrDecode) {
		
		//convert the message to a char array and remove spaces. RETURNS ArrayList<Character>
		StringToCharArray stringToCharArray = new StringToCharArray();
		ArrayList<Character> messageAsCharArray = stringToCharArray.stringToCharArray(message);
		
		//sort the codeword alphabetically. RETURNS String
		SortString sortString = new SortString();
		String sortedCodeword = sortString.sortString(codeword);
		
		//multiply dayOfMonth by the codeword after it is transformed into a number, to get the keyword.
		//This is done by assigning each letter of the codeword with a number based
		//on its occurrence in the alphabet. For example, if the codeword is CONSTANTINOPLE 
		// A=1, C=2 (because there is no B in the codeword)
		// C  O  N  S   T   A  N  T   I  N  O   P   L  E
		// 2  9  6  12  13  1  7  14  4  8  10  11  5  3
		//RETURNS String
		Keyword keywordObj = new Keyword();
		String keyword = keywordObj.keyword(codeword, dayOfMonth, sortedCodeword);
		
		//encode the message 
		EncodeDecode encodeDecode = new EncodeDecode();
		String encodedMessage = encodeDecode.encodeDecode(messageAsCharArray, keyword, encodeOrDecode);
				
		
		return encodedMessage.stripLeading();
		
	}

}
