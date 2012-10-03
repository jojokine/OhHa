/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Luokka tallentaa Laatta-olioita arraylistiin vakeustason perusteella ja pitää
 * ylhäällä kentään tilaa koskevia tietoja
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
    
    /**
     * Luo uuden kentän, jolla laattoja annetun vaikeustason mukainen määrä.
     * @param vaikeus pelin vaikeustaso
     */
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
        for (int i = 0; i < laattoja; i = i + 2) {
            pelinLaatat.add(new Laatta(i));
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

    public void lisaaKaantoja() {
        kaannot++;
    }

    public void loytyi() {
        parit++;
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

//    public int[][] haeLaatttojenIndeksit(int tunniste) {
//        int[][] indeksit;
//        for (int j = 0; j < getLaatat().size(); j++) {
//            if (getLaatat().get(j).getTunniste() == tunniste) {
//                           }
//        }
//        return 0;
//    }
    
    
//    public void eiPari(int laatta1, int laatta2) {
//        nollaaKaannetyt();
//        pelinLaatat.get(laatta1).piilota();
//        pelinLaatat.get(laatta2).piilota();
//        kaannot++;
//    }
}
