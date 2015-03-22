// 根据中序+后序遍历结果重构二叉树
public class Problem18_2 {
	static class TreeNode{
		private int val;
		private TreeNode left;
		private TreeNode right;
		TreeNode(){
			this.val = 0;
			this.left = null;
			this.right = null;
		}
		TreeNode(int val){
			this.val = val;
			this.left = null;
			this.right = null;
		}
	}
	public static TreeNode buildTree(int postOrder[], int pend, int inOrder[],int iend, int length){
		//boundary test
		if(postOrder == null || postOrder.length == 0 || inOrder == null || inOrder.length == 0 || postOrder.length != inOrder.length)
		{
			System.out.print("te");  
			return null;
		}
		//create root;
		TreeNode root = new TreeNode();
		int value = postOrder[pend];
		root.val = value;
		
		if(length ==1)
			return root;
		// search the index of the root in inorder
		int i =0;
		while(inOrder[iend-i]!=value){
			i++;
		}
		
		root.right =  buildTree(postOrder, pend-1, inOrder, iend,  i);	
		root.left =  buildTree(postOrder,  pend-i-1, inOrder, iend-i-1,  length-i-1);
		return root;
		
	}
	 //  前序遍历二叉树      
	 private static void preOrder(TreeNode root) {  
	        if (root == null) {  
	            return;
	            
	        }  
	        System.out.print(root.val+" ");  
	        preOrder(root.left);  
	        preOrder(root.right);  
	       
	    }
	
	 public static void main(String[] args) {
			// TODO Auto-generated method stub
			//char[] preOrder = new char[] {'1', '2', '4', '5', '3', '6'};    
	        //int[] preOrder = new int[] {10,6,4,8,14,12,16};    
			int[] postOrder = new int[] {4,8,6,12,16,14,10};    
	        //char[] inOrder = new char[] {'4', '2', '5', '1', '6', '3'};    
	        int[] inOrder = new int[] {4,6,8,10,12,14,16};    
	        TreeNode root = buildTree(postOrder, postOrder.length-1, inOrder, inOrder.length - 1, inOrder.length);   


	        preOrder(root);  
		}
}
