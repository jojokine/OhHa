/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author jojokine
 */
public class Kentta {

    private int vaikeustaso;
    private int kaannot;
    private int parit;
    private int kaannettyna;
    private int laattoja;
    private ArrayList<Laatta> pelinLaatat;

    // private Laatta [] laatta;
    public Kentta(int vaikeus) {
        pelinLaatat = new ArrayList();
        vaikeustaso = vaikeus;
        kaannot = 0;
        parit = 0;
        kaannettyna = 0;

        if (vaikeustaso == 0) {
            laattoja = 16;
        } else if (vaikeustaso == 1) {
            laattoja = 24;
        } else {
            laattoja = 36;
        }
        for (int i = 0; i < laattoja; i++) {
            pelinLaatat.add(new Laatta(i));
        }
        Collections.shuffle(pelinLaatat);
    }

    public ArrayList<Laatta> getLaatat() {
        return pelinLaatat;
    }

    public int getLaattoja() {
        return laattoja;
    }

    public int getVaikeus() {
        return vaikeustaso;
    }

    public int getKaannot() {
        return kaannot;
    }

    public int getParit() {
        return parit;
    }

    public int getKaannetyt() {
        return kaannettyna;
    }

    public void lisaaKaannettyja() {
        kaannettyna++;
    }

    public void nollaaKaannetyt() {
        kaannettyna = 0;
    }

    public void eiPari() {
        nollaaKaannetyt();
        kaannot++;
    }
}
