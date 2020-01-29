package com.testjava.tuto.api;

import org.mockserver.integration.ClientAndServer;
import org.mockserver.matchers.Times;
import org.mockserver.model.Header;
import org.mockserver.model.HttpRequest;
import org.mockserver.model.HttpResponse;
import org.mockserver.model.Parameter;
import org.mockserver.verify.VerificationTimes;

import com.testjava.tuto.TestMockServer;
import com.testjava.tuto.model.Abonne;
import com.testjava.tuto.model.Movement;

public class ServiceApi {

	public void ajouterAdresse(Abonne abonne) {

		HttpRequest httpRequest = new HttpRequest();
		httpRequest.withMethod("POST").withPath("/adresse/" + abonne.getId()).withBody("{canal: " + abonne.getCanal()
				+ ", active: " + abonne.getAdresse().getActive()
				+ ", pays: " + abonne.getAdresse().getPays() + ", condition: ''}");

		HttpResponse httpResponse = new HttpResponse();
		httpResponse
			.withStatusCode(200)
			.withHeaders(new Header("Content-Type", "application/json"))
			.withBody("{ message: 'l\'adresse de l\'abonné " + abonne.getId() + " est bien enregistrer' }");

		TestMockServer.mockServer.when(httpRequest).respond(httpResponse);
	}

	public void verifierAdresse(ClientAndServer mockServer) {

		HttpRequest httpRequest = new HttpRequest();
		httpRequest.withMethod("POST").withPath("/adresse");
		mockServer.verify(httpRequest, VerificationTimes.once());
	}
	
	public void getAbonne(int id, String filter) {
		TestMockServer.mockServer
        .when(
            HttpRequest.request()
            .withMethod("GET")
            .withPath("/adresse/" + id)
            .withHeader(Header.header("Content-Type", "application/json; charset=utf-8"))
            .withQueryStringParameter(Parameter.param("canal", filter)),
            Times.unlimited()
        ).respond(
            HttpResponse.response()
            .withStatusCode(200)
        );
	}

	public void ajouterMovement(Movement movement) {

		HttpRequest httpRequest = new HttpRequest();
		httpRequest.withMethod("POST").withPath("/movement/" + movement.getId()).withBody("{condition: " + movement.getDescription() + "}");

		HttpResponse httpResponse = new HttpResponse();
		httpResponse
			.withStatusCode(200)
			.withHeaders(new Header("Content-Type", "application/json"))
			.withBody("{ message: 'Un mouvement de modification d adresse est cree' }");

		TestMockServer.mockServer.when(httpRequest).respond(httpResponse);
	}
}
