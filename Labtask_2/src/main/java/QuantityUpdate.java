import newpack.CartValues_1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class QuantityUpdate extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        String itemName[]=null;

        if(req.getParameterValues("itemName")!=null) {
            itemName = req.getParameterValues("itemName");
        }
        ArrayList<CartValues_1> shoppingCart=null;
        if(session.getAttribute("shoppingcart")!=null && itemName!=null) {
            shoppingCart= (ArrayList<CartValues_1>) session.getAttribute("shoppingcart");
            for(int i=0;i< itemName.length;i++){
                CartValues_1 cartValues1=null;
                for(CartValues_1 c: shoppingCart){
                    if(c.getItemName().equals(itemName[i])){
                        cartValues1=c;
                        break;
                    }
                }
                shoppingCart.remove(cartValues1);
                cartValues1.setQuantity(Integer.valueOf(req.getParameter(itemName[i])));
                shoppingCart.add(cartValues1);
            }
        }
        if(req.getSession().getAttribute("shoppingcart")!=null && itemName!=null){
            req.getSession().removeAttribute("shoppingcart");
        }
        if(itemName!=null)
            session.setAttribute("shoppingcart",shoppingCart);

        RequestDispatcher rd=req.getRequestDispatcher("/loginsucessServlet");
        rd.forward(req,resp);

    }
}
