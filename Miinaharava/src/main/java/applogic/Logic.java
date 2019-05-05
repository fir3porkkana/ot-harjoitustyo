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
    private int totalMines;
    private int totalFlagged;
    private int totalRevealed;
    private boolean[][] revealed = new boolean[16][9];
    private boolean[][] flagged = new boolean[16][9];
    private boolean victory;
    private boolean defeat;
    private boolean isFirstClick;
    private Date startingTime = new Date();

    private int neighs = 0;

    Random rand = new Random();

    public Logic() {
        this.isFirstClick = true;
    }

    public Logic(int x, int y) {
        this.isFirstClick = false;
        this.placeMine(x, y);
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

    /**
     * Tells whether or not the two cells indicated by the parameters are
     * neighbours.
     *
     * @param mX X-coordinate of the original cell that is being checked
     * @param mY Y-coordinate of the original cell that is being checked
     * @param cX X-coordinate of the cell that is a potential neighbour
     * @param cY Y-coordinate of the cell that is a potential neighbour
     * @return a boolean value; true, if the cells are neighbours
     */
    public boolean isNeighbour(int mX, int mY, int cX, int cY) {
        if (mX - cX < 2 && mX - cX > -2
                && mY - cY < 2 && mY - cY > -2
                && mines[cX][cY] == 1) {
            return true;
        }
        return false;
    }

    /**
     * Sets the cell in the revealed-table corresponding to the given parameters
     * as true. Also increments the (totalRevealed) variable each time a cell is
     * set as true. Moreover, it also calls itself on every neighbour cell if
     * the cell it was first called on had no neighbouring mines.
     *
     * @param i X-index of the cell which is to be revealed
     * @param j Y-index of the cell which is to be revealed
     */
    public void dfs(int i, int j) {
        if (i < 0 || 15 < i || j < 0 || 8 < j) {
            return;
        }
        if (revealed[i][j]) {
            return;
        }
        revealed[i][j] = true;
        totalRevealed++;
        if (mines[i][j] == 1) {
            setDefeat();
            return;
        }
        if (neighbours[i][j] == 0) {
            dfs(i - 1, j);
            dfs(i + 1, j);
            dfs(i, j + 1);
            dfs(i, j - 1);
            dfs(i - 1, j - 1);
            dfs(i + 1, j - 1);
            dfs(i + 1, j + 1);
            dfs(i - 1, j + 1);
        }

    }

    public boolean isDefeat() {
        return defeat;
    }

    public boolean isVictory() {
        return victory;
    }

    public void setVictory() {
        this.victory = true;
    }

    public void setDefeat() {
        this.defeat = true;
    }

    public Date getstartingTime() {
        return startingTime;
    }

    public int[][] getMines() {
        return mines;
    }

    /**
     * Sets the cell in the revealed-table corresponding to the x and y
     * parameters as true. Should the parameter (isFirstClick) be true, the
     * method constructs the arrays used in the game before calling the
     * dfs-method on the cell defined by the given parameters. This is done as
     * to avoid the possibility of the first click being on a mine, resulting in
     * an instant loss.
     *
     * @param x X-index of the cell which is to be flagged
     * @param y Y-index of the cell which is to be flagged
     */
    public void setBoxRevealed(int x, int y) {
        if (isFirstClick) {
            isFirstClick = false;
            for (int i = 0; i < 16; i++) {
                for (int j = 0; j < 9; j++) {
                    if (rand.nextInt(101) <= 30 && (Math.abs(x - i) >= 2 || Math.abs(j - y) >= 2)) {
                        mines[i][j] = 1;
                        totalMines++;
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
        dfs(x, y);
    }

    /**
     * Flips the right-clicked box' corresponding boolean value in the
     * flagged-array. Also increments or decrements the amount of total flagged
     * boxes (totalFlagged.)
     *
     * @param x X-index of the cell which is to be flagged
     * @param y Y-index of the cell which is to be flagged
     */
    public void setBoxFlagged(int x, int y) {
        if (flagged[x][y]) {
            totalFlagged--;
        } else {
            totalFlagged++;
        }
        flagged[x][y] = !flagged[x][y];
        if (totalFlagged == totalMines && totalRevealed + totalFlagged == 144) {
            this.setVictory();
        }
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

    public int getTotalFlagged() {
        return totalFlagged;
    }

    public int getTotalMines() {
        return totalMines;
    }

    public void placeMine(int x, int y) {
        this.mines[x][y] = 1;
        totalMines++;
    }

    public int getTotalRevealed() {
        return totalRevealed;
    }
}
