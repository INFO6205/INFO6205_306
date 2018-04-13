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
public class Main {
    public static void main(String[] args) {
      Environment e=new Environment();
      Gene g=e.begin(0,0);
      for(Point p:g.getPoints())
        System.out.print(p.getXpo()+","+p.getYpo()+"->");
        System.out.println(g.getTotal());

}
}
 