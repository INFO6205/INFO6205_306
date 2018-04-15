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
    //Because of the unit test, we change the function to public.
    //The function calculateFitness, cross, cross2, mutation, evolution and evolution2 should be private.
    private final int capacity=1000;//The capacity of environment
    private ArrayList<Gene> genes=new  ArrayList<Gene>() ;//genes of all colonies
    private ArrayList<Gene> offSpring=new  ArrayList<Gene>() ;//genes of all offSpring
    private ArrayList<Double> fitness=new ArrayList<Double>();//fitness of all clonies
    private double Pc=0.9,Pm=0.005;//The possibility of crossGene and mutation
    private int generation=1,max=10000;//Current generation and max generation
    private double bestW=Double.MAX_VALUE;//The best cost
    private ArrayList<Gene> bestG=new  ArrayList<Gene>();//The best genes 
   private final Random random = new Random();
   private Graph graph;
   private ArrayList<Double> bestD=new ArrayList<Double>();
   private InsertionSort<Gene> insert=new InsertionSort<>();
    public void init(int x,int y){
        graph=new Graph("Simple1.csv");
        Point p=new Point(x,y);
        graph.addPoints(p);
        Gene g=null;
for(int i=0;i<100;i++){
    g= graph.generateGene();
    g.calculateWeight();
    g.setGeneration(-2);
      genes.add(g);
}
    }
    public void calculateFitness(){
    fitness=new ArrayList<Double>();
    for(Gene g:genes)
        fitness.add(1.0/g.getTotal());
    }
    //cross and decide the genes of offspring method1
    public void cross(Gene g1,Gene g2){
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
      for ( int k = 0, j = flag; j < size;)  
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
      Gene ng1=new Gene(new1);
      Gene ng2=new Gene(new2);
      ng1.setGeneration(generation);
      ng2.setGeneration(generation);
      ng1.calculateWeight();
      ng2.calculateWeight();
       offSpring.add(ng1);
       offSpring.add(ng2);
    }
    //cross and decide the genes of offspring method2
     public void cross2(Gene g1,Gene g2){
      int index=graph.getPos().size(),temp,flag,i,j,k;
      int  cut1 = random.nextInt(index);  
      int  cut2= random.nextInt(index); 
      int size=g1.getPoints().length;
      Point[] p1=g1.getPoints(), p2=g2.getPoints(),new1=new Point[size],new2=new Point[size];   
        while (cut1 == cut2) {  
            cut2 = random.nextInt(index);  
        }  
        if (cut1 > cut2)
        {  
            temp = cut1;  
            cut1 = cut2;  
            cut2 = temp;  
        }   
         for (i = 0, j = cut2; j < size; i++, j++) {  
            new2[i] = p1[j];  
        }  
  
        flag = i; 
  
        for (k = 0, j = flag; j < size;)
        {  
            new2[j] =p2[k++];  
            for (i = 0; i < flag; i++) {  
                if (new2[i] == new2[j]) {  
                    break;  
                }  
            }  
            if (i == flag) {  
                j++;  
            }  
        }  
  
        flag = cut1;  
        for (k = 0, j = 0; k < size;)  
        {  
            new1[j] = p1[k++];  
            for (i = 0; i < flag; i++) {  
                if (p2[i] == new1[j]) {  
                    break;  
                }  
            }  
            if (i == flag) {  
                j++;  
            }  
        }  
  
        flag = size - cut1;  
  
        for (i = 0, j = flag; j < size; j++, i++) {  
            new1[j] = p2[i];  
        }  
Gene ng1=new Gene(new1);
      Gene ng2=new Gene(new2);
      ng1.setGeneration(generation);
      ng2.setGeneration(generation);
      ng1.calculateWeight();
      ng2.calculateWeight();
       offSpring.add(ng1);
       offSpring.add(ng2);
     }
    public void Mutation(Gene g) {  
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
    public void evolution(){  
        int index=genes.size();
        int a=0,b=0,c=0;
        int item1=random.nextInt(index),item2=random.nextInt(index);;
        offSpring=new ArrayList<>();
         for(int i=0;i<genes.size()/4;i++){
         while(genes.get(item1).getGeneration()>generation-2)
              item1=random.nextInt(index);
         while((genes.get(item2).getGeneration()>generation-2)||item1==item2)
               item2=random.nextInt(index);
         cross(genes.get(item1), genes.get(item2));
         }
         for(Gene g:offSpring)
             genes.add(g);
    }
     public void evolution2(){  
        int index=genes.size();
        int a=0,b=0,c=0;
        int item1=random.nextInt(index),item2=random.nextInt(index);;
        offSpring=new ArrayList<>();
         for(int i=0;i<genes.size()/4;i++){
         while(genes.get(item1).getGeneration()>generation-2)
              item1=random.nextInt(index);
         while((genes.get(item2).getGeneration()>generation-2)||item1==item2)
               item2=random.nextInt(index);
         cross2(genes.get(item1), genes.get(item2));
         }
         for(Gene g:offSpring)
             genes.add(g);
    }
    public Gene begin(int x,int y){
        genes=new ArrayList<>();
        bestD=new ArrayList<Double>();
        generation=1;
        bestW=Double.MAX_VALUE;
        bestG=new ArrayList<>();
        int sybol=0;
        init(x,y);
        insert.sort(genes);
        calculateFitness();        
        for(;generation<max+1;generation++){
        evolution();
        for(int i=0;i<genes.size();i++)
        {
           float rate=random.nextFloat();
           if(rate<Pm)
               Mutation(genes.get(i));
        }
        insert.sort(genes);
        while(genes.size()>capacity){
            genes.remove(genes.size()-1);
        }
        if(bestW>genes.get(0).getTotal()){
            bestW=genes.get(0).getTotal();
            sybol=0;
          
        }
        if(bestW==genes.get(0).getTotal()){
            sybol++;
        }
        if(sybol>2000){
       
            break;
        }
        bestD.add(genes.get(0).getTotal());
        bestG.add(genes.get(0));
        }
            return genes.get(0);
    }
    public int getGeneration(){
        return this.generation-1;
    }

    public ArrayList<Double> getBestD() {
        return bestD;
    }

    public double getBestW() {
        return bestW;
    }
    
     public Gene begin2(int x,int y){
        genes=new ArrayList<>();
        bestD=new ArrayList<Double>();
        generation=1;
        bestW=Double.MAX_VALUE;
        bestG=new ArrayList<>();
        int sybol=0;
        init(x,y);
        insert.sort(genes);
        calculateFitness();        
        for(;generation<max+1;generation++){
        evolution2();
        for(int i=0;i<genes.size();i++)
        {
           float rate=random.nextFloat();
           if(rate<Pm)
               Mutation(genes.get(i));
        }
        insert.sort(genes);
        while(genes.size()>capacity){
            genes.remove(genes.size()-1);
        }
        if(bestW>genes.get(0).getTotal()){
            bestW=genes.get(0).getTotal();
            sybol=0;
        }
        if(bestW==genes.get(0).getTotal()){
            sybol++;
         
        }
        if(sybol>2000)
            break;
        bestD.add(genes.get(0).getTotal());
        bestG.add(genes.get(0));
        }
            return genes.get(0);
    }

    public ArrayList<Gene> getGenes() {
        return genes;
    }

    public ArrayList<Gene> getOffSpring() {
        return offSpring;
    }

    public Random getRandom() {
        return random;
    }

    public Graph getGraph() {
        return graph;
    }

    public void setGraph(Graph graph) {
        this.graph = graph;
    }

    public ArrayList<Gene> getBestG() {
        return bestG;
    }
     
     
}
