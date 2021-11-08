/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marcelo
 */
public class Grade {
    private int tamanho;
    private Agentes grade[][];
    private List <EstadoHumano> humanosDia = new ArrayList<EstadoHumano>();
    private List <EstadoVetor>  vetoresDia = new ArrayList<EstadoVetor>();
    private Configuracao configura;
    public Grade(int tam) {
        tamanho = tam;
        grade = new Agentes[tam][tam];
        zeraGrade(tam);
    }
    public Grade(int tam, EstadoHumano ehu, EstadoVetor eve, Configuracao conf) {
        if((ehu.getSusceptivel()+ehu.getExposto()+ehu.getInfectado()+ehu.getRecuperado()<=(tam*tam)) &&
            eve.getSusceptivel()+eve.getExposto()+eve.getInfectado()<=(tam*tam)    ) {
            int ins = 0;
            tamanho = tam;
            grade = new Agentes[tam][tam];
            zeraGrade(tam);
            humanosDia.clear();
            humanosDia.add(ehu);
            vetoresDia.clear();
            vetoresDia.add(eve);
            configura = conf;
            insereInicialh(1, ehu.getSusceptivel());
            insereInicialh(2, ehu.getExposto());
            insereInicialh(3, ehu.getInfectado());
            insereInicialh(4, ehu.getRecuperado());
            insereInicialv(1, eve.getSusceptivel());
            insereInicialv(2, eve.getExposto());
            insereInicialv(3, eve.getInfectado());
        }
    }
    private void insereInicialh(int x, int qtdx) {
        int qtd = 0;
        while(qtd<qtdx) {
            int linha, coluna;
            do {
               linha  = configura.getRandomico().nextInt(tamanho);
               coluna = configura.getRandomico().nextInt(tamanho);
            } while(grade[linha][coluna].getHumano()!=0);
            grade[linha][coluna].setHumano(x);
            ++qtd;
        }
    }
    private void insereInicialv(int x, int qtdx) {
        int qtd = 0;
        while(qtd<qtdx) {
            int linha, coluna;
            do {
               linha  = configura.getRandomico().nextInt(tamanho);
               coluna = configura.getRandomico().nextInt(tamanho);
            } while(grade[linha][coluna].getVetor()!=0);
            grade[linha][coluna].setVetor(x);
            ++qtd;
        }
    }
    public void zeraGrade(int t) {
        EstadoHumano ehu = new EstadoHumano();
        EstadoVetor eve = new EstadoVetor();
        for(int i=0; i<t;++i) {
            for(int j=0; j<t;++j) {
                this.getGrade()[i][j] = new Agentes();
                this.grade[i][j].setHumano(0);
                this.grade[i][j].setVetor(0);
            }
        }
        this.humanosDia = new ArrayList<EstadoHumano>();
        this.vetoresDia = new ArrayList<EstadoVetor>();
        ehu.zera();
        eve.zera();
        this.humanosDia.add(ehu);
        this.vetoresDia.add(eve);
    }

    public Agentes[][] getGrade() {
        return grade;
    }

    public void setGrade(Agentes[][] grade) {
        this.grade = grade;
    }

    public List<EstadoHumano> getHumanosDia() {
        return humanosDia;
    }

    public void setHumanosDia(List<EstadoHumano> humanosDia) {
        this.humanosDia = humanosDia;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public List<EstadoVetor> getVetoresDia() {
        return vetoresDia;
    }

    public void setVetoresDia(List<EstadoVetor> vetoresDia) {
        this.vetoresDia = vetoresDia;
    }
    public int getTotalUltimoHumano() {
        return humanosDia.get(humanosDia.size()-1).getSusceptivel()+
               humanosDia.get(humanosDia.size()-1).getExposto()+
               humanosDia.get(humanosDia.size()-1).getInfectado()+
               humanosDia.get(humanosDia.size()-1).getRecuperado();
    }
    public int getTotalUltimoVetor() {
        return vetoresDia.get(vetoresDia.size()-1).getSusceptivel()+
               vetoresDia.get(vetoresDia.size()-1).getExposto()+
               vetoresDia.get(vetoresDia.size()-1).getInfectado();
    }
    public EstadoHumano getUltimoHumano() {
        return humanosDia.get(humanosDia.size()-1);
    }
    public EstadoVetor getUltimoVetor() {
        return vetoresDia.get(vetoresDia.size()-1);
    }
    public int getUltimoInfectadoHumano() {
        return humanosDia.get(humanosDia.size()-1).getInfectado();
    }
    public int getUltimoInfectadoVetor() {
        return vetoresDia.get(vetoresDia.size()-1).getInfectado();
    }
}
