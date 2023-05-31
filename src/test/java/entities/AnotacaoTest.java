package entities;

import exceptions.TituloTextoNaoExisteException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class AnotacaoTest {

    Anotacao anotacao;
    Anotacao teste;

    @BeforeEach
    void setUp() {
        teste = new Anotacao();
        anotacao = new Anotacao();
        anotacao.setTitulo("leo");
        anotacao.setTexto("leo");
    }

    @Test
    void getDataEHora() {
        //nao da de testar por conta dos segundos que sempre mudam
    }

    @Test
    void getTexto() {
        assertEquals("leo", anotacao.getTexto());
    }

    @Test
    void setTexto() {
        teste.setTexto("ola");
        assertEquals("ola", teste.getTexto());

    }

    @Test
    void getTitulo() {
        assertEquals("leo", anotacao.getTitulo());
    }

    @Test
    void setTitulo() {
        teste.setTitulo("leo");
        assertEquals("leo", teste.getTitulo());
    }

    @Test
    void isDeletar() {
        assertEquals(false, anotacao.isDeletar());
    }

    @Test
    void setDeletar() {
        teste.setDeletar(true);
        assertEquals(true, teste.isDeletar());
    }
}