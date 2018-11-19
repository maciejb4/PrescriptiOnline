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

    <h1>Wyszukaj pacjenta</h1>
    <form:form method="post"
               modelAttribute="user">
        <div class="form-group">
            <label for="pesel">PESEL pacjenta:</label>
            <form:input path="pesel" class="form-control col-md-6"/><br>
            Np: 92112904879<br>
            Np: 92141201132
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>

    <a href="/">Powrót</a>

</div>

<jsp:include page="footer.jsp"/>