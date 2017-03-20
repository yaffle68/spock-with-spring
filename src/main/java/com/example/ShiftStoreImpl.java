package com.example;

import com.google.common.collect.Range;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by simon.harding on 16.03.2017.
 */
@Component
public class ShiftStoreImpl implements ShiftStore {

    private Set m_shifts = new HashSet<Range<LocalDateTime>>();

    @Override
    public void addShift(Range<LocalDateTime> shift) {
        m_shifts.add(shift);
    }

    @Override
    public Object[] getShifts() {
        return m_shifts.toArray();
    }
}
