/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.test;

import com.me.main.Gene;
import com.me.main.InsertionSort;
import com.me.main.Point;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

/**
 *
 * @author jm
 */
public class InsertionSortTest {
       @Test
    public void test1() throws Exception {
     InsertionSort<Integer> sc=new InsertionSort<Integer>();
     ArrayList<Integer> ai=new ArrayList<Integer>();
    ai.add(3);
    ai.add(4);
    ai.add(2);
    ai.add(1);
    ai.add(5);
    sc.sort(ai);
    assertEquals(1,(int)ai.get(0));
    assertEquals(2,(int)ai.get(1));
    assertEquals(3,(int)ai.get(2));
    assertEquals(4,(int)ai.get(3));
    assertEquals(5,(int)ai.get(4));
    }
    

}
