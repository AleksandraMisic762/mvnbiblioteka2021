package rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka.interfejs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka.Knjiga;

public abstract class BibliotekaInterfaceTest {
	
	protected BibliotekaInterface biblioteka;

	@Test
	public void testDodajKnjigu() {
		Knjiga k = new Knjiga();
		k.setNaslov("Knjiga 1");
		
		biblioteka.dodajKnjigu(k);
		
		assertEquals(1, biblioteka.vratiSveKnjige().size());		
		assertEquals(k, biblioteka.vratiSveKnjige().get(0));
	}
	
	@Test
	public void testDodajKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> biblioteka.dodajKnjigu(null));	
	}
	
	@Test
	public void testDodajKnjiguDuplikat() {
		Knjiga k1 = new Knjiga();
		k1.setIsbn("1234567890123");
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("1234567890123");
		
		biblioteka.dodajKnjigu(k1);
		
		RuntimeException e = assertThrows(java.lang.RuntimeException.class, 
				() -> biblioteka.dodajKnjigu(k2));	
		
		assertEquals("knjiga vec postoji u biblioteci", e.getMessage());
	}

	@Test
	public void testObrisiKnjigu() {
		Knjiga k = new Knjiga();
		k.setIsbn("1234567890123");
		
		biblioteka.dodajKnjigu(k);
		
		biblioteka.obrisiKnjigu(k);
		
		assertEquals(0, biblioteka.vratiSveKnjige().size());
	}
	
	@Test
	public void testObrisiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> biblioteka.obrisiKnjigu(null));	
	}
	
	@Test
	public void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		k.setIsbn("1234567890123");
		
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k.setIsbn("0204060833123");
		
		assertThrows(java.lang.RuntimeException.class, 
				() -> biblioteka.obrisiKnjigu(k2));	
	}

	@Test
	public void testVratiSveKnjige() {
		Knjiga k1 = new Knjiga();
		k1.setIsbn("1234567890123");
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("2039555890123");
		
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		
		assertEquals(k1, knjige.get(0));
		assertEquals(k2, knjige.get(1));
	}

	@Test
	public void testPronadjiKnjigu() {
		Knjiga k1 = new Knjiga();
		k1.setNaslov("Knjiga o dzungli");
		k1.setIsbn("1234");
		
		Knjiga k2 = new Knjiga();
		k2.setNaslov("Dzungla zivota");
		k2.setIsbn("5678");
		
		Knjiga k3 = new Knjiga();
		k3.setNaslov("Evgenije Onjegin");
		k3.setIsbn("91011");
		
		biblioteka.dodajKnjigu(k1);
		biblioteka.dodajKnjigu(k2);
		biblioteka.dodajKnjigu(k3);
		
		List<Knjiga> rezultat = biblioteka.pronadjiKnjigu(null, null, "zung", null);
		
		assertEquals(2, rezultat.size());
		assertTrue(rezultat.contains(k1));
		assertTrue(rezultat.contains(k2));
	}
	
	@Test
	public void testPronadjiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class, 
				() -> biblioteka.pronadjiKnjigu(null, null, null, null));
	}

}
