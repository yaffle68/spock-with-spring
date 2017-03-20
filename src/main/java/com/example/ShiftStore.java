package com.example;

import com.google.common.collect.Range;

import java.time.LocalDateTime;

/**
 * Created by simon.harding on 16.03.2017.
 */
public interface ShiftStore {
    void addShift(Range<LocalDateTime> shift);

    Object[] getShifts();
}
