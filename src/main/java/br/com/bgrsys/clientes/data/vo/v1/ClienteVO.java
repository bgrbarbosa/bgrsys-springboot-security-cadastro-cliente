package br.com.bgrsys.clientes.data.vo.v1;

import java.io.Serializable;

import lombok.Data;


@Data
public class ClienteVO implements Serializable {
	

	private static final long serialVersionUID = 1L;

	private Long idCliente;
	private String nomeCliente;
	private String rgCliente;
	private String cpfCliente;
	private String ieCliente;
	private String cnpjCliente;
	private String telCliente;
	private String celCliente;
	private String emailCliente;
	private String endereco;
	private String numero;
	private String complemento;
	private String bairro;
	private String cidade;
	private String cep;
	private String uf;

}
