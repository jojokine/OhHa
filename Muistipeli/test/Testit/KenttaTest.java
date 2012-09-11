/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Testit;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author osku
 */
public class KenttaTest {

    muistipeli.Kentta peli;
    double vertailuTarkkuus = 0.0001;

 
    @Before
    public void setUp() {
        peli = new muistipeli.Kentta(1);
    }
    
    @Test
    public void laatatKaantyyJaNollaaKaannetytNollaa () {
        peli.lisaaKaannettyja();
        peli.lisaaKaannettyja();
        assertEquals(2, peli.getKaannetyt(), vertailuTarkkuus);
        peli.nollaaKaannetyt();
        assertEquals(0, peli.getKaannetyt(), vertailuTarkkuus);
    }
            
}
