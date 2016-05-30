/**
 * 
 */
package br.com.webstore.testes;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.Test;

/**
 * @author webstore
 *
 */
public class TesteConexaoBanco {
	
	private static final String NAME_DB = "webstoreDB";
	
	@Test
	public void testaAConexaoComOBancoMySql(){
		EntityManagerFactory factory = Persistence.createEntityManagerFactory(NAME_DB);
		EntityManager em = factory.createEntityManager();
		assertTrue(em.isOpen());
	}
}
