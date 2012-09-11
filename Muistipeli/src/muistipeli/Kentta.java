/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.ArrayList;

/**
 *
 * @author jojokine
 */
public class Kentta {

    private int vaikeustaso;
    private int laatat;
    private int kaannot;
    private int parit;
    private int kaannettyna;
    private int laattoja;
//    private Laatta [] laatta;

    public Kentta(int vaikeustaso) {
        if (vaikeustaso == 0) {
            laattoja = 16;
        } else if (vaikeustaso == 1) {
            laattoja = 24;
        } else {
            laattoja = 36;
        }
        ArrayList<Laatta> laatat = new ArrayList<Laatta>();
        for (int i = 0; i < vaikeustaso; i++) {
            laatat.add(new Laatta(i));
        }
    }
}
