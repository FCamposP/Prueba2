/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package convertidorXmi;

import java.util.StringTokenizer;

/**
 *
 * @author fabry
 */
public class Formato {

    public static String variable(String a) {
        String b = "";
        StringTokenizer t = new StringTokenizer(a);
        if (t.countTokens() == 1) {
            b = a.trim();
        } else {
            while (t.hasMoreTokens()) {
                String palabra = t.nextToken().toLowerCase();
                b += palabra.substring(0, 1).toUpperCase() + palabra.substring(1, palabra.length()); // contatena cada palabra con la primera letra mayuscula y las demas minuscula
            }
            if (!b.equals("")) {
                b = b.substring(0, 1).toLowerCase() + b.substring(1, b.length()); // modifica primer caracter a minuscula
            }
        }
          if (!b.equals("")) {
                b = b.substring(0, 1).toLowerCase() + b.substring(1, b.length()); // modifica primer caracter a minuscula
          }
        return b;
    }

    public static String nombreVariable(String a) {
        String b = "";
        StringTokenizer t = new StringTokenizer(a);
        while (t.hasMoreTokens()) {
            String palabra = t.nextToken().toLowerCase();
            b += palabra.substring(0, 1).toUpperCase() + palabra.substring(1, palabra.length()) + " "; // contatena cada palabra con la primera letra mayuscula y las demas minuscula
        }
        return b.trim();
    }

    public static String nombreClase(String a) {
        String b = "";
        StringTokenizer t = new StringTokenizer(a);
        if (t.countTokens() == 1) {
            b = mayusculaPrimeraLetra(a.trim());
        } else {
            while (t.hasMoreTokens()) {
                String palabra = t.nextToken().toLowerCase();
                b += palabra.substring(0, 1).toUpperCase() + palabra.substring(1, palabra.length()); // contatena cada palabra con la primera letra mayuscula y las demas minuscula
            }
        }
        return b;
    }

    public static String mayusculaPrimeraLetra(String a) {
        return a.substring(0, 1).toUpperCase() + a.substring(1, a.length());
    }
}
