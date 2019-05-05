/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package src;

import applogic.Click;
import applogic.Logic;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class GUI extends JFrame {

    private int spacing = 4;

    public int mx = -10;
    public int my = -10;

    public int smileyX = 439;
    public int smileyY = 25;

    public int timerX = 820;
    public int timerY = 25;

    public long secs = 0;

    public Logic l;

    public GUI() {
        this.setTitle("Miinaharava");
        this.setSize(911, 590);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
        this.setResizable(false);
        this.l = new Logic();

        Board board = new Board();
        this.setContentPane(board);

        Move move = new Move();
        this.addMouseMotionListener(move);

        Click click = new Click();
        this.addMouseListener(click);
    }

    public class Board extends JPanel {

        /**
         * Paints the game and its UI.
         */
        public void paintComponent(Graphics g) {
            g.setColor(Color.DARK_GRAY);
            g.fillRect(0, 0, 920, 590);
            if (!l.isDefeat() && !l.isVictory()) {
                for (int i = 0; i < 16; i++) {
                    for (int j = 0; j < 9; j++) {
                        g.setColor(Color.MAGENTA);

                        if (l.getRevealed()[i][j]) {
                            g.setColor(Color.LIGHT_GRAY);
                            if (l.getMines()[i][j] == 1) {
                                g.setColor(Color.RED);
                            }
                        }
                        int botX = i * 56 + 3 * spacing;
                        int topX = i * 56 + 56 + spacing;
                        int botY = j * 56 + 56 + 3 * spacing;
                        int topY = j * 56 + 56 * 2 + spacing;
                        if (mx >= botX && mx <= topX && my >= botY && my <= topY) {
                            g.setColor(Color.CYAN);
                        }
                        g.fillRect(3 * spacing + i * 56, spacing + j * 56 + 32, 56 - 2 * spacing, 56 - 2 * spacing);

                        if (l.getRevealed()[i][j] && l.getNeighbours()[i][j] != 0) {
                            g.setColor(Color.BLACK);
                            if (l.getMines()[i][j] == 0) {
                                g.setColor(Color.BLACK);
                                g.setFont(new Font("Tahoma", Font.BOLD, 30));
                                g.drawString("" + l.getNeighbours()[i][j], i * 56 + 3 * spacing + 13, j * 56 + 56 + 16);
                            } else if (l.getMines()[i][j] == 1) {
                                g.fillRect(i * 56 + 10 + 16, j * 56 + 56 - 16, 20, 40);
                                g.fillRect(i * 56 + 16, j * 56 + 56 + 10 - 16, 40, 20);
                                g.fillRect(i * 56 + 5 + 16, j * 56 + 56 + 5 - 16, 30, 30);
                            }
                        }

                        if (l.getFlagged()[i][j]) {
                            g.setColor(Color.BLACK);
                            g.fillRect(i * 56 + 10 + 16, j * 56 + 56 - 16, 3, 40);
                            g.setColor(Color.WHITE);
                            g.fillRect(i * 56 + 10 + 16 + 3, j * 56 + 56 - 16, 18, 12);
                        }
                    }
                }
            } else {
                if (l.isDefeat()) {
                    g.setColor(Color.RED);
                    g.setFont(new Font("Arial", Font.PLAIN, 80));
                    g.drawString("Hävisit", 300, 300);
                } else {
                    g.setColor(Color.GREEN);
                    g.setFont(new Font("Arial", Font.PLAIN, 80));
                    g.drawString("Voitit", 345, 300);
                }
            }
            g.setColor(Color.cyan);
            g.fillRect(smileyX, 0, 35, 35);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial", Font.PLAIN, 20));
            if ((smileyX <= mx && mx <= smileyX + 35) && (smileyY <= my && my <= 65)) {
                g.drawString(":o", smileyX + 6, smileyY);
            } else {
                g.drawString("xd", smileyX + 7, smileyY);
            }

            if (!l.isDefeat() && !l.isVictory()) {
                secs = (new Date().getTime() - l.getstartingTime().getTime()) / 1000;
            }

            g.setColor(Color.WHITE);
            g.drawString("" + secs, timerX, timerY);
        }
    }

    /**
     * Returns the X-index that corresponds with the mouse's current
     * whereabouts. If the mouse is not within the boundaries of any particular
     * box, returns -1.
     *
     *
     * @return an integer between -1 and 15, that is used as an index value to
     * access the contents of a table.
     */
    public int inBoxX() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                int botX = i * 56 + 3 * spacing;
                int topX = i * 56 + 56 + spacing;
                int botY = j * 56 + 56 + 3 * spacing;
                int topY = j * 56 + 56 * 2 + spacing;
                if (mx >= botX && mx <= topX && my >= botY && my <= topY) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * Returns the Y-index that corresponds with the mouse's current
     * whereabouts. If the mouse is not within the boundaries of any particular
     * box, returns -1.
     *
     *
     * @return an integer between -1 and 8, that is used as an index value to
     * access the contents of a table.
     */
    public int inBoxY() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                int botX = i * 56 + 3 * spacing;
                int topX = i * 56 + 56 + spacing;
                int botY = j * 56 + 56 + 3 * spacing;
                int topY = j * 56 + 56 * 2 + spacing;
                if (mx >= botX && mx <= topX && my >= botY && my <= topY) {
                    return j;
                }
            }
        }
        return -1;
    }

    /**
     * A class that handles the mouse button presses within the frame.
     */
    public class Click implements MouseListener {

        @Override
        /**
         * Handles each click that happens within the frame.
         *
         * Depending on the type and location of the click, either sets a box as
         * revealed, flags it, resets the game or does nothing.
         *
         */
        public void mouseClicked(MouseEvent me) {
            int x = inBoxX();
            int y = inBoxY();

            if ((smileyX <= mx && mx <= smileyX + 35) && (smileyY <= my && my <= 65)) {
                l = new Logic();
            }

            if (!l.isDefeat() && !l.isVictory()) {
                if (me.getButton() == MouseEvent.BUTTON1 && x != -1 && y != -1 && !l.getFlagged()[x][y]) {
                    l.setBoxRevealed(inBoxX(), inBoxY());
                }

                if (me.getButton() == MouseEvent.BUTTON3 && x != -1 && y != -1 && !l.getRevealed()[x][y]) {
                    l.setBoxFlagged(x, y);
                }
            }
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

    /**
     * A class that provides methods to keep track of the coordinates of the
     * mouse.
     *
     */
    public class Move implements MouseMotionListener {

        @Override
        public void mouseDragged(MouseEvent me) {
        }

        @Override
        /**
         * Moving the mouse updates the private variables mouse x (mx) and mouse
         * y (my).
         */
        public void mouseMoved(MouseEvent me) {
            mx = me.getX();
            my = me.getY();
        }

    }

}
