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
		 // �߽���֤
		 if(preOrder == null || preOrder.length ==0 || inOrder == null || inOrder.length <=0 ||preOrder.length != inOrder.length){
			 return null;
		 }
		 // ǰ������ĵ�һ���ڵ�Ϊroot
		 TreeNode root = new TreeNode(preOrder[start]);
		 
		 int value = preOrder[start];
		 // �ݹ���ֹ
		 if(length == 1){
			 return root;
		 }
		 // Ѱ�������������ֵ�
		 int i=0;
		 while(value!=inOrder[end-i]){
			 i++;
		 }
		 
		 //�󻮷�����
		 root.left = buildTree(preOrder,start+1,inOrder,end-i-1,length-i-1);
		 //�һ�������
		 root.right = buildTree(preOrder,start+i+1,inOrder,end,i);
		 return root;
	 }
	 //  �������������   
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


