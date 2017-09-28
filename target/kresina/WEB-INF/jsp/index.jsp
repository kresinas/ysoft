<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html lang="cs">
<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/bootstrap.min.css">
</head>
<body>
<div class="m-5">
    <h1>YSoft homework Křesina</h1>
    <form action="post" method="post">
        <div class="form-group">
            <label for="message">Vlož your text :)</label>
            <textarea class="form-control" id="message" rows="5" name="message">${message}</textarea>

            <br>
            <label for="coder">Vyber kódování</label> <br>
            <c:forEach var="code" items="${cryptorNamesList}" varStatus="status">
                <input type="radio" name="coder" id="coder" value="${code}" <c:if test="${status.count == '1'}"> checked="checked" </c:if> > ${code} <br>
            </c:forEach>
        </div>
        <button type="submit" class="btn btn-primary" name="submitButton" value="Encrypt">Encrypt</button>
        <button type="submit" class="btn btn-primary" name="submitButton" value="Decrypt">Decrypt</button>
    </form>
</div>
<div class="m-5">
    <p class="font-weight-bold"> ${encrypted} </p>
</div>

<script src="script/jquery-3.2.1.slim.min.js"/>
<script src="script/popper.min.js"/>
<script src="script/bootstrap.min.js"/>
</body>
</html>