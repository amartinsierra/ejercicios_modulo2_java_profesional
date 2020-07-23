package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import service.ServicePaises;

public class TestPaises {
	ServicePaises service;
	@Before
	public void setUp() throws Exception {
		service=new ServicePaises();
	}

	@Test
	public void testContinenteConMasPaises() {
		assertEquals(service.continenteConMasPaises(), "Europe");
	}
	@Test
	public void testPaisMasPoblado() {
		assertEquals(service.paisMasPoblado().getHabitantes(), 249903450);
	}
	@Test
	public void testFundacionAnterior() {
		assertEquals(service.paisesFundacionAnterior(1800).size(),4);
	}
}
