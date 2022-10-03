package com.accumulation.valley;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author : liushaogeng
 * create at:  2021/6/17
 * @description:
 */
public class ValleyTest {
    private PeakIndex peakIndex;
    @Before
    public void setUp() throws Exception {
        peakIndex = new PeakIndex();
    }

    @After
    public void tearDown() throws Exception {
        peakIndex = null;
    }

    @Test
    public void testPeakIndexInMountainArray() {
        try{
            // 测试
            int idx = peakIndex.peakIndexInMountainArray(new int[]{1});
            assertEquals(idx, 0);
            // 测试
            idx = peakIndex.peakIndexInMountainArray(new int[]{1,2});
            assertEquals(idx, 0);
            // 测试
            idx = peakIndex.peakIndexInMountainArray(new int[]{3,1,2});
            assertEquals(idx, 0);
            // 测试
            // 测试
            idx = peakIndex.peakIndexInMountainArray(new int[]{2,5,4,2});
            assertEquals(idx, 1);

            // 测试
            idx = peakIndex.peakIndexInMountainArray(new int[]{2,5,4,2,1});
            assertEquals(idx, 1);

            // 测试
            idx = peakIndex.peakIndexInMountainArray(new int[]{2,3,5,2,1});
            assertEquals(idx, 2);

            // 测试
            idx = peakIndex.peakIndexInMountainArray(new int[]{0,2,3,5,2,1});
            assertEquals(idx, 3);

            // 测试
            idx = peakIndex.peakIndexInMountainArray(new int[]{0,2,1});
            assertEquals(idx, 1);

            // 测试
            idx = peakIndex.peakIndexInMountainArrayByThree(new int[]{2,5,4,2});
            assertEquals(idx, 1);

            // 测试
            idx = peakIndex.peakIndexInMountainArrayByThree(new int[]{2,5,4,2,1});
            assertEquals(idx, 1);

            // 测试
            idx = peakIndex.peakIndexInMountainArrayByThree(new int[]{2,3,5,2,1});
            assertEquals(idx, 2);

            // 测试
            idx = peakIndex.peakIndexInMountainArrayByThree(new int[]{0,2,3,5,2,1});
            assertEquals(idx, 3);

            // 测试
            idx = peakIndex.peakIndexInMountainArrayByThree(new int[]{0,2,1});
            assertEquals(idx, 1);

        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
