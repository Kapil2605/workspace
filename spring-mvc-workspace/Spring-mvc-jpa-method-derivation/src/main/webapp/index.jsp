<html>
<body>
<h2>Hello World!</h2>

<form action="get-by-name" method="get">
Enter Product Name:<input type="text" name="name"/>
<input type="submit" value="Submit it"/>
</form>



<br><br>
<form action="searchByPriceRange" method="get">
Enter Product Price1:<input type="text" name="price1"/>
Enter Product Price2:<input type="text" name="price2"/>
<input type="submit" value="Search by Price Range"/>
</form>


<form action="searchByPriceAndStock" method="get">
Enter Product Price:<input type="text" name="price"/>
Enter Product Stock_quantity:<input type="text" name="stockQuantity"/>
<input type="submit" value="Search by Price and qty"/>
</form>

</body>
</html>
