/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.model;

/**
 *
 * @author alunoinf
 */
public enum StatusVenda {

    CANCELADO, CONFIRMADO;
    private String text;

    public static StatusVenda fromString(String text) {

        if (text != null) {

            for (StatusVenda n : StatusVenda.values()) {

                if (text.equalsIgnoreCase(n.name())) {
                    return n;
                }

            }
        }
        return null;
    }
}
