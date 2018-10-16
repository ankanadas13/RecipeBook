package controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

/**
 * Servlet implementation class RecipeController
 */
@WebServlet(name="RecipeController",urlPatterns="/admin-panel/")
public class RecipeController extends HttpServlet {
	Part image;
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecipeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String pathValue = null;
		try {
			InputStream in = image.getInputStream();
			File f = new File(request.getServletContext().getRealPath("images/")+image.getSubmittedFileName());
			f.createNewFile();
			FileOutputStream out = new FileOutputStream(f);
			
			byte[] buffer = new byte[1024];
			int length;
			while ((length=in.read(buffer))>0){
				out.write(buffer, 0, length);
			}
			out.close();
			in.close();

			pathValue = "images\\"+image.getSubmittedFileName();
			System.out.println("upload success");
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
