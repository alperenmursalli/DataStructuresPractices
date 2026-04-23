import java.util.Set;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;

public class checkPermutation {
    boolean isPermutation(String s1, String s2){
        Map<Character, Integer> map = new HashMap<>();
        if (s1.length()!=s2.length()){
            return false;
        }

        for (char c : s1.toCharArray()){
            map.put(c,map.getOrDefault(c,0)+1);
        }

        for (char c : s2.toCharArray()){
            if(!map.containsKey(c)){
                return false;}
            
            map.put(c, map.get(c)-1);
            if (map.get(c)==0){
                 map.remove(c);}

        }

        return map.isEmpty();


    }
    
    public static void main(String[] args) {

        checkPermutation obj = new checkPermutation();

        // Test cases
        System.out.println(obj.isPermutation("abc", "bca"));   // true
        System.out.println(obj.isPermutation("abc", "abcd"));  // false
        System.out.println(obj.isPermutation("aabc", "abca")); // true
        System.out.println(obj.isPermutation("aabc", "abc"));  // false
        System.out.println(obj.isPermutation("hello", "llheo"));// true
        System.out.println(obj.isPermutation("hello", "world"));// false
    }
}
