/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

/**
 *
 * @author Marcelo
 */
public class Estado {
    private int susceptivel;
    private int exposto;
    private int infectado;
    public int getExposto() {
        return exposto;
    }
    public void setExposto(int exposto) {
        this.exposto = exposto;
    }
    public int getInfectado() {
        return infectado;
    }
    public void setInfectado(int infectado) {
        this.infectado = infectado;
    }
    public int getSusceptivel() {
        return susceptivel;
    }
    public void setSusceptivel(int susceptivel) {
        this.susceptivel = susceptivel;
    }
    public void zera() {
        this.exposto = 0;
        this.infectado = 0;
        this.susceptivel = 0;
    }
}
