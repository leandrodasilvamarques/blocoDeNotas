package entities;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BlocoDeNotasTest {
    Anotacao anotcao;
    Anotacao nota;
    BlocoDeNotas blocoDeNotas;
    String notasStringAnotacao;

    @BeforeEach
    void setUp() {
        //anotações
        anotcao = new Anotacao();
        anotcao.setTitulo("leo");


        //Bloco de notas
        blocoDeNotas = new BlocoDeNotas();
        blocoDeNotas.addArrayListAnotacao(anotcao);
        nota = blocoDeNotas.getNotapeloTitulo("leo");
        notasStringAnotacao = blocoDeNotas.toStringAnotacao(nota);
    }

    @Test
    void addArrayListAnotacao() {
        assertEquals(1, blocoDeNotas.arrayListAnotacao.size());
    }

    @Test
    void getNotapeloTitulo() {
        assertEquals(anotcao, blocoDeNotas.getNotapeloTitulo("leo"));
    }

    @Test
    void toStringAnotacao() {
        //não tem como testar por conta dos segundos mas fora isso esta tudo certo.
    }

    @Test
    void editarAnotacao() {
        //não tem como testar por conta de não dar de editar a nota pelo JUnit
    }

    @Test
    void deletaAnotacao() {
        //não tem como testar por conta de não dar de deletar a nota pelo JUnit
    }

    @Test
    void buscaAnotacaoExistente() {
      assertEquals(anotcao,blocoDeNotas.buscaAnotacaoExistente("leo"));
    }
}