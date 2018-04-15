/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.main;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 *
 * @author jm
 */
public class ThreadRunning {
     private static Map<String,Object> map=new HashMap<String,Object>();
    public void execute(int x,int y) {
        ExecutorService exe = Executors.newFixedThreadPool(50);  
        RunThread a=new RunThread(x,y);
        RunThread2 b=new RunThread2(x,y);
        exe.execute(a);
        exe.execute(b);
        exe.shutdown();
         while (true) {  
           if (exe.isTerminated()) {  
              break;  
           }  
         }
    }
    public Map<String,Object> threadResult(int x,int y){
        execute(x, y);
        return map;
    }
    private static class RunThread extends  Thread{
    private int x,y;
    public RunThread(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void run() {
Environment e=new Environment();
       Gene   g= e.begin(x,y);
       map.put("Method1", g);
         map.put("generation1", e.getGeneration());
          map.put("bestG1", e.getBestG());
            map.put("bestD1", e.getBestD());
}
}
   private static class RunThread2  extends  Thread{
           private int x,y;
           public RunThread2(int x,int y){
        this.x=x;
        this.y=y;
    }
    public void run() {
Environment e=new Environment();
     
              Gene   g= e.begin2(x,y);
          map.put("Method2", g);
                   map.put("generation2", e.getGeneration());
                     map.put("bestD2", e.getBestD());
                             map.put("bestG2", e.getBestG());
}
}
}
