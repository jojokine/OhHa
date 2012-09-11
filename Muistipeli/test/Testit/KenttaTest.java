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
    public void laatatKaantyyJaNollaaKaannetytNollaa() {
        peli.lisaaKaannettyja();
        peli.lisaaKaannettyja();
        // käännetään kaksi laattaa, joten käännettynä pitäisi olla kaksi laattaa
        assertEquals(2, peli.getKaannetyt(), vertailuTarkkuus);
        peli.nollaaKaannetyt();
        // nollataan käännetyt, joten käänettynä pitäisi olla nolla
        assertEquals(0, peli.getKaannetyt(), vertailuTarkkuus);
    }

    @Test
    public void laattojaOikeaMääräTaulukossa() {
        // laattoja on lisätty vaikeustason 1 verran tauluun, joten niitä pitäisi olla 24
        assertEquals(24, peli.getLaatat().size(), vertailuTarkkuus);
    }
}
