package com.gxu.tbvp.controller;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import static java.lang.Math.log;

//基于用户的协同过滤算法
public class Test {

    public static void main(String[] args) {
        int[] xs ={1,2,1};
        Test test = new Test();
        double d = test.entropy(xs);
        System.out.printf("%.2f", d);
    }

    double entropy(int[] xs){
        double hx = 0;
        Map<Double, Double> map = new HashMap<>();
        for (double x:xs){
            map.put(x, map.containsKey(x) ? map.get(x) + 1 : 1);
        }
        for (Map.Entry<Double, Double> en: map.entrySet()) {
            Double value = en.getValue();
            hx += (value/xs.length)*(log(value/xs.length)/log(2));
        }
        return -hx;
    }



}
