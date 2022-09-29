package br.com.bgrsys.clientes.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.bgrsys.clientes.data.vo.v1.ClienteVO;
import br.com.bgrsys.clientes.model.Cliente;
import br.com.bgrsys.clientes.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;
	
	@GetMapping(
			produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClienteVO> findAll()throws Exception {
		
		return service.findAll();
	}
	
	@GetMapping(value = "/{id}",
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO findById(@PathVariable(value = "id") Long id)throws Exception {
		
		return service.findById(id);
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO create(@RequestBody ClienteVO cliente)throws Exception {
		
		return service.create(cliente);
	}
	
	@PutMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ClienteVO update(@RequestBody ClienteVO cliente)throws Exception {
		
		return service.update(cliente);
	}
	
	@DeleteMapping(value = "/{id}")
	public void delete(@PathVariable(value = "id") Long id)throws Exception {
		service.delete(id);
	}

			
}
