package servletes;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import static java.util.Collections.list;
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
        ArrayList<String> listItems;
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
                listItems = (ArrayList<String>) session.getAttribute("listItems");  
                
                if(listItems != null)
                {
                    int listSize = listItems.size();
                    request.setAttribute("listSize", listSize);
                    
                    request.setAttribute("listItems", listItems);
                    session.setAttribute("listItems", listItems);
                }
                else
                {
                    request.setAttribute("listsize", 0);
                }
                getServletContext().getRequestDispatcher("/WEB-INF/shoppingList.jsp").forward(request, response);
            }
        }
        
        if(action.equals("logout"))
        {          
            session.removeAttribute("username");
            session.removeAttribute("listItems");
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
        //Array List for the items created 
        ArrayList<String> listItems = (ArrayList<String>) session.getAttribute("listItems");  
        //check if the item list is empty
        if(listItems == null)
        {
            listItems = new ArrayList<String>();
        }
        
        if (action.equals("register"))
        {   
            String username = request.getParameter("username");
            session.setAttribute("username", username);
            //TODO get username, redirect to home
            response.sendRedirect("home");           
        }
        if(action.equals("add"))
        {
           // String username = (String) session.getAttribute("username");
            String item = request.getParameter("item");
            //add the items
            listItems.add(item);
            // set the session 
            session.setAttribute("listItems", listItems); 
            response.sendRedirect("home");  
            return;
        }
        if(action.equals("delete"))
        {     
            //get the item to be deleted
            String deleteItem = request.getParameter("deleteItem");
            //index of the item is coming from the delete item parameter
            int itemIndex = Integer.parseInt(deleteItem);
            //remove the item from the list
            listItems.remove(itemIndex);
            response.sendRedirect("home"); 
        }
    }

}
