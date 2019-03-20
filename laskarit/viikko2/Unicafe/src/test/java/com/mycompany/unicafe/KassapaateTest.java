/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.unicafe;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author tiera
 */
public class KassapaateTest {

    Kassapaate paate;
    Maksukortti kortti;

    @Before
    public void setUp() {
        paate = new Kassapaate();
        kortti = new Maksukortti(0);
    }

    @Test
    public void hello() {
    }
    
    @Test
    public void alussaKassassaOikeaRahamaara() {
        assertEquals(100000, paate.kassassaRahaa());
    }
    
    @Test
    public void kateismaksunRiittaessaPaateToimiiOikeinEdullinen() {
        assertEquals(0, paate.syoEdullisesti(240));
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateismaksunEiRiittaessaPaateToimiiOikeinEdullinen() {
        assertEquals(239, paate.syoEdullisesti(239));
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void kateismaksunRiittaessaPaateToimiiOikeinMaukas() {
        assertEquals(0, paate.syoMaukkaasti(400));
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void kateismaksunEiRiittaessaPaateToimiiOikeinMaukas() {
        assertEquals(399, paate.syoMaukkaasti(399));
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttimaksunRiittaessaPaateToimiiOikeinEdullinen() {
        kortti.lataaRahaa(240);
        assertTrue(paate.syoEdullisesti(kortti));
        assertEquals(0, kortti.saldo());
        assertEquals(1, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttimaksunEiRiittaessaPaateToimiiOikeinEdullinen() {
        kortti.lataaRahaa(239);
        assertFalse(paate.syoEdullisesti(kortti));
        assertEquals(239, kortti.saldo());
        assertEquals(0, paate.edullisiaLounaitaMyyty());
    }
    
    @Test
    public void korttimaksunRiittaessaPaateToimiiOikeinMaukas() {
        kortti.lataaRahaa(400);
        assertTrue(paate.syoMaukkaasti(kortti));
        assertEquals(0, kortti.saldo());
        assertEquals(1, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttimaksunEiRiittaessaPaateToimiiOikeinMaukas() {
        kortti.lataaRahaa(399);
        assertFalse(paate.syoMaukkaasti(kortti));
        assertEquals(399, kortti.saldo());
        assertEquals(0, paate.maukkaitaLounaitaMyyty());
    }
    
    @Test
    public void korttiaLadatessaVaarinPaateToimiiOikein() {
        paate.lataaRahaaKortille(kortti, -20);
        assertEquals(100000, paate.kassassaRahaa());
        assertEquals("saldo: 0.0", kortti.toString());
    }
    
    @Test
    public void korttiaLadatessaOikeinPaateToimiiOikein() {
        paate.lataaRahaaKortille(kortti, 3);
        assertEquals(100003, paate.kassassaRahaa());
        assertEquals("saldo: 0.3", kortti.toString());
    }
}
