package mainpackage;

import mainpackage.datapackage.Cocktails;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class mainpackage.CocktailServlet
 */
@WebServlet("/DrinkServlet")
public class DrinkServlet extends HttpServlet {

    /**
     * @see HttpServlet#HttpServlet()
     */
    public DrinkServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        HttpSession session = request.getSession(true);
        DatabaseProcedures dP = new DatabaseProcedures();

        String base = request.getParameter("Base");
        List<Cocktails> cocktailsList = dP.getCocktails(base);

        request.setAttribute("cocktailsList", cocktailsList);
        request.setAttribute("Base", base);
        request.getRequestDispatcher("drinks_page.jsp").forward(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
