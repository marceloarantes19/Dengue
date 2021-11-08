/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

/**
 *
 * @author Marcelo
 */
public class Relat {
    private int dia;
    private int hSus;
    private int hExp;
    private int hInf;
    private int hRec;
    private int hTotal;
    private int vSus;
    private int vExp;
    private int vInf;
    private int vTotal;
    public Relat() {
        this.dia=0;
        this.hSus=0;
        this.hExp=0;
        this.hInf=0;
        this.hRec=0;
        this.hTotal=0;
        this.vSus=0;
        this.vExp=0;
        this.vInf=0;
        this.vTotal=0;
    }
    public Relat(Relat x){
        this.dia=x.dia;
        this.hSus=x.hSus;
        this.hExp=x.hExp;
        this.hInf=x.hInf;
        this.hRec=x.hRec;
        this.hTotal=x.hTotal;
        this.vSus=x.vSus;
        this.vExp=x.vExp;
        this.vInf=x.vInf;
        this.vTotal=x.vTotal;
    }
    public Relat(int dia, int hSus, int hExp, int hInf, int hRec, int hTotal,
                 int vSus, int vExp, int vInf, int vTotal)
    {
        this.dia=dia;
        this.hSus=hSus;
        this.hExp=hExp;
        this.hInf=hInf;
        this.hRec=hRec;
        this.hTotal=hTotal;
        this.vSus=vSus;
        this.vExp=vExp;
        this.vInf=vInf;
        this.vTotal=vTotal;
    }
    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int gethExp() {
        return hExp;
    }

    public void sethExp(int hExp) {
        this.hExp = hExp;
    }

    public int gethInf() {
        return hInf;
    }

    public void sethInf(int hInf) {
        this.hInf = hInf;
    }

    public int gethRec() {
        return hRec;
    }

    public void sethRec(int hRec) {
        this.hRec = hRec;
    }

    public int gethSus() {
        return hSus;
    }

    public void sethSus(int hSus) {
        this.hSus = hSus;
    }

    public int gethTotal() {
        return hTotal;
    }

    public void sethTotal(int hTotal) {
        this.hTotal = hTotal;
    }

    public int getvExp() {
        return vExp;
    }

    public void setvExp(int vExp) {
        this.vExp = vExp;
    }

    public int getvInf() {
        return vInf;
    }

    public void setvInf(int vInf) {
        this.vInf = vInf;
    }

    public int getvSus() {
        return vSus;
    }

    public void setvSus(int vSus) {
        this.vSus = vSus;
    }

    public int getvTotal() {
        return vTotal;
    }

    public void setvTotal(int vTotal) {
        this.vTotal = vTotal;
    }
}
