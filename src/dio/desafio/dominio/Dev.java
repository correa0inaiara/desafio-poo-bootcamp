package dio.desafio.dominio;

import java.util.*;

public class Dev {

    private String nome;
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();
    private Curso cursoEmAndamento;
    private List<Map<String, int[]>> questionariosRespondidos = new LinkedList<>();

    public Dev(String nome) {
        this.nome = nome;
    }

    public void inscreverBootcamp(Bootcamp bootcamp) {
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        bootcamp.getDevsInscritos().add(this);
        this.cursoEmAndamento = null;
    }

    public void iniciarCurso() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent() && conteudo.get().getTipoConteudo() == Conteudo.TipoConteudo.CURSO) {
            this.setCursoEmAndamento((Curso) conteudo.get());
        }
    }

    public void progredir() {
        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
        if (conteudo.isPresent()) {

            if (conteudo.get().getTipoConteudo() == Conteudo.TipoConteudo.CURSO) {
                Curso curso = (Curso) conteudo.get();
                Boolean respondeu = curso.getQuestionatioRespondido();

                if (respondeu) {
                    this.conteudosConcluidos.add(conteudo.get());
                    this.conteudosInscritos.remove(conteudo.get());
                    this.iniciarCurso();
                } else {
                    System.err.println("Você precisa responder o questionário para avançar no bootcamp.");
                }
            } else {
                this.conteudosConcluidos.add(conteudo.get());
                this.conteudosInscritos.remove(conteudo.get());
            }

        } else {
            System.err.println("Você não está matriculado em nenhum conteúdo.");
        }
    }

    public void responderQuestionario(Map<Questao, Integer> questionario) {
        double pontuacaoQuestionario = cursoEmAndamento.getQuestionario().verificaQuestionario(questionario);
        cursoEmAndamento.setPontuacaoQuestionario(pontuacaoQuestionario);
        cursoEmAndamento.setQuestionatioRespondido(true);
//        this.setQuestionatioRespondido(true);
    }

//    public void responderQuestionario(Curso curso, int[] indicesRespostas) {
//        // {1,5}
//        Map<String, int[]> respostas = new HashMap<>();
//        respostas.put(curso.getTitulo(), indicesRespostas);
//        questionariosRespondidos.add(respostas);
//
//        curso.setQuestionatioRespondido(true);
//
////        Optional<Conteudo> conteudo = conteudosConcluidos.stream().filter(c -> c.getTitulo().equals(tituloCurso)).findFirst();
////        if (conteudo.isPresent()) {
////            Curso curso = (Curso) conteudo.get();
////            curso.setQuestionatioRespondido(true);
////        }
//
////        Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
////        if (conteudo.isPresent()) {
////            Conteudo.TipoConteudo tipoConteudo = conteudo.get().getTipoConteudo();
////            if (tipoConteudo == Conteudo.TipoConteudo.CURSO) {
////                Curso curso = (Curso) conteudo.get();
////                curso.
////            }
////        }
//    }

    public double calcularTotalXP() {
        return this.conteudosConcluidos.stream().mapToDouble(conteudo -> conteudo.calcularXP()).sum();
    }

    public Curso getCursoEmAndamento() {
        return cursoEmAndamento;
    }

    private void setCursoEmAndamento(Curso cursoEmAndamento) {
        this.cursoEmAndamento = cursoEmAndamento;
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public void getConteudosInscritos() {
        System.out.println("\n=== Conteúdos Inscritos ===");
        System.out.println("Dev: " + this.getNome());
        this.conteudosInscritos.stream().forEach(System.out::println);
    }

    private void setConteudosInscritos(Set<Conteudo> conteudosInscritos) {
        this.conteudosInscritos = conteudosInscritos;
    }

    public void getConteudosConcluidos() {
        System.out.println("\n=== Conteúdos Concluídos ===");
        System.out.println("Dev: " + this.getNome());
        this.conteudosConcluidos.stream().forEach(System.out::println);
    }

    private void setConteudosConcluidos(Set<Conteudo> conteudosConcluidos) {
        this.conteudosConcluidos = conteudosConcluidos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Dev dev = (Dev) o;
        return Objects.equals(nome, dev.nome) && Objects.equals(conteudosInscritos, dev.conteudosInscritos) && Objects.equals(conteudosConcluidos, dev.conteudosConcluidos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, conteudosInscritos, conteudosConcluidos);
    }
}
