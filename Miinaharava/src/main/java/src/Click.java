/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 *
 * @author tiera
 */
public class Click implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent me) {
        System.out.println("mouse was clicked");
    }

    @Override
    public void mousePressed(MouseEvent me) {
    }

    @Override
    public void mouseReleased(MouseEvent me) {
    }

    @Override
    public void mouseEntered(MouseEvent me) {
    }

    @Override
    public void mouseExited(MouseEvent me) {
    }

}
