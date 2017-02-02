package br.com.redeteste.util;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.server.ResourceConfig;

// http://localhost:8080/RedeTeste/rest
@ApplicationPath("rest")
public class RedeREST extends ResourceConfig {
	public RedeREST() {
		packages("br.com.redeteste.service");
	}
}
