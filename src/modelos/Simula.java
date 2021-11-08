// Taxas de Renascimento
// Taxas de Renascimento Infectado

package modelos;

public class Simula {
    public int simula(Grade atual, Agentes[][] gradeDia, Configuracao configura, int dia,
                           int populacaoHumanos, int populacaoVetores,
                           int humInfectados, int vetInfectados, double varia) {
        int i, j, infectados=0;
        Grade proximaGeracao = new Grade(configura.getTamanhoDaGrade());
        float probGlobalHumano, probGlobalVetor, probLocalHumano=0, probLocalVetor;
        float probTotalHumano=0, probTotalVetor=0;
        int vizinhos=0;
        //float peso1 = 0.995f, peso2 = 0.005f;
        float peso1 = configura.getAjusteLocal(), peso2 = configura.getAjusteGlobal();
        // Original
        probGlobalHumano = (float)humInfectados/(float)populacaoHumanos;
        probGlobalVetor = (float)vetInfectados/(float)populacaoVetores;
        // Invertido - a probabilidade está relacionada ao elemento infectante
        //probGlobalHumano = (float)vetInfectados/(float)populacaoVetores;
        //probGlobalVetor = (float)humInfectados/(float)populacaoHumanos;
        proximaGeracao.zeraGrade(configura.getTamanhoDaGrade());
        for(i=0; i<atual.getTamanho();++i) {
            for(j=0;j<atual.getTamanho();++j) {
                vizinhos = 0;
                if(gradeDia[i][j].getHumano()>0) {
                    gradeDia[i][j].setHumano(gradeDia[i][j].getHumano()-1);
                }
                if(gradeDia[i][j].getVetor()>0) {
                    gradeDia[i][j].setVetor(gradeDia[i][j].getVetor()-1);
                }
                if(atual.getGrade()[i][j].getHumano()==1) {
                    vizinhos=checkMoore(i,j,'h', configura, atual);
                    probLocalHumano =  1-(float)Math.pow(1-0.007,vizinhos);
                    probTotalHumano = peso1*probLocalHumano+peso2*probGlobalHumano;
                }
                if(atual.getGrade()[i][j].getHumano()==1 &&
                  (((float)(configura.getRandomico().nextInt(100) +1)/100) <= probTotalHumano)) {
                    proximaGeracao.getGrade()[i][j].setHumano(2);
                    gradeDia[i][j].setHumano((int) (configura.getRandomico().nextInt(12) + 3));
                }
                else if(atual.getGrade()[i][j].getHumano()==2 &&
                       (gradeDia[i][j].getHumano() == 0)) {
                    ++infectados;
                    ++humInfectados;
                    proximaGeracao.getGrade()[i][j].setHumano(3);
                    gradeDia[i][j].setHumano((int) (configura.getRandomico().nextInt(8) + 3));
                }
                else if(atual.getGrade()[i][j].getHumano()==3 &&
                       (gradeDia[i][j].getHumano() == 0)) {
                    proximaGeracao.getGrade()[i][j].setHumano(4);
                    --humInfectados;
                }
                else {
                    proximaGeracao.getGrade()[i][j].setHumano(atual.getGrade()[i][j].getHumano());
                }
                vizinhos = 0;
                if(atual.getGrade()[i][j].getVetor()==1) {
                    vizinhos=checkMoore(i,j,'v', configura, atual);
                    probLocalVetor =  1-(float)Math.pow(1-0.03,vizinhos);
                    probTotalVetor = (float) peso1*probLocalVetor+peso2*probGlobalVetor;
                }
                if(atual.getGrade()[i][j].getVetor()==1 &&
                  (((float)(configura.getRandomico().nextInt(100)+1)/100) <= probTotalVetor)) {
                    proximaGeracao.getGrade()[i][j].setVetor(2);
                    gradeDia[i][j].setVetor((int) (configura.getRandomico().nextInt(4) + 8));
                }
                else if(atual.getGrade()[i][j].getVetor()==2 &&
                       (gradeDia[i][j].getVetor() == 0)) {
                    proximaGeracao.getGrade()[i][j].setVetor(3);
                    ++vetInfectados;
                    //gradeDia[i][j].setVetor((int) (Math.random() * 20 + 60));
                }
               /* else if(atual.getGrade()[i][j].getVetor()==3 &&
                       (gradeDia[i][j].getVetor() == 0)) { // 9 no original
                    proximaGeracao.getGrade()[i][j].setVetor(1);
                    --vetInfectados;
                } */
                else if(atual.getGrade()[i][j].getVetor()!=0 && configura.getMortalidade()>0 &&
                        (((float)(configura.getRandomico().nextInt(100)+1)/100) <= (1.0/configura.getMortalidade())))  {
                    // Renascimento do mosquito
                    proximaGeracao.getGrade()[i][j].setVetor(0);
                    --populacaoVetores;
                }
                // Nascimento do mosquito levando em consideração a vizinhança
                else if(atual.getGrade()[i][j].getVetor()==0) {
                    int v = vetoresVizinhos(i, j, configura, atual);
//                    System.out.println(i+" - "+j+" - "+v);
//                    double cosseno = Math.cos(Math.toRadians((dia-1+330)%360));
                    double cosseno = Math.cos(Math.toRadians((dia-1)%360));
                    double probNasc = (0.025*((float)v/8.0)*(1+cosseno))/2;
                    //double probNasc = cosseno>=0?varia*((float)v/8.0)*(cosseno):0;
                    double rnd = (double) configura.getRandomico().nextDouble();
                    if(rnd<=probNasc) {
                        proximaGeracao.getGrade()[i][j].setVetor(1);
                        ++populacaoVetores;
//                        System.out.println(v+" - "+dia+ " - "+cosseno+" - "+probNasc+" - "+rnd);
                    }
                }
                else {
                    proximaGeracao.getGrade()[i][j].setVetor(atual.getGrade()[i][j].getVetor());
                }
            }
        }
        atualiza(atual, proximaGeracao, configura);
        return infectados;
    }
    private void atualiza(Grade atual, Grade proximaGeracao, Configuracao configura) {
        for(int i=0;i<configura.getTamanhoDaGrade();++i) {
            for(int j=0;j<configura.getTamanhoDaGrade();++j) {
                atual.getGrade()[i][j].setHumano(proximaGeracao.getGrade()[i][j].getHumano());
                atual.getGrade()[i][j].setVetor(proximaGeracao.getGrade()[i][j].getVetor());
            }
        }
    }
    public int checkMoore(int x,int y, char tipo, Configuracao configura, Grade atual)  {
       int vizinhos=0;
       int iAux=0,jAux=0;
       for(int i=x-configura.getVizinhanca();i<=x+configura.getVizinhanca();i++) {
           for(int j=y-configura.getVizinhanca();j<=y+configura.getVizinhanca();j++) {
              iAux=0;jAux=0;
              iAux=periodico(i, configura.getTamanhoDaGrade());
              jAux=periodico(j, configura.getTamanhoDaGrade());
              if((tipo=='h' && atual.getGrade()[iAux][jAux].getVetor()==3) ||
                 (tipo=='v' && atual.getGrade()[iAux][jAux].getHumano()==3)){
                 vizinhos++;
              }
           }
       }
       return vizinhos;
    }

    public int vetoresVizinhos(int x,int y, Configuracao configura, Grade atual)  {
       int vizinhos=0;
       int iAux=0,jAux=0;
       for(int i=x-1;i<=x+1;i++) {
           for(int j=y-1;j<=y+1;j++) {
              iAux=0;jAux=0;
              iAux=periodico(i, configura.getTamanhoDaGrade());
              jAux=periodico(j, configura.getTamanhoDaGrade());
              if(atual.getGrade()[iAux][jAux].getVetor()!=0) {
                 vizinhos++;
              }
           }
       }
       return vizinhos;
    }

    public int periodico(int i, int tam) {
       if(i<0)
          return tam+i;
       else if(i>=tam)
          return i - tam;
       else
          return i;
    }
    public void zeraGradeDia(Agentes [][] gradeDia, Configuracao configura) {
        for(int i=0; i<configura.getTamanhoDaGrade();++i) {
            for(int j=0;j<configura.getTamanhoDaGrade(); ++j) {
                gradeDia[i][j] = new Agentes();
                gradeDia[i][j].setHumano(0);
                gradeDia[i][j].setVetor(0);
            }
        }
    }
}