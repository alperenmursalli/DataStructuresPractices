/*Given two strings, check if they are one edit (or zero edits) away.
Insert a character
Remove a character
Replace a character

Return true if:
strings can be made equal with at most one edit

pale, ple    → true  (remove)
pales, pale  → true  (insert)
pale, bale   → true  (replace)
pale, bake   → false (2 edits)

Patterns: Two Pointer
*/


public class oneAway {
    boolean isEdited(String s1,String s2){

       
        if (Math.abs((s1.length()-s2.length()))>1){
            return false;
        }

        if(s1.length()==s2.length()){
            boolean foundDiff=false;

            for (int i=0; i<s1.length();i++){
                if (s1.charAt(i)!=s2.charAt(i)){
                    if (foundDiff){
                        return false;
                    }
                    foundDiff=true;
                }
                
            }
            return true;
        }
        
        String shorter = s1.length() < s2.length() ? s1:s2;
        String longer = s2.length() < s1.length() ? s1:s2;

        int i=0;
        int j=0;
        boolean foundDiff = false;

        while (i<shorter.length() && j < longer.length()){
            if (shorter.charAt(i)!=longer.charAt(j)){
                if (foundDiff){
                    return false;
                }
                foundDiff=true;
                j++;
            }
            else{
            i++;
            j++;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        oneAway obj = new oneAway();

        System.out.println(obj.isEdited("pale", "ple"));   // true
        System.out.println(obj.isEdited("pales", "pale")); // true
        System.out.println(obj.isEdited("pale", "bale"));  // true
        System.out.println(obj.isEdited("pale", "bake"));  // false
        System.out.println(obj.isEdited("abc", "abc"));    // true
    }
    
}


