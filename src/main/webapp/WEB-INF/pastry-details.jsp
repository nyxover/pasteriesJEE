<%--
  Created by IntelliJ IDEA.
  User: buire
  Date: 25/01/2023
  Time: 13:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <title>Pastry details</title>
</head>
<body>
<div class="container">

  <div class="row">
    <div class="col-8 offset-2">
      <h1>Pastry Détail</h1>
      <div class="card mt-3 text-black">
        <img src="https://sauvageboris.fr/training/api/pastries/images/${pastry.img}">
        <div class="card-body">
          <p class="card-title ws-bold">${pastry.name}</p>
          <p class="card-text"> ${pastry.description}</p>
          <a class="btn btn-primary" href="${pageContext.request.contextPath}/pastry-list/edit?id=${pastry.id}">Edit</a>
          <form class="text-end m-0" method="post" action="${pageContext.request.contextPath}/pastry-list/delete">
            <input type="hidden" value="${pastry.id}" name="idPastry">
            <button class="btn btn-danger">Delete</button>
          </form>
          <a href="${pageContext.request.contextPath}/pastry-list">Retour</a>
        </div>

      </div>
    </div>
  </div>
</body>
</html>
