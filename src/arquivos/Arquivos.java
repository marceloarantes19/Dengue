/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package arquivos;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import modelos.Configuracao;

/**
 *
 * @author Marcelo
 */
public class Arquivos {
    public void gera(Configuracao conf, List<Integer> dados) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(conf.getNomeDoArquivo()+".csv"));
            int total = 0, i = 0;
            Iterator it = dados.iterator();
            bw.write("Grade "+conf.getTamanhoDaGrade()+" x "+conf.getTamanhoDaGrade()); bw.newLine();
            bw.write("Populacao Inicial de Pessoas: "+conf.getPopulacao()); bw.newLine();
            bw.write(" Susceptiveis: "+conf.getEstadosPopulacao().getSusceptivel()+";");
            bw.write(" Expostos: "+conf.getEstadosPopulacao().getExposto()+";");
            bw.write(" Infectados: "+conf.getEstadosPopulacao().getInfectado()+";");
            bw.write(" Recuperados: "+conf.getEstadosPopulacao().getSusceptivel()); bw.newLine();
            bw.write("Populacao Inicial de Vetores: "+conf.getPopulacaoVetores()); bw.newLine();
            bw.write(" Susceptiveis: "+conf.getEstadosVetores().getSusceptivel()+";");
            bw.write(" Expostos: "+conf.getEstadosVetores().getExposto()+";");
            bw.write(" Infectados: "+conf.getEstadosVetores().getInfectado()+";"); bw.newLine();
            bw.write("Ajuste local: "+conf.getAjusteLocal()+";");
            bw.write(" Ajuste global: "+conf.getAjusteGlobal()+";");
            bw.write(" Vizinhanca: "+conf.getVizinhanca()+";");
            bw.write(" Semente: "+conf.getSemente()); bw.newLine();
            while(it.hasNext()) {
                bw.write(((i%12)+1)+";"+nomeMes((i%12)+1)+";"+(Integer)it.next());
                bw.newLine();
                ++i;
            }
            bw.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Erro "+e+"!");
        }
    }
    public void gera2(Configuracao conf, List<Integer> dados, int tam) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(conf.getNomeDoArquivo()+".csv"));
            int i = 0;
            int [][] mat = new int[12][tam];
            float adc = 0.05f;
            Iterator it = dados.iterator();
            bw.write("Grade "+conf.getTamanhoDaGrade()+" x "+conf.getTamanhoDaGrade()); bw.newLine();
            bw.write("Populacao Inicial de Pessoas: "+conf.getPopulacao()); bw.newLine();
            bw.write(" Susceptiveis: "+conf.getEstadosPopulacao().getSusceptivel()+";");
            bw.write(" Expostos: "+conf.getEstadosPopulacao().getExposto()+";");
            bw.write(" Infectados: "+conf.getEstadosPopulacao().getInfectado()+";");
            bw.write(" Recuperados: "+conf.getEstadosPopulacao().getSusceptivel()); bw.newLine();
            bw.write("Populacao Inicial de Vetores: "+conf.getPopulacaoVetores()); bw.newLine();
            bw.write(" Susceptiveis: "+conf.getEstadosVetores().getSusceptivel()+";");
            bw.write(" Expostos: "+conf.getEstadosVetores().getExposto()+";");
            bw.write(" Infectados: "+conf.getEstadosVetores().getInfectado()+";"); bw.newLine();
            bw.write("Ajuste local: "+conf.getAjusteLocal()+";");
            bw.write(" Ajuste global: "+conf.getAjusteGlobal()+";");
            bw.write(" Vizinhanca: "+conf.getVizinhanca()+";");
            bw.write(" Semente: "+conf.getSemente()); bw.newLine();
            bw.newLine();
            bw.write(";;");
            for(int x=0;x<tam;++x) {
               bw.write(adc+";");
               adc=adc+0.05f;
            }
            bw.newLine();
            while(it.hasNext()) {
                mat[i%12][i/12] = (Integer)it.next();
                ++i;
            }
            for(i=0;i<12;++i) {
                bw.write((i+1)+";"+nomeMes((i%12)+1)+";");
                for(int j=0;j<tam;++j) {
                    bw.write(mat[i][j]+";");
                }
                bw.newLine();
            }
            /*
            while(it.hasNext()) {
                bw.write(((i%12)+1)+";"+nomeMes((i%12)+1)+";"+(Integer)it.next());
                bw.newLine();
                ++i;
            }
             *
             */
            bw.close();
        }
        catch(Exception e) {
            JOptionPane.showMessageDialog(null,"Erro "+e+"!");
        }
    }
    private String nomeMes(int i) {
        switch(i) {
            case 1: return "Janeiro";
            case 2: return "Fevereiro";
            case 3: return "Marco";
            case 4: return "Abril";
            case 5: return "Maio";
            case 6: return "Junho";
            case 7: return "Julho";
            case 8: return "Agosto";
            case 9: return "Setembro";
            case 10: return "Outubro";
            case 11: return "Novembro";
            case 12: return "Dezembro";
            default : return "Zero";
        }
    }
}
