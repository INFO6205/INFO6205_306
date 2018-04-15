/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.test;


import com.me.main.Point;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author dell
 */
public class PointTest {
     @Test
    public void test1() throws Exception {
        Point p1=new Point(1,1);
        Point p2=new Point(3,1);
        double d=p1.distanceTo(p2);
        assertEquals(2,(int)d);
    }
}
