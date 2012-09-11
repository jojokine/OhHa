package Testit;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
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
public class LaattaTest {

    muistipeli.Laatta laatta;
    double vertailuTarkkuus = 0.0001;

    @Before
    public void setUp() {
        laatta = new muistipeli.Laatta(5);
    }

    @Test
    public void konstruktoriAsettaaLaatanTilanOikein() {

        // luodun laatan tulisi olla kääntämättä ja löytämättä
        assertFalse(laatta.onkoLoydetty());
        assertFalse(laatta.tila());
    }

    @Test
    public void konstruktoriAntaaLaatalleTunnisteenOikein() {

        // luodun laatan tunnisteen tulisi olla "5"
        assertEquals(5, laatta.tunniste(), vertailuTarkkuus);
    }
    
    @Test
    public void laatanTilaOikeinKaannonJalkeen() {
        laatta.nayta();
        // laatan kääntämisen jälkeen sen tilan tulisi olla true
        assertTrue(laatta.tila());
    }
    
    @Test
    public void laatanTilaOikeinTakaisinKaannonJalkeen() {
        laatta.piilota();
        // laatan takaisin kääntämisen jälkeen sen tilan tulisi olla false
        assertFalse(laatta.tila());
    }
    
    @Test
    public void laatanTilaOikeinLöytämisenJälkeen() {
        laatta.loyda();
        // laatan löytämisen jälkeen sen tulisi olla löydetyssä tilassa
        assertTrue(laatta.onkoLoydetty());
    }
    
    
}
