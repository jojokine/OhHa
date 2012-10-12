/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.ArrayList;
import pistelistat.HiScore;
import pistelistat.PisteSailo;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jojokine
 */
public class PisteSailoTest {

    private double vertailuTarkkuus = 0.0001;
    private PisteSailo testiPisteet;
    private HiScore score;
    private String nimi = "testi";
    private int pisteet = 10;

    @Before
    public void setUp() {
        testiPisteet = new PisteSailo(5);
        score = new HiScore(nimi, pisteet);
    }

    @Test
    public void LisaaPisteetLisaa() {
        assertTrue(testiPisteet.lisaaPisteet(nimi, pisteet));

    }

    @Test
    public void LisaaPisteetEiLisaaJosTyhjaNimi() {
        assertFalse(testiPisteet.lisaaPisteet("", pisteet));
    }

    @Test
    public void PisteetTuleeJarjestykseenPienimmästäSuurimpaan() {
        testiPisteet.lisaaPisteet("erkki", 30);
        testiPisteet.lisaaPisteet(nimi, pisteet);
        testiPisteet.lisaaPisteet("matti", 15);
        assertTrue(testiPisteet.getPisteet().get(0).getNimi().equals(nimi));
        assertTrue(testiPisteet.getPisteet().get(testiPisteet.getPisteet().size()-1).getNimi().equals("erkki"));

    }

    @Test
    public void PisteetLöytyyTiedostosta() {
        assertTrue(testiPisteet.getPisteet().get(0).getNimi().equals(nimi));
    }
}
