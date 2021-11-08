package tn.esprit.spring.services;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Role;
import tn.esprit.spring.entities.Contrat;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class ContratServiceImplTest {
	
	@Autowired
	IContratService contrat;
	
	//@Test
	//@Order(1)
	//public void testRetriveveAllContrats() {
	//	List<Contrat> listContrats = contrat.retrieveAllContrats();
	//	Assertions.assertEquals(13, listContrats.size());
	//}

	@Test
	@Order(2)
	public void testAddContrat() throws ParseException {
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2020-02-06");
		Contrat c  = new Contrat(d,"CDI",1500);
		Contrat contratAdded = contrat.addContrat(c);
		Assertions.assertEquals(c.getTypeContrat(),contratAdded.getTypeContrat());
	}

	@Test
	@Order(3)
	public void testModifyContrat() throws ParseException {
	SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date d = dateFormat.parse("2015-02-06");
		Contrat u  = new Contrat(1L,d,"CVP",800);
		Contrat contratUpdated = contrat.updateContrat(u);
		Assertions.assertEquals(u.getTypeContrat(),contratUpdated.getTypeContrat());
	}
	
	@Test
	@Order(4)
	public void testRetrieveContrat() {
		Contrat contratRetrieved = contrat.retrieveContrat("5");
		Assertions.assertEquals(5L,contratRetrieved.getReference());
	}
	
	@Test
	@Order(5)
	public void testDeleteContrat() {
		contrat.deleteContrat("10");
	//	Assertions.assertNull(contrat.retrieveContrat("3"));
	}
	
	//@Test
	//public void testUpdateContrat() {
	//}
	
}
