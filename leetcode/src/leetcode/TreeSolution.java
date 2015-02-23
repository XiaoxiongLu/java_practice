package leetcode;

public class TreeSolution {
	
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || inorder.length != postorder.length) return null;
        return recursiveBuildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    public static TreeNode recursiveBuildTree(int[] inorder, int[] postorder, int inorder_start, int inorder_end, int postorder_start, int postorder_end) {
        if (postorder_start > postorder_end) return null;
        System.out.println(postorder[postorder_end]);
        TreeNode root = new TreeNode(postorder[postorder_end]);
        int inorder_pivot = 0;
        for (int i = inorder_start; i <= inorder_end; i++) {
            if (inorder[i] == postorder[postorder_end]) {
                inorder_pivot = i;
                break;
            }
        }
        System.out.println("inorder_pivot: " + inorder_pivot);
        System.out.println("postorder_start: " + postorder_start);
        System.out.println("postorder_end: " + (postorder_start + (inorder_pivot - 1 - inorder_start)));
        root.left = recursiveBuildTree(inorder, postorder, inorder_start, inorder_pivot - 1, postorder_start, postorder_start + (inorder_pivot - 1 - inorder_start));
        root.right = recursiveBuildTree(inorder, postorder, inorder_pivot + 1, inorder_end, postorder_start + (inorder_pivot - inorder_start), postorder_end - 1);
        return root;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {-1};
		TreeNode c = buildTree(a, a);
		System.out.println(c.val);
	}

}
