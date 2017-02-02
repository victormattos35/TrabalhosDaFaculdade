package br.com.mercadotcc.DO;

import java.util.ArrayList;
import java.util.Vector;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import br.com.mercadotcc.model.Produto;

public class ProdutoDO {

	private static final String URL = "http://192.168.0.103:8080/WebServiceExemplo/services/ProdutoDAO?wsdl";
	private static final String NAMESPACE = "http://dao.webservice.com.br";

	private static final String INSERIR = "salvar";
	private static final String EXCLUIR = "excluir";
	private static final String ATUALIZAR = "editar";
	private static final String LISTAR = "listar";

	public ArrayList<Produto> listar() {
		ArrayList<Produto> lista = new ArrayList<Produto>();

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
				Produto prod = new Produto();
				prod.setIdproduto(Long.parseLong(soapObject.getProperty("idproduto").toString()));
				prod.setDescricao(soapObject.getProperty("descricao").toString());
				prod.setValor_venda(Double.parseDouble(soapObject.getProperty("valor_venda").toString()));
				lista.add(prod);
				
			}
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}

		return lista;
	}

}
