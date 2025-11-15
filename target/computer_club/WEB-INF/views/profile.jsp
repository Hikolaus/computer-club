<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Профиль</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <main>
        <h1>Профиль пользователя</h1>

        <section>
            <h2>Активные сеансы</h2>
            <c:choose>
                <c:when test="${not empty activeSessions}">
                    <c:forEach var="session" items="${activeSessions}">
                        <div class="active-session">
                            <p><strong>Компьютер:</strong> ${session.computerName}</p>
                            <p><strong>Начало:</strong>
                                <fmt:formatDate value="${session.actualStart}" pattern="dd.MM.yyyy HH:mm"/>
                            </p>
                            <p><strong>Стоимость:</strong> ${session.finalCost} руб</p>
                            <div class="session-actions">
                                <a href="<c:url value='/session/extend?id=${session.id}'/>">Продлить</a>
                                <a href="<c:url value='/session/end?id=${session.id}'/>">Завершить</a>
                            </div>
                        </div>
                    </c:forEach>
                </c:when>
                <c:otherwise>
                    <p>Нет активных сеансов</p>
                </c:otherwise>
            </c:choose>
        </section>

        <section>
            <h2>История сеансов</h2>
            <c:if test="${not empty sessions}">
                <table border="1">
                    <thead>
                        <tr>
                            <th>Компьютер</th>
                            <th>Начало</th>
                            <th>Конец</th>
                            <th>Длительность</th>
                            <th>Стоимость</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="session" items="${sessions}">
                            <tr>
                                <td>${session.computerName}</td>
                                <td>
                                    <fmt:formatDate value="${session.actualStart}" pattern="dd.MM.yyyy HH:mm"/>
                                </td>
                                <td>
                                    <c:if test="${not empty session.actualEnd}">
                                        <fmt:formatDate value="${session.actualEnd}" pattern="dd.MM.yyyy HH:mm"/>
                                    </c:if>
                                </td>
                                <td>${session.duration}</td>
                                <td>${session.finalCost} руб</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </c:if>
        </section>

        <section>
            <h2>Личные данные</h2>
            <div class="user-info">
                <p><strong>Имя:</strong> ${user.name}</p>
                <p><strong>Email:</strong> ${user.email}</p>
                <p><strong>Роль:</strong> ${user.role}</p>
                <p><strong>Дата регистрации:</strong>
                    <fmt:formatDate value="${user.dateRegistered}" pattern="dd.MM.yyyy"/>
                </p>
                <c:if test="${not empty wallet}">
                    <p><strong>Баланс:</strong> ${wallet.balance} ${wallet.currency}</p>
                </c:if>
                <a href="<c:url value='/profile/edit'/>">Редактировать</a>
            </div>
        </section>
    </main>

    <jsp:include page="footer.jsp"/>
</body>
</html>