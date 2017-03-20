package com.example

import com.google.common.collect.Range
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.test.context.ContextConfiguration
import spock.lang.Specification

import java.time.LocalDateTime

@ContextConfiguration
class SpockTest extends Specification {

    @Autowired
    ShiftStore shiftStore;

    def "a spock test"() {
        given:
//        ShiftStore shiftStore = new ShiftStoreImpl()
        Range<LocalDateTime> shift1 = Range.closed(LocalDateTime.of(1988, 12, 3, 12, 34), LocalDateTime.of(1988, 12, 3, 16, 0))

        when: "add a shift"
        shiftStore.addShift(shift1)
        Object[] knownShifts = shiftStore.getShifts()

        then: "expect value of the item"
        knownShifts.length == 1
        knownShifts[0].equals(shift1)
    }

    @Configuration
    @ComponentScan(basePackages = "com.example")
    static class SpringConfig {

    }
}
