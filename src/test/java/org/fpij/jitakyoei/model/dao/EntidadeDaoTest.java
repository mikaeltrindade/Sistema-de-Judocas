package org.fpij.jitakyoei.model.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


import java.util.List;

import org.junit.BeforeClass;
import org.junit.Test;

import org.fpij.jitakyoei.model.beans.Endereco;
import org.fpij.jitakyoei.model.beans.Entidade;
import org.fpij.jitakyoei.model.dao.DAO;
import org.fpij.jitakyoei.model.dao.DAOImpl;
import org.fpij.jitakyoei.util.DatabaseManager;

public class EntidadeDaoTest {

    private static DAO<Entidade> entidadeDao;
    private static Endereco endereco;
    private static Entidade entidade;

    @BeforeClass
    public static void setUp() {
        // Configurar o ambiente de teste
        DatabaseManager.setEnviroment(DatabaseManager.TEST);

        // Criar endereço
        endereco = new Endereco();
        endereco.setBairro("Dirceu");
        endereco.setCep("64078-213");
        endereco.setCidade("Teresina");
        endereco.setEstado("PI");
        endereco.setRua("Rua Des. Berilo Mota");

        // Criar entidade
        entidade = new Entidade();
        entidade.setNome("Academia 1");
        entidade.setTelefone1("(88) 2802-1826");
        entidade.setTelefone2("(88) 98516-2167");
        entidade.setCnpj("60.580.350/0001-04");
        entidade.setEndereco(endereco);

        entidadeDao = new DAOImpl<Entidade>(Entidade.class);
    }

    public static void clearDatabase() {
        List<Entidade> all = entidadeDao.list();
        for (Entidade each : all) {
            entidadeDao.delete(each);
        }
        assertEquals(0, entidadeDao.list().size());
    }

@Test
public void testAddEntidade() {
    clearDatabase(); // Limpa o banco de dados antes de começar

    // Verifica que a lista de entidades está vazia
    assertEquals(0, entidadeDao.list().size());

    // Adiciona a entidade
    entidadeDao.save(entidade);

    // Verifica que a entidade foi salva corretamente
    assertEquals(1, entidadeDao.list().size());
    assertEquals("Academia 1", entidadeDao.get(entidade).getNome());
    assertEquals("(88) 2802-1826", entidadeDao.get(entidade).getTelefone1());
    assertEquals("(88) 98516-2167", entidadeDao.get(entidade).getTelefone2());
    assertEquals("60.580.350/0001-04", entidadeDao.get(entidade).getCnpj());
    assertEquals("Dirceu", entidadeDao.get(entidade).getEndereco().getBairro());
    assertEquals("64078-213", entidadeDao.get(entidade).getEndereco().getCep());
    assertEquals("PI", entidadeDao.get(entidade).getEndereco().getEstado());
    assertEquals("Rua Des. Berilo Mota", entidadeDao.get(entidade).getEndereco().getRua());
}

@Test
public void testSearchEntidadeByName() {
    clearDatabase();

    // Adiciona a entidade antes de buscar
    entidadeDao.save(entidade);

    // Criar critério de busca
    Entidade searchCriteria = new Entidade();
    searchCriteria.setNome("Academia 1");

    // Realiza a busca
    List<Entidade> result = entidadeDao.search(searchCriteria);

    // Verifica se a lista de resultados não está vazia
    assertNotNull("A busca não deve retornar null", result);
    assertFalse("A busca não deve retornar lista vazia", result.isEmpty());

    // Verifica se a entidade retornada é a esperada
    assertEquals("Academia 1", result.get(0).getNome());
}

@Test
public void testUpdateEntidade() {
    clearDatabase();

    // Salva a entidade
    entidadeDao.save(entidade);

    // Atualiza a entidade
    Entidade savedEntidade = entidadeDao.get(entidade);
    savedEntidade.setNome("Academia Atualizada");
    entidadeDao.save(savedEntidade);

    // Verifica se a atualização foi bem-sucedida
    Entidade updatedEntidade = entidadeDao.get(savedEntidade);
    assertEquals("Academia Atualizada", updatedEntidade.getNome());
}

@Test
public void testSearchEntidadeAfterSave() {
    // Limpar o banco de dados antes de iniciar
    clearDatabase();

    // Criar e salvar uma nova entidade
    Entidade novaEntidade = new Entidade();
    novaEntidade.setNome("Academia Nova");
    novaEntidade.setEndereco(endereco);
    entidadeDao.save(novaEntidade);

    // Buscar a entidade pelo nome
    Entidade searchCriteria = new Entidade();
    searchCriteria.setNome("Academia Nova");

    List<Entidade> result = entidadeDao.search(searchCriteria);

    // Verificar se o resultado da busca é correto
    assertNotNull("A busca não deve retornar null", result);
    assertEquals("A quantidade de resultados não está correta", 1, result.size());
    assertEquals("O nome da entidade encontrada não corresponde ao esperado", "Academia Nova", result.get(0).getNome());
}




@Test
public void testAddMultipleEntidades() {
    clearDatabase(); // Limpa o banco antes de começar

    // Cria novas entidades
    Entidade entidade1 = new Entidade();
    entidade1.setNome("Academia Nova");
    entidade1.setEndereco(endereco);

    Entidade entidade2 = new Entidade();
    entidade2.setNome("Academia Secundária");
    entidade2.setEndereco(endereco);

    // Adiciona as entidades
    entidadeDao.save(entidade1);
    entidadeDao.save(entidade2);

    // Verifica se as entidades foram salvas
    List<Entidade> entidades = entidadeDao.list();
    assertEquals(2, entidades.size());
    assertTrue(entidades.contains(entidade1));
    assertTrue(entidades.contains(entidade2));
}

}
