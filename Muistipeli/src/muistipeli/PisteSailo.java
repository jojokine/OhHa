/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

/**
 *
 * @author jojokine
 */
import java.util.*;
import java.io.*;

public class PisteSailo {

    private ArrayList<HiScore> tulokset;
    private static final String TULOSTIEDOSTO = "tulokset.dat";
    ObjectOutputStream tallentaja = null;
    ObjectInputStream lukija = null;

    public PisteSailo() {

        tulokset = new ArrayList<HiScore>();
    }

    public ArrayList<HiScore> getPisteet() {
        lataaPistetiedosto();
        return tulokset;
    }

    public void lisaaPisteet(String nimi, int pisteet) {
        lataaPistetiedosto();
        tulokset.add(new HiScore(nimi, pisteet));
        paivitaPistetiedosto();
    }

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
