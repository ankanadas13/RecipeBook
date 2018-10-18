package JUnitTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.AdminDAO;
import pojo.Admin;

public class AdminDAOTest {

	AdminDAO dao;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new AdminDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddAdmin() {
		// expected
		Admin adminExpected = new Admin("naruto", "naruto123", "uzumaki naruto", "uzumaki@konoha.org", "Aktif");
		String expectedFullname = adminExpected.getFullname();
		String expectedUsername = adminExpected.getUsername();
		String expectedPassword = adminExpected.getPassword();
		String expectedEmail = adminExpected.getEmail();
		String expectedStatus = adminExpected.getStatus();
		dao.addNewAdmin(adminExpected);
		Integer expectedIdAdmin = adminExpected.getIdadmin();
		// actual
		Admin adminActual = dao.getAdminLastRecord();
		Integer actualIdAdmin = adminActual.getIdadmin();
		String actualFullname = adminActual.getFullname();
		String actualUsername = adminActual.getUsername();
		String actualPassword = adminActual.getPassword();
		String actualEmail = adminActual.getEmail();
		String actualStatus = adminActual.getStatus();
		try {
			// testing
			assertEquals(expectedIdAdmin, actualIdAdmin);
			assertEquals(expectedFullname, actualFullname);
			assertEquals(expectedUsername, actualUsername);
			assertEquals(expectedPassword, actualPassword);
			assertEquals(expectedEmail, actualEmail);
			assertEquals(expectedStatus, actualStatus);
		} finally {
			dao.deleteAdmin(adminExpected);
		}
	}

	@Test
	public void testGetAllAdmin() {
		List<Admin> listAdmin = dao.getAllAdmin();
		// testing
		assertTrue(listAdmin.size() > 0);
		assertTrue(listAdmin.size() != 0);
		assertNotNull(listAdmin);
	}

	@Test
	public void testGetAllAdminID() {
		List<Admin> listAdminID = dao.getAllAdminID();
		// testing
		assertTrue(listAdminID.size() > 0);
		assertTrue(listAdminID.size() != 0);
		assertNotNull(listAdminID);
	}

	@Test
	public void testGetAdminByID() {
		// expected
		String expectedUsername = "gavin";
		String expectedPassword = "gavin";
		String expectedFullname = "Richard Gavin";
		String expectedEmail = "RichardGavin@recipebook.com";
		String expectedStatus = "Aktif";
		// actual
		Admin admin = dao.getAdminById(17);
		String actualUsername = admin.getUsername();
		String actualPassword = admin.getPassword();
		String actualFullname = admin.getFullname();
		String actualEmail = admin.getEmail();
		String actualStatus = admin.getStatus();
		// testing
		assertNotNull(admin);
		assertEquals(expectedFullname, actualFullname);
		assertEquals(expectedUsername, actualUsername);
		assertEquals(expectedPassword, actualPassword);
		assertEquals(expectedEmail, actualEmail);
		assertEquals(expectedStatus, actualStatus);
	}

	@Test
	public void testValidateLogin() {
		// expected
		Admin adminExpected = new Admin();
		String expectedUsername = "root1";
		String expectedPassword = "12345";
		adminExpected.setUsername(expectedUsername);
		adminExpected.setPassword(expectedPassword);
		// actual
		List<Admin> adminActual = dao.validateLogin(adminExpected);
		String actualUsername = adminActual.get(0).getUsername();
		String actualPassword = adminActual.get(0).getPassword();
		String actualStatus = adminActual.get(0).getStatus();
		// testing
		assertTrue(adminActual.size() > 0);
		assertFalse(adminActual.size() == 0);
		assertEquals(expectedUsername, actualUsername);
		assertEquals(expectedPassword, actualPassword);
		assertEquals("Aktif", actualStatus);
	}

	@Test
	public void testDeleteAdmin() {
		// expected
		Admin adminExpected = new Admin("naruto", "naruto123", "uzumaki naruto", "uzumaki@konoha.org", "Tidak Aktif");
		dao.addNewAdmin(adminExpected);
		dao.deleteAdmin(adminExpected);
		// actual
		Admin adminActual = dao.getAdminLastRecord();
		// testing
		assertNotEquals(adminExpected.getIdadmin(), adminActual.getIdadmin());
		assertNotEquals(adminExpected.getUsername(), adminActual.getUsername());
		assertNotEquals(adminExpected.getPassword(), adminActual.getPassword());
		assertNotEquals(adminExpected.getFullname(), adminActual.getFullname());
		assertNotEquals(adminExpected.getEmail(), adminActual.getEmail());
		assertNotEquals(adminExpected.getStatus(), adminActual.getStatus());
	}

	@Test
	public void testUpdateAdmin() {
		Admin admin = new Admin("naruto", "naruto123", "uzumaki naruto", "uzumaki@konoha.org", "Aktif");
		dao.addNewAdmin(admin);
		Admin adminExpected = dao.getAdminLastRecord();
		adminExpected.setUsername("sasuke");
		adminExpected.setPassword("sasuke123");
		adminExpected.setFullname("uciha sasuke");
		adminExpected.setEmail("sasuke@akatsuki.com");
		adminExpected.setStatus("Tidak Aktif");
		// expected
		String expectedFullname = adminExpected.getFullname();
		String expectedUsername = adminExpected.getUsername();
		String expectedPassword = adminExpected.getPassword();
		String expectedEmail = adminExpected.getEmail();
		String expectedStatus = adminExpected.getStatus();
		// actual
		dao.updateAdmin(adminExpected);
		Admin adminActual = dao.getAdminLastRecord();
		String actualFullname = adminActual.getFullname();
		String actualUsername = adminActual.getUsername();
		String actualPassword = adminActual.getPassword();
		String actualEmail = adminActual.getEmail();
		String actualStatus = adminActual.getStatus();
		try {
			// testing
			assertEquals(expectedFullname, actualFullname);
			assertEquals(expectedUsername, actualUsername);
			assertEquals(expectedPassword, actualPassword);
			assertEquals(expectedEmail, actualEmail);
			assertEquals(expectedStatus, actualStatus);
		} finally {
			dao.deleteAdmin(adminExpected);
		}
	}

	@Test
	public void testGetAdminLastRecord() {
		// expected
		Admin adminExpected = new Admin("naruto", "naruto123", "uzumaki naruto", "uzumaki@konoha.org", "Aktif");
		String expectedFullname = adminExpected.getFullname();
		String expectedUsername = adminExpected.getUsername();
		String expectedPassword = adminExpected.getPassword();
		String expectedEmail = adminExpected.getEmail();
		String expectedStatus = adminExpected.getStatus();
		dao.addNewAdmin(adminExpected);
		Integer expectedIdAdmin = adminExpected.getIdadmin();
		// actual
		Admin adminActual = dao.getAdminLastRecord();
		Integer actualIdAdmin = adminActual.getIdadmin();
		String actualFullname = adminActual.getFullname();
		String actualUsername = adminActual.getUsername();
		String actualPassword = adminActual.getPassword();
		String actualEmail = adminActual.getEmail();
		String actualStatus = adminActual.getStatus();
		try {
			// testing
			assertEquals(expectedIdAdmin, actualIdAdmin);
			assertEquals(expectedFullname, actualFullname);
			assertEquals(expectedUsername, actualUsername);
			assertEquals(expectedPassword, actualPassword);
			assertEquals(expectedEmail, actualEmail);
			assertEquals(expectedStatus, actualStatus);
		} finally {
			dao.deleteAdmin(adminExpected);
		}
	}
}
