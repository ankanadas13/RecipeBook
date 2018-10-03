package dao;

import java.io.File;
import java.io.FileInputStream;
import java.util.Formatter;
import java.util.List;
import java.util.Random;

import pojo.Admin;
import pojo.Recipe;

public class testapp {

	public static void main(String[] args) {
		
//		Recipe recipe = new Recipe();
//		Random r = new Random();
//		RecipeDAO dao =new RecipeDAO();
//		List<Recipe> list = recipe.getAllRecipe();
//		for (Recipe recipe2 : list) {
//			recipe2.setIdadmin(r.nextInt(18 + 1 - 15) + 15);
//			dao.updateRecipe(recipe2);
//		}
		
//		Random r = new Random();
//		String[] n1 = {"Steve","Richard","Hillary","Jimmy","Hemorna","Sarah","Charly"};
//		String[] n2 = {"Bernad","Rocky","Billy","Jim","Grock","Queen","King","Gavin","Torvalds"};
//		for (int i = 1; i < 11; i++) {
//			String firstname = n1[r.nextInt(n1.length)];
//			String lastname = n2[r.nextInt(n2.length)];
//			Admin admin = new Admin();
//			admin.setFullname(firstname+" "+lastname);
//			admin.setUsername("root"+i);
//			admin.setPassword("root"+i);
//			admin.setTemppassword("root"+i);
//			admin.setEmail(firstname+lastname+"@recipebook.com");
//			admin.setStatus("Aktif");
//			admin.addNewAdmin();
//		}
		
		Recipe recipe = new Recipe();
		List<Recipe> recipes = recipe.getAllRecipe();
		for (Recipe recipe2 : recipes) {
			System.out.println(recipe2);
		}
	}

}
