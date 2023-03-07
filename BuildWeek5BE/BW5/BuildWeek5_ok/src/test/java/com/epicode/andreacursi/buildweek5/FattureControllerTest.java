package com.epicode.andreacursi.buildweek5;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epicode.andreacursi.buildweek5.repositories.FattureRepository;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class FattureControllerTest {

	@Resource
	FattureRepository fr;
	
	@Test
	public void testGetAllFatture() {
		assertEquals(fr.findAll().size(), 6299);
	}

	@Test
	public void testGetByClienteId() {
		assertEquals(fr.getFattureByClienteId(1L).get(0).getAnno(),2020);
	}

	@Test
	public void testGetByAnno() {
		assertEquals(fr.getFattureByAnno(2020).get(0).getNumero(),1);
	}

}
