<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        <p>
            Hello, ${username} <a href="shoppingList">Logout</a>
        </p>
        <h1>List</h1>
        <form action="" method="post">           
            Add item: <input type="text" name="item"/>
            <input type="submit" value="Register name" />
        </form>
    </body>
</html>

