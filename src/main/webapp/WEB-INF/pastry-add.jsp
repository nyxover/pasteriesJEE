<%--
  Created by IntelliJ IDEA.
  User: buire
  Date: 25/01/2023
  Time: 11:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
  <title>Add Pastry</title>
</head>
<body>
<div class="container">

  <div class="row text-center">
    <h1 class="h3 mb-3 font-weight-normal">Add Pastry</h1>
  </div>

  <div class="row">
    <div class="col-8 offset-2 mt-3">
      <div class="card">
        <div class="card-body text-dark">
          <form action="${pageContext.request.contextPath}/pastry-list/add" method="post">
            <div class="mb-3">
              <label for="pastryName">Name</label>
              <input id="pastryName" type="text" name="pastryName" class="form-control">
            </div>

            <div class="mb-3">
              <label for="pastryDescription">Description</label>
              <textarea id="pastryDescription" type="text" name="pastryDescription"
                        class="form-control"></textarea>
            </div>

            <div class="mb-3 text-end">
              <button type="submit" class="btn btn-primary">Add</button>
            </div>
          </form>
        </div>
      </div>
    </div>
  </div>
</div>
</div>
</body>
</html>
