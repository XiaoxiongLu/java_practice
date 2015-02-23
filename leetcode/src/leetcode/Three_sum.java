package leetcode;

import java.util.*;

public class Three_sum {
	
	public static List<List<Integer>> threeSum(int[] num) {
		List<List<Integer>> result = new ArrayList<List<Integer>> ();
        if (num == null || num.length < 3) return result;
        //List<Integer> orig_list = new ArrayList<Integer> ();
        Arrays.sort(num);
        Map<Integer, List<Integer>> curr_map = new HashMap<Integer, List<Integer>> ();
        for (int i = 0; i < num.length; i++) {
            //orig_list.add(num[i]);
            if (curr_map.containsKey(num[i])) {
                List<Integer> temp = curr_map.get(num[i]);
                temp.add(i);
                curr_map.put(num[i], temp);
            } else {
                List<Integer> temp = new ArrayList<Integer> ();
                temp.add(i);
                curr_map.put(num[i], temp);
            }
        }
        for (int i = 0; i < num.length - 2; i++) {
        	if (i > 0 && num[i] == num[i - 1]) continue;
            for (int j = i + 1; j < num.length - 1; j++) {
            	if (j > i + 1 && num[j] == num[j - 1]) continue;
                int target = 0 - (num[i] + num[j]);
                List<Integer> target_index_list = curr_map.get(target);
                if (target_index_list == null || target_index_list.isEmpty()) continue;
                int last_index = target_index_list.get(target_index_list.size() - 1);
                if (last_index > j) {
                    List<Integer> curr_result = Arrays.asList(num[i], num[j], num[last_index]);
                    result.add(curr_result);
                }
            }
        }
        return result;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int[] num = {-1, 0, 1, 2, -1, -4};
		int[] num = {};
		System.out.println(threeSum(num));
	}

}
