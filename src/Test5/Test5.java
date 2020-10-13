package Test5;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-11 21:15
 **/
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

public class Test5 {
    public static void main(String[] args) {
        Test5 test5=new Test5();
        int[] preorder =new int[]{3,9,20,15,7};//前序
        int[] inorder  =new int[]{9,3,15,20,7};//中序
        TreeNode treeNode=test5.buildTree(preorder,inorder);
        System.out.println(treeNode.right.right.val);
    }
    int prP=0;
    int inP=0;
    public TreeNode buildTree(int[] preorder, int[] inorder){
//        return helper(0,0,inorder.length-1,preorder,inorder);
        return helper(preorder,inorder,Integer.MAX_VALUE);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int stop) {
        if(prP>preorder.length-1){
            return null;
        }
        if (inorder[inP]==stop){
            inP++;
            return null;
        }
        TreeNode treeNode=new TreeNode(preorder[prP++]);
        treeNode.left=helper(preorder,inorder,treeNode.val);
        treeNode.right=helper(preorder,inorder,stop);
        return treeNode;
    }


//    public TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
//        if (preStart>preorder.length-1 || inStart>inEnd){
//            return null;
//        }
//        TreeNode treeNode=new TreeNode(preorder[preStart]);
//        int index=0;
//        for (int i=inStart;i<=inEnd;i++){
//            if (inorder[i]==treeNode.val){
//                index=i;
//                break;
//            }
//        }
//        treeNode.left=helper(preStart+1,0,index-1,preorder,inorder);
//        treeNode.right=helper(preStart + index - inStart + 1,index+1,inEnd,preorder,inorder);
//        return treeNode;
//    }
}
