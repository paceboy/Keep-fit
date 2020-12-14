package com.goodcoder.train;

/**
 * @author : liushaogeng
 * create at:  2020/12/14
 * @description: 火车票座位分配算法测试
 */
public class Main {
    public static void main(String[] args) {
        TrainSeats trainSeats = new TrainSeats();
        try {
            // 同排逻辑测试
            trainSeats.allocateSeats(4, new int[]{2, 5, 4, 2});
            trainSeats.printSeats();

            // 分排逻辑测试
            trainSeats = new TrainSeats();
            trainSeats.setSeats(new int[TrainSeats.ROW][TrainSeats.COLUMN]);
            trainSeats.allocateSeats(21, new int[]{4, 3, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 5, 3});
            trainSeats.printSeats();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
