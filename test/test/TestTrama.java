/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.app.modelo.conexion.analizador.Analizador;

/**
 *
 * @author Hyper
 */
public class TestTrama {

    public static void main(String[] args) {
        String t = "a259b984c650";
        String t2 = "a1344b801c281";
        String t3 = "a262b986c651";
        String t4 = "a0b0c0";
        Analizador a = new Analizador();
        System.out.println(a.convertir(t));
        System.out.println(a.convertir(t2));
        System.out.println(a.convertir(t3));
        System.out.println(a.convertir(t4));
    }
}
