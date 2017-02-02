package br.com.mercadotcc.DO;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import br.com.mercadotcc.model.Produto;

public class ListaVendaDO {

	private static final String URL = "http://192.168.0.103:8080/WebServiceExemplo/services/ProdutoDAO?wsdl";
	private static final String NAMESPACE = "http://dao.webservice.com.br";

	private static final String BUSCAR = "buscar";

	public Produto buscar(String idproduto) {
		Produto prod = null;
		SoapObject buscar = new SoapObject(NAMESPACE, BUSCAR);
		buscar.addProperty("idproduto", idproduto);
		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(buscar);

		envelope.implicitTypes = true;

		HttpTransportSE http = new HttpTransportSE(URL);
		try {
			http.call("urn:" + BUSCAR, envelope);
			SoapObject resposta = (SoapObject) envelope.getResponse();

			prod = new Produto();
			prod.setIdproduto(Long.parseLong(resposta.getProperty("idproduto")
					.toString()));
			prod.setDescricao(resposta.getProperty("descricao").toString());
			prod.setValor_venda(Double.parseDouble(resposta.getProperty("valor_venda").toString()));
			

		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return prod;
	}
}
