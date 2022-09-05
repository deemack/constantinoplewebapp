package enigma;

import java.util.Arrays;

public class SortString {
	
    public String sortString(String string) {
        char[] tempArray = string.toCharArray();
        Arrays.sort(tempArray);
        return new String(tempArray);
    }
}
