/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

import java.util.Random;
/**
 *
 * @author Marcelo
 */
public class Configuracao {
    private int tamanhoDaGrade;
    private int populacao;
    private EstadoHumano estadosPopulacao;
    private EstadoVetor estadosVetores;
    private int vizinhanca;
    private String nomeDoArquivo;
    private int mesesASimular;
    private float ajusteLocal;
    private float ajusteGlobal;
    private float mortalidade;
    private int semente;
    private Random randomico;

    public Random getRandomico() {
        return randomico;
    }

    public void setRandomico(long semente) {
        this.randomico = new Random(semente);
    }

    public int getSemente() {
        return semente;
    }

    public void setSemente(int semente) {
        this.semente = semente;
    }

    public float getMortalidade() {
        return mortalidade;
    }

    public void setMortalidade(float mortalidade) {
        this.mortalidade = mortalidade;
    }

    public int getMesesASimular() {
        return mesesASimular;
    }

    public void setMesesASimular(int mesesASimular) {
        this.mesesASimular = mesesASimular;
    }

    public EstadoHumano getEstadosPopulacao() {
        return estadosPopulacao;
    }

    public void setEstadosPopulacao(EstadoHumano estadosPopulacao) {
        this.estadosPopulacao = estadosPopulacao;
    }

    public EstadoVetor getEstadosVetores() {
        return estadosVetores;
    }

    public void setEstadosVetores(EstadoVetor estadosVetores) {
        this.estadosVetores = estadosVetores;
    }

    public String getNomeDoArquivo() {
        return nomeDoArquivo;
    }

    public void setNomeDoArquivo(String nomeDoArquivo) {
        this.nomeDoArquivo = nomeDoArquivo;
    }

    public int getPopulacao() {
        return populacao;
    }

    public void setPopulacao(int populacao) {
        this.populacao = populacao;
    }

    public int getTamanhoDaGrade() {
        return tamanhoDaGrade;
    }

    public void setTamanhoDaGrade(int tamanhoDaGrade) {
        this.tamanhoDaGrade = tamanhoDaGrade;
    }

    public int getVizinhanca() {
        return vizinhanca;
    }

    public void setVizinhanca(int vizinhanca) {
        this.vizinhanca = vizinhanca;
    }

    public int getPopulacaoVetores() {
        return estadosVetores.getExposto()+estadosVetores.getSusceptivel()+
               estadosVetores.getInfectado();
    }

    public float getAjusteGlobal() {
        return ajusteGlobal;
    }

    public void setAjusteGlobal(float ajusteGlobal) {
        this.ajusteGlobal = ajusteGlobal;
    }

    public float getAjusteLocal() {
        return ajusteLocal;
    }
    
    public void setAjusteLocal(float ajusteLocal) {
        this.ajusteLocal = ajusteLocal;
    }  
}