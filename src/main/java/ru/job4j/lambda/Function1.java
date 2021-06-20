package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Function1 {
    public static List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> res = new ArrayList<>();
        for (double i = start; i < end; i++) {
            res.add(func.apply(i));
        }
        return res;
    }
}
