<%@ page import="java.util.ArrayList" %>
<%@ page import="newpack.CartValues_1" %>
<%--

  Created by IntelliJ IDEA.
  User: FAHIM
  Date: 2/12/2023
  Time: 1:15 PM
  To change this template use File | Settings | File Templates.
--%>
<%--<%@ tag import="src/main/java/ShoppingCart.java" %>--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Print ArrayList of Items</title>
</head>
<body>
<h2>List of Items</h2>
<table>
    <tr>
        <th>Item Name</th>
        <th>Item Quantity</th>
    </tr>
    <form name="items" method="post" action="shoppingcart">
    <%
        ArrayList<CartValues_1> items = (ArrayList<CartValues_1>) request.getSession().getAttribute("shoppingcart");
        for (CartValues_1 item : items) {
    %>
    <tr>
        <td><%= item.getItemName() %></td>
        <td><%= item.getQuantity() %></td>
    </tr>
    <%
        }
    %>
     <tr>
        <td><input type="submit" value="ok"></td>
     </tr>
    </form>
</table>
</body>
</html>

