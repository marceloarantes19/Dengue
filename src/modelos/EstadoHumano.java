/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

/**
 *
 * @author Marcelo
 */
public class EstadoHumano extends Estado {
    private int recuperado;
    public int getRecuperado() {
        return recuperado;
    }
    public void setRecuperado(int recuperado) {
        this.recuperado = recuperado;
    }
    @Override
    public void zera() {
        super.zera();
        recuperado = 0;
    }
}