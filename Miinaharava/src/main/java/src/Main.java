/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

/**
 *
 * @author tiera
 */
public class Main implements Runnable {

    GUI gui = new GUI();

    public static void main(String[] args) {
        new Thread(new Main()).start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                gui.repaint();
                Thread.sleep(32);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

}
