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
public class MuistipeliTest {

    muistipeli.Kentta peli;

    @Before
    public void setUp() {
        peli = new muistipeli.Kentta(1);
    }

    @Test
    public void voikoKaantaaEiAnnaKaantaaSamaa() {
        assertTrue(muistipeli.Muistipeli.voikoKaantaa(peli, 5));
        peli.getLaatat().get(5).nayta();
        peli.lisaaKaannettyja();
        assertFalse(muistipeli.Muistipeli.voikoKaantaa(peli, 5));
        peli.getLaatat().get(5).piilota();
        peli.nollaaKaannetyt();
        assertTrue(muistipeli.Muistipeli.voikoKaantaa(peli, 5));
    }
    
    @Test
    public void voikoKaantaaEiAnnaKaantaaKahtaEnempaa(){
        assertTrue(muistipeli.Muistipeli.voikoKaantaa(peli, 5));
        peli.getLaatat().get(5).nayta();
        peli.lisaaKaannettyja();
        assertTrue(muistipeli.Muistipeli.voikoKaantaa(peli, 6));
        peli.getLaatat().get(6).nayta();
        peli.lisaaKaannettyja();    
        assertFalse(muistipeli.Muistipeli.voikoKaantaa(peli, 7));
        
    }
    
    @Test 
    public void onkoPariVastaaOikeinJosPari(){
        peli.getLaatat().get(5).nayta();
        peli.getLaatat().get()
    }
}
