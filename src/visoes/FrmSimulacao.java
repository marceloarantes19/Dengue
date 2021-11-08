/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmSimulacao.java
 *
 * Created on 02/09/2010, 08:41:38
 */

package visoes;

import arquivos.Arquivos;
import java.awt.Color;
import modelos.Painel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.JScrollBar;
import modelos.Agentes;
import modelos.Configuracao;
import modelos.Grade;
import modelos.Simula;

/**
 *
 * @author Marcelo
 */
public class FrmSimulacao extends javax.swing.JFrame implements Runnable {

    /** Creates new form FrmSimulacao */
    private Grade atual;
    private Configuracao configura;
    private Simula simula;
    int dia;
    int infectados;
    int populacaoHumanos;
    int populacaoVetores;
    int humInfectados;
    int vetInfectados;
    Painel painelHumano, painelVetor, painelHumanoVetor;
    List<Integer> infect = new ArrayList<Integer>();
    Agentes gradeDia [][];
    JScrollBar jsb;
    Thread runner = null, thisTh=null;

    // Construtor
    public FrmSimulacao(Configuracao config) {
        initComponents();
        configura = config;
        atual = new Grade(configura.getTamanhoDaGrade(), configura.getEstadosPopulacao(), configura.getEstadosVetores(), configura);
        simula = new Simula();
        painelHumano = new Painel(configura, atual, 0);
        painelVetor = new Painel(configura, atual, 1);
        painelHumanoVetor = new Painel(configura, atual, 2);
        painelHumano.setLocation(1, 1);
        painelVetor.setLocation(1, 1);
        painelHumanoVetor.setLocation(1, 1);
        painelHumano.setSize(configura.getTamanhoDaGrade()*10+1, configura.getTamanhoDaGrade()*10+1);
        painelVetor.setSize(configura.getTamanhoDaGrade()*10+1, configura.getTamanhoDaGrade()*10+1);
        painelHumanoVetor.setSize(configura.getTamanhoDaGrade()*10+1, configura.getTamanhoDaGrade()*10+1);
        jPanelHumano.add(painelHumano);
        jPanelHumano.setSize(configura.getTamanhoDaGrade()*10+1, configura.getTamanhoDaGrade()*10+1);

        jPanelVetor.add(painelVetor);
        jPanelHumanoVetor.add(painelHumanoVetor);
        dia = 0;
        infectados = atual.getUltimoInfectadoHumano();
        populacaoHumanos = configura.getPopulacao();
        populacaoVetores = configura.getPopulacaoVetores();
        humInfectados = configura.getEstadosPopulacao().getInfectado();
        vetInfectados = configura.getEstadosVetores().getInfectado();
        gradeDia = new Agentes[configura.getTamanhoDaGrade()][configura.getTamanhoDaGrade()];
        zeraGradeDia(gradeDia);
    }

    // Simulador
    public void executivo() {
        ++dia;
        jTextFieldDiasDeSimulacao.setText((dia+" "));
        jTextFieldDiasDeSimulacao.setBackground(Color.WHITE);
        jTextFieldDiasDeSimulacao.setForeground(Color.BLACK);
        if(dia%30==0) {
           infect.add(infectados);
           infectados = 0;
           if(dia>=(30*configura.getMesesASimular())) {
               finaliza();
           }
        }
            // Chama Simulador
        infectados = infectados+simula.simula(atual, gradeDia, configura, dia,
                populacaoHumanos, populacaoVetores, humInfectados, vetInfectados, 0.025);
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

    public void parar() {

    }

    public void finaliza() {
        this.relatorio();
        this.dispose();
    }

    public void relatorio() {
        Iterator it = infect.iterator();
        String s="População: "+populacaoHumanos+"\n";
        int i = 1, total = 0;
        while(it.hasNext()) {
            int infMes = (Integer)it.next();
            float percentual = (float)(infMes * 100) / populacaoHumanos;
            s=s+"Mes - "+i+" - "+infMes+" - "+percentual+"\n";
            ++i;
            total+=infMes;
        }
        s=s+"\nTotal de Infectados: "+total+"\n\nFim da Simulação!";
        JOptionPane.showMessageDialog(null, s);
        if(!configura.getNomeDoArquivo().trim().isEmpty()) {
            Arquivos arq = new Arquivos();
            arq.gera(configura, infect);
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButtonExecutar = new javax.swing.JButton();
        jTabbedPaneSimula = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanelHumano = new javax.swing.JPanel();
        jPanelVetor = new javax.swing.JPanel();
        jPanelHumanoVetor = new javax.swing.JPanel();
        jButtonPassoaPasso = new javax.swing.JButton();
        jButtonParar = new javax.swing.JButton();
        jButtonFinalizar = new javax.swing.JButton();
        jSliderVelocidade = new javax.swing.JSlider();
        jLabelVelocidade = new javax.swing.JLabel();
        jLabelDiasDeSimulacao = new javax.swing.JLabel();
        jTextFieldDiasDeSimulacao = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Simulação de Dengue");

        jButtonExecutar.setText("Executar");
        jButtonExecutar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonExecutarActionPerformed(evt);
            }
        });

        jScrollPane1.setAutoscrolls(true);

        jPanelHumano.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        javax.swing.GroupLayout jPanelHumanoLayout = new javax.swing.GroupLayout(jPanelHumano);
        jPanelHumano.setLayout(jPanelHumanoLayout);
        jPanelHumanoLayout.setHorizontalGroup(
            jPanelHumanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 818, Short.MAX_VALUE)
        );
        jPanelHumanoLayout.setVerticalGroup(
            jPanelHumanoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 639, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanelHumano);

        jTabbedPaneSimula.addTab("Humano", jScrollPane1);

        javax.swing.GroupLayout jPanelVetorLayout = new javax.swing.GroupLayout(jPanelVetor);
        jPanelVetor.setLayout(jPanelVetorLayout);
        jPanelVetorLayout.setHorizontalGroup(
            jPanelVetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );
        jPanelVetorLayout.setVerticalGroup(
            jPanelVetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jTabbedPaneSimula.addTab("Vetor", jPanelVetor);

        javax.swing.GroupLayout jPanelHumanoVetorLayout = new javax.swing.GroupLayout(jPanelHumanoVetor);
        jPanelHumanoVetor.setLayout(jPanelHumanoVetorLayout);
        jPanelHumanoVetorLayout.setHorizontalGroup(
            jPanelHumanoVetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 807, Short.MAX_VALUE)
        );
        jPanelHumanoVetorLayout.setVerticalGroup(
            jPanelHumanoVetorLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 369, Short.MAX_VALUE)
        );

        jTabbedPaneSimula.addTab("Humano-Vetor", jPanelHumanoVetor);

        jButtonPassoaPasso.setText("Passo a Passo");
        jButtonPassoaPasso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPassoaPassoActionPerformed(evt);
            }
        });

        jButtonParar.setText("Parar");
        jButtonParar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPararActionPerformed(evt);
            }
        });

        jButtonFinalizar.setText("Finalizar");
        jButtonFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonFinalizarActionPerformed(evt);
            }
        });

        jSliderVelocidade.setMajorTickSpacing(5);
        jSliderVelocidade.setMaximum(20);
        jSliderVelocidade.setMinorTickSpacing(1);
        jSliderVelocidade.setPaintLabels(true);
        jSliderVelocidade.setPaintTicks(true);

        jLabelVelocidade.setText("Velocidade");

        jLabelDiasDeSimulacao.setText("Dias de Simulação");

        jTextFieldDiasDeSimulacao.setEnabled(false);
        jTextFieldDiasDeSimulacao.setFocusable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPaneSimula, javax.swing.GroupLayout.DEFAULT_SIZE, 812, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonExecutar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonPassoaPasso)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonParar)
                        .addGap(5, 5, 5)
                        .addComponent(jButtonFinalizar)
                        .addGap(10, 10, 10)
                        .addComponent(jLabelVelocidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jSliderVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelDiasDeSimulacao)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldDiasDeSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jTabbedPaneSimula, javax.swing.GroupLayout.DEFAULT_SIZE, 397, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 25, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButtonExecutar)
                                .addComponent(jButtonPassoaPasso)
                                .addComponent(jButtonParar)
                                .addComponent(jButtonFinalizar)
                                .addComponent(jLabelVelocidade))
                            .addGap(34, 34, 34))
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jSliderVelocidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelDiasDeSimulacao)
                            .addComponent(jTextFieldDiasDeSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonExecutarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonExecutarActionPerformed
        // TODO add your handling code here:
        //stop();
        if(runner == null)
        {
            runner=new Thread(this);
            runner.start();
        }
    }//GEN-LAST:event_jButtonExecutarActionPerformed

    private void jButtonPassoaPassoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPassoaPassoActionPerformed
        // TODO add your handling code here:
        executivo();
        this.repaint();
    }//GEN-LAST:event_jButtonPassoaPassoActionPerformed

    private void jButtonPararActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPararActionPerformed
        // TODO add your handling code here:
        stop();
    }//GEN-LAST:event_jButtonPararActionPerformed

    private void jButtonFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonFinalizarActionPerformed
        // TODO add your handling code here:
        stop();
        finaliza();
    }//GEN-LAST:event_jButtonFinalizarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonExecutar;
    private javax.swing.JButton jButtonFinalizar;
    private javax.swing.JButton jButtonParar;
    private javax.swing.JButton jButtonPassoaPasso;
    private javax.swing.JLabel jLabelDiasDeSimulacao;
    private javax.swing.JLabel jLabelVelocidade;
    private javax.swing.JPanel jPanelHumano;
    private javax.swing.JPanel jPanelHumanoVetor;
    private javax.swing.JPanel jPanelVetor;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSlider jSliderVelocidade;
    private javax.swing.JTabbedPane jTabbedPaneSimula;
    private javax.swing.JTextField jTextFieldDiasDeSimulacao;
    // End of variables declaration//GEN-END:variables

    public void run() {
        // throw new UnsupportedOperationException("Not supported yet.");
        thisTh = Thread.currentThread();
        while(thisTh == runner && dia<=configura.getMesesASimular()*30) {
            try {
                executivo();
                painelHumano.paintImmediately(1,1,painelHumano.getWidth(),painelHumano.getHeight());
                painelVetor.paintImmediately(1,1,painelVetor.getWidth(),painelVetor.getHeight());
                painelHumanoVetor.paintImmediately(1,1,painelHumanoVetor.getWidth(),painelHumanoVetor.getHeight());
                Thread.sleep((21-jSliderVelocidade.getValue())*5);
            }
            catch(Exception e) {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }
    private void stop() {
        if(runner!=null) {
            runner = null;
        }
    }
}