package enigma;

import java.util.ArrayList;
import java.util.Hashtable;
//import java.util.ListIterator;
import java.util.Map;

public class EncodeDecode {
	
    	
    //Hash table fields to map alphabet letter to number and vice versa
    private Map<Character, Integer> alphabetMap= new Hashtable<>();
    private Map<Integer, Character> alphabetMapNumIndex= new Hashtable<>();
    
    //creates the hash table to lookup numbers from letters
    public void createAlphabetMap() {
        int index = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetMap.put(c, index);
            index++;
        }
    }
	
	//creates the hash table to look up letters from numbers
    public void createAlphabetMapNumIndex() {
        int index = 1;
        for (char c = 'a'; c <= 'z'; c++) {
            alphabetMapNumIndex.put(index, c);
            index++;
        }
    }    
    
    public int letterToNumber(Character letter) {
        return alphabetMap.get(letter);
    }	
    
    public String encodeDecode(ArrayList<Character> messageAsCharArray, String keyword, String encodeOrDecode) {
    	createAlphabetMap();
        createAlphabetMapNumIndex();
		ArrayList<Character> messageEncoded = new ArrayList<>();
		//ListIterator<Character> i = messageAsCharArray.listIterator();
		char[] codeWordDigits = keyword.toCharArray();
		int codeWordIndex = 0;
        for (char c : messageAsCharArray) {
            int letterToNumber = letterToNumber(c);
            if (codeWordIndex > (codeWordDigits.length - 1)) {
                codeWordIndex = codeWordIndex % (codeWordDigits.length);
            }
            int codeNumber = codeWordDigits[codeWordIndex] - '0';
            if (encodeOrDecode.equals("Encode")) {            
            	messageEncoded.add(NumberToLetter(letterToNumber + codeNumber));
            	codeWordIndex++;
            }
            else {
            	messageEncoded.add(NumberToLetter(letterToNumber - codeNumber));
            	codeWordIndex++;
            }
        }
        if (encodeOrDecode.equals("Encode")) {
        String messageEncodedAsString = messageEncodedAsString(messageEncoded);
		return messageEncodedAsString;
        }
        else {
        	return messageEncoded.toString().replace(",", "").replace("[", "").replace("]", "").trim().replace(" ", "");
        }
     }
        
     public Character NumberToLetter(int number) {
            if (number > 26) {
                number = number % 26;
            }
            if (number < 1) {
                number = number + 26;
            }
            return alphabetMapNumIndex.get(number);
        }
     
     public String messageEncodedAsString(ArrayList<Character> messageEncoded) {
         StringBuilder str = new StringBuilder();
         int index = 0;
         for (char c : messageEncoded) {
             if (index % 5 == 0) {
                 str.append(" ");
                 str.append(c);
             }
             else {
                 str.append(c);
             }
             index++;
         }
         return str.toString();
     }

}
