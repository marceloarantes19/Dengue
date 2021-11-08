/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * FrmPrincipal.java
 *
 * Created on 30/08/2010, 02:04:29
 */

package visoes;

import modelos.Configuracao;
import modelos.EstadoHumano;
import modelos.EstadoVetor;
import modelos.SimulaArquivo3d;
import modelos.SimulaDengue;

/**
 *
 * @author Marcelo
 */
class FrmPrincipal extends javax.swing.JFrame implements Runnable{

    /** Creates new form FrmPrincipal */
    Configuracao configura = new Configuracao();
    public FrmPrincipal() {
        initComponents();
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelTamanhoGrade = new javax.swing.JLabel();
        jLabelNumeroHabitantes = new javax.swing.JLabel();
        jLabelHabitantesExpostos = new javax.swing.JLabel();
        jLabelHabitantesInfectados = new javax.swing.JLabel();
        jLabelHabitantesRecuperados = new javax.swing.JLabel();
        jLabelVetoresSusceptiveis = new javax.swing.JLabel();
        jLabelVetoresExpostos = new javax.swing.JLabel();
        jLabelVetoresInfectados = new javax.swing.JLabel();
        jLabelMesesDeSimulacao = new javax.swing.JLabel();
        jLabelTamanhoDaVizinhanca = new javax.swing.JLabel();
        jLabelNomeDoArquivo = new javax.swing.JLabel();
        jTextFieldTamanhoGrade = new javax.swing.JTextField();
        jTextFieldNumeroHabitantes = new javax.swing.JTextField();
        jTextFieldHabitantesExpostos = new javax.swing.JTextField();
        jTextFieldHabitantesInfectados = new javax.swing.JTextField();
        jTextFieldHabitantesRecuperados = new javax.swing.JTextField();
        jTextFieldVetoresSusceptiveis = new javax.swing.JTextField();
        jTextFieldVetoresExpostos = new javax.swing.JTextField();
        jTextFieldVetoresInfectados = new javax.swing.JTextField();
        jTextFieldMesesDeSimulacao = new javax.swing.JTextField();
        jTextFieldTamanhoDaVizinhaca = new javax.swing.JTextField();
        jTextFieldNomeDoArquivo = new javax.swing.JTextField();
        jButtonSimulacaoVisual = new javax.swing.JButton();
        jLabelValorDeAjusteLocal = new javax.swing.JLabel();
        jLabelValorDeAjusteGlobal = new javax.swing.JLabel();
        jTextFieldAjusteLocal = new javax.swing.JTextField();
        jTextFieldAjusteGlobal = new javax.swing.JTextField();
        jLabelSemente = new javax.swing.JLabel();
        jTextFieldSemente = new javax.swing.JTextField();
        jButtonGeraArquivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Modelagem e Simulação de Dengue 2.0");

        jLabelTamanhoGrade.setText("Tamanho da Grade");

        jLabelNumeroHabitantes.setText("Número de Habitantes");

        jLabelHabitantesExpostos.setText("Habitantes Expostos");

        jLabelHabitantesInfectados.setText("Habitantes Infectados");

        jLabelHabitantesRecuperados.setText("Habitantes Recuperados");

        jLabelVetoresSusceptiveis.setText("Vetores Susceptiveis");

        jLabelVetoresExpostos.setText("Vetores Expostos");

        jLabelVetoresInfectados.setText("Vetores Infectados");

        jLabelMesesDeSimulacao.setText("Meses de Simulação");

        jLabelTamanhoDaVizinhanca.setText("Tamanho da Vizinhança");

        jLabelNomeDoArquivo.setText("Nome do Arquivo LOG");

        jTextFieldTamanhoGrade.setText("115");
        jTextFieldTamanhoGrade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTamanhoGradeActionPerformed(evt);
            }
        });

        jTextFieldNumeroHabitantes.setText("13000");
        jTextFieldNumeroHabitantes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNumeroHabitantesActionPerformed(evt);
            }
        });

        jTextFieldHabitantesExpostos.setText("0");
        jTextFieldHabitantesExpostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHabitantesExpostosActionPerformed(evt);
            }
        });

        jTextFieldHabitantesInfectados.setText("0");
        jTextFieldHabitantesInfectados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHabitantesInfectadosActionPerformed(evt);
            }
        });

        jTextFieldHabitantesRecuperados.setText("0");
        jTextFieldHabitantesRecuperados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldHabitantesRecuperadosActionPerformed(evt);
            }
        });

        jTextFieldVetoresSusceptiveis.setText("1040");
        jTextFieldVetoresSusceptiveis.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVetoresSusceptiveisActionPerformed(evt);
            }
        });

        jTextFieldVetoresExpostos.setText("0");
        jTextFieldVetoresExpostos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVetoresExpostosActionPerformed(evt);
            }
        });

        jTextFieldVetoresInfectados.setText("260");
        jTextFieldVetoresInfectados.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldVetoresInfectadosActionPerformed(evt);
            }
        });

        jTextFieldMesesDeSimulacao.setText("12");
        jTextFieldMesesDeSimulacao.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldMesesDeSimulacaoActionPerformed(evt);
            }
        });

        jTextFieldTamanhoDaVizinhaca.setText("1");
        jTextFieldTamanhoDaVizinhaca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldTamanhoDaVizinhacaActionPerformed(evt);
            }
        });

        jTextFieldNomeDoArquivo.setText("dengue1");
        jTextFieldNomeDoArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldNomeDoArquivoActionPerformed(evt);
            }
        });

        jButtonSimulacaoVisual.setText("Simulação Visual");
        jButtonSimulacaoVisual.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSimulacaoVisualActionPerformed(evt);
            }
        });

        jLabelValorDeAjusteLocal.setText("Valor de Ajuste Local");

        jLabelValorDeAjusteGlobal.setText("Valor de Ajuste Global");

        jTextFieldAjusteLocal.setText("0.9");

        jTextFieldAjusteGlobal.setText("0.1");

        jLabelSemente.setText("Semente");

        jTextFieldSemente.setText("321789");

        jButtonGeraArquivo.setText("Gera Arquivo");
        jButtonGeraArquivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGeraArquivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabelTamanhoGrade)
                    .addComponent(jLabelNumeroHabitantes)
                    .addComponent(jLabelVetoresExpostos)
                    .addComponent(jLabelHabitantesInfectados)
                    .addComponent(jLabelHabitantesRecuperados)
                    .addComponent(jLabelHabitantesExpostos)
                    .addComponent(jLabelVetoresSusceptiveis)
                    .addComponent(jLabelVetoresInfectados)
                    .addComponent(jLabelMesesDeSimulacao)
                    .addComponent(jLabelTamanhoDaVizinhanca)
                    .addComponent(jLabelNomeDoArquivo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonSimulacaoVisual, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonGeraArquivo)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldNomeDoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldTamanhoDaVizinhaca, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldMesesDeSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldVetoresInfectados, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldVetoresExpostos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldVetoresSusceptiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTextFieldHabitantesRecuperados, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jTextFieldHabitantesExpostos, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jLabelSemente))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jTextFieldTamanhoGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jTextFieldNumeroHabitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(47, 47, 47)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabelValorDeAjusteGlobal)
                                            .addComponent(jLabelValorDeAjusteLocal)))
                                    .addComponent(jTextFieldHabitantesInfectados, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextFieldSemente, javax.swing.GroupLayout.DEFAULT_SIZE, 54, Short.MAX_VALUE)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jTextFieldAjusteGlobal, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                                        .addComponent(jTextFieldAjusteLocal, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)))))
                        .addGap(22, 22, 22))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldTamanhoGrade, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelTamanhoGrade)
                    .addComponent(jLabelValorDeAjusteLocal)
                    .addComponent(jTextFieldAjusteLocal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextFieldNumeroHabitantes, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelNumeroHabitantes)
                    .addComponent(jLabelValorDeAjusteGlobal)
                    .addComponent(jTextFieldAjusteGlobal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHabitantesExpostos)
                    .addComponent(jTextFieldHabitantesExpostos, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelSemente)
                    .addComponent(jTextFieldSemente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelHabitantesInfectados)
                    .addComponent(jTextFieldHabitantesInfectados, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelHabitantesRecuperados)
                        .addGap(11, 11, 11)
                        .addComponent(jLabelVetoresSusceptiveis)
                        .addGap(11, 11, 11)
                        .addComponent(jLabelVetoresExpostos)
                        .addGap(11, 11, 11)
                        .addComponent(jLabelVetoresInfectados)
                        .addGap(11, 11, 11)
                        .addComponent(jLabelMesesDeSimulacao)
                        .addGap(11, 11, 11)
                        .addComponent(jLabelTamanhoDaVizinhanca)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelNomeDoArquivo)
                        .addGap(18, 18, 18))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jTextFieldHabitantesRecuperados, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jTextFieldVetoresSusceptiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jTextFieldVetoresExpostos, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jTextFieldVetoresInfectados, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jTextFieldMesesDeSimulacao, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(11, 11, 11)
                        .addComponent(jTextFieldTamanhoDaVizinhaca, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jTextFieldNomeDoArquivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonSimulacaoVisual)
                    .addComponent(jButtonGeraArquivo))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTextFieldTamanhoGradeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTamanhoGradeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTamanhoGradeActionPerformed

    private void jTextFieldNumeroHabitantesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNumeroHabitantesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNumeroHabitantesActionPerformed

    private void jTextFieldHabitantesExpostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHabitantesExpostosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHabitantesExpostosActionPerformed

    private void jTextFieldHabitantesInfectadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHabitantesInfectadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHabitantesInfectadosActionPerformed

    private void jTextFieldHabitantesRecuperadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldHabitantesRecuperadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldHabitantesRecuperadosActionPerformed

    private void jTextFieldVetoresSusceptiveisActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVetoresSusceptiveisActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVetoresSusceptiveisActionPerformed

    private void jTextFieldVetoresExpostosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVetoresExpostosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVetoresExpostosActionPerformed

    private void jTextFieldVetoresInfectadosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldVetoresInfectadosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldVetoresInfectadosActionPerformed

    private void jTextFieldMesesDeSimulacaoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldMesesDeSimulacaoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldMesesDeSimulacaoActionPerformed

    private void jTextFieldTamanhoDaVizinhacaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldTamanhoDaVizinhacaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldTamanhoDaVizinhacaActionPerformed

    private void jTextFieldNomeDoArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldNomeDoArquivoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldNomeDoArquivoActionPerformed

    private void iniciaDados() {
        int p, s, e, i, r;
        EstadoHumano eh = new EstadoHumano();
        EstadoVetor ev = new EstadoVetor();
        SimulaDengue simula;
        configura.setTamanhoDaGrade(Integer.parseInt(jTextFieldTamanhoGrade.getText()));
        p = Integer.parseInt(jTextFieldNumeroHabitantes.getText());
        e = Integer.parseInt(jTextFieldHabitantesExpostos.getText());
        i = Integer.parseInt(jTextFieldHabitantesInfectados.getText());
        r = Integer.parseInt(jTextFieldHabitantesRecuperados.getText());
        s = p - (e+i+r);
        eh.setSusceptivel(s);
        eh.setExposto(e);
        eh.setInfectado(i);
        eh.setRecuperado(r);
        s = Integer.parseInt(jTextFieldVetoresSusceptiveis.getText());
        e = Integer.parseInt(jTextFieldVetoresExpostos.getText());
        i = Integer.parseInt(jTextFieldVetoresInfectados.getText());
        ev.setSusceptivel(s);
        ev.setExposto(e);
        ev.setInfectado(i);
        configura.setPopulacao(p);
        configura.setEstadosPopulacao(eh);
        configura.setEstadosVetores(ev);
        configura.setMesesASimular(Integer.parseInt(jTextFieldMesesDeSimulacao.getText()));
        configura.setVizinhanca(Integer.parseInt(jTextFieldTamanhoDaVizinhaca.getText()));
        configura.setNomeDoArquivo(jTextFieldNomeDoArquivo.getText());
        configura.setAjusteLocal(Float.parseFloat(jTextFieldAjusteLocal.getText()));
        configura.setAjusteGlobal(Float.parseFloat(jTextFieldAjusteGlobal.getText()));
        configura.setMortalidade(45);
        configura.setSemente(Integer.parseInt(jTextFieldSemente.getText()));
        configura.setRandomico(configura.getSemente());
    }
    private void jButtonSimulacaoVisualActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSimulacaoVisualActionPerformed
        // TODO add your handling code here:
        iniciaDados();
        FrmSimulacao frmSimula = new FrmSimulacao(configura);
        frmSimula.show();
        //simula = new SimulaDengue(configura);
    }//GEN-LAST:event_jButtonSimulacaoVisualActionPerformed

    private void jButtonGeraArquivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGeraArquivoActionPerformed
        // TODO add your handling code here:
        SimulaArquivo3d sma;
        iniciaDados();
        sma = new SimulaArquivo3d(configura);
    }//GEN-LAST:event_jButtonGeraArquivoActionPerformed

    /**
    * @param args the command line arguments
    */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrmPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonGeraArquivo;
    private javax.swing.JButton jButtonSimulacaoVisual;
    private javax.swing.JLabel jLabelHabitantesExpostos;
    private javax.swing.JLabel jLabelHabitantesInfectados;
    private javax.swing.JLabel jLabelHabitantesRecuperados;
    private javax.swing.JLabel jLabelMesesDeSimulacao;
    private javax.swing.JLabel jLabelNomeDoArquivo;
    private javax.swing.JLabel jLabelNumeroHabitantes;
    private javax.swing.JLabel jLabelSemente;
    private javax.swing.JLabel jLabelTamanhoDaVizinhanca;
    private javax.swing.JLabel jLabelTamanhoGrade;
    private javax.swing.JLabel jLabelValorDeAjusteGlobal;
    private javax.swing.JLabel jLabelValorDeAjusteLocal;
    private javax.swing.JLabel jLabelVetoresExpostos;
    private javax.swing.JLabel jLabelVetoresInfectados;
    private javax.swing.JLabel jLabelVetoresSusceptiveis;
    private javax.swing.JTextField jTextFieldAjusteGlobal;
    private javax.swing.JTextField jTextFieldAjusteLocal;
    private javax.swing.JTextField jTextFieldHabitantesExpostos;
    private javax.swing.JTextField jTextFieldHabitantesInfectados;
    private javax.swing.JTextField jTextFieldHabitantesRecuperados;
    private javax.swing.JTextField jTextFieldMesesDeSimulacao;
    private javax.swing.JTextField jTextFieldNomeDoArquivo;
    private javax.swing.JTextField jTextFieldNumeroHabitantes;
    private javax.swing.JTextField jTextFieldSemente;
    private javax.swing.JTextField jTextFieldTamanhoDaVizinhaca;
    private javax.swing.JTextField jTextFieldTamanhoGrade;
    private javax.swing.JTextField jTextFieldVetoresExpostos;
    private javax.swing.JTextField jTextFieldVetoresInfectados;
    private javax.swing.JTextField jTextFieldVetoresSusceptiveis;
    // End of variables declaration//GEN-END:variables

    public void run() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}