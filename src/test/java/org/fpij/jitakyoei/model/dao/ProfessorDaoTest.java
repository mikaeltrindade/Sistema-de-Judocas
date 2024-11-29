package org.fpij.jitakyoei.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import org.fpij.jitakyoei.model.beans.Endereco;
import org.fpij.jitakyoei.model.beans.Entidade;
import org.fpij.jitakyoei.model.beans.Filiado;
import org.fpij.jitakyoei.model.beans.Professor;
import org.fpij.jitakyoei.model.dao.DAO;
import org.fpij.jitakyoei.model.dao.DAOImpl;
import org.fpij.jitakyoei.util.DatabaseManager;

public class ProfessorDaoTest {

    private static DAO<Professor> professorDao;
    private static Professor professor;
    private static Filiado filiado;
    private static List<Entidade> entidades;
    private static Endereco endereco;

    @BeforeClass
    public static void setUp() {
        // Configurar o ambiente de teste
        DatabaseManager.setEnviroment(DatabaseManager.TEST);

        // Criar endereço
        endereco = new Endereco();
        endereco.setBairro("Centro");
        endereco.setCep("12345-678");
        endereco.setCidade("São Paulo");
        endereco.setEstado("SP");
        endereco.setRua("Rua Principal");

        // Criar filiado
        filiado = new Filiado();
        filiado.setNome("João Silva");
        filiado.setCpf("123.456.789-10");
        filiado.setDataNascimento(new Date());
        filiado.setDataCadastro(new Date());
        filiado.setEndereco(endereco);

        // Criar entidades associadas
        entidades = new ArrayList<>();
        Entidade entidade = new Entidade();
        entidade.setNome("Academia Central");
        entidade.setEndereco(endereco);
        entidades.add(entidade);

        // Criar professor
        professor = new Professor();
        professor.setFiliado(filiado);
        professor.setEntidades(entidades);

        // Inicializar DAO
        professorDao = new DAOImpl<>(Professor.class);
    }

    // Limpar banco de dados
    public static void clearDatabase() {
        List<Professor> all = professorDao.list();
        for (Professor each : all) {
            professorDao.delete(each);
        }
        assertEquals(0, professorDao.list().size());
    }

    @Test
    public void testCreateProfessorWithMultipleEntidades() {
        // Criar novas entidades
        Entidade entidade1 = new Entidade();
        entidade1.setNome("Academia Nova");
        entidade1.setEndereco(endereco);

        Entidade entidade2 = new Entidade();
        entidade2.setNome("Academia Secundária");
        entidade2.setEndereco(endereco);

        // Associar as entidades ao professor
        professor.getEntidades().clear();
        professor.getEntidades().add(entidade1);
        professor.getEntidades().add(entidade2);

        // Salvar o professor
        professorDao.save(professor);

        // Recuperar o professor e verificar associações
        Professor savedProfessor = professorDao.get(professor);
        assertNotNull("O professor não foi salvo corretamente", savedProfessor);
        assertEquals("Número de entidades associadas ao professor está incorreto", 2, savedProfessor.getEntidades().size());
    }

    @Test
    public void testUpdateProfessorName() {
        professorDao.save(professor);
        professor.getFiliado().setNome("João da Silva");
        professorDao.save(professor);

        Professor updatedProfessor = professorDao.get(professor);
        assertEquals("João da Silva", updatedProfessor.getFiliado().getNome());
    }

@Test
public void testRemoveEntidadeFromProfessor() {
    // Criar novas entidades
    Entidade entidade1 = new Entidade();
    entidade1.setNome("Academia Nova");
    entidade1.setEndereco(endereco);

    Entidade entidade2 = new Entidade();
    entidade2.setNome("Academia Secundária");
    entidade2.setEndereco(endereco);

    // Associar as entidades ao professor
    professor.getEntidades().clear();
    professor.getEntidades().add(entidade1);
    professor.getEntidades().add(entidade2);

    // Salvar o professor com as entidades
    professorDao.save(professor);

    // Recuperar o professor salvo
    Professor savedProfessor = professorDao.get(professor);
    assertNotNull("O professor não foi salvo corretamente", savedProfessor);

    // Verificar a quantidade de entidades associadas
    assertEquals("Número de entidades associadas ao professor está incorreto", 2, savedProfessor.getEntidades().size());

    // Remover uma entidade
    savedProfessor.getEntidades().remove(entidade1);

    // Salvar novamente o professor com as entidades atualizadas
    professorDao.save(savedProfessor);

    // Recuperar o professor novamente
    Professor updatedProfessor = professorDao.get(savedProfessor);

    // Verificar se a entidade foi removida corretamente
    assertEquals("Número de entidades associadas ao professor após remoção está incorreto", 1, updatedProfessor.getEntidades().size());

    // Verificar se a entidade1 foi removida da lista
    boolean entidade1Exists = updatedProfessor.getEntidades().contains(entidade1);
    assertEquals("A entidade removida ainda está na lista", false, entidade1Exists); // Verificando se a entidade1 foi removida

    // Verificar se a entidade2 ainda está na lista
    boolean entidade2Exists = updatedProfessor.getEntidades().contains(entidade2);
    assertEquals("A entidade restante não está na lista", true, entidade2Exists); // Verificando se a entidade2 está na lista
}

@Test
public void testAssociateProfessorWithFiliado() {
    // Criar um novo Filiado
    Filiado novoFiliado = new Filiado();
    novoFiliado.setNome("Carlos Almeida");
    novoFiliado.setCpf("987.654.321-00");
    novoFiliado.setDataNascimento(new Date());
    novoFiliado.setDataCadastro(new Date());
    novoFiliado.setEndereco(endereco);  // Associar o mesmo endereço

    // Criar um novo Professor e associar o Filiado
    Professor novoProfessor = new Professor();
    novoProfessor.setFiliado(novoFiliado);
    novoProfessor.setEntidades(entidades);  // Associe as entidades, se necessário

    // Salvar o professor com o filiado
    professorDao.save(novoProfessor);

    // Recuperar o professor e verificar se o filiado foi associado corretamente
    Professor professorSalvo = professorDao.get(novoProfessor);
    assertNotNull("O professor não foi salvo corretamente", professorSalvo);
    assertNotNull("O filiado não foi associado corretamente", professorSalvo.getFiliado());
    assertEquals("O nome do filiado não coincide", "Carlos Almeida", professorSalvo.getFiliado().getNome());
    assertEquals("O CPF do filiado não coincide", "987.654.321-00", professorSalvo.getFiliado().getCpf());
    
    // Atualizar o nome do filiado
    professorSalvo.getFiliado().setNome("Carlos Alberto Almeida");
    professorDao.save(professorSalvo);

    // Recuperar o professor novamente e verificar a atualização
    Professor professorAtualizado = professorDao.get(professorSalvo);
    assertEquals("O nome do filiado não foi atualizado corretamente", "Carlos Alberto Almeida", professorAtualizado.getFiliado().getNome());
}




    @Test
    public void testSearchProfessorByName() {
        clearDatabase(); // Limpar o banco antes de rodar o teste

        professorDao.save(professor);

        Filiado filiadoBusca = new Filiado();
        filiadoBusca.setNome("João Silva");

        Professor searchCriteria = new Professor();
        searchCriteria.setFiliado(filiadoBusca);

        List<Professor> result = professorDao.search(searchCriteria);
        assertNotNull("A busca não deve retornar null", result);
        assertEquals("A quantidade de resultados não está correta", 1, result.size());
        assertEquals("João Silva", result.get(0).getFiliado().getNome());
    }
}
