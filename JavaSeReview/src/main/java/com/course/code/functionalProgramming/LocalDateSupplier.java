package com.course.code.functionalProgramming;

import java.time.LocalDate;
import java.util.function.Supplier;

public class LocalDateSupplier  implements Supplier<LocalDate> {

    LocalDate start = LocalDate.of(2023,1,1);
    int n = -1;
    @Override
    public LocalDate get() {
        n++;
        return start.plusDays(n);
    }
}
