/*
Formato de la trama a valor, b valor y c vavlor
 */
package com.app.modelo.entidades;

public class Trama {
    
    private int a;
    private int b;
    private int c;

    public Trama() {
    }

    public Trama(int a, int b, int c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public int getA() {
        return a;
    }

    public void setA(int a) {
        this.a = a;
    }

    public int getB() {
        return b;
    }

    public void setB(int b) {
        this.b = b;
    }

    public int getC() {
        return c;
    }

    public void setC(int c) {
        this.c = c;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + this.a;
        hash = 29 * hash + this.b;
        hash = 29 * hash + this.c;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Trama other = (Trama) obj;
        if (this.a != other.a) {
            return false;
        }
        if (this.b != other.b) {
            return false;
        }
        if (this.c != other.c) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Trama{" + "a=" + a + ", b=" + b + ", c=" + c + '}';
    }
    
}
