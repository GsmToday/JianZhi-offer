public class Problem18 {
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
	 public static TreeNode buildTree(int[] preOrder,int start, int[] inOrder,int end,int length){    
		 // 边界验证
		 if(preOrder == null || preOrder.length ==0 || inOrder == null || inOrder.length <=0 ||preOrder.length != inOrder.length){
			 return null;
		 }
		 // 前序遍历的第一个节点为root
		 TreeNode root = new TreeNode(preOrder[start]);
		 
		 int value = preOrder[start];
		 // 递归终止
		 if(length == 1){
			 return root;
		 }
		 // 寻找左右子树划分点
		 int i=0;
		 while(value!=inOrder[end-i]){
			 i++;
		 }
		 
		 //左划分子树
		 root.left = buildTree(preOrder,start+1,inOrder,end-i-1,length-i-1);
		 //右划分子树
		 root.right = buildTree(preOrder,start+i+1,inOrder,end,i);
		 return root;
	 }
	 //  后序遍历二叉树   
	    private static void postOrder(TreeNode root) {  
	        if (root == null) {  
	            return;  
	        }  
	        postOrder(root.left);  
	        postOrder(root.right);  
	        System.out.print(root.val+" ");  
	    }  
	  
	  
	    public static void main(String[] args) {   
	        //char[] preOrder = new char[] {'1', '2', '4', '5', '3', '6'};    
	        int[] preOrder = new int[] {10,6,4,8,14,12,16};    
	        //char[] inOrder = new char[] {'4', '2', '5', '1', '6', '3'};    
	        int[] inOrder = new int[] {4,6,8,10,12,14,16};    
	        TreeNode root = buildTree(preOrder, 0, inOrder, inOrder.length - 1, inOrder.length);   


	        postOrder(root);  
	    }    
}    


