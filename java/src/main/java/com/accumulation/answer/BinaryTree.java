package com.accumulation.answer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTree {

    /*
     * 给你二叉树的根节点 root ，返回其节点值 自底向上的层序遍历 。 （即按从叶子节点所在层到根节点所在的层，逐层从左向右遍历）
     * 示例 1：
        输入：root = [3,9,20,null,null,15,7]
        输出：[[15,7],[9,20],[3]]
        示例 2：

        输入：root = [1]
        输出：[[1]]
        示例 3：

        输入：root = []
        输出：[]
     * Param: root 传入的二叉树根节点
     * Return：返回
     * */
    public List<List<Integer>> levelOrderBottomByYourself(BinaryTreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList();
        if (root == null) {
            return levelOrder;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            List<Integer> singleLevel = new ArrayList();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                BinaryTreeNode binaryTreeNode = queue.poll();
                singleLevel.add(binaryTreeNode.val);

                BinaryTreeNode left = binaryTreeNode.left;
                BinaryTreeNode right = binaryTreeNode.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(0, singleLevel);
        }
        return levelOrder;
    }

    /*
     给定这样一个二叉树结构，对这样一个root节点，从左子节点开始蛇形层次遍历输出整棵树的节点值
    比如：
            1
         |-----|
         2     3
       |---|   ---|
       4   5      6
    |---   ---|
    7         8
    输出12365478

    比如：
            a
         |-----|
         b     c
       |---|
       d   e
           ---|
              h
    输出abcedh

     * Param: root 传入的二叉树根节点
     * Return：返回
     * */
    public List<List<Integer>> levelOrderByYourself(BinaryTreeNode root) {
        List<List<Integer>> levelOrder = new LinkedList();
        if (root == null) {
            return levelOrder;
        }

        Queue<BinaryTreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            List<Integer> singleLevel = new ArrayList();
            int size = queue.size();
            for(int i=0;i<size;i++) {
                BinaryTreeNode binaryTreeNode = queue.poll();
                if (level % 2 == 0) {
                    singleLevel.add(0, binaryTreeNode.val);
                } else {
                    singleLevel.add(binaryTreeNode.val);
                }

                BinaryTreeNode left = binaryTreeNode.left;
                BinaryTreeNode right = binaryTreeNode.right;
                if (left != null) {
                    queue.offer(left);
                }
                if (right != null) {
                    queue.offer(right);
                }
            }
            levelOrder.add(singleLevel);
            level++;
        }
        return levelOrder;
    }

}
