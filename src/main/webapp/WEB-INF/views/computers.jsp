<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Компьютеры</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <main>
        <h1>Список компьютеров</h1>

        <table border="1">
            <thead>
                <tr>
                    <th>Название</th>
                    <th>CPU</th>
                    <th>GPU</th>
                    <th>RAM</th>
                    <th>Статус</th>
                    <th>Цена/час</th>
                    <th>Действия</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="computer" items="${computers}">
                    <tr>
                        <td>${computer.name}</td>
                        <td>${computer.cpu}</td>
                        <td>${computer.gpu}</td>
                        <td>${computer.ram} GB</td>
                        <td>
                            <c:choose>
                                <c:when test="${computer.status == 'свободен'}">
                                    <span style="color: green;">Свободен</span>
                                </c:when>
                                <c:when test="${computer.status == 'занят'}">
                                    <span style="color: red;">Занят</span>
                                </c:when>
                                <c:otherwise>
                                    <span style="color: orange;">${computer.status}</span>
                                </c:otherwise>
                            </c:choose>
                        </td>
                        <td>${computer.pricePerHour} руб</td>
                        <td>
                            <c:if test="${computer.status == 'свободен'}">
                                <a href="<c:url value='/book?computerId=${computer.id}'/>">Забронировать</a>
                            </c:if>
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

        <section>
            <h2>Карта всех ПК</h2>
            <div class="computers-map">
                <c:forEach var="computer" items="${computers}" varStatus="status">
                    <div class="computer-slot">
                        <strong>${computer.name}</strong>
                        <p>${computer.pricePerHour} руб/час</p>
                        <p>
                            <c:choose>
                                <c:when test="${computer.status == 'свободен'}">
                                    <span style="color: green;">✓</span>
                                </c:when>
                                <c:otherwise>
                                    <span style="color: red;">✗</span>
                                </c:otherwise>
                            </c:choose>
                        </p>
                    </div>
                </c:forEach>
            </div>
        </section>
    </main>

    <jsp:include page="footer.jsp"/>
</body>
</html>