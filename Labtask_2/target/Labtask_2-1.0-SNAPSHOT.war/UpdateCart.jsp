<%@ page import="newpack.CartValues_1" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: FAHIM
  Date: 2/12/2023
  Time: 4:57 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <title>Print ArrayList of Items</title>
</head>
<body>
<h2>List of Items</h2>
<p>Please select the checkbox the item you want to delete</p>
<table>
  <tr>
    <th>Item Name</th>
    <th>Item Quantity</th>
  </tr>
  <form name="itemsUpdate" method="post" action="updatecartservlet">
    <%
      ArrayList<CartValues_1> items = (ArrayList<CartValues_1>) request.getSession().getAttribute("shoppingcart");
      for (CartValues_1 item : items) {
    %>
    <tr>
      <td><input type="checkbox" name="itemName" value=<%= item.getItemName() %>><%= item.getItemName() %></td>
      <td><%= item.getQuantity() %></td>
    </tr>
    <%
      }
    %>
    <tr>
      <td><input type="submit" value="delete"></td>
    </tr>
  </form>
</table>
</body>
</html>