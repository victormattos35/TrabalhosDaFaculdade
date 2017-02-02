package br.com.mercadotcc.DO;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

public class LoginDO {
	private static final String URL = "http://192.168.0.103:8080/WebServiceExemplo/services/LoginDAO?wsdl";
	private static final String NAMESPACE = "http://dao.webservice.com.br";

	private static final String BUSCAR = "validate";

	public boolean validate(String cpf, String senha) {
		SoapObject buscar = new SoapObject(NAMESPACE, BUSCAR);
		buscar.addProperty("cpf", cpf);
		buscar.addProperty("senha", senha);

		SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(
				SoapEnvelope.VER11);

		envelope.setOutputSoapObject(buscar);

		envelope.implicitTypes = true;

		HttpTransportSE http = new HttpTransportSE(URL);
		try {
			http.call("urn:" + BUSCAR, envelope);
			SoapPrimitive resposta = (SoapPrimitive) envelope.getResponse();
			return Boolean.parseBoolean(resposta.toString());

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
