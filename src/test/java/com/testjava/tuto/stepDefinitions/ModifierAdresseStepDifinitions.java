package com.testjava.tuto.stepDefinitions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import com.testjava.tuto.TestMockServer;
import com.testjava.tuto.api.ServiceApi;
import com.testjava.tuto.model.Abonne;
import com.testjava.tuto.model.Adresse;
import com.testjava.tuto.model.Movement;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.fr.Alors;
import io.cucumber.java.fr.Etantdonné;
import io.cucumber.java.fr.Lorsque;

public class ModifierAdresseStepDifinitions {

	private ServiceApi serviceApi = new ServiceApi();

	HttpResponse httpResponse;
	HttpPost httpPost;
	Abonne abonneUn, abonneTrois;

	@Before
	public void init() {
		TestMockServer.createMockServer();
		
		Adresse adresseUn = new Adresse("inactive", "France");
		Adresse adresseDeux = new Adresse("active", "Pologne");
		abonneUn = new Abonne(1, "FACE", adresseUn);
		//Abonne abonneDeux = new Abonne(2, "FACE", adresseUn);
		abonneTrois = new Abonne(2, "EC", adresseDeux);
		//Abonne abonneQuatre = new Abonne(4, "EC", adresseDeux);
		
		serviceApi.ajouterAdresse(abonneUn);
		//serviceApi.ajouterAdresse(abonneDeux);
		serviceApi.ajouterAdresse(abonneTrois);
		//serviceApi.ajouterAdresse(abonneQuatre);
	}
	
	@Etantdonné("un abonne avec une adresse principale {string} en {string}")
	public void un_abonne_avec_une_adresse_principale_en(String active, String pays) {
		System.out.println("un abonné avec une adresse principale : " + active + " et en : " + pays);

		try {
			String json = "{canal: " + abonneUn.getCanal() + ", active: " + abonneUn.getAdresse().getActive() + ", pays: " + abonneUn.getAdresse().getPays() + ", condition: ''}";
			httpPost = new HttpPost("http://localhost:1088/adresse/" + abonneUn.getId());
			StringEntity entity = new StringEntity(json);
			httpPost.setEntity(entity);
			httpPost.setHeader("Content-type", "application/json");
			
			
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Lorsque("le conseiller connecte a {string} modifie l adresse de l abonne {string}")
	public void le_conseiller_connecte_a_modifie_l_adresse_de_l_abonne(String canal, String condition) {
		System.out.println("le conseiller connecte a " + canal + " modifie l'adresse de l'abonne " + condition);
		
		try {
			httpResponse = HttpClientBuilder.create().build().execute(httpPost);
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Alors("l adresse de l abonne modifiee est enregistree sur l ensemble des contrats de l abonne")
	public void l_adresse_de_l_abonne_modifiee_est_enregistree_sur_l_ensemble_des_contrats_de_l_abonne() {
		System.out.println("l'adresse de l'abonne modifiée est enregistrée");
		assertEquals(200, httpResponse.getStatusLine().getStatusCode());
	}

	@Alors("un mouvement de modification d adresse est cree")
	public void un_mouvement_de_modification_d_adresse_est_cree() {
		System.out.println("un mouvement de modification d adresse est cree");
		Movement movement = new Movement(1, "un mouvement de modification d adresse est cree");
		serviceApi.ajouterMovement(movement);
	}
	
	@After
	public void stopMockServer() {
		TestMockServer.mockServer.stop();
	}
}
