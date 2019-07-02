package duoc.tata.modelo.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import duoc.tata.modelo.Cliente;

@Repository
public interface IClienteDAO extends JpaRepository<Cliente, String>{
	public Cliente findByNombres(String nombres);
}
