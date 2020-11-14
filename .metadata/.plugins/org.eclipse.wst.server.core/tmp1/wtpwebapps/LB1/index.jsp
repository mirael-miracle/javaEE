<%@ page language="java" contentType="text/html; charset=UTF-8"
                         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" 
                      "http://www.w3.org/TR/html4/loose.dtd">
<html>
   <head>
      <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
      <title>EJB 3.2</title>
   </head>
   <body>
       <h3>Enterprise JavaBeans 3</h3>
          <p>${answer}</p>
          <form action="hello" method="post">
              Введите имя : <input type="text" name="name" value=""/>
              <input type="submit" value="OK"/>
          </form>
   </body>
</html>