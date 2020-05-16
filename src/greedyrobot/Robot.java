/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedyrobot;

import java.util.Iterator;
import java.util.Stack;

/**
 *
 * @author peanu
 */
public class Robot {

    Stack<Character> s = new Stack<>();
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
        moving(x, y, xx, yy, 0, 0, 0, 0);
    }

    private void moving(int x, int y, int xx, int yy, int north, int south, int east, int west) {
        if (x == xx && y == yy) {
            System.out.println(toString());
            return;
        }
        //lower than target
        if (y < yy) {
            if (north < max) {
                s.push('N');
                moving(x, y + 1, xx, yy, north + 1, 0, 0, 0);
                s.pop();
            }
        }
        //higher than target
        if (y > yy) {
            if(south < max){
                s.push('S');
                moving(x, y - 1, xx, yy, 0, south + 1 , 0, 0);
                s.pop();
            }
        }
        //left of target
        if (x < xx) {
            if (east < max) {
                //south = max;
                s.push('E');
                moving(x + 1, y, xx, yy, 0, 0, east + 1, 0);
                s.pop();
            }
            //east = max;
        }
        //right of target
        if (x > xx) {
            if (west < max) {
                s.push('W');
                moving(x - 1, y, xx, yy, 0, 0, 0, west + 1);
                s.pop();
            }
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
