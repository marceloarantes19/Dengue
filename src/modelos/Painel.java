/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;
import modelos.Configuracao;
import modelos.Grade;

/**
 *
 * @author Marcelo
 */
public class Painel extends JPanel {

    Configuracao configura;
    Grade atual;
    int tipo;
    public Painel(Configuracao conf, Grade atual, int tp) {
        configura = conf;
        this.atual = atual;
        tipo = tp;
    }
    @Override
    public void paint(Graphics g) {
        int tam = configura.getTamanhoDaGrade(), tam10=tam*10;
        g.setColor(Color.GRAY);
        g.fillRect(0,0,tam10, tam10);
        g.setColor(Color.BLACK);
        //horizontal
        for(int i=0;i<=tam;i++) {
            g.drawLine(0,i*10,tam10,i*10);
        }
        //vertical
        for(int i=0;i<=tam;i++) {
            g.drawLine(i*10,0,i*10,tam10);
        }

        for(int i=0;i<tam;i++) {
            for(int j=0;j<tam;j++)
            {
                if(tipo==0 || tipo == 2) {
                    if(atual.getGrade()[i][j].getHumano()==0)
                       g.setColor(Color.GRAY);
                    if(atual.getGrade()[i][j].getHumano()==1)
                       g.setColor(Color.GREEN);
                    if(atual.getGrade()[i][j].getHumano()==2)
                       g.setColor(Color.WHITE);
                    if(atual.getGrade()[i][j].getHumano()==3)
                       g.setColor(Color.RED);
                    if(atual.getGrade()[i][j].getHumano()==4)
                       g.setColor(Color.BLUE);
                    if(tipo==0) {
//                       g.fillRect(i*10+1, j*10+1, 9, 9);
                       g.fillRect( j*10+1, i*10+1, 9, 9);
                    }
                    else {
                       int [] px = new int[3];
                       int [] py = new int[3];
                       px[0] = i*10+1; py[0] = j*10+1;
                       px[1] = i*10+9; py[1] = j*10+1;
                       px[2] = i*10+1; py[2] = j*10+9;
                       g.fillPolygon(py, px, 3);
                    }
                }
                if(tipo==1 || tipo == 2) {
                    if(atual.getGrade()[i][j].getVetor()==0)
                       g.setColor(Color.GRAY);
                    if(atual.getGrade()[i][j].getVetor()==1)
                       g.setColor(Color.GREEN);
                    if(atual.getGrade()[i][j].getVetor()==2)
                       g.setColor(Color.WHITE);
                    if(atual.getGrade()[i][j].getVetor()==3)
                       g.setColor(Color.RED);
                    if(atual.getGrade()[i][j].getVetor()==4)
                       g.setColor(Color.BLUE);
                    if(tipo==1) {
                       g.fillRect(j*10+1, i*10+1, 9, 9);
                    }
                    else {
                       int [] px = new int[3];
                       int [] py = new int[3];
                       px[0] = i*10+10; py[0] = j*10+10;
                       px[1] = i*10+10; py[1] = j*10;
                       px[2] = i*10; py[2] = j*10+10;
                       g.fillPolygon(py, px, 3);
                    }
                }

            }
        }
    }
    //public void repinta(atual,)
}
