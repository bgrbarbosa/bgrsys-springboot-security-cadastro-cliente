package br.com.bgrsys.clientes.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import br.com.bgrsys.clientes.data.vo.v1.ClienteVO;
import br.com.bgrsys.clientes.exception.ResourceNotFoundException;
import br.com.bgrsys.clientes.mapper.DozerMapper;
import br.com.bgrsys.clientes.model.Cliente;
import br.com.bgrsys.clientes.repository.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	ClienteRepository repository;
	
	private final AtomicLong counter = new AtomicLong();
	private Logger logger = Logger.getLogger(ClienteService.class.getName());
	
	public ClienteVO create(ClienteVO cliente) {
		
		logger.info("Inserindo um Cliente");		
		var entity = DozerMapper.parseObject(cliente, Cliente.class);
		var vo = DozerMapper.parseObject(repository.save(entity), ClienteVO.class);
		return vo;
	}
	
	public ClienteVO update(ClienteVO cliente) {
		
		logger.info("Alterando um Cliente");
		
		var entity = repository.findById(cliente.getIdCliente())
				.orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado!!"));
		
		entity.setNomeCliente(cliente.getNomeCliente());
		entity.setRgCliente(cliente.getRgCliente());
		entity.setCpfCliente(cliente.getCpfCliente());
		entity.setIeCliente(cliente.getIeCliente());
		entity.setCpfCliente(cliente.getCpfCliente());
		entity.setTelCliente(cliente.getTelCliente());
		entity.setCelCliente(cliente.getCelCliente());
		entity.setEndereco(cliente.getEndereco());
		entity.setNumero(cliente.getNumero());
		entity.setComplemento(cliente.getComplemento());
		entity.setBairro(cliente.getBairro());
		entity.setCidade(cliente.getCidade());
		entity.setCelCliente(cliente.getCelCliente());
		entity.setEmailCliente(cliente.getEmailCliente());
		entity.setUf(cliente.getUf());	

		var vo = DozerMapper.parseObject(repository.save(entity), ClienteVO.class);
		return vo;
	}
	
	public void delete(Long id) {
		
		logger.info("Deletando um Cliente");
		
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado!!"));
		
		repository.delete(entity);
	}
	
	public List<ClienteVO> findAll(){
		logger.info("Listando Clientes");
	
		return DozerMapper.parseListObjects(repository.findAll(), ClienteVO.class);
	}
	
	public ClienteVO findById(Long id) {
		
		logger.info("Procura um Cliente");		
				
		var entity = repository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Registro não encontrado!!"));
		
		return DozerMapper.parseObject(entity, ClienteVO.class);
	}
}
