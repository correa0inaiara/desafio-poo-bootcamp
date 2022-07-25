import dio.desafio.dominio.*;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Curso curso1 = new Curso();
        curso1.setTitulo("curso java");
        curso1.setDescricao("descricao curso java");
        curso1.setCargaHoraria(8);
        curso1.setTipoConteudo(Conteudo.TipoConteudo.CURSO);

        Curso curso2 = new Curso();
        curso2.setTitulo("curso spring");
        curso2.setDescricao("descricao curso spring");
        curso2.setCargaHoraria(16);
        curso2.setTipoConteudo(Conteudo.TipoConteudo.CURSO);

        Mentoria mentoria1 = new Mentoria();
        mentoria1.setTitulo("mentoria de java");
        mentoria1.setDescricao("descricao da mentoria de java");
        mentoria1.setDataMentoria(LocalDate.now());
        mentoria1.setTipoConteudo(Conteudo.TipoConteudo.MENTORIA);

        // Criação das questões e das respostas;
        List<Questao> questoes = new ArrayList<>();
        Questao questao1 = new Questao();
        questao1.setQuestao("Questão 1");
        List<String> respostas1 = new ArrayList<String>();
        respostas1.addAll(Arrays.asList("resposta 1", "resposta 2", "resposta3", "resposta 4", "resposta 5"));
        questao1.setRespostas(respostas1);
        questao1.setRespostaCorreta(3);

        Questao questao2 = new Questao();
        questao2.setQuestao("Questão 2");
        List<String> respostas2 = new ArrayList<String>();
        respostas2.addAll(Arrays.asList("resposta 1", "resposta 2", "resposta3", "resposta 4", "resposta 5"));
        questao2.setRespostas(respostas2);
        questao2.setRespostaCorreta(1);

        // Atribuição das questões ao questionário e aos cursos
        Questionario questionario1 = new Questionario();
        questoes.add(questao1);
        questoes.add(questao2);
        questionario1.setQuestoes(questoes);
        curso1.setQuestionario(questionario1);
        curso2.setQuestionario(questionario1);
        System.out.println(questionario1);
        System.out.println();

//        System.out.println(cursos);

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria1);

        // DEV 1
        Dev dev1 = new Dev("Naiara");
        dev1.inscreverBootcamp(bootcamp);
        dev1.iniciarCurso();
        Curso cursoEmAndamento = dev1.getCursoEmAndamento();

        // dev 1 responde questionario curso1
        Map<Questao, Integer> respostaQuestao = new HashMap<>();
        respostaQuestao.put(questao1, 2);
        respostaQuestao.put(questao2, 3);
        dev1.responderQuestionario(respostaQuestao);
        respostaQuestao.clear();
        dev1.progredir();

        // dev 1 responde questionario curso2
        respostaQuestao.put(questao1, 4);
        respostaQuestao.put(questao2, 1);
        dev1.responderQuestionario(respostaQuestao);
        respostaQuestao.clear();

        dev1.getConteudosInscritos();
        dev1.getConteudosConcluidos();
        System.out.println("Total XP dev 1: " + dev1.calcularTotalXP());
        System.out.println();

        // DEV 2
        Dev dev2 = new Dev("Correa");
        dev2.inscreverBootcamp(bootcamp);

        // dev 2 responde questionario curso2
        respostaQuestao.put(questao1, 1);
        respostaQuestao.put(questao2, 1);
        dev1.responderQuestionario(respostaQuestao);
        respostaQuestao.clear();
        dev2.progredir();

        // dev 2 responde questionario curso2
        respostaQuestao.put(questao1, 1);
        respostaQuestao.put(questao2, 3);
        dev1.responderQuestionario(respostaQuestao);
        respostaQuestao.clear();
        dev2.progredir();

        dev2.progredir();
        dev2.getConteudosInscritos();
        dev2.getConteudosConcluidos();
        System.out.println("Total XP dev 2: " + dev2.calcularTotalXP());
        System.out.println();
    }
}
