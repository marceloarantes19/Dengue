/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;

import arquivos.Arquivos;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Marcelo
 */
public class SimulaArquivo3d {
    private Grade atual;
    private Configuracao configura;
    private Simula simula;
    int dia;
    int infectados;
    int populacaoHumanos;
    int populacaoVetores;
    int humInfectados;
    int vetInfectados;
    double variacao;
   // Painel painelHumano, painelVetor, painelHumanoVetor;
    List<Integer> infect = new ArrayList<Integer>();
    Agentes gradeDia [][];
    public SimulaArquivo3d(Configuracao conf) {
        for(variacao = 0.05; variacao<0.30;variacao+=0.05) {
           inicia(conf);
           executivo();
        }
        if(!configura.getNomeDoArquivo().trim().isEmpty()) {
            Arquivos arq = new Arquivos();
            arq.gera2(configura, infect, 5);
        }
        JOptionPane.showMessageDialog(null, "Fim de Simulação!");
    }
    public void inicia(Configuracao configura) {
        atual = new Grade(configura.getTamanhoDaGrade(), configura.getEstadosPopulacao(), configura.getEstadosVetores(), configura);
        simula = new Simula();
        dia = 0;
        infectados = atual.getUltimoInfectadoHumano();
        populacaoHumanos = configura.getPopulacao();
        populacaoVetores = configura.getPopulacaoVetores();
        humInfectados = configura.getEstadosPopulacao().getInfectado();
        vetInfectados = configura.getEstadosVetores().getInfectado();
        gradeDia = new Agentes[configura.getTamanhoDaGrade()][configura.getTamanhoDaGrade()];
        this.configura = configura;
        zeraGradeDia(gradeDia);
    }
    public void executivo() {
        do {
            ++dia;
            if(dia%30==0) {
               infect.add(infectados);
               infectados = 0;
            }
                // Chama Simulador
            infectados = infectados+simula.simula(atual, gradeDia, configura, dia,
                    populacaoHumanos, populacaoVetores, humInfectados, vetInfectados, variacao);
        }while(dia<30*configura.getMesesASimular());
    }

    public void zeraGradeDia(Agentes [][] gradeDia) {
        for(int i=0; i<configura.getTamanhoDaGrade();++i) {
            for(int j=0;j<configura.getTamanhoDaGrade(); ++j) {
                int estHum = atual.getGrade()[i][j].getHumano();
                int estVet = atual.getGrade()[i][j].getVetor();
                gradeDia[i][j] = new Agentes();
                if(estHum==2) {
                    gradeDia[i][j].setHumano((int) (Math.random() * 12 + 3));
                }
                else if(estHum==3) {
                    gradeDia[i][j].setHumano((int) (Math.random() * 8 + 3));
                }
                else gradeDia[i][j].setHumano(0);
                if(estVet==2) {
                    gradeDia[i][j].setVetor((int) (Math.random() * 3 + 7));
                }
                else gradeDia[i][j].setVetor(0);
            }
        }
    }
}
