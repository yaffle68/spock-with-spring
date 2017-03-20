package com.example;

import com.google.common.collect.Range;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.time.LocalDateTime;

/**
 * Unit test for simple App.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
@ComponentScan
public class JavaTest {

    @Autowired
    private ShiftStore m_shiftStore;

//    @Before
//    public void setup() {
//        m_shiftStore = new ShiftStoreImpl();
//    }


    /**
     * Rigourous Test :-)
     */
    @Test
    public void testAddShift() {
        Range<LocalDateTime> shift1 = Range.closed(LocalDateTime.of(1988, 12, 3, 12, 34), LocalDateTime.of(1988, 12, 3, 16, 0));
        Range<LocalDateTime> shift2 = Range.closed(LocalDateTime.of(1988, 12, 3, 14, 34), LocalDateTime.of(1988, 12, 3, 17, 0));

        m_shiftStore.addShift(shift1);

        Object[] knownShifts = m_shiftStore.getShifts();

        Assert.assertTrue( knownShifts.length == 1 );
        Assert.assertTrue(knownShifts[0].equals(shift1));
    }

    @Configuration
    @ComponentScan("com.example")
    public static class SpringConfig {

    }
}
