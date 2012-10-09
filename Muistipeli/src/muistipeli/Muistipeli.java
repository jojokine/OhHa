/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package muistipeli;

import ui.Gui;

/**
 *
 * @author jojokine
 */
public class Muistipeli {

    public static void main(String[] args) {

        Gui.uusiPeli(ui.Pop.valitseNappula("Valitse Vaikeustaso!", "Helppo", "Keskivaikea", "Vaikea"));

    }
}
