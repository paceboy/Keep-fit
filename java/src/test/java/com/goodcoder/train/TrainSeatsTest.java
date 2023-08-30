package com.goodcoder.train;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author : liushaogeng
 * create at:  2020/12/14
 * @description:
 */
public class TrainSeatsTest {
    private TrainSeats trainSeats;

    @Before
    public void setUp() throws Exception {
        trainSeats = new TrainSeats();
    }

    @After
    public void tearDown() throws Exception {
        trainSeats = null;
    }

    @Test
    public void testAllocateSeats() {
        try{
            // 同排逻辑测试
            trainSeats.allocateSeats(4, new int[]{2,5,4,2});
            int[][]seats = new int[TrainSeats.ROW][TrainSeats.COLUMN];
            seats[0] = new int[]{4,1,1,1,1,0};
            seats[1] = new int[]{5,1,1,1,1,1};
            seats[2] = new int[]{4,1,1,1,1,0};
            assertEquals(trainSeats.getSeats(), seats);

            // 分排逻辑测试
            trainSeats.allocateSeats(21, new int[]{4,3,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,3});
            seats = new int[TrainSeats.ROW][TrainSeats.COLUMN];
            for (int i=0;i<TrainSeats.ROW;i++){
                seats[i] = new int[]{5,1,1,1,1,1};
            }
            assertEquals(trainSeats.getSeats(), seats);

            // 异常测试
            try{
                trainSeats.allocateSeats(3, new int[]{4,3});
            }catch(Exception e){
                e.printStackTrace();
                seats = new int[TrainSeats.ROW][TrainSeats.COLUMN];
                trainSeats = new TrainSeats();
                assertEquals(trainSeats.getSeats(), seats);
            }


            // 异常测试
            try{
                trainSeats.allocateSeats(2, new int[]{6,3});
            }catch(Exception e){
                e.printStackTrace();
                seats = new int[TrainSeats.ROW][TrainSeats.COLUMN];
                trainSeats = new TrainSeats();
                assertEquals(trainSeats.getSeats(), seats);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testSetSeats() {
        trainSeats.setSeats(new int[][]{});
        assertEquals(trainSeats.getSeats(), new int[][]{});

        trainSeats.setSeats(new int[][]{{1}});
        assertEquals(trainSeats.getSeats(), new int[][]{{1}});
    }

    @Test
    public void printSeats() {
        trainSeats.setSeats(new int[][]{});
        trainSeats.printSeats();
        assertEquals(trainSeats.getSeats(), new int[][]{});

        try{
            trainSeats.setSeats(new int[][]{{1}});
            trainSeats.printSeats();
        }catch(Exception e){
            e.printStackTrace();
        }
        assertEquals(trainSeats.getSeats(), new int[][]{{1}});
    }
}
