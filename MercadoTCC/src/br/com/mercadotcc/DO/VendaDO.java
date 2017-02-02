package br.com.mercadotcc.DO;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import br.com.mercadotcc.model.Venda;

public class VendaDO {
	private static final String URL = "http://localhost:8080/WebServiceExemplo/services/VendaDAO?wsdl";
	private static final String NAMESPACE = "http://dao.webservice.com.br";

	private static final String INSERIR = "salvar";
	private static final String ATUALIZAR = "editar";

	public boolean salvar(Venda v) {
		SoapObject salvar = new SoapObject(NAMESPACE, INSERIR);

		SoapObject venda = new SoapObject(NAMESPACE, "v");

		venda.addProperty("idvenda", v.getIdvenda());
		venda.addProperty("nome", v.getDia());
		venda.addProperty("cpf", v.getValortotal());
		venda.addProperty("senha", v.getCliente().getIdcliente());
		salvar.addSoapObject(venda);
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

	public boolean editar(Venda v) {

		SoapObject salvar = new SoapObject(NAMESPACE, ATUALIZAR);

		SoapObject venda = new SoapObject(NAMESPACE, "v");

		venda.addProperty("idvenda", v.getIdvenda());
		venda.addProperty("nome", v.getDia());
		venda.addProperty("cpf", v.getValortotal());
		venda.addProperty("senha", v.getCliente().getIdcliente());
		salvar.addSoapObject(venda);
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

}
