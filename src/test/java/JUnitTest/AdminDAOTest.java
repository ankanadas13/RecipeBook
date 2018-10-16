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
		//expected
		Admin adminExpected = new Admin("naruto","naruto123","uzumaki naruto","uzumaki@konoha.org","Aktif");
		dao.addNewAdmin(adminExpected);
		//actual
		Admin adminActual = dao.getAdminLastRecord();
		try {	
		//testing
		assertEquals(adminExpected.getFullname(), adminActual.getFullname());
		assertEquals(adminExpected.getUsername(), adminActual.getUsername());
		assertEquals(adminExpected.getPassword(), adminActual.getPassword());
		assertEquals(adminExpected.getEmail(), adminActual.getEmail());
		assertEquals(adminExpected.getStatus(), adminActual.getStatus());
		} finally {
		dao.deleteAdmin(adminExpected);
		}
	}
	
	@Test
	public void testGetAllAdmin() {
		List<Admin> listAdmin = dao.getAllAdmin();
		//testing
		assertTrue(listAdmin.size()>0);
		assertFalse(listAdmin.size()==0);
		assertNotNull(listAdmin);
	}
	
	@Test
	public void testGetAllAdminID() {
		List<Admin> listAdminID = dao.getAllAdminID();
		//testing
		assertTrue(listAdminID.size()>0);
		assertFalse(listAdminID.size()==0);
		assertNotNull(listAdminID);
	}
	
	@Test
	public void testGetAdminByID() {
		//expected
		String usernameExpected = "gavin";
		String fullnameExpected = "Richard Gavin";
		//actual
		Admin admin = dao.getAdminById(17);
		String usernameActual = admin.getUsername();
		String fullnameActual = admin.getFullname();
		//testing
		assertEquals(usernameExpected, usernameActual);
		assertEquals(fullnameExpected, fullnameActual);
		assertNotNull(admin);
	}
	
	@Test
	public void testValidateLogin() {
		//expected
		Admin adminExpected = new Admin();
		String username = "root1";
		String password = "12345";
		String status = "Aktif";
		adminExpected.setUsername(username);
		adminExpected.setPassword(password);
		adminExpected.setStatus(status);
		//actual
		List<Admin> adminActual = dao.validateLogin(adminExpected);
		//testing
		assertTrue(adminActual.size()>0);
		assertFalse(adminActual.size()==0);
		assertEquals(adminExpected.getUsername(), adminActual.get(0).getUsername());
		assertEquals(adminExpected.getPassword(), adminActual.get(0).getPassword());
		assertEquals(adminExpected.getStatus(), adminActual.get(0).getStatus());
	}
	
	@Test
	public void testDeleteAdmin() {
		Admin adminExpected = new Admin("naruto","naruto123","uzumaki naruto","uzumaki@konoha.org","Aktif");
		dao.addNewAdmin(adminExpected);
		dao.deleteAdmin(adminExpected);
		Admin adminActual = dao.getAdminLastRecord();
		//testing
		assertNotEquals(adminExpected.getIdadmin(), adminActual.getIdadmin());
		assertNotEquals(adminExpected.getUsername(), adminActual.getUsername());
		assertNotEquals(adminExpected.getFullname(), adminActual.getFullname());
	}
	
	@Test
	public void testUpdateAdmin() {
		Admin admin = new Admin("naruto","naruto123","uzumaki naruto","uzumaki@konoha.org","Aktif");
		dao.addNewAdmin(admin);
		//expected
		Admin adminExpected = dao.getAdminLastRecord();
		adminExpected.setUsername("sasuke");
		adminExpected.setPassword("sasuke123");
		adminExpected.setFullname("uciha sasuke");
		dao.updateAdmin(adminExpected);
		//actual
		Admin adminActual = dao.getAdminLastRecord();
		try {	
		//testing
		assertEquals(adminExpected.getFullname(), adminActual.getFullname());
		assertEquals(adminExpected.getUsername(), adminActual.getUsername());
		assertEquals(adminExpected.getPassword(), adminActual.getPassword());
		} finally {
		dao.deleteAdmin(adminExpected);
		}
	}
	
	@Test
	public void testGetAdminLastRecord() {
		//expected
		Admin adminExpected = new Admin("naruto","naruto123","uzumaki naruto","uzumaki@konoha.org","Aktif");
		dao.addNewAdmin(adminExpected);
		//actual
		Admin adminActual = dao.getAdminLastRecord();
		try {	
		//testing
		assertEquals(adminExpected.getFullname(), adminActual.getFullname());
		assertEquals(adminExpected.getUsername(), adminActual.getUsername());
		assertEquals(adminExpected.getPassword(), adminActual.getPassword());
		assertEquals(adminExpected.getEmail(), adminActual.getEmail());
		assertEquals(adminExpected.getStatus(), adminActual.getStatus());
		} finally {
		dao.deleteAdmin(adminExpected);
		}
	}
}
