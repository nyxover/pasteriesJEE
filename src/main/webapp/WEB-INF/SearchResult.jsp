<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>searchResult</title>
</head>
<body>

<!--  search bar  -->
<div id = "searchblock">
  <form action = "search" method = "POST">
    <input class ="searchbar" placeholder="Search by title" name = "title">
    <input type = "submit" class = "submitbutton" id = "searchbutton" value = "Enter">
  </form>

  <a id = "showallbookstext" href="pastry-list">
    Show All Books
  </a>
</div>

<!--  search result text -->
<div class = "subsection" style = "margin: 20px 15%; font-size: 30px; color: black;">
  Search Result:
</div>

<!-- search results -->

<c:forEach items = "${searchResult}" var = "pastry">
  <div class = "searchresultblock">
    <img class = "pastrythumbnail" src = "https://sauvageboris.fr/training/api/pastries/images/${pastry.img}"></img>
    <div class = "pastrydetails">
      <p> nom: ${pastry.name} </p>
      <p> description: ${pastry.description} </p>
    </div>
    <div class = "pastryopt">
      <div>
        <div>

        </div>
      </div>
    </div>
  </div>
</c:forEach>


</body>
</html>
