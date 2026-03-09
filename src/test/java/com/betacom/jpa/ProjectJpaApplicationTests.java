package com.betacom.jpa;

import org.junit.jupiter.api.Test;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;
import org.springframework.boot.test.context.SpringBootTest;

import com.betacom.jpa.abbonamento.AbbonamentoControllerTest;
import com.betacom.jpa.attivita.AttivitaAbbonamentoTest;
import com.betacom.jpa.attivita.AttivitaTest;
import com.betacom.jpa.cetificato.CertificatoControllerTest;
import com.betacom.jpa.socio.SocioControlerTest;
import com.betacom.jpa.socio.SocioServicesTest;

@SpringBootTest
class ProjectJpaApplicationTests {

	@Test
	void contextLoads() {
	}

}
