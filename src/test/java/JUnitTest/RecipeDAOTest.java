package JUnitTest;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import dao.RecipeDAO;
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
		Recipe recipe = new Recipe();
		recipe.setName("Fried Chicken");
		recipe.setIngredients("1 kg chicken wings, 1 teaspoon salt");
		recipe.setDirections("Cook chicken first, then add salt");
		recipe.setTime("5 minutes");
		recipe.setDifficulty(3);
		recipe.setServings(4);
		recipe.setCategory("Breakfast");
		recipe.setImgpath("images\\fried.jpg");
		// expected
		String expectedName = recipe.getName();
		String expectedIngredients = recipe.getIngredients();
		String expectedDirections = recipe.getDirections();
		String expectedTime = recipe.getTime();
		int expectedDifficulty = recipe.getDifficulty();
		int expectedServings = recipe.getServings();
		String expectedCategory = recipe.getCategory();
		String expectedImgpath = recipe.getImgpath();
		dao.addNewRecipe(recipe);
		// actual
		Recipe recipeActual = dao.getRecipeLastRecord();
		String actualName = recipeActual.getName();
		String actualIngredients = recipeActual.getIngredients();
		String actualDirections = recipeActual.getDirections();
		String actualTime = recipeActual.getTime();
		int actualDifficulty = recipeActual.getDifficulty();
		int actualServings = recipeActual.getServings();
		String actualCategory = recipeActual.getCategory();
		String actualImgpath = recipeActual.getImgpath();
		try {
			// testing
			assertEquals(expectedName, actualName);
			assertEquals(expectedIngredients, actualIngredients);
			assertEquals(expectedDirections, actualDirections);
			assertEquals(expectedTime, actualTime);
			assertEquals(expectedDifficulty, actualDifficulty);
			assertEquals(expectedServings, actualServings);
			assertEquals(expectedCategory, actualCategory);
			assertEquals(expectedImgpath, actualImgpath);
		} finally {
			dao.deleteRecipe(recipe);
		}
	}

	@Test
	public void testGetAllRecipe() {
		List<Recipe> list = dao.getAllRecipe();
		// testing
		assertTrue(list.size() > 0);
		assertTrue(list.size() != 0);
		assertNotNull(list);
	}

	@Test
	public void testGetAllRecipeID() {
		List<Recipe> list = dao.getAllRecipeID();
		// testing
		assertTrue(list.size() > 0);
		assertFalse(list.size() == 0);
		assertNotNull(list);
	}

	@Test
	public void testGetRecipeByCategory() {
		String category = "Meat";
		List<Recipe> list = dao.getRecipeByCategory(category);
		// testing
		assertTrue(list.size() > 0);
		assertFalse(list.size() == 0);
		assertNotNull(list);
	}

	@Test
	public void testGetImageById() {
		// expected
		String imageExpected = "images\\chicken.jpg";
		// actual
		String imageActual = dao.getImageById(6);
		// testing
		assertTrue(imageActual != null);
		assertEquals(imageExpected, imageActual);
	}

	@Test
	public void testGetRecipeByID() {
		// expected
		String expectedName = "Sour Soup";
		String expectedIngredients ="1 piece of sweet corn.\r\n" + 
									"20 items of melinjo.\r\n" + 
									"1 cabbage.\r\n" + 
									"5 long beans.\r\n" + 
									"3 Beans.\r\n" + 
									"2 bay leaves.\r\n" + 
									"2 tablespoons of brown sugar.\r\n" + 
									"1 galangal finger segment.";
		String expectedDirections = "The first step is to mix the vegetables to be mixed, then wash thoroughly.\r\n" + 
									"Then prepare the layah and seasoning until smooth.\r\n" + 
									"Next prepare a pan for cooking. Fill the water and bring to a boil, then add the spices, then the ingredients. Cover and cook over medium heat.\r\n" + 
									"Afterwards, taste the taste, add spices which according to recipe friends are lacking.\r\n" + 
									"Lift serve.\r\n" + 
									"";
		String expectedTime = "23 minutes";
		int expectedDifficulty = 3;
		int expectedServings = 1;
		String expectedCategory = "Breakfast";
		String expectedImgpath = "images\\hot.jpg";
		
		// actual
		Recipe recipeActual = dao.getRecipeById(7);
		String actualName = recipeActual.getName();
		String actualIngredients = recipeActual.getIngredients();
		String actualDirections = recipeActual.getDirections();
		String actualTime = recipeActual.getTime();
		int actualDifficulty = recipeActual.getDifficulty();
		int actualServings = recipeActual.getServings();
		String actualCategory = recipeActual.getCategory();
		String actualImgpath = recipeActual.getImgpath();
		// testing
		assertEquals(expectedName, actualName);
		assertEquals(expectedIngredients, actualIngredients);
		assertEquals(expectedDirections, actualDirections);
		assertEquals(expectedTime, actualTime);
		assertEquals(expectedDifficulty, actualDifficulty);
		assertEquals(expectedServings, actualServings);
		assertEquals(expectedCategory, actualCategory);
		assertEquals(expectedImgpath, actualImgpath);
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
		// testing
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
		// expected
		recipe.setName("Fried Coconut");
		recipe.setIngredients("1 fresh coconut");
		recipe.setDirections("break the coconut with a sharp sword");
		recipe.setTime("7 minutes");
		recipe.setDifficulty(5);
		recipe.setServings(2);
		recipe.setCategory("Vegetarian");
		recipe.setImgpath("images\\coconut.jpg");
		dao.updateRecipe(recipe);
		// actual
		Recipe recipeActual = dao.getRecipeLastRecord();
		try {
			// testing
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
		// expected
		Recipe recipe = new Recipe();
		recipe.setName("Fried Chicken");
		recipe.setIngredients("1 kg chicken wings, 1 teaspoon salt");
		recipe.setDirections("Cook chicken first, then add salt");
		recipe.setTime("5 minutes");
		recipe.setDifficulty(3);
		recipe.setServings(4);
		recipe.setCategory("Breakfast");
		recipe.setImgpath("images\\fried.jpg");
		
		String expectedName = recipe.getName();
		String expectedIngredients = recipe.getIngredients();
		String expectedDirections = recipe.getDirections();
		String expectedTime = recipe.getTime();
		int expectedDifficulty = recipe.getDifficulty();
		int expectedServings = recipe.getServings();
		String expectedCategory = recipe.getCategory();
		String expectedImgpath = recipe.getImgpath();
		dao.addNewRecipe(recipe);
		// actual
		Recipe recipeActual = dao.getRecipeLastRecord();
		String actualName = recipeActual.getName();
		String actualIngredients = recipeActual.getIngredients();
		String actualDirections = recipeActual.getDirections();
		String actualTime = recipeActual.getTime();
		int actualDifficulty = recipeActual.getDifficulty();
		int actualServings = recipeActual.getServings();
		String actualCategory = recipeActual.getCategory();
		String actualImgpath = recipeActual.getImgpath();
		try {
			// testing
			assertEquals(expectedName, actualName);
			assertEquals(expectedIngredients, actualIngredients);
			assertEquals(expectedDirections, actualDirections);
			assertEquals(expectedTime, actualTime);
			assertEquals(expectedDifficulty, actualDifficulty);
			assertEquals(expectedServings, actualServings);
			assertEquals(expectedCategory, actualCategory);
			assertEquals(expectedImgpath, actualImgpath);
		} finally {
			dao.deleteRecipe(recipe);
		}
	}

}
