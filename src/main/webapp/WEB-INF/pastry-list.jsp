<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Pastry list</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD" crossorigin="anonymous">
    <link href="<c:url value="/assets/css/style.css" />" rel="stylesheet" type="text/css">

</head>
<body>


    <a class="btn btn-primary" href="${pageContext.request.contextPath}/pastry-list/add">+</a>
<c:forEach items="${pastries}" var="pastry">

    <div class="card mb-3" style="max-width: 540px;">
    <div class="row g-0">
        <div class="col-md-4">
            <img src="https://sauvageboris.fr/training/api/pastries/images/${pastry.img}" class="img-fluid rounded-start" alt="...">
        </div>
        <div class="col-md-8">
            <div class="card-body">
                <h5 class="card-title">${pastry.name}</h5>
                <p>${pastry.id}</p>
                <p class="card-text">${pastry.description}</p>
                <p class="card-text"><small class="text-muted">Last updated 3 mins ago</small></p>



                <div class="button-group">
                    <a class="btn btn-primary" href="${pageContext.request.contextPath}/pastry-list/edit?id=${pastry.id}">Edit</a>
                    <form method="post" action="${pageContext.request.contextPath}/pastry-list/delete">
                        <input type="hidden" value="${pastry.id}" name="idPastry">
                        <button class="btn btn-danger btn-size">Delete</button>
                    </form>
                    <a class="btn btn-success" href="${pageContext.request.contextPath}/pastry-list/details?id=${pastry.id}">Détails</a>
                </div>
            </div>
        </div>
    </div>
</div>


    </c:forEach>



</body>
</html>
