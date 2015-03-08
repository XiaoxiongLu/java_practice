package leetcode;
import java.util.*;

public class ZigZigConvert {

	/**
	 * @param args
	 */
    public static String convert(String s, int nRows) {
        if (nRows == 1) return s;
        ArrayList<String> str_list = new ArrayList<String>();
        for (int i = 0; i < nRows; i++) { 
            str_list.add(i, ""); 
        }
        int iter_num = 2 * nRows - 2;
        for(int i = 0; i < s.length(); i++) {
            int rest_index = i % iter_num;
            if (rest_index < nRows) {
                String temp = str_list.get(rest_index);
                temp += s.charAt(i);
                str_list.set(rest_index, temp);
            } else {
                int adjusted_index = iter_num - rest_index;
                String temp = str_list.get(adjusted_index);
                temp += s.charAt(i);
                str_list.set(adjusted_index, temp);
            }
        }
        String result_str = "";
        for (int i = 0; i < str_list.size(); i++) {
            result_str += str_list.get(i);
        }
        return result_str;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String input = "ABC";
		System.out.println(convert(input, 2));
	}

}
