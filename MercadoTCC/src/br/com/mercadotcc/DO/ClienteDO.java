package br.com.mercadotcc.DO;

import java.util.ArrayList;
import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import br.com.mercadotcc.model.Cliente;

public class ClienteDO {
	private static final String URL = "http://192.168.0.103:8080/WebServiceExemplo/services/ClienteDAO?wsdl";
	private static final String NAMESPACE = "http://dao.webservice.com.br";

	private static final String INSERIR = "salvar";
	private static final String EXCLUIR = "excluir";
	private static final String ATUALIZAR = "editar";
	private static final String LISTAR = "listar";

	public boolean salvar(Cliente c) {
		SoapObject salvar = new SoapObject(NAMESPACE, INSERIR);

		SoapObject cliente = new SoapObject(NAMESPACE, "c");

		cliente.addProperty("idcliente", c.getIdcliente());
		cliente.addProperty("nome", c.getNome());
		cliente.addProperty("cpf", c.getCpf());
		cliente.addProperty("senha", c.getSenha());
		cliente.addProperty("telefone", c.getTelefone());
		cliente.addProperty("celular", c.getCelular());
		cliente.addProperty("email", c.getEmail());
		cliente.addProperty("cep", c.getCep());
		cliente.addProperty("rua", c.getRua());
		cliente.addProperty("numero", c.getNumero());
		cliente.addProperty("complemento", c.getComplemento());
		cliente.addProperty("bairro", c.getBairro());
		cliente.addProperty("cidade", c.getCidade());
		cliente.addProperty("estado", c.getEstado());
		salvar.addSoapObject(cliente);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(salvar);

		envelope.implicitTypes = true;

		HttpTransportSE http = new HttpTransportSE(URL);
		try {
			http.call("urn:" + INSERIR, envelope);
			SoapPrimitive resposta = (SoapPrimitive) envelope.getResponse();

			return Boolean.parseBoolean(resposta.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public ArrayList<Cliente> listar() {
		ArrayList<Cliente> lista = new ArrayList<Cliente>();

		SoapObject listar = new SoapObject(NAMESPACE, LISTAR);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(listar);

		envelope.implicitTypes = true;

		HttpTransportSE http = new HttpTransportSE(URL);
		try {
			http.call("urn:" + LISTAR, envelope);
			Vector<SoapObject> resposta = (Vector<SoapObject>) envelope.getResponse();

			for (SoapObject soapObject : resposta) {
				Cliente cli = new Cliente();
				cli.setIdcliente(Long.parseLong(soapObject.getProperty("idcliente").toString()));
				cli.setNome(soapObject.getProperty("nome").toString());
				
				lista.add(cli);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return lista;
	}

	public boolean editar(Cliente c) {

		SoapObject salvar = new SoapObject(NAMESPACE, ATUALIZAR);

		SoapObject cliente = new SoapObject(NAMESPACE, "c");

		cliente.addProperty("idcliente", c.getIdcliente());
		cliente.addProperty("nome", c.getNome());
		cliente.addProperty("cpf", c.getCpf());
		cliente.addProperty("senha", c.getSenha());
		cliente.addProperty("telefone", c.getTelefone());
		cliente.addProperty("celular", c.getCelular());
		cliente.addProperty("email", c.getEmail());
		cliente.addProperty("cep", c.getCep());
		cliente.addProperty("rua", c.getRua());
		cliente.addProperty("numero", c.getNumero());
		cliente.addProperty("complemento", c.getComplemento());
		cliente.addProperty("bairro", c.getBairro());
		cliente.addProperty("cidade", c.getCidade());
		cliente.addProperty("estado", c.getEstado());
		salvar.addSoapObject(cliente);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(salvar);

		envelope.implicitTypes = true;

		HttpTransportSE http = new HttpTransportSE(URL);
		try {
			http.call("urn:" + ATUALIZAR, envelope);
			SoapPrimitive resposta = (SoapPrimitive) envelope.getResponse();

			return Boolean.parseBoolean(resposta.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean excluir(Cliente c) {

		SoapObject salvar = new SoapObject(NAMESPACE, EXCLUIR);

		SoapObject cliente = new SoapObject(NAMESPACE, "c");

		cliente.addProperty("idcliente", c.getIdcliente());
		cliente.addProperty("nome", c.getNome());
		cliente.addProperty("cpf", c.getCpf());
		cliente.addProperty("senha", c.getSenha());
		cliente.addProperty("telefone", c.getTelefone());
		cliente.addProperty("celular", c.getCelular());
		cliente.addProperty("email", c.getEmail());
		cliente.addProperty("cep", c.getCep());
		cliente.addProperty("rua", c.getRua());
		cliente.addProperty("numero", c.getNumero());
		cliente.addProperty("complemento", c.getComplemento());
		cliente.addProperty("bairro", c.getBairro());
		cliente.addProperty("cidade", c.getCidade());
		cliente.addProperty("estado", c.getEstado());
		salvar.addSoapObject(cliente);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(salvar);

		envelope.implicitTypes = true;

		HttpTransportSE http = new HttpTransportSE(URL);
		try {
			http.call("urn:" + EXCLUIR, envelope);
			SoapPrimitive resposta = (SoapPrimitive) envelope.getResponse();

			return Boolean.parseBoolean(resposta.toString());
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean excluir(long idcliente){
		return excluir(new Cliente((long) idcliente, "", "", "", "", "", "", "", "", 0L, "", "", "", ""));
	}

}
