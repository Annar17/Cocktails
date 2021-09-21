package mainpackage;

import mainpackage.datapackage.Cocktails;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.io.InputStream;

/**
 * Servlet implementation class mainpackage.CocktailServlet
 */
@MultipartConfig
@WebServlet("/DeleteCocktailServlet")
public class DeleteCocktailServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteCocktailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        //String taste = request.getParameter("Taste");
        String name = request.getParameter("DrinkName");
        //String image = request.getParameter("Image");

        Cocktails cocktail = new Cocktails(name, "", "", "", "", "");

        DatabaseProcedures dP = new DatabaseProcedures();
        String result = dP.deleteCocktail(cocktail);
        response.setContentType("text/plain");
        response.getWriter().print(result);
        response.setHeader("Refresh", "3;url=admin_drink_page.jsp");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
