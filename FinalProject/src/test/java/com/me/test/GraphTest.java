/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.test;

import com.me.main.Graph;
import com.me.main.Point;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author dell
 */
public class GraphTest {
    @Test
    public void test1() throws Exception {
        Graph graph=new Graph("test.csv");
        int v=graph.getV();
        assertEquals(10,v);
        ArrayList<Point> p=graph.getPos();
        Point p1=p.get(0);
        
        assertEquals(10,p1.getXpo());
        assertEquals(53,p1.getYpo());
    }
}
