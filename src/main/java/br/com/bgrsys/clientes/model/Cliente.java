package br.com.bgrsys.clientes.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table (name = "Clientes")
@Data
public class Cliente implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column (name = "idCliente")
	private Long idCliente;
	
	@Column(name = "nomeCliente", nullable = false, length = 80)
	private String nomeCliente;
	
	@Column(name = "rgCliente",nullable = true, length = 18)
	private String rgCliente;
	
	@Column(name = "cpfCliente", nullable = true,length = 11)
	private String cpfCliente;
	
	@Column(name = "ieCliente", nullable = true, length = 18)
	private String ieCliente;
	
	@Column(name = "cnpjCliente", nullable = true, length = 11)
	private String cnpjCliente;
	
	@Column(name = "telCliente", nullable = true, length = 10)
	private String telCliente;
	
	@Column(name = "celCliente", nullable = false, length = 11)
	private String celCliente;
	
	@Column(name = "emailCliente", nullable = false, length = 80)
	private String emailCliente;
	
	@Column(name = "endereco", nullable = false, length = 80)
	private String endereco;
	
	@Column(name = "num", nullable = false, length = 10)
	private String numero;
	
	@Column(name = "complemento", nullable = true, length = 80)
	private String complemento;
	
	@Column(name = "bairro", nullable = false, length = 80)
	private String bairro;
	
	@Column(name = "cidade", nullable = false, length = 80)
	private String cidade;
	
	@Column (name = "cep", nullable = false, length = 10)
	private String cep;
	
	@Column (name = "uf", nullable = false, length = 2)
	private String uf;

}
