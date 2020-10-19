package Sword_Offer.TreeNode;

import Util.TreeNode;

import java.util.Arrays;

/**
 * @Author XiongWei
 * @WriteTime 2020-10-11 21:15
 **/
public class Test {
    public static void main(String[] args) {
        Test test =new Test();
        int[] preorder =new int[]{3,9,20,15,7};//前序
        int[] inorder  =new int[]{9,3,15,20,7};//中序
        TreeNode treeNode= test.buildTree(preorder,inorder);
        int[][] TOlder=TreeOlder(treeNode);
        System.out.println(Arrays.deepToString(TOlder));
    }

    private static int preOlder=0;
    private static int midOlder=0;
    private static int backOlder=0;

    private static int[][] TreeOlder(TreeNode treeNode) {
        int n=count(treeNode);
        int[][] result=new int[3][n];
        Older(treeNode,result);
        return result;
    }

    private static void Older(TreeNode treeNode, int[][] result) {
        if (treeNode==null){
            return;
        }
        result[0][preOlder++]=treeNode.val;
        Older(treeNode.left,result);
        result[1][midOlder++]=treeNode.val;
        Older(treeNode.right,result);
        result[2][backOlder++]=treeNode.val;
    }

    //计算树枝和叶子
    private static int count(TreeNode treeNode) {
        if (treeNode==null){
            return 0;
        }
        return 1+count(treeNode.left)+count(treeNode.right);
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


//    public Sword_Offer.TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
//        if (preStart>preorder.length-1 || inStart>inEnd){
//            return null;
//        }
//        Sword_Offer.TreeNode treeNode=new Sword_Offer.TreeNode(preorder[preStart]);
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
