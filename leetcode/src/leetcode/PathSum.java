package leetcode;

public class PathSum {
	
	public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        int curr_sum = sum - root.val;
        if (curr_sum == 0) {
            return true;
        } else {
            return (hasPathSum(root.left, curr_sum) || hasPathSum(root.right, curr_sum));
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
