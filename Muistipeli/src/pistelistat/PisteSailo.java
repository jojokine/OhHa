/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pistelistat;

/**
 *
 * @author jojokine
 */
import java.util.*;
import java.io.*;

/**
 * PisteSailo luo HiScore-olioita parametrien perusteella
 * ja tallentaa niitä tiedostoon.
 * @author jojokine
 */

public class PisteSailo {

    private ArrayList<HiScore> tulokset;
    private static String TULOSTIEDOSTO;
    ObjectOutputStream tallentaja = null;
    ObjectInputStream lukija = null;

    
    public PisteSailo(int vaikeus) {

        tulokset = new ArrayList<HiScore>();
        TULOSTIEDOSTO = "tulokset"+vaikeus+".dat";
    }

    public ArrayList<HiScore> getPisteet() {
        lataaPistetiedosto();
        return tulokset;
    }

    /**
     * Metodi lisää pelaajan pisteet pistelistaan.
     * @param nimi pelaajan nimi
     * @param pisteet pelaajan pisteet
     * @return 
     */
    public boolean lisaaPisteet(String nimi, int pisteet) {
        if (!nimi.isEmpty()) {
            lataaPistetiedosto();
            tulokset.add(new HiScore(nimi, pisteet));
            Collections.sort(tulokset);
            Collections.reverse(tulokset);
            paivitaPistetiedosto();
            return true;
        }
        else{
            return false;
        }
    }

    /**
     * Metodi avaa pistelistan tiedostosta.
     */
    public void lataaPistetiedosto() {
        try {
            lukija = new ObjectInputStream(new FileInputStream(TULOSTIEDOSTO));
            tulokset = (ArrayList<HiScore>) lukija.readObject();
        } catch (Exception e) {
            System.out.println("Tiedoston avaaminen ei onnistu" + e.getMessage());
        }
        try {
            if (tallentaja != null) {
                tallentaja.flush();
                tallentaja.close();
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * metodi päivittää pistetiedostoa tai luo uuden tiedoston.
     */
    public void paivitaPistetiedosto() {
        try {
            tallentaja = new ObjectOutputStream(new FileOutputStream(TULOSTIEDOSTO));
            tallentaja.writeObject(tulokset);
        } catch (FileNotFoundException e) {
            System.out.println("Tiedostoa ei löydy" + e.getMessage() + ",ohjelma luo uuden tiedoston.");
        } catch (IOException e) {
            System.out.println("Kirjoittaminen ei onistunut" + e.getMessage());
        }
        try {
            if (tallentaja != null) {
                tallentaja.flush();
                tallentaja.close();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
