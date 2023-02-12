
import newpack.CartValues_1;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
 class CartValues{
    String itemName=new String();
    Integer quantity=null;
    CartValues(String itemName,Integer quantity){
        this.itemName=itemName;
        this.quantity=quantity;
    }
    String getItemName(){
        return this.itemName;
    }
    Integer getQuantity(){
        return  this.quantity;
    }
}


public class ShoppingCart extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();

        String itemName[]=null;

        if(req.getParameterValues("itemName")!=null) {
            itemName = req.getParameterValues("itemName");
        }
        ArrayList<CartValues_1> shoppingCart=null;
        if(req.getSession().getAttribute("shoppingcart")!=null){
            shoppingCart=(ArrayList<CartValues_1>)req.getSession().getAttribute("shoppingcart");
            req.getSession().removeAttribute("shoppingcart");
        }else{
            shoppingCart=new ArrayList<>();
        }
        for(int i = 0; itemName!=null && i < itemName.length ; i++){
            System.out.println(req.getParameter(itemName[i]));
            CartValues_1 newCart=new CartValues_1(itemName[i],Integer.valueOf(req.getParameter(itemName[i])));
            Boolean flag=true;
            if(shoppingCart!=null){
                for(CartValues_1 c:shoppingCart){
                    if(c.getItemName().equals(newCart.getItemName())){
                        flag=false;
                        break;
                    }
                }
                if(flag) {
                    shoppingCart.add(newCart);
                }
            }else {
                shoppingCart.add(newCart);
            }
        }
        session.setAttribute("shoppingcart",shoppingCart);


        RequestDispatcher rd=req.getRequestDispatcher("/loginsucessServlet");
        rd.forward(req,resp);
    }
}
