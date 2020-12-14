package com.goodcoder.train;

/**
 * @author : liushaogeng
 * create at:  2020/12/14
 * @description: 火车票座位分配算法
 * 假设一节车厢有20排、每一排5个座位。为方便起见，我们用1到100来给所有的座位编号，第一排是1到5号，第二排是6到10号，依次类推，第20排是96到100号。
 * 购票时，一个人可能购一张或多张票，最多不超过5张。如果这几张票可以安排在同一排编号相邻的座位，则应该安排在编号最小的相邻座位。否则应该安排在编号最小的几个空座位中（不考虑是否相邻）。
 * 假设初始时车票全部未被购买，现在给了一些购票指令，请你处理这些指令。
 */
public class TrainSeats {
    public static final int ROW = 20; // 座位行数
    public static final int COLUMN = 6; // 座位列数
    public static final int LIMIT_TICKET_COUNT = 5; // 每次票数的上限
    public static final int OCCUPY = 1; // 位置已被占用
    public static final int TICKETS_DETERMINE = 1; // 相应票数已经确定位置
    public static final int TICKETS_UNDETERMINE = 0; // 相应票数未确定位置

    private int[][] seats = new int[ROW][COLUMN]; // 座位

    /**
     * 根据买票数分配座位
     *
     * @param count   购票指令数量
     * @param tickets 购票数
     * @return
     */
    public void allocateSeats(int count, int[] tickets) throws Exception {
        if (count != tickets.length) {
            throw new Exception(String.format("购票指令数和购票数不一致"));
        }
        for (int t : tickets) {
            try {
                match(t);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 通过票数匹配位置
     *
     * @param ticket 票数
     * @return
     */
    private void match(int ticket) throws Exception {
        if (ticket > LIMIT_TICKET_COUNT) {
            throw new Exception(String.format("票数越界，不可超过%d", LIMIT_TICKET_COUNT));
        }
        int found = TICKETS_UNDETERMINE; // 找到位置的标识
        // 同排分配位置
        for (int i = 0; i < ROW && found == TICKETS_UNDETERMINE; i++) {
            if (COLUMN - seats[i][0] - 1 >= ticket) {
                int ti = seats[i][0] > 0 ? seats[i][0] + 1 : 1;
                for (int t = ti; t < ti + ticket; t++) {
                    seats[i][t] = OCCUPY;
                    System.out.printf("同排分配位置 %d ", i * (COLUMN - 1) + t);
                }
                System.out.println();
                seats[i][0] += ticket;
                found = TICKETS_DETERMINE;
            }
        }
        // 未确定位置，分排分配位置
        if (found == TICKETS_UNDETERMINE) {
            for (int i = 0; i < ROW; i++) {
                for (int j = seats[i][0] + 1; j < COLUMN && ticket > 0; j++) {
                    seats[i][j] = OCCUPY;
                    System.out.printf("分排分配位置 %d", i * (COLUMN - 1) + j);
                    seats[i][0]++;
                    ticket--;
                    found = TICKETS_DETERMINE;
                }
            }
            if (found == TICKETS_DETERMINE) {
                System.out.println();
            }
        }
    }

    /**
     * 输出座位信息
     *
     * @param
     * @return
     */
    public void printSeats() {
        for (int[] i : getSeats()) {
            for (int j : i) {
                System.out.print(j + ",");
            }
            System.out.println();
        }
    }

    /**
     * 获取座位号
     *
     * @param
     * @return
     */
    public int[][] getSeats() {
        return seats;
    }

    /**
     * 设置座位号
     *
     * @param seats
     * @return
     */
    public void setSeats(int[][] seats) {
        this.seats = seats;
    }
}