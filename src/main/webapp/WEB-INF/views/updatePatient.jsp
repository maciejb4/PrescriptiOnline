<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: maciej
  Date: 14.11.18
  Time: 09:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>
<div id="content-wrapper">

    <h1>Edytuj pacjenta</h1>
    <form:form method="post"
               modelAttribute="user">
        <div class="form-group">
            <form:hidden  path="id" />
            <label for="firstName">Imię:</label>
            <form:input path="firstName" class="form-control col-md-6"/><br>
            <label for="lastName">Nazwisko:</label>
            <form:input path="lastName" class="form-control col-md-6"/><br>
            <label for="username">Nazwa użytkownika:</label>
            <form:input path="username" class="form-control col-md-6"/><br>
            <label for="dateOfBirthString">Data urodzenia:</label>
            <form:input type="date" path="dateOfBirthString"  class="form-control col-md-6"/><br>
            <label for="pesel">PESEL:</label>
            <form:input path="pesel" class="form-control col-md-6"/><br>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>

    <a href="/doctor/listPatients">Powrót</a>
</div>



<jsp:include page="footer.jsp"/>