/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

/**
 *
 * @author jojokine
 */
public class Laatta {
    
    private boolean tila;
    
    private int tunniste;

    public void nayta() {
        tila = true;
    }

    public void piilota() {
        tila = false;
    }

    public int tunniste() {
        return tunniste;
    }
    
    public boolean tila() {
        return tila;
    }
}
