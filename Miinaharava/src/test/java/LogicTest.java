/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import applogic.Logic;
import applogic.Click;
import java.util.Random;

/**
 *
 * @author tiera
 */
public class LogicTest {
    
    @Test
    public void tauluSisaltaaMiinan() {
        Logic l = new Logic();
        l.setBoxRevealed(0, 0);
        boolean onkoMiina = false;
        int[][] miinaruudunArvo = l.getMines();
        System.out.println("");
        
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                int ruutu = miinaruudunArvo[i][j];
                if (ruutu == 1) {
                    onkoMiina = true;
                }
            }
        }
        
        assertTrue(onkoMiina);
    }
    
    @Test
    public void syvyyshakuToimiiOikein() {
        Logic l = new Logic(15, 8);
        l.setBoxRevealed(0, 0);
        
        assertTrue(l.getRevealed()[14][7]);
        assertTrue(l.getRevealed()[15][7]);
        assertTrue(l.getRevealed()[14][8]);
    }
    
    @Test
    public void voittaminenToimiiOikein() {
        Logic l = new Logic(6, 4);
        l.setBoxRevealed(0, 0);
        l.setBoxFlagged(6, 4);
        
        assertTrue(l.isVictory());
    }
    
    @Test
    public void häviäminenToimiiOikein() {
        Logic l = new Logic(6, 4);
        l.setBoxRevealed(0, 0);
        l.setBoxRevealed(6, 4);
        
        assertTrue(l.isDefeat());
    }
    
    @Test
    public void flagaaminenToimiiOikein() {
        Logic l = new Logic();
        l.setBoxRevealed(0, 0);
        Random r = new Random();
        boolean onnistui = false;
        boolean[][] onkoLiputettu = l.getFlagged();
        int x = r.nextInt(15) + 1;
        int y = r.nextInt(8) + 1;
        
        l.setBoxFlagged(x, y);
        l.setBoxFlagged(x, y);
        l.setBoxFlagged(x, y);
        
        for (int i = 0; i < 16; i++) {
            for (int j = 0; j < 9; j++) {
                if (onkoLiputettu[i][j]) {
                    onnistui = true;
                }
            }
            
        }
        assertEquals(1, l.getTotalFlagged());
        assertTrue(onnistui);
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }
}
