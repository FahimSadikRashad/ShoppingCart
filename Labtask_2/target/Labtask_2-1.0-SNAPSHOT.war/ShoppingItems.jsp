<%--
  Created by IntelliJ IDEA.
  User: FAHIM
  Date: 2/12/2023
  Time: 1:28 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Shopping Item</title>
</head>
<body>
<h1>Your name is</h1>
<%=request.getSession().getAttribute("userName") %><br>

<h1>The shopping list is:</h1>
<span>Please note that : <bold>You have to tick the checkbox to add items and quantity</bold></span>
<form name="items" method="post" action="shoppingcart">
    <input type="checkbox" name="itemName" value="item1">item1 <input id="item1" name="item1" type="number" min="0" value="0"/><br>
    <input type="checkbox" name="itemName" value="item2">item2 <input id="item2" name="item2" type="number" min="0" value="0"/><br>
    <input type="checkbox" name="itemName" value="item3">item3 <input id="item3" name="item3" type="number" min="0" value="0"/><br>
    <input type="submit" value="add">
</form>
<h1>Your choices are: </h1>
<a href="ViewCart.jsp">View Cart</a><br>
<a href="UpdateCart.jsp">Delete items</a><br>
<a href="UpadateQuantity.jsp">Update Cart</a>

</body>
</html>
