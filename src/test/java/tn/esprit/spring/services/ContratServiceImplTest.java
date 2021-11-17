package tn.esprit.spring.services;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import tn.esprit.spring.entities.Contrat;


@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
public class ContratServiceImplTest {
	@Autowired 
IContratService cs;
private static final Logger l = LogManager.getLogger(ContratServiceImplTest.class);
	@Test
	@Order(1)
	 public void testRetrieveAllUser()
	{
		List<Contrat> listContrats = cs.retrieveAllContrats();
      Assertions.assertEquals(5, listContrats.size());
	}
	
	@Test
	@Order(2)
	public void testAddContrat() throws ParseException
	{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d =dateFormat.parse("2015-03-23");

		Contrat c = new Contrat(d,"CDI",1.80f);
		Contrat contratAdded = cs.addContrat(c);

	}
	
	@Test
	@Order(3)
	public void testUpdateContrat() throws ParseException{
		SimpleDateFormat dateFormat = new SimpleDateFormat ("yyyy-MM-dd");
		Date d =dateFormat.parse("2021-03-24");
		Contrat c = new Contrat(3,d,"55",1.900f);
		Contrat contratupdated = cs.updateContrat(c);
		Assertions.assertEquals(3, contratupdated.getReference());

	 
	}
	
	@Test
	@Order(4)
	public void testDeleteUser() throws ParseException
	{
cs.deleteContrat("2");
Assertions.assertNull(cs.retrieveContrat("2"));

	 
	}
	
}
