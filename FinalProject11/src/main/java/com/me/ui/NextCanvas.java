/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.ui;

import com.me.main.Gene;
import com.me.main.Point;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author dell
 */
public class NextCanvas extends Thread{
    protected java.awt.Component ui = new JPanel();
  public NextCanvas (JPanel ui){		
	this.ui = ui;		
    }

    public Component getUi() {
        return ui;
    }

    public void setUi(Component ui) {
        this.ui = ui;
    }
   public void draw(Gene gene){
     Graphics g = ui.getGraphics();
		Graphics2D g2d = (Graphics2D) g;
		Dimension size = ui.getSize();
                int wid=size.width;
                int height=size.height;
                System.out.println(wid+","+height);
   if(gene!=null){
       Point[] p=gene.getPoints();
       for(int i=0;i<p.length-1;i++)
                paintLine1(g2d,p[i].getXpo()*wid/100,p[i].getYpo()*height/100,p[i+1].getXpo()*wid/100,p[i+1].getYpo()*height/100);
           paintLine1(g2d,p[0].getXpo()*wid/100,p[0].getYpo()*height/100,p[p.length-1].getXpo()*wid/100,p[p.length-1].getYpo()*height/100);
         for(int i=0;i<p.length;i++)
                paintLine(g2d,p[i].getXpo()*wid/100,p[i].getYpo()*height/100,p[i].getXpo()*wid/100,p[i].getYpo()*height/100);  
   }

     }
    
    private void paintLine(Graphics2D g2d, int startx, int starty, int endx, int endy) {
		g2d.setColor(Color.BLACK);
                g2d.setStroke(new BasicStroke(3.0f));
		g2d.drawLine(startx, starty, endx, endy);
                
                /*g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(3.0f));
		g2d.drawLine(endx, endy, endx, endy);*/
	}
     private void paintLine1(Graphics2D g2d, int startx, int starty, int endx, int endy) {
		g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(1.0f));
		g2d.drawLine(startx, starty, endx, endy);
                
                /*g2d.setColor(Color.RED);
                g2d.setStroke(new BasicStroke(3.0f));
		g2d.drawLine(endx, endy, endx, endy);*/
	}
}
