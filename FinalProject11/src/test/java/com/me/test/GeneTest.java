/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.test;


import com.me.main.Gene;
import com.me.main.Point;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author dell
 */
public class GeneTest {
    @Test
    public void test1() throws Exception {
        Point p1=new Point(1,1);
        Point p2=new Point(4,1);
        Point p3=new Point(4,5);
        Point[] p=new Point[3];
        p[0]=p1;
        p[1]=p2;
        p[2]=p3;
       
        Gene g=new Gene(p);
        double d=g.calculateWeight();
        assertEquals(12,(int)d);
    }
}
