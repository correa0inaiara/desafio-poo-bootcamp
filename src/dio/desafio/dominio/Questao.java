package dio.desafio.dominio;

import java.util.ArrayList;
import java.util.List;

public class Questao {

    private String questao;
    private List<String> respostas;
    private int respostaCorreta;

    public Boolean verificaQuestaoCerta(int questaoRespondida) {
        if (questaoRespondida == this.getRespostaCorreta()) {
            return true;
        }
        return false;
    }

    public String getQuestao() {
        return questao;
    }

    public void setQuestao(String questao) {
        this.questao = questao;
    }

    public List<String> getRespostas() {
        return respostas;
    }

    public void setRespostas(List<String> respostas) {
        this.respostas = respostas;
    }

    public int getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(int respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }

    @Override
    public String toString() {
        return "Questao{" +
                "questao='" + questao + '\'' +
                ", respostas=" + respostas +
                ", respostaCorreta=" + respostaCorreta +
                '}';
    }
}
