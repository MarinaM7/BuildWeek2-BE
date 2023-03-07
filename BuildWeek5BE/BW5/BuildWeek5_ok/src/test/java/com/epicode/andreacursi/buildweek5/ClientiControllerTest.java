package com.epicode.andreacursi.buildweek5;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.epicode.andreacursi.buildweek5.repositories.ClientiRepository;

@SpringBootTest
@AutoConfigureMockMvc
@RunWith(SpringRunner.class)
public class ClientiControllerTest {

	@Resource
	ClientiRepository cr;
	
	@Test
	public void testGetClientiPerNome_page() {
		assertEquals(cr.findById(1L).get().getNomeContatto(), "Giulietta");
	}

	@Test
	public void testGetClientiPerFatturato_page() {
		assertEquals(cr.findByFatturatoAnnuale(232636.18).get(0).getNomeContatto(), "Giulietta");
	}

}
