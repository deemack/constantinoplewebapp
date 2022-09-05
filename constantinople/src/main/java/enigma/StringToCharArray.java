package enigma;

import java.util.*;

public class StringToCharArray {
	
	public ArrayList<Character> stringToCharArray(String message) {
		ArrayList<Character> charArray = new ArrayList<>();
		for (char c : message.trim().replaceAll("\\s+","").toCharArray()) {
			charArray.add(c);
		}
		
		return charArray;
		
	}

}
