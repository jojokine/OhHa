/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import muistipeli.Laatta;
import muistipeli.Operaatiot;

/**
 *
 * @author jojokine
 */
public class Gui extends JFrame {

    int i = 0;
    static JPanel peliKentta;
    GridLayout kentanKoko;
    int kaannettava;
    static ArrayList<Laatta> kaannetyt;

    public Gui(int vaikeus) {

        kaannetyt = new ArrayList();


        final muistipeli.Kentta peli;
        peli = new muistipeli.Kentta(vaikeus);

        if (peli.getLaattoja() == 16) {
            kentanKoko = new GridLayout(4, 4);
        } else if (peli.getLaattoja() == 24) {
            kentanKoko = new GridLayout(6, 4);
        } else if (peli.getLaattoja() == 36) {
            kentanKoko = new GridLayout(6, 6);
        }

        //peli.getLaatat().get(1).setTunniste(1);
        //peli.getLaatat().get(2).setTunniste(2);

        for (int j = 0; j < peli.getLaatat().size(); j++) {
            // System.out.println((j + 1) + " on " + peli.getLaatat().get(j).getTunniste());
        }


        final JToggleButton[] laatat = new JToggleButton[peli.getLaattoja()];

        peliKentta = new JPanel(kentanKoko);
        for (i = 0; i < laatat.length; i++) {
            laatat[i] = new JToggleButton();
            laatat[i].setIcon((new javax.swing.ImageIcon(getClass().getResource("/kuvat/pohja.jpg"))));
            // laatat[i] = new JButton(Integer.toString(i + 1));
            laatat[i].setSize(50, 50);
            laatat[i].addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {
                            kaannettava = 0;

                            for (int i = 1; i < laatat.length; i++) {
                                if (e.getSource() == laatat[i]) {
                                    kaannettava = i;
                                }
                            }
                            // System.out.println("yritetään kääntää" + ((kaannettava)));
                            if (Operaatiot.kaannaLaatta(peli, (kaannettava))) {
                                kaannetyt.add(peli.getLaatat().get((kaannettava)));
                                // System.out.println("guinkaannetyt" + kaannetyt.toString());

                                // System.out.println("käännettiin!");
                                if (peli.getKaannetyt() == 2) {
                                    if (Operaatiot.onkoPari(peli)) {
                                        // System.out.println("löysit parin!");
                                        for (int i = 0; i < peli.getLaatat().size(); i++) {
                                            if (peli.getLaatat().get(i).onkoLoydetty()) {
                                                laatat[i].setEnabled(false);
                                                kaannetyt.clear();
                                            }
                                        }
                                    } else {
                                        // System.out.println("eivät olleet pari!");
                                        for (int j = 0; j < peli.getLaatat().size(); j++) {
                                            if (laatat[j].isEnabled()) {
                                                laatat[j].setSelected(false);
                                            }
                                        }
                                        kaannetyt.clear();
                                        if (peli.getParit() == (peli.getLaattoja()/2)){
                                            
                                        }
                                        
                                    }
                                }
                            }
                        }
                    });

            peliKentta.add(laatat[i]);

        }
        for (int j = 0;
                j < peli.getLaatat()
                .size(); j++) {
            if (peli.getLaatat().get(j).getTunniste() % 2 == 0) {
                laatat[j].setSelectedIcon((new javax.swing.ImageIcon(getClass().getResource("/kuvat/pari" + peli.getLaatat().get(j).getTunniste() + ".png"))));
            } else if (peli.getLaatat().get(j).getTunniste() % 2 != 0) {
                laatat[j].setSelectedIcon((new javax.swing.ImageIcon(getClass().getResource("/kuvat/pari" + ((peli.getLaatat().get(j).getTunniste()) - 1) + ".png"))));
            }
        }
        // laatat[0].setSelectedIcon((new javax.swing.ImageIcon(getClass().getResource("/kuvat/pari1.jpg"))));
        // laatat[2].setSelectedIcon((new javax.swing.ImageIcon(getClass().getResource("/kuvat/pari2.jpg"))));
    }

    public static void uusiPeli(int vaikeus) {
        Gui ruudukko = new Gui(vaikeus);
        ruudukko.setTitle("Muistipeli");
        ruudukko.setPreferredSize(new Dimension(800, 800));
        ruudukko.add(peliKentta);
        ruudukko.pack();
        ruudukko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ruudukko.setVisible(true);

    }
}
