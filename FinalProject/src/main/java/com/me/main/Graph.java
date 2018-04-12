/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author jm
 */
public class Graph {
   private int V;  
   private ArrayList<Point> pos; 
   private final Random random = new Random();
   public Graph() 
   { 
    this.V=0;
    this.pos=new ArrayList<>();
   } 
   //Initial graph picture by csv file
   public Graph(String filename) 
   {  
    this.V=0;
    this.pos=new ArrayList<>();
        BufferedReader br = null;
        String line = "";
        String cvsSplitBy = ",";
        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] data = line.split(cvsSplitBy);
              Point p=new Point(Integer.parseInt(data[0]),Integer.parseInt(data[1]));
              pos.add(p);
              V++;
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (br != null) {
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
   } 
    public int getV() {
        return V;
    }

    public ArrayList<Point> getPos() {
        return pos;
    }
 public void addPoints(Point p){
     pos.add(p);
     V++;
 }
 public Gene generateGene(){
    Point[] p=new Point[V];
    for(int i=0;i<p.length;i++){
    int index= random.nextInt(pos.size());
    p[i]=pos.get(index);
            for(int j=0;j<i;j++){
            if(p[j]==p[i]){
                i--;
            break;
            }
        }
    }
    
     Gene g=new Gene(p);
     g.calculateWeight();
     return g;
 }
}
