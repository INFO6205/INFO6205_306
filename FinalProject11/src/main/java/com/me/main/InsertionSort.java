/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.main;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 *
 * @author jm
 */
public class InsertionSort <X extends Comparable<X>> {
    public void sort(ArrayList<X> xs) {
        // TODO implement insertionSort
          
      for (int i = 0; i <xs.size(); i++) 
         for (int j = i; j > 0; j--) 
            if (less(xs.get(j),xs.get(j-1))) 
              swap(xs, j, j-1); 
            else break; 
    }
    static <X extends Comparable<X>> boolean less(X v, X w) {
        return v.compareTo(w) < 0;
    }

    static <X extends Comparable<X>> void swap(ArrayList<X> a, int i, int j) {
        X temp = a.get(i);
        X temp1 =a.get(j);
        a.set(j, temp);
        a.set(i, temp1);

    }
}

