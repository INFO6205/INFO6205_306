/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 *
 * @author jm
 */
public class Environment {
    private final int capacity=1000;//The capacity of environment
    private ArrayList<Gene> genes=new  ArrayList<Gene>() ;//genes of all colonies
    private ArrayList<Gene> offSpring=new  ArrayList<Gene>() ;//genes of all offSpring
    private ArrayList<Double> fitness=new ArrayList<Double>();//fitness of all clonies
    private double Pc=0.9,Pm=0.1;//The possibility of crossGene and mutation
    private int generation=0,max=1000;//Current generation and max generation
    private double bestW=Double.MAX_VALUE;//The best cost
    private Gene bestG;//The best genes 
   private final Random random = new Random();
   private Graph graph;
   private InsertionSort<Gene> insert;
    public void init(){
        graph=new Graph("Simple.csv");
        Point p=new Point(0,0);
        graph.addPoints(p);
        Gene g=null;
for(int i=0;i<100;i++){
    g= graph.generateGene();
    g.calculateWeight();
      genes.add(g);
}
    }
    private void calculateFitness(){
    fitness=new ArrayList<Double>();
    for(Gene g:genes)
        fitness.add(1.0/g.getTotal());
    }
    //cross and decide the genes of offspring
    private void cross(Gene g1,Gene g2){
        int index=graph.getPos().size(),temp,flag;
      int  start = random.nextInt(index);  
      int  end= random.nextInt(index); 
      int size=g1.getPoints().length;
      Point[] p1=g1.getPoints(), p2=g2.getPoints(),new1=new Point[size],new2=new Point[size];   
        while (start == end) {  
            end = random.nextInt(index);  
        }  
        if (start > end)
        {  
            temp = start;  
            start = end;  
            end = temp;  
        }   
        flag = end - start + 1; 
        //Cut part of two genes
        for (int i = 0,j = start; i < flag; i++, j++) {  
            new1[i] = p2[j];  
            new2[i] = p1[j];  
        }
        int symbol;//use to decide whether current genes exist same point to father 
        for (int k = 0, j = flag; j < size;)
        {  
            new1[j] = p1[k++];  
            for (symbol = 0; symbol < flag; symbol++) {  
                if (new1[symbol] == new1[j]) {  
                    break;  
                }  
            }  
            if (symbol == flag) {  
                j++;  
            }  
        }  
      for ( int k = 0, j = flag; j < size;)// 染色体长度  
        {  
            new2[j] = p2[k++];  
            for (symbol = 0; symbol < flag; symbol++) {  
                if (new2[symbol] == new2[j]) {  
                    break;  
                }  
            }  
            if (symbol == flag) {  
                j++;  
            }  
        }
      g1.calculateWeight();
      g2.calculateWeight();
       offSpring.add(g1);
       offSpring.add(g2);
    }
    private void Mutation(Gene g) {  
        int index=graph.getPos().size();
        int p1, p2;
        Point temp;
        int count = random.nextInt(index);  
        Point[] p=g.getPoints();
        for (int i = 0; i < count; i++) {  
  
            p1 = random.nextInt(index);  
            p2 = random.nextInt(index);  
            while (p1 == p2) {  
                p2 = random.nextInt(index);  
            }  
            temp = p[p1];  
            p[p1] = p[p2];  
            p[p2]= temp;  
        }  
        g.calculateWeight();
    }
    private void evolution(){  
        int index=genes.size();
        offSpring=new ArrayList<>();
         for(int i=0;i<genes.size()/4;i++){
        int item1=random.nextInt(index);
        int item2=random.nextInt(index);
         while (item1 == item2) {  
                item2 = random.nextInt(index);  
            }
         cross(genes.get(item1), genes.get(item2));
         }
         for(Gene g:offSpring)
             genes.add(g);
    }
    public double begin(){
        init();
        calculateFitness();        
        for(generation=0;generation<max;generation++){
        evolution();
        while(genes.size()>capacity){
            genes.remove(genes.size()-1);
        }
        }
                double min=10.0;
                for(Gene g:genes)
                    if(g.getTotal()<min)
                        min=g.getTotal();
        return min;
    }
}
