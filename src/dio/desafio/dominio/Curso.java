package dio.desafio.dominio;

import java.util.Map;

public class Curso extends Conteudo {

    private int cargaHoraria;
    private Questionario questionario;
    private Boolean questionatioRespondido = false;
    private double pontuacaoQuestionario = 0.0d;

    public Curso() {
    }

//    public void responderQuestionario(Map<Questao, Integer> questionario) {
//        this.pontuacaoQuestionario = this.questionario.verificaQuestionario(questionario);
//        this.setQuestionatioRespondido(true);
//    }


    public double getPontuacaoQuestionario() {
        return pontuacaoQuestionario;
    }

    public void setPontuacaoQuestionario(double pontuacaoQuestionario) {
        this.pontuacaoQuestionario = pontuacaoQuestionario;
    }

    public Boolean getQuestionatioRespondido() {
        return questionatioRespondido;
    }

    public void setQuestionatioRespondido(Boolean questionatioRespondido) {
        this.questionatioRespondido = questionatioRespondido;
    }

    public Questionario getQuestionario() {
        return questionario;
    }

    public void setQuestionario(Questionario questionario) {
        this.questionario = questionario;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXP() {
        return (XP_PADRAO * cargaHoraria) + pontuacaoQuestionario;
    }

    @Override
    public String toString() {
        return "Curso: " + this.getTitulo() + "\n" +
                    "Tipo: " + this.getTipoConteudo() + "\n" +
                    "Carga Horária: " + this.cargaHoraria + "\n" +
                    "Questionário Respondido: " + this.getQuestionatioRespondido() + "\n" +
                    "Pontuação Questionário: " + this.pontuacaoQuestionario + "\n";
    }
}
