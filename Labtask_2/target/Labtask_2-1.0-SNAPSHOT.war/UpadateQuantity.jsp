<%@ page import="newpack.CartValues_1" %>
<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: FAHIM
  Date: 2/12/2023
  Time: 6:27 PM
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
<p>Please note to select the checkbox if you update the quantity</p>
<table>
  <tr>
    <th>Item Name</th>
    <th>Item Quantity</th>
  </tr>
  <form name="items" method="post" action="quantityupdate">
    <%
      ArrayList<CartValues_1> items = (ArrayList<CartValues_1>) request.getSession().getAttribute("shoppingcart");
      for (CartValues_1 item : items) {
    %>
    <tr>
      <td><input type="checkbox" name="itemName" value=<%= item.getItemName() %>><%= item.getItemName() %></td>
      <td><input id="item1" type="number" value=<%= item.getQuantity() %> name=<%= item.getItemName() %> /></td>
    </tr>
    <%
      }
    %>
    <tr>
      <td><input type="submit" value="update"></td>
    </tr>
  </form>
</table>
</body>
</html>
