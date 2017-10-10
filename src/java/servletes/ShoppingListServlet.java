package servletes;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import sait.domainmodel.User;

public class ShoppingListServlet extends HttpServlet 
{
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();  
        String username = (String) session.getAttribute("username");
        
        if(action == null)
        {
            if(username == null)
            {
                getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
                return;
            }
            else
            {
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
                //TODO check session to see if there a itemlist , if yes display
            }
        }
        if(action.equals("logout"))
        {          
            session.removeAttribute("user");
            request.setAttribute("message", "You have successfuly logged out.");
            getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
            return;
        } 
           
        getServletContext().getRequestDispatcher("/WEB-INF/register.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String action = request.getParameter("action");
        HttpSession session = request.getSession();
        
        //User user = (User) session.getAttribute("user");  
        //session.setAttribute("user", user); 
        
        
        
        if (action.equals("register"))
        {   
            String username = request.getParameter("username");
            session.setAttribute("username", username); 
            //TODO get username, redirect to home
            response.sendRedirect("home");
            //getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);            
        }
    }

}
