/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package modelos;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import visoes.FrmSimulacao;

/**
 *
 * @author Marcelo
 */
public class SimulaDengue {
    Grade atual;
    Grade proximaGeracao;
    Agentes gradeDia [][];
    Configuracao configura;
    FrmSimulacao frmSimula;
    List <Relat> relatDiario = new ArrayList<Relat>();
    int dia;
    int mes;
    float peso1 = 0.995f, peso2 = 0.005f;

    public SimulaDengue(Configuracao config) {
        configura = config;
        atual = new Grade(configura.getTamanhoDaGrade(), configura.getEstadosPopulacao(), configura.getEstadosVetores(), configura);
        proximaGeracao = new Grade(configura.getTamanhoDaGrade());
        dia = 0;
        mes = 0;
        simula();
    }
    void simula() {
        int i, j;
        float probGlobalHumano, probGlobalVetor, probLocalHumano=0, probLocalVetor;
        float probTotalHumano=0, probTotalVetor=0;
        int vizinhos=0, infectados=atual.getUltimoInfectadoHumano();
        Thread thread = Thread.currentThread();
        List <Integer> infect = new ArrayList<Integer>();
        gradeDia = new Agentes[atual.getTamanho()][atual.getTamanho()];
        zeraGradeDia();
       // mostraTeste();
        int valorTrab;
        while(dia<(configura.getMesesASimular()*30)) {
            ++dia;
            if(dia%30==0) {
               totalizaMes();
               infect.add(infectados);
               infectados = 0;
               ++mes;
            }
            probGlobalHumano = (float)(atual.getUltimoInfectadoHumano()/atual.getTotalUltimoHumano());
            probGlobalVetor = (float)(atual.getUltimoInfectadoVetor()/atual.getTotalUltimoVetor());
            proximaGeracao.zeraGrade(configura.getTamanhoDaGrade());
            for(i=0; i<atual.getTamanho();++i) {
                for(j=0;j<atual.getTamanho();++j) {
                    vizinhos = 0;
                    if(atual.getGrade()[i][j].getHumano()==1) {
                        vizinhos=checkMoore(i,j,'h');
                        probLocalHumano =  1-(float)Math.pow(1-0.03,vizinhos);
                        probTotalHumano = (float) peso1*probLocalHumano+peso2*probGlobalHumano;
                    }
                    if(atual.getGrade()[i][j].getHumano()==1 &&
                      (((float)(Math.random() * 100 +1)/100) <= probTotalHumano)) {
                        proximaGeracao.getGrade()[i][j].setHumano(2);
                        gradeDia[i][j].setHumano(dia);
                    }
                    else if(atual.getGrade()[i][j].getHumano()==2 &&
                           (dia - gradeDia[i][j].getHumano() == 7)) {
                        ++infectados;
                        proximaGeracao.getGrade()[i][j].setHumano(3);
                        gradeDia[i][j].setHumano(dia);
                    }
                    else if(atual.getGrade()[i][j].getHumano()==3 &&
                           (dia - gradeDia[i][j].getHumano() == 10)) {
                        //proximaGeracao.getGrade()[i][j].setHumano(4);
                        proximaGeracao.getGrade()[i][j].setHumano(1);
                    }
                    else {
                        proximaGeracao.getGrade()[i][j].setHumano(atual.getGrade()[i][j].getHumano());
                    }
                    vizinhos = 0;
                    if(atual.getGrade()[i][j].getVetor()==1) {
                        vizinhos=checkMoore(i,j,'v');
                        probLocalVetor =  1-(float)Math.pow(1-0.03,vizinhos);
                        probTotalVetor = (float) peso1*probLocalVetor+peso2*probGlobalVetor;
                    }
                    if(atual.getGrade()[i][j].getVetor()==1 &&
                      (((float)(Math.random() * 100 +1)/100) <= probTotalVetor)) {
                        proximaGeracao.getGrade()[i][j].setVetor(2);
                        gradeDia[i][j].setVetor(dia);
                    }
                    else if(atual.getGrade()[i][j].getVetor()==2 &&
                           (dia - gradeDia[i][j].getVetor() == 7)) {
                        proximaGeracao.getGrade()[i][j].setVetor(3);
                        gradeDia[i][j].setVetor(dia);
                    }
                    else if(atual.getGrade()[i][j].getVetor()==3 &&
                           (dia - gradeDia[i][j].getVetor() == 60)) { // 9 no original
                        proximaGeracao.getGrade()[i][j].setVetor(1);
                    }
                    else if(atual.getGrade()[i][j].getVetor()!=0 &&
                            (((float)(Math.random() * 100 +1)/100) <= 0.02))  {
                        proximaGeracao.getGrade()[i][j].setVetor(0);
                    } 
                    else {
                        proximaGeracao.getGrade()[i][j].setVetor(atual.getGrade()[i][j].getVetor());
                    }
                }
            }
            atualiza();
            try {
               Thread.sleep(1000);
            } catch (InterruptedException e) {

            }
            JOptionPane.showMessageDialog(null, "");
            //for(int kk=0; kk<100000; ++kk) ;
         
        //    mostraTeste();
        }
        Iterator it = infect.iterator();
        while(it.hasNext()) {
            JOptionPane.showMessageDialog(null, it.next());
        }
        JOptionPane.showMessageDialog(null, "Fim da simulação!");
        System.exit(0);
    }
    private void totalizaMes() {}
    private void atualiza() {
        for(int i=0;i<configura.getTamanhoDaGrade();++i) {
            for(int j=0;j<configura.getTamanhoDaGrade();++j) {
                atual.getGrade()[i][j].setHumano(proximaGeracao.getGrade()[i][j].getHumano());
                atual.getGrade()[i][j].setVetor(proximaGeracao.getGrade()[i][j].getVetor());
            }
        }
    }
    private void mostraTeste() {
        String s="Humano \n\n";
        for(int i=0; i<configura.getTamanhoDaGrade(); ++i) {
            for(int j=0; j<configura.getTamanhoDaGrade();++j) {
                s=s+atual.getGrade()[i][j].getHumano()+"  ";
            }
            s=s+"\n";
        }
        s=s+"\n Vetores \n\n";
        for(int i=0; i<configura.getTamanhoDaGrade(); ++i) {
            for(int j=0; j<configura.getTamanhoDaGrade();++j) {
                s=s+atual.getGrade()[i][j].getVetor()+"  ";
            }
            s=s+"\n";
        }
        JOptionPane.showMessageDialog(null, s);
    }
    public int checkMoore(int x,int y, char tipo)  {
       int vizinhos=0;
       int iAux=0,jAux=0;
       for(int i=x-configura.getVizinhanca();i<=x+configura.getVizinhanca();i++) {
           for(int j=y-configura.getVizinhanca();j<=y+configura.getVizinhanca();j++) {
              iAux=0;jAux=0;
              iAux=periodico(i);
              jAux=periodico(j);
              //System.out.println(iAux+":"+jAux);
              if((tipo=='h' && atual.getGrade()[x][y].getVetor()==3) ||
                 (tipo=='v' && atual.getGrade()[x][y].getHumano()==3)){
                 vizinhos++;
              }
           }
       }
       return vizinhos;
    }

    public int periodico(int i) {
       if(i<0)
          return configura.getTamanhoDaGrade()+i;
       else if(i>configura.getTamanhoDaGrade()-1)
          return i - configura.getTamanhoDaGrade() - 1;
       else
          return i;
    }
    public void zeraGradeDia() {
        for(int i=0; i<configura.getTamanhoDaGrade();++i) {
            for(int j=0;j<configura.getTamanhoDaGrade(); ++j) {
                this.gradeDia[i][j] = new Agentes();
                this.gradeDia[i][j].setHumano(0);
                this.gradeDia[i][j].setVetor(0);
            }
        }
    }
}
