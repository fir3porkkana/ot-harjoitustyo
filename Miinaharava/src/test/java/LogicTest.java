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

/**
 *
 * @author tiera
 */
public class LogicTest {
    
    @Test
    public void tauluSisaltaaMiinan() {
        Logic l = new Logic();
        boolean onkoMiina = false;
        int[][] miinaruudunArvo = l.getMines();
        
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
}
