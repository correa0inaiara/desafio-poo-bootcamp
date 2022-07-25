package dio.desafio.dominio;

public abstract class Conteudo {

    protected static final double XP_PADRAO = 10d;
    public enum TipoConteudo {CURSO, MENTORIA};

    private String titulo;
    private String descricao;
    private TipoConteudo tipoConteudo;

    public abstract double calcularXP();

    public TipoConteudo getTipoConteudo() {
        return tipoConteudo;
    }

    public void setTipoConteudo(TipoConteudo tipoConteudo) {
        this.tipoConteudo = tipoConteudo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

//    @Override
//    public String toString() {
//        return "Conteudo{" +
//                "titulo='" + titulo + '\'' +
//                ", descricao='" + descricao + '\'' +
//                '}';
//    }
}
