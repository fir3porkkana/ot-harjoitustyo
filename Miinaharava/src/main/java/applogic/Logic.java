/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package applogic;

import java.util.Date;
import java.util.Random;

/**
 *
 * @author tiera
 */
public class Logic {

    private int[][] mines = new int[16][9];
    private int[][] neighbours = new int[16][9];
    private boolean[][] revealed = new boolean[16][9];
    private boolean[][] flagged = new boolean[16][9];
    private boolean victory;
    private boolean defeat;
    private Date startingTime = new Date();

    private int neighs = 0;

    Random rand = new Random();

    public Logic() {
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                if (rand.nextInt(100) < 23) {
                    mines[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                neighs = 0;
                for (int m = 0; m < 16; m++) {
                    for (int n = 0; n < 9; n++) {
                        if (isNeighbour(i, j, m, n) && !(i == m && j == n)) {
                            neighs++;
                        }
                    }
                }
                neighbours[i][j] = neighs;
            }
        }
    }

    public boolean isNeighbour(int mX, int mY, int cX, int cY) {
        if (mX - cX < 2 && mX - cX > -2 && mY - cY < 2 && mY - cY > -2 && mines[cX][cY] == 1) {
            return true;
        }
        return false;
    }

    public void syvyyshaku(int i, int j) {
        if (i < 0 || 15 < i || j < 0 || 8 < j) {
            return;
        }
        if (revealed[i][j]) {
            return;
        }
        revealed[i][j] = true;
        if (neighbours[i][j] == 0) {
            syvyyshaku(i - 1, j);
            syvyyshaku(i + 1, j);
            syvyyshaku(i, j + 1);
            syvyyshaku(i, j - 1);
            syvyyshaku(i - 1, j - 1);
            syvyyshaku(i + 1, j - 1);
            syvyyshaku(i + 1, j + 1);
            syvyyshaku(i - 1, j + 1);
        }

    }

    public boolean isDefeat() {
        return defeat;
    }

    public boolean isVictory() {
        
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public void setDefeat(boolean defeat) {
        this.defeat = defeat;
    }

    public Date getstartingTime() {
        return startingTime;
    }

    public int[][] getMines() {
        return mines;
    }

    public void setBoxRevealed(int x, int y) {
        syvyyshaku(x, y);
    }
    
    public void setBoxFlagged(int x, int y) {
        flagged[x][y] = !flagged[x][y];
    }

    public boolean[][] getRevealed() {
        return revealed;
    }

    public boolean[][] getFlagged() {
        return flagged;
    }

    public int[][] getNeighbours() {
        return neighbours;
    }

}
