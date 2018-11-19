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

    <h1>Dodaj nową receptę</h1>
    <form:form method="post"
               modelAttribute="prescription">
        <div class="form-group">
            <label for="drugs">Nazwa leku:</label>
            <form:select path="drugs" items="${drugs}" itemLabel="drug_name" itemValue="id" multiple="false"/><br>
            <label for="drugQuantity">Ilość substancji czynnej (w mg):</label>
            <form:input path="drugQuantity" class="form-control col-md-6"/><br>
            <label for="drugDose">Dawkowanie:</label>
            <form:input path="drugDose" class="form-control col-md-6"/><br>
        </div>
        <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>

    <a href="/doctor/patientDetails/${id}">Powrót</a>

</div>

<jsp:include page="footer.jsp"/>
