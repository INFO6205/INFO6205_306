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
public class Point {
    private int xpo;
    private int ypo;
    public Point(int xpo,int ypo){
        this.xpo=xpo;
        this.ypo=ypo;
    }

    public int getXpo() {
        return xpo;
    }

    public void setXpo(int xpo) {
        this.xpo = xpo;
    }

    public int getYpo() {
        return ypo;
    }

    public void setYpo(int ypo) {
        this.ypo = ypo;
    }
//Calculate Distance to other point
public double distanceTo(Point b){
    return Math.sqrt((xpo-b.getXpo())*(xpo-b.getXpo())+(ypo-b.getYpo())*(ypo-b.getYpo()));
}
    
}
