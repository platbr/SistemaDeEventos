/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufg.inf.espbd.siseventos.model;

/**
 *
 * @author alunoinf
 */
public enum NivelAcesso {

    OPERACIONAL, GERENCIAL;
    private String text;

    public static NivelAcesso fromString(String text) {

        if (text != null) {

            for (NivelAcesso n : NivelAcesso.values()) {

                if (text.equalsIgnoreCase(n.name())) {
                    return n;
                }

            }
        }
        return null;
    }
}
