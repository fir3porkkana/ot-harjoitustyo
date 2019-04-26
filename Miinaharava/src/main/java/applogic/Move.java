/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applogic;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

/**
 *
 * @author tiera
 */
public class Move implements MouseMotionListener {
    
    private int mx;
    private int my;

    @Override
    public void mouseDragged(MouseEvent me) {

    }

    @Override
    public void mouseMoved(MouseEvent me) {
//            System.out.println("mouse was moved");
        mx = me.getX();
        my = me.getY();
//            System.out.println("x: " + mx + " ,y: " + my);
    }

    public int getMx() {
        return mx;
    }

    public int getMy() {
        return my;
    }
    
    
}
