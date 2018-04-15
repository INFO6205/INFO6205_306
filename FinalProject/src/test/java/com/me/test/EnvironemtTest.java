/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.test;

import com.me.main.Environment;
import com.me.main.Gene;
import com.me.main.Graph;
import com.me.main.Point;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
/**
 *
 * @author dell
 */
public class EnvironemtTest {

    @Test
    public void testCross() throws Exception {
        Environment e=new Environment();
        graph=new Graph("test.csv"); 
       e.setGraph(graph);
        Gene g=null;
        for(int i=0;i<10;i++){
        g= graph.generateGene();
        g.calculateWeight();
        g.setGeneration(-2);
        e.getGenes().add(g);
        }
        e.cross(e.getGenes().get(1), e.getGenes().get(2));
        boolean repeat=false;
        Gene g1=null;
        Gene g2=null;
        g1=e.getOffSpring().get(0);
        g2=e.getOffSpring().get(1);
        Point[] p1=g1.getPoints();
        Point[] p2=g2.getPoints();
        for(int i=0;i<graph.getV()-1;i++){
            for(int j=i+1;j<graph.getV();j++){
                if(p1[i]==p1[j]){
                    repeat=true;
                    break;
                }
            }
        }
        assertEquals(false, repeat);
        for(int i=0;i<graph.getV()-1;i++){
            for(int j=i+1;j<graph.getV();j++){
                if(p2[i]==p2[j]){
                    repeat=true;
                    break;
                }
            }
        }
        assertEquals(false, repeat);
    }
    
    @Test
    public void testCross2() throws Exception {
        Environment e=new Environment();
        graph=new Graph("test.csv"); 
       e.setGraph(graph);
        Gene g=null;
        for(int i=0;i<10;i++){
        g= graph.generateGene();
        g.calculateWeight();
        g.setGeneration(-2);
        e.getGenes().add(g);
        }
        e.cross2(e.getGenes().get(1), e.getGenes().get(2));
        boolean repeat=false;
        Gene g1=null;
        Gene g2=null;
        g1=e.getOffSpring().get(0);
        g2=e.getOffSpring().get(1);
        Point[] p1=g1.getPoints();
        Point[] p2=g2.getPoints();
        for(int i=0;i<graph.getV()-1;i++){
            for(int j=i+1;j<graph.getV();j++){
                if(p1[i]==p1[j]){
                    repeat=true;
                    break;
                }
            }
        }
        assertEquals(false, repeat);
        for(int i=0;i<graph.getV()-1;i++){
            for(int j=i+1;j<graph.getV();j++){
                if(p2[i]==p2[j]){
                    repeat=true;
                    break;
                }
            }
        }
        assertEquals(false, repeat);
    }
    
    @Test
    public void testMutation() throws Exception {
        Environment e=new Environment();
        graph=new Graph("test.csv"); 
       e.setGraph(graph);
        Gene g=null;
        for(int i=0;i<10;i++){
        g= graph.generateGene();
        g.calculateWeight();
        g.setGeneration(-2);
        e.getGenes().add(g);
        }
        e.Mutation(e.getGenes().get(1));
        boolean repeat=false;
        g=e.getGenes().get(1);
        Point[] p=g.getPoints();
        for(int i=0;i<graph.getV()-1;i++){
            for(int j=i+1;j<graph.getV();j++){
                if(p[i]==p[j]){
                    repeat=true;
                    break;
                }
            }
        }
        assertEquals(false, repeat);
    }
    
  @Test
    public void testEvolution() throws Exception {
        Environment e=new Environment();
        graph=new Graph("test.csv"); 
        e.setGraph(graph);
        Gene g=null;
        for(int i=0;i<10;i++){
        g= graph.generateGene();
        g.calculateWeight();
        g.setGeneration(-2);
        e.getGenes().add(g);
        }
          e.evolution();
    int k=e.getGenes().size();
            int j=e.getOffSpring().size();
        assertEquals(14, k);
        assertEquals(4, j);
    }
    
    @Test
    public void testEvolution2() throws Exception {
        Environment e=new Environment();
        graph=new Graph("test.csv"); 
        e.setGraph(graph);
        Gene g=null;
        for(int i=0;i<10;i++){
        g= graph.generateGene();
        g.calculateWeight();
        g.setGeneration(-2);
        e.getGenes().add(g);
        }
          e.evolution2();
    int k=e.getGenes().size();
            int j=e.getOffSpring().size();
        assertEquals(14, k);
        assertEquals(4, j);
    }
    
    
    Graph graph;
    

}
