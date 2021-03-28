package rs.ac.bg.fon.nprog.mvnbiblioteka.biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka.Autor;

public class AutorTest {

	Autor a;

	@BeforeEach
	public void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	public void tearDown() throws Exception {
		a = null;
	}

	@Test
	public void testAutor() {
		a = new Autor();
		
		assertNotNull(a);
	}

	@Test
	public void testAutorStringString() {
		a = new Autor("Mika", "Mikic");
		
		assertNotNull(a);
		assertEquals("Mika", a.getIme());
		assertEquals("Mikic", a.getPrezime());
	}

	@Test
	public void testSetIme() {
		a.setIme("Pera");

		assertEquals("Pera", a.getIme());
	}

	@Test
	@DisplayName("Testira ako je uneto null umesto imena")
	public void testSetImeNull() {

		assertThrows(java.lang.NullPointerException.class, new Executable() {
			public void execute() throws Throwable {
				a.setIme(null);
			}
		});
	}

	@Test
	public void testSetImePrekratakString() {
		assertThrows(java.lang.RuntimeException.class, new Executable() {
			public void execute() throws Throwable {
				a.setIme("P");
			}
		});
	}

	@Test
	public void testSetImePrazanString() {
		assertThrows(java.lang.RuntimeException.class, new Executable() {
			public void execute() throws Throwable {
				a.setIme("");
			}
		});
	}

	@Test
	public void testSetPrezime() {
		a.setPrezime("Peric");
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	public void testSetPrezimeNull() {
		assertThrows(java.lang.NullPointerException.class, new Executable() {
			public void execute() throws Throwable {
				a.setPrezime(null);
			}
		});
	}

	@Test
	public void testSetPrezimePrekratakString() {
		assertThrows(java.lang.RuntimeException.class, new Executable() {
			public void execute() throws Throwable {
				a.setPrezime("T");
			}
		});
	}

	@Test
	public void testSetPrezimePrazanString() {
		assertThrows(java.lang.RuntimeException.class, new Executable() {
			public void execute() throws Throwable {
				a.setPrezime("");
			}
		});
	}
	

	@Test
	public void testToString() {
		a.setIme("Zika");
		a.setPrezime("Zikic");
		
		String s = a.toString();
		
		assertTrue(s.contains("Zika"));
		assertTrue(s.contains("Zikic"));
	}

	@ParameterizedTest
	@CsvSource({
		"Pera, Peric, Pera, Peric, true",
		"Pera, Zikic, Pera, Peric, false",
		"Mika, Peric, Pera, Peric, false",
		"Pera, Peric, Mika, Mikic, false"
	})
	public void testEqualsObject(String ime1, String prezime1, String ime2, String prezime2, boolean equals) {
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor b = new Autor();
		b.setIme(ime2);
		b.setPrezime(prezime2);
		
		assertEquals(a.equals(b), equals);
	}

}
