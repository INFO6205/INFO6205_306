/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.main;

/**
 *
 * @author jm
 */
public class Gene implements Comparable<Gene>{
    private Point[] points;
    private double total;
    private int generation;
    public Gene(Point[] points){
        this.points=points;
    }

    public int getGeneration() {
        return generation;
    }

    public void setGeneration(int generation) {
        this.generation = generation;
    }

    public Point[] getPoints() {
        return points;
    }

    public void setPoints(Point[] points) {
        this.points = points;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
    public  double calculateWeight(){
        double weight=0.0;
        for(int i=0;i<points.length-1;i++)
            weight+=points[i].distanceTo(points[i+1]);
        weight+=points[0].distanceTo(points[points.length-1]);
        this.total=weight;
        return weight;
    }
    public int compareTo(Gene gene){
    if(this.total<gene.getTotal())
        return -1;
     if(this.total>gene.getTotal())
        return 1;
        return 0;
    }
   
}
