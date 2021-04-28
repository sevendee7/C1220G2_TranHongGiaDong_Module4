<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
  </head>
  <body>
    <h2>Sandwich Condiments</h2>
    <form action="/result">
      <input type="checkbox" id="lettuce" name="lettuce" value="lettuce"/>
      <label for="lettuce">Lettuce</label>
      <input type="checkbox" id="tomato" name="tomato" value="tomato"/>
      <label for="tomato">Tomato</label>
      <input type="checkbox" id="mustard" name="mustard" value="mustard"/>
      <label for="mustard">Mustard</label>
      <input type="checkbox" id="sprouts" name="sprouts" value="sprouts"/>
      <label for="sprouts">Sprouts</label>
      <input type="submit" value="Save"/>
    </form>
  </body>
</html>
