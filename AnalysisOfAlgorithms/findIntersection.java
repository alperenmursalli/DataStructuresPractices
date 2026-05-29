import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// Problem: Given two sets/arrays A and B, find the numbers that appear in both.
// Brute-force solution: compare every element of A with every element of B.
// Presorting solution: sort both arrays, then scan them with two pointers.
public class findIntersection {
	public static List<Integer> bruteForceIntersection(int[] a, int[] b) {
		List<Integer> section = new ArrayList<Integer>();
        

        for (int i=0;i<a.length;i++ ){
            for (int j=0; j<b.length;j++){
                if (a[i]==b[j] && !section.contains(a[i])){
                    section.add(a[i]);
                }
            }
        }
        return section;

	}

	public static List<Integer> presortIntersection(int[] a, int[] b) {
        List<Integer> section = new ArrayList<Integer>();

        int[] sortedA = Arrays.copyOf(a, a.length);
        int[] sortedB = Arrays.copyOf(b, b.length);

        Arrays.sort(sortedA);
        Arrays.sort(sortedB);
        
        int i=0;
        int j=0;
        
        while (i<sortedA.length&& j<sortedB.length){
            if(sortedA[i]== sortedB[j]){
                if (section.isEmpty() || section.get(section.size() - 1) != sortedA[i]) {
                    section.add(sortedA[i]);
                }
                i++;
                j++;
            }
            else if (sortedA[i]<sortedB[j]){
                i++;
            }
            else{
                j++;
            }
        }


        return section;

	}

	public static void main(String[] args) {
		int[] a = { 1, 2, 3, 4, 5, 7, 9, 9 };
		int[] b = { 3, 4, 4, 5, 6, 9, 10 };

		List<Integer> bruteForce = bruteForceIntersection(a, b);
		List<Integer> presort = presortIntersection(a, b);

		System.out.println("A = " + Arrays.toString(a));
		System.out.println("B = " + Arrays.toString(b));
		System.out.println("Brute-force intersection = " + bruteForce);
		System.out.println("Presorting-based intersection = " + presort);
		System.out.println("Brute-force efficiency class: O(nm)");
		System.out.println("Presorting-based efficiency class: O(n log n + m log m)");
	}
}
