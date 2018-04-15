/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.main;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author jm
 */
public class Main {
    private static Map<String,Object> map=new HashMap<String,Object>();
    public static void main(String[] args) {
        long start=System.nanoTime();
       ThreadRunning tr=new ThreadRunning();
       Map<String,Object> map=tr.threadResult(20, 20);
       Gene g1=(Gene)map.get("Method1");
       Gene g2=(Gene)map.get("Method2");
       int gen1=(int)map.get("generation1");
       int gen2=(int)map.get("generation2");
       ArrayList<Gene> bg1= (ArrayList<Gene>)map.get("bestG1");
       ArrayList<Gene> bg2= (ArrayList<Gene>)map.get("bestG2");
       ArrayList<Double> bd1= (ArrayList<Double>)map.get("bestD1");
       ArrayList<Double> bd2= (ArrayList<Double>)map.get("bestD2");
       for(Double d:bd1)
            System.out.println(d);
 System.out.println(gen1);
//Environment e=new Environment();
//              Gene   g= e.begin(0,0);
//              Gene g2=e.begin(10, 10);
//             Gene   g3= e.begin(0,0);
//              Gene g4=e.begin(10, 10);
            long end=System.nanoTime();

    }
}
 
 