<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<jsp:include page="header.jsp"/>

<div id="content-wrapper">

    <table id="example" class="table table-striped table-bordered" style="width:40%">
        <thead>
        <tr>
            <th>Imię</th>
            <th>Nazwisko</th>
            <th>Nazwa użytkownika</th>
            <th>Data urodzenia</th>
            <th>PESEL</th>
            <th>Recepty</th>
        </tr>
        </thead>

        <tbody>

        <tr>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td>${user.username}</td>
            <td>${user.dateOfBirthString}</td>
            <td>${user.pesel}</td>
            <td>
            <c:forEach items="${user.prescriptions}" var="prescription">
                <a href="/doctor/prescriptionDetails/${prescription.id}">${prescription.drugName}</a><br>
            </c:forEach>
            </td>
        </tr>

        </tbody>

    </table>

    <a href="/doctor/prescriptionAdd/${user.id}">Dodaj receptę</a><br>


    <a href="/doctor/listPatients">Powrót</a>

</div>


<jsp:include page="footer.jsp"/>

