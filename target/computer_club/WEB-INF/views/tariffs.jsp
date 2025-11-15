<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Цены</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <main>
        <h1>Тарифы</h1>

        <div class="tariffs-list">
            <c:forEach var="tariff" items="${tariffs}">
                <div class="tariff-card">
                    <h3>${tariff.name}</h3>
                    <p class="price">${tariff.pricePerHour} руб/час</p>
                    <p class="description">${tariff.description}</p>
                </div>
            </c:forEach>
        </div>
    </main>

    <jsp:include page="footer.jsp"/>
</body>
</html>