/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Recursion;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author peanu
 */
public class Robot {

    Stack<Character> s = new Stack<>();
    private int east = 0;
    private int west = 0;
    private int north = 0;
    private int south = 0;
    private int x;
    private int y;
    private int xx;
    private int yy;
    private int max;

    Robot(int x, int y, int xx, int yy, int max) {
        this.x = x;
        this.y = y;
        this.xx = xx;
        this.yy = yy;
        this.max = max;
    }

    public void moving() {
        moving(x, y, xx, yy);
    }

    private void moving(int x, int y, int xx, int yy) {
        if (x == xx && y == yy) {
            System.out.println(toString());
            return;
        }
        //lower than target
        if (y < yy) {
            south = 0;
            west = 0;
            east = 0;
            if (north < max) {
                s.push('N');
                moving(x, y + 1, xx, yy);
                north++;
                s.pop();
            }
            else 
                north = 0;
            
        }
        //higher than target
        if (y > yy) {
            north = 0;
            west = 0;
            east = 0;
            if(south < max){
                s.push('S');
                moving(x, y - 1, xx, yy);
                south++;
                s.pop();
            }
            else
                south = 0;
        }
        //left of target
        if (x < xx) {
            south = 0;
            west = 0;
            north = 0;
            if (east < max) {
                //south = max;
                s.push('E');
                moving(x + 1, y, xx, yy);
                east++;
                s.pop();
            }
            else 
                east = 0;
            //east = max;
        }
        //right of target
        if (x > xx) {
            east = 0;
            north = 0;
            south = 0;
            if (west < max) {
                s.push('W');
                moving(x - 1, y, xx, yy);
                west++;
                s.pop();
            }
            else
                west = 0;
        }
    }

    @Override
    public String toString() {
        Iterator i = s.iterator();
        String s = "";
        while (i.hasNext()) {
            s += (i.next());
        }
        return s;
    }
}
