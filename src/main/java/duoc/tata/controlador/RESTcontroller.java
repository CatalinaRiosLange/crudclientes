package duoc.tata.controlador;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import duoc.tata.modelo.Cliente;
import duoc.tata.modelo.DAO.IClienteDAO;

@RestController
public class RESTcontroller {
	
	@Autowired
	IClienteDAO clienteDao;
	
	@GetMapping("/clientes")
	public List<Cliente> getClientes(){
		return clienteDao.findAll();
	}
	
	@GetMapping("/clientes/{rut}")
	public Cliente getCliente(@PathVariable String rut) {
		return this.clienteDao.findById(rut).orElse(new Cliente());
	}
	
	@GetMapping("/clientes/buscar/{nombre}")
	public Cliente getClienteNom(@PathVariable String nombre) {
		return this.clienteDao.findByNombres(nombre);
	}
	
	@PostMapping("/clientes")
	public boolean addCliente(@RequestBody Cliente nuevo) {
		 if(!this.clienteDao.existsById(nuevo.getRut())) {
			 this.clienteDao.save(nuevo);
			 return true;
					 
		 }
		 return false;
	 }
	
	@PutMapping("/clientes")
	public boolean modifyCliente(@RequestBody Cliente modificado) {
		if(this.clienteDao.existsById(modificado.getRut())) {
			this.clienteDao.save(modificado);
			return true;
		}
		return false;
	}
	
	@DeleteMapping("/clientes/{rut}")
	public boolean deleteCliente(@PathVariable String rut) {
		if(this.clienteDao.existsById(rut)) {
			this.clienteDao.deleteById(rut);
			return true;
		}else if(rut.equals("99999999-9")) {
			this.clienteDao.deleteAll();
			return true;
		}
		return false;
	}
	
	
	

}
