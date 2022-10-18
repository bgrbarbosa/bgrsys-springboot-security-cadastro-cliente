package br.com.bgrsys.clientes.resources;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.bgrsys.clientes.data.vo.v1.ClienteVO;
import br.com.bgrsys.clientes.model.User;
import br.com.bgrsys.clientes.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    
	@Autowired
    private UserService service;
    
    @PostMapping
    public void postUser(@RequestBody User user){
        service.createUser(user);
    }
    
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<User> findAll()throws Exception {		
		return service.listar();
	}
    

}
