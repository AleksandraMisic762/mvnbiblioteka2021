package rs.ac.bg.fon.nprog.mvnbiblioteka.biblioteka;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka.interfejs.BibliotekaInterfaceTest;
import rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka.Biblioteka;

public class BibliotekaTest extends BibliotekaInterfaceTest {

	@BeforeEach
	public void setUp() throws Exception {
		biblioteka = new Biblioteka();
	}

	@AfterEach
	public void tearDown() throws Exception {
		biblioteka = null;
	}

}
