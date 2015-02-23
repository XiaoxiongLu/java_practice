package leetcode;
import java.util.*;

public class SearchInsertPostion {

	public static int searchInsert(int[] A, int target) {
        int start_index = 0;
        int end_index = A.length - 1;
        while(start_index <= end_index) {
            int mid_index = (start_index + end_index) / 2;
            if (A[mid_index] == target) {
                return mid_index;
            }
            if (A[mid_index] > target) {
                end_index = mid_index - 1;
            } else {
                start_index = mid_index + 1;
            }
        }
        A = addElement(A, A[A.length-1]);
        for(int i = A.length - 1; i > start_index; i--) {
        	A[i] = A[i - 1];
        }
        A[start_index] = target;
        return start_index;
    }
	
	public static int[] addElement(int[] a, int e) {
		System.out.println(a);
	    a  = Arrays.copyOf(a, a.length + 1);
	    a[a.length - 1] = e;
	    System.out.println(a);
	    return a;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,3,5,6};
		System.out.println(searchInsert(A, 2));
		int b = 1;
		long a = b;
	}

}
