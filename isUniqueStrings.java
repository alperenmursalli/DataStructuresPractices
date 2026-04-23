import java.util.HashSet;
import java.util.Set;
import java.util.Arrays;

public class isUniqueStrings {
    /*
    boolean isUniqueStrings(String s){
        Set<Character> set = new HashSet<>();

        if (s == null) return true; //edge case

        for (char c : s.toCharArray()){
            if (set.contains(c)){
                return false;
            }
            set.add(c);
        }
        return true;
    }*/

    //without extra space

    boolean isUnique(String s){
        if (s == null) return true;

        char[] arr = s.toCharArray();

        Arrays.sort(arr);

        for (int i=1;i<arr.length; i++){
            if (arr[i]==arr[i-1]){
                return false;
            }
        }
        return true;
    }
}

