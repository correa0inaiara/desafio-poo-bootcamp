package dio.desafio.dominio;

import java.time.LocalDate;

public class Mentoria extends Conteudo {

    private LocalDate dataMentoria;

    public Mentoria() {
    }

    public LocalDate getDataMentoria() {
        return dataMentoria;
    }

    public void setDataMentoria(LocalDate dataMentoria) {
        this.dataMentoria = dataMentoria;
    }

    @Override
    public double calcularXP() {
        return XP_PADRAO + 20d;
    }

    @Override
    public String toString() {
        return "Mentoria: " + this.getTitulo() + "\n" +
                "Tipo: " + this.getTipoConteudo() + "\n" +
                "Data Mentoria: " + this.getDataMentoria() + "\n";
    }
}
