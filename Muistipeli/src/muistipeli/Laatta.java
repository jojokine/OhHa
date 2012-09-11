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

    private boolean onkoLoydetty;
    private boolean laatanTila;
    private int tunniste;

    public Laatta(int laatanTunniste) {
        onkoLoydetty = false;
        laatanTila = false;
        tunniste = laatanTunniste;
    }

    public void loyda() {
        onkoLoydetty = true;
    }

    public void nayta() {
        laatanTila = true;
    }

    public void piilota() {
        laatanTila = false;
    }

    public int tunniste() {
        return tunniste;
    }

    public boolean tila() {
        return laatanTila;
    }

    public boolean onkoLoydetty() {
        return onkoLoydetty;
    }
}
