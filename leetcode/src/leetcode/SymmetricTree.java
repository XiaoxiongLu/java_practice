package leetcode;
import java.util.*;

public class SymmetricTree {

	/**
	 * @param args
	 */
	public static boolean isListSymmetic(List list) {
        if (list.size() == 0) return true;
        int i = 0;
        int j = list.size() - 1;
        while(i <= j){
            if (i == j) return false;
            if (list.get(i) != list.get(j)) return false;
            i++;
            j--;
        }
        return true;
    }
    
    public static boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        ArrayList<TreeNode> old_list = new ArrayList<TreeNode>();
        ArrayList<TreeNode> new_list = new ArrayList<TreeNode>();
        old_list.add(root);
        while(old_list.size() != 0) {
            TreeNode temp = old_list.remove(0);
            if (temp.left != null) new_list.add(temp.left);
            if (temp.right != null) new_list.add(temp.right);
            if (old_list.size() == 0) {
                if (!isListSymmetic(new_list)) return false;
                old_list = new_list;
                new_list = new ArrayList<TreeNode>();
            }
        }
        return true;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(2);
		a.left = b;
		a.right = c;
		System.out.println(isSymmetric(a));
	}

}
