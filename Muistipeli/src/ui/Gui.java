/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import muistipeli.Laatta;
import muistipeli.Operaatiot;

/**
 *
 * @author jojokine
 */
public class Gui extends JFrame {

    private int i = 0;
    private static JPanel peliKentta;
    private GridLayout kentanKoko;
    private int kaannettava;
    private static ArrayList<Laatta> kaannetyt;
    private static pisteSyotto syotto;
    private static String lista;
    private static int kaannot;
    private static Gui ruudukko;
    private static JMenuBar mb = new JMenuBar();
    private static JMenu mnuValikko = new JMenu("Valikko");
    private static JMenuItem mnuItemLopeta = new JMenuItem("Lopeta");
    private static JMenuItem mnuItemPisteet = new JMenuItem("Parhaat tulokset");
    private static JMenu mnuApua = new JMenu("Apua");
    private static JMenuItem mnuItemAbout = new JMenuItem("About");

    public static void uusiPeli(final int vaikeus) {
        ruudukko = new Gui(vaikeus);
        ruudukko.setTitle("Muistipeli");
        ruudukko.setPreferredSize(new Dimension(800, 800));
        ruudukko.setJMenuBar(mb);

        mnuItemLopeta.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        System.exit(0);
                    }
                });
        mnuItemPisteet.addActionListener(
                new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        lista = "Parhaat tulokset vaikeustasolle\nNimi:      Kääntökertoja:\n";
                        for (int i = 0; i < Operaatiot.pisteetSailosta(vaikeus).getPisteet().size(); i++) {
                            lista = lista + Operaatiot.pisteetSailosta(vaikeus).getPisteet().get(i).getNimi() + "     " + Operaatiot.pisteetSailosta(vaikeus).getPisteet().get(i).getPisteet() + "\n";
                        }
                        Pop.ilmoita(lista);

                    }
                });




        mnuValikko.add(mnuItemLopeta);
        mnuValikko.add(mnuItemPisteet);
        mnuApua.add(mnuItemAbout);
        mb.add(mnuValikko);
        mb.add(mnuApua);


        ruudukko.add(peliKentta);
        ruudukko.pack();
        ruudukko.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ruudukko.setVisible(true);

    }

    public Gui(int vaikeus) {

        kaannetyt = new ArrayList();


        final muistipeli.Kentta peli;
        peli = new muistipeli.Kentta(vaikeus);


        if (peli.getLaattoja() == 16) {
            kentanKoko = new GridLayout(4, 4);
        }
        if (peli.getLaattoja() == 24) {
            kentanKoko = new GridLayout(6, 4);
        }
        if (peli.getLaattoja() == 36) {
            kentanKoko = new GridLayout(6, 6);
        }

        //peli.getLaatat().get(1).setTunniste(1);
        //peli.getLaatat().get(2).setTunniste(2);

        for (int j = 0; j < peli.getLaatat().size(); j++) {
            // System.out.println((j + 1) + " on " + peli.getLaatat().get(j).getTunniste());
        }


        final JButton[] laatat = new JButton[peli.getLaattoja()];

        peliKentta = new JPanel(kentanKoko);
        for (i = 0; i < laatat.length; i++) {
            laatat[i] = new JButton();
            laatat[i].setIcon((new javax.swing.ImageIcon(getClass().getResource("/kuvat/pohja.jpg"))));
            // laatat[i] = new JButton(Integer.toString(i + 1));
            laatat[i].setSize(50, 50);
            laatat[i].addActionListener(
                    new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {


                            // kaannettava = 0;

                            for (int i = 0; i < laatat.length; i++) {
                                if (e.getSource() == laatat[i]) {
                                    kaannettava = i;
                                }
                            }
                            // System.out.println("yritetään kääntää" + ((kaannettava)));
                            if (Operaatiot.kaannaLaatta(peli, (kaannettava))) {
                                Gui.kaannot = peli.getKaannot();
                                System.out.println(peli.getKaannot());
                                laatat[kaannettava].setSelected(true);
                                kaannetyt.add(peli.getLaatat().get((kaannettava)));
                                // System.out.println("guinkaannetyt" + kaannetyt.toString());

                                // System.out.println("käännettiin!");
                                if (peli.getKaannetyt() == 2) {
                                    if (Operaatiot.onkoPari(peli)) {
                                        // System.out.println("löysit parin!");
                                        for (int i = 0; i < peli.getLaatat().size(); i++) {
                                            if (peli.getLaatat().get(i).onkoLoydetty()) {
                                                laatat[i].setEnabled(false);
                                                laatat[i].setSelected(true);
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


                                    }
                                    if (peli.getParit() == (peli.getLaattoja() / 2)) {
                                        System.out.println("peli loppui");
                                        syotto = new pisteSyotto();
                                        syotto.setTitle("Pisteiden tallennus");
                                        syotto.pack();
                                        syotto.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                                        syotto.setVisible(true);
                                    }
                                }
                            }

                        }
                    });

            peliKentta.add(laatat[i]);

        }

        for (int j = 0; j < peli.getLaatat().size(); j++) {
            laatat[j].setSelectedIcon((new javax.swing.ImageIcon(getClass().getResource("/kuvat/pari" + peli.getLaatat().get(j).getTunniste() + ".png"))));
        }

    }
}
