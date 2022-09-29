package br.com.bgrsys.clientes.resources;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/info")
public class ResourcesController {
	
	@RequestMapping(
			method = RequestMethod.GET,
			produces = MediaType.APPLICATION_JSON_VALUE)
	public Map<String, Object>getInfo(){
		
		Map<String, Object> info = new HashMap<>();
		info.put("Nome:", "BGRSYS - Sistema de Pedidos");
		info.put("Versão:", "1.0 -  Demo");
		return info;
	}
	

			
}
