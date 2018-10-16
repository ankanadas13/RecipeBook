package JUnitTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.RecipeDAO;
import pojo.Admin;
import pojo.Recipe;

public class RecipeDAOTest {
	
	RecipeDAO dao;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		dao = new RecipeDAO();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAddRecipe() {
		//expected
		Recipe recipe = new Recipe();
        recipe.setName("Fried Chicken");
        recipe.setIngredients("1 kg chicken wings, 1 teaspoon salt");
        recipe.setDirections("Cook chicken first, then add salt");
        recipe.setTime("5 minutes");
        recipe.setDifficulty(3);
        recipe.setServings(4);
        recipe.setCategory("Breakfast");
        recipe.setImgpath("images\\fried.jpg");
        dao.addNewRecipe(recipe);
		//actual
        Recipe recipeActual = dao.getRecipeLastRecord();
		try {	
		//testing
		assertEquals(recipe.getName(), recipeActual.getName());
        assertEquals(recipe.getIngredients(), recipeActual.getIngredients());
        assertEquals(recipe.getDirections(), recipeActual.getDirections());
        assertEquals(recipe.getTime(), recipeActual.getTime());
        assertEquals(recipe.getServings(), recipeActual.getServings());
        assertEquals(recipe.getCategory(), recipeActual.getCategory());
        assertEquals(recipe.getImgpath(), recipeActual.getImgpath());
		} finally {
		dao.deleteRecipe(recipe);
		}
	}
	
	
	@Test
	public void testGetAllRecipe() {
		List<Recipe> list = dao.getAllRecipe();
		//testing
		assertTrue(list.size()>0);
		assertFalse(list.size()==0);
		assertNotNull(list);
	}
	
	@Test
	public void testGetAllRecipeID() {
		List<Recipe> list = dao.getAllRecipeID();
		//testing
		assertTrue(list.size()>0);
		assertFalse(list.size()==0);
		assertNotNull(list);
	}
	
	@Test
	public void testGetRecipeByCategory() {
		String category = "Meat";
		List<Recipe> list = dao.getRecipeByCategory(category);
		//testing
		assertTrue(list.size()>0);
		assertFalse(list.size()==0);
		assertNotNull(list);
	}
	
	@Test
	public void testGetImageById() {
		//expected
		String imageExpected = "images\\chicken.jpg";
		//actual
		String imageActual = dao.getImageById(6);
		//testing
		assertTrue(imageActual!=null);
		assertEquals(imageExpected, imageActual);
		assertNotNull(imageActual);
	}
	
	@Test
	public void testGetRecipeByID() {
		//expected
		String nameExpected = "Sour Soup";
	    String categoryExpected	 = "Breakfast";
		//actual
	    Recipe recipeActual = dao.getRecipeById(7);
	    String nameActual = "Sour Soup";
	    String categoryActual = "Breakfast";
		//testing
	    assertEquals(nameExpected, nameActual);
	    assertEquals(categoryExpected, categoryActual);
	
	}
	
	@Test
	public void testDeleteRecipe() {
		Recipe recipe = new Recipe();
        recipe.setName("Fried Chicken");
        recipe.setIngredients("1 kg chicken wings, 1 teaspoon salt");
        recipe.setDirections("Cook chicken first, then add salt");
        recipe.setTime("5 minutes");
        recipe.setDifficulty(3);
        recipe.setServings(5);
        recipe.setCategory("Breakfast");
        recipe.setImgpath("images\\fried.jpg");
        dao.addNewRecipe(recipe);
		dao.deleteRecipe(recipe);
		Recipe recipeActual = dao.getRecipeLastRecord();
		//testing
		assertNotEquals(recipe.getName(), recipeActual.getName());
        assertNotEquals(recipe.getIngredients(), recipeActual.getIngredients());
        assertNotEquals(recipe.getDirections(), recipeActual.getDirections());
        assertNotEquals(recipe.getTime(), recipeActual.getTime());
        assertNotEquals(recipe.getServings(), recipeActual.getServings());
        assertNotEquals(recipe.getCategory(), recipeActual.getCategory());
        assertNotEquals(recipe.getImgpath(), recipeActual.getImgpath());
	}
	
	@Test
	public void testUpdateRecipe() {
		Recipe recipe = new Recipe();
        recipe.setName("Fried Chicken");
        recipe.setIngredients("1 kg chicken wings, 1 teaspoon salt");
        recipe.setDirections("Cook chicken first, then add salt");
        recipe.setTime("5 minutes");
        recipe.setDifficulty(3);
        recipe.setServings(4);
        recipe.setCategory("Breakfast");
        recipe.setImgpath("images\\fried.jpg");
        dao.addNewRecipe(recipe);
        //expected
        recipe.setName("Fried Coconut");
        recipe.setIngredients("1 fresh coconut");
        recipe.setDirections("break the coconut with a sharp sword");
        recipe.setTime("7 minutes");
        recipe.setDifficulty(5);
        recipe.setServings(2);
        recipe.setCategory("Vegetarian");
        recipe.setImgpath("images\\coconut.jpg");
        dao.updateRecipe(recipe);
        //actual
        Recipe recipeActual = dao.getRecipeLastRecord();
		try {	
		//testing
		assertEquals(recipe.getName(), recipeActual.getName());
        assertEquals(recipe.getIngredients(), recipeActual.getIngredients());
        assertEquals(recipe.getDirections(), recipeActual.getDirections());
        assertEquals(recipe.getTime(), recipeActual.getTime());
        assertEquals(recipe.getServings(), recipeActual.getServings());
        assertEquals(recipe.getCategory(), recipeActual.getCategory());
        assertEquals(recipe.getImgpath(), recipeActual.getImgpath());
		} finally {
		dao.deleteRecipe(recipe);
		}
	}
	
	@Test
	public void testGetAdminLastRecord() {
		//expected
		Recipe recipe = new Recipe();
        recipe.setName("Fried Chicken");
        recipe.setIngredients("1 kg chicken wings, 1 teaspoon salt");
        recipe.setDirections("Cook chicken first, then add salt");
        recipe.setTime("5 minutes");
        recipe.setDifficulty(3);
        recipe.setServings(4);
        recipe.setCategory("Breakfast");
        recipe.setImgpath("images\\fried.jpg");
        dao.addNewRecipe(recipe);
		//actual
        Recipe recipeActual = dao.getRecipeLastRecord();
		try {	
		//testing
		assertEquals(recipe.getName(), recipeActual.getName());
        assertEquals(recipe.getIngredients(), recipeActual.getIngredients());
        assertEquals(recipe.getDirections(), recipeActual.getDirections());
        assertEquals(recipe.getTime(), recipeActual.getTime());
        assertEquals(recipe.getServings(), recipeActual.getServings());
        assertEquals(recipe.getCategory(), recipeActual.getCategory());
        assertEquals(recipe.getImgpath(), recipeActual.getImgpath());
		} finally {
		dao.deleteRecipe(recipe);
		}
	}

}
