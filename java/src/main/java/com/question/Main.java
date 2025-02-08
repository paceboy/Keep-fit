package com.question;

import com.accumulation.answer.BinaryTree;
import com.accumulation.answer.BinaryTreeNode;

import java.util.List;

/**
 * @author liushaogeng
 * @date 2022/10/3 17:32
 * @description
 */
public class Main {
    public static void main(String[] args) {

//        MinumPath minumPath = new MinumPath();
//        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
//        System.out.println (minumPath.minPathSum(grid));
//
//        int [][] grid1 = {{1,2,3}, {4,5,6}};
//        System.out.println (minumPath.minPathSum(grid1));

        // 二叉树的按叶子结点往根节点的排序遍历
//        BinaryTree binaryTree = new BinaryTree();
//        BinaryTreeNode root ;
////      Example root = [3,9,20,null,null,15,7]
//        BinaryTreeNode left = new BinaryTreeNode(9, null, null);
//        BinaryTreeNode right = new BinaryTreeNode(20 , new BinaryTreeNode(15), new BinaryTreeNode(7));
//        BinaryTreeNode node = new BinaryTreeNode(3, left, right);
//        root =  node;
//        List<List<Integer>> listOfLists = binaryTree.levelOrderBottomByYourself(root);
//        for(List<Integer> innerList : listOfLists) {
//            for(Integer number : innerList) {
//                System.out.print(number);
//                System.out.print(',');
//            }
//            System.out.println();
//        }

//        ClimbStairs climbStairs = new ClimbStairs();
//        int ret = climbStairs.solution(7);
//        System.out.printf("climbStairs ret = %d\n", ret);

//        String pn = "1-23-45 6";
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
//
//        pn = "123 4-567";
//        ReformatNumber.formatNumber(pn);
//
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
//
//        pn = "123 4-5678";
//        ReformatNumber.formatNumber(pn);
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
//
//        pn = "12";
//        ReformatNumber.formatNumber(pn);
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
//
//        pn = "--17-5 229 35-39475 ";
//        ReformatNumber.formatNumber(pn);
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
//
//        pn = "1234";
//        ReformatNumber.formatNumber(pn);
//        System.out.printf("formatNumber : pn = %s, formatNumber = %s", pn, ReformatNumber.formatNumber(pn));
        BinaryTree binaryTree = new BinaryTree();
        BinaryTreeNode root ;
        BinaryTreeNode left1 = new BinaryTreeNode(1, new BinaryTreeNode(4), new BinaryTreeNode(5));
        BinaryTreeNode right1 = new BinaryTreeNode(2, new BinaryTreeNode(3), new BinaryTreeNode(2));
        BinaryTreeNode left = new BinaryTreeNode(9, left1, right1);
        BinaryTreeNode left2 = new BinaryTreeNode(10, new BinaryTreeNode(11), new BinaryTreeNode(12));
        BinaryTreeNode right2 = new BinaryTreeNode(13, new BinaryTreeNode(14), new BinaryTreeNode(15));
        BinaryTreeNode right = new BinaryTreeNode(20 , left2, right2);
        BinaryTreeNode node = new BinaryTreeNode(3, left, right);
        root =  node;
        List<List<Integer>> listOfLists = binaryTree.levelOrderBottomByYourself(root);
        for(List<Integer> innerList : listOfLists) {
            for(Integer number : innerList) {
                System.out.print(number);
                System.out.print(',');
            }
            System.out.println();
        }
    }
}
