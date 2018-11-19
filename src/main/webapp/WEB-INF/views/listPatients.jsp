<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  <%--Created by IntelliJ IDEA.--%>
  <%--User: maciej--%>
  <%--Date: 13.11.18--%>
  <%--Time: 13:45--%>
  <%--To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<html>--%>
<%--<head>--%>
    <%--<title>Title</title>--%>


    <%--<meta charset="utf-8">--%>
    <%--<meta http-equiv="X-UA-Compatible" content="IE=edge">--%>
    <%--<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">--%>
    <%--<meta name="description" content="">--%>
    <%--<meta name="author" content="">--%>

    <%--<!-- Bootstrap core CSS-->--%>
    <%--<link href="/resources/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">--%>

    <%--<!-- Custom fonts for this template-->--%>
    <%--<link href="/resources/vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">--%>

    <%--<!-- Page level plugin CSS-->--%>
    <%--<link href="/resources/vendor/datatables/dataTables.bootstrap4.css" rel="stylesheet">--%>

    <%--<!-- Custom styles for this template-->--%>
    <%--<link href="/resources/css/sb-admin.css" rel="stylesheet">--%>
<%--</head>--%>
<%--<body>--%>

<%--class="table table-striped table-bordered"--%>
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
            <th>Usuwanie</th>
            <th>Edycja</th>
            <th>Szczegóły</th>
        </tr>
        </thead>
            <tbody>
        <c:forEach items="${patients}" var="patient">
        <tr>
            <td>${patient.firstName}</td>
            <td>${patient.lastName}</td>
            <td>${patient.username}</td>
            <td>${patient.dateOfBirthString}</td>
            <td>${patient.pesel}</td>
            <td><a href="/doctor/deletePatient${patient.id}">usuń pacjenta</a></td>
            <td><a href="/doctor/updatePatient/${patient.id}">edytuj pacjenta</a></td>
            <td><a href="/doctor/patientDetails/${patient.id}">szczegóły pacjenta</a></td>
        </tr>
            <%--<a href="/bookform/confirmDel/${book.id}">usuń książkę</a> <a href="/bookform/update/${book.id}">edytuj książkę</a> <br>--%>
        </c:forEach>
            </tbody>
            </table>

        <a href="/doctor/addPatient">Dodaj pacjenta</a>

</div>

<jsp:include page="footer.jsp"/>

<%--</body>--%>
<%--</html>--%>
