package com.goodcoder.train;

import com.interview.list.List;
import com.interview.solution.Solution;
import com.interview.sort.QuickSort;

/**
 * @author : liushaogeng
 * create at:  2020/12/14
 * @description: 火车票座位分配算法测试
 */
public class Main {
    public static void main(String[] args) {
        // Solution rotate = new Solution();
        // System.out.println(rotate.rotate(1534236469));
        //
        // List.Node node = new List.Node(1);
        // List.Node node1 = new List.Node(4);
        // List.Node node2 = new List.Node(6);
        // node1.setNext(node2);
        // node.setNext(node1);
        //
        // List.Node node2_1 = new List.Node(2);
        // List.Node node2_2 = new List.Node(3);
        // List.Node node2_3 = new List.Node(5);
        // node2_2.setNext(node2_3);
        // node2_1.setNext(node2_2);
        //
        // List list = new List();
        // // List.Node ret = list.merge(node, node2_1);
        // List.Node ret = list.mergeNoRec(node, node2_1);
        // // List.Node ret = list.MergeTwoOrderedLists(node, node2_1);
        //
        // while(ret!=null){
        //     System.out.printf("val = %d ", ret.getVal());
        //     ret = ret.getNext();
        // }

        QuickSort quickSort = new QuickSort();
        int[] a = {3,2,4,5,1,6};
        quickSort.quickSort(a,0, a.length-1);
        quickSort.display(a);

        // System.out.println(rotate.rotate(1234567));
        // System.out.println(rotate.rotate(1230));

        // TrainSeats trainSeats = new TrainSeats();
        // try {
        //     // 同排逻辑测试
        //     trainSeats.allocateSeats(4, new int[]{2, 5, 4, 2});
        //     trainSeats.printSeats();
        //
        //     // 分排逻辑测试
        //     trainSeats = new TrainSeats();
        //     trainSeats.setSeats(new int[TrainSeats.ROW][TrainSeats.COLUMN]);
        //     trainSeats.allocateSeats(21, new int[]{4, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3});
        //     trainSeats.printSeats();
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
    }

}
