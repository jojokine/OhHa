/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Testit;

import java.util.ArrayList;
import muistipeli.Laatta;
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
public class OperaatiotTest {

    muistipeli.Kentta peli;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        peli = new muistipeli.Kentta(1);
    }

    @Test
    public void voikoKaantaaEiAnnaKaantaaSamaa() {
        assertTrue(muistipeli.Operaatiot.voikoKaantaa(peli, 5));
        peli.getLaatat().get(5).nayta();
        peli.lisaaKaannettyja();
        assertFalse(muistipeli.Operaatiot.voikoKaantaa(peli, 5));
        peli.getLaatat().get(5).piilota();
        peli.nollaaKaannetyt();
        assertTrue(muistipeli.Operaatiot.voikoKaantaa(peli, 5));
    }

    @Test
    public void voikoKaantaaEiAnnaKaantaaKahtaEnempaa() {
        assertTrue(muistipeli.Operaatiot.voikoKaantaa(peli, 5));
        peli.getLaatat().get(5).nayta();
        peli.lisaaKaannettyja();
        assertTrue(muistipeli.Operaatiot.voikoKaantaa(peli, 6));
        peli.getLaatat().get(6).nayta();
        peli.lisaaKaannettyja();
        assertFalse(muistipeli.Operaatiot.voikoKaantaa(peli, 7));

    }

    @Test
    public void onkoPariVastaaOikeinJosPari() {
        peli.getLaatat().get(5).setTunniste(1);
        peli.getLaatat().get(5).nayta();
        peli.getLaatat().get(8).setTunniste(2);
        peli.getLaatat().get(8).nayta();
        assertTrue(muistipeli.Operaatiot.onkoPari(peli));
    }

    @Test
    public void onkoPariVastaaOikeinJosEiPari() {
        peli.getLaatat().get(5).setTunniste(4);
        peli.getLaatat().get(5).nayta();
        peli.getLaatat().get(8).setTunniste(2);
        peli.getLaatat().get(8).nayta();
        assertFalse(muistipeli.Operaatiot.onkoPari(peli));
    }

    @Test
    public void kaannaLaattaKaantaaOikein() {
        muistipeli.Operaatiot.kaannaLaatta(peli, 2);
        assertTrue(peli.getLaatat().get(2).getTila());
    }

    @Test
    public void kaannaLaattaEiKaannaJoKaannettya() {
        muistipeli.Operaatiot.kaannaLaatta(peli, 2);
        assertFalse(muistipeli.Operaatiot.kaannaLaatta(peli, 2));
    }
    
    @Test
    public void haeKaannettyPariPalauttaaOikeanParin(){
        peli.getLaatat().get(1).nayta();
        peli.getLaatat().get(2).nayta();
        ArrayList<Laatta>pari = new ArrayList();
        pari = muistipeli.Operaatiot.haeKaannettyPari(peli);
        assertEquals(peli.getLaatat().get(1).getTunniste(), pari.get(0).getTunniste(), vertailuTarkkuus);
        assertEquals(peli.getLaatat().get(2).getTunniste(), pari.get(1).getTunniste(), vertailuTarkkuus);
    }
}
