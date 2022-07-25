package dio.desafio.dominio;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Questionario {

    public final int DURACAO_EM_MINUTOS = 12;
    private List<Questao> questoes;

    public double verificaQuestionario(Map<Questao, Integer> questionarioRespondido) {
        System.out.println(questionarioRespondido);
        double pontuacao = 0;
//        for (Map<Questao, Integer> map : questionarioRespondido) {
            for (Map.Entry<Questao, Integer> entry : questionarioRespondido.entrySet()) {
                Boolean acertou = entry.getKey().verificaQuestaoCerta(entry.getValue());
                if (acertou) {
                    pontuacao += 10d;
                }
//            }
        }
        return pontuacao;
    }

//    public void adicionaQuestao(String questao, ArrayList )

    public List<Questao> getQuestoes() {
        return questoes;
    }

    public void setQuestoes(List<Questao> questoes) {
        this.questoes = questoes;
    }

    @Override
    public String toString() {
        return "Questionario{" +
                "DURACAO_EM_MINUTOS=" + DURACAO_EM_MINUTOS +
                ", questoes=" + questoes +
                '}';
    }
}
