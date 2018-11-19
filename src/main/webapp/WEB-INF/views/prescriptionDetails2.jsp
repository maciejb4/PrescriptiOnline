<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div id="content-wrapper">
    <form:form method="post" modelAttribute="prescription">
    <table id="example" class="table table-striped table-bordered" style="width:40%">
        <thead>
        <tr>
            <th>Nazwa leku</th>
            <th>Ilość substancji czynnej</th>
            <th>Dawkowanie</th>
            <th>Realizacja</th>
        </tr>
        </thead>

        <tbody>

        <tr>
            <td>${prescription.drugName}</td>
            <td>${prescription.drugQuantity}mg</td>
            <td>${prescription.drugDose}</td>
            <td>
            <form:checkbox path="filledIn"/> <br>
            </td>
        </tr>

        </tbody>

    </table>
    <button type="submit" class="btn btn-primary">Submit</button>
    </form:form>

    <a href="/pharmacist/findPatientsByPesel">Powrót</a>

<%--<a href="/doctor/patientDetails/${id}">Powrót</a>--%>

</div>

<jsp:include page="footer.jsp"/>