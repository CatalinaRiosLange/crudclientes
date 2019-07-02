package duoc.tata;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import duoc.tata.modelo.Cliente;
import duoc.tata.modelo.DAO.IClienteDAO;

@RunWith(SpringRunner.class)
@DataJpaTest
public class EliminarTest {
	
	@Autowired
	TestEntityManager manager;
	
	@Autowired
	IClienteDAO dao;

	@Before
	public void setUp() throws Exception {
		Cliente cli = new Cliente("17254553-k", "Parixaurius", "Marin de Rios", "soyundinosaurio@dino.cl", "888888888");
		this.manager.persist(cli);
		cli = new Cliente("7044691-k", "Ximena Teresa", "Lange de la Fuente", "laxime@xme.cl", "888888888");
		this.manager.persist(cli);
	}

	@Test
	public void cuandoeliminaRetornaTrue() {
		int inicio = this.dao.findAll().size();
		this.dao.deleteById("17254553-k");
		int fin = this.dao.findAll().size();
		assertTrue("quedan "+fin+" despues de la eliminacion", inicio>fin);
	}

}
