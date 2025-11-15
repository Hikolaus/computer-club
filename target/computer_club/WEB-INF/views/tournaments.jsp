<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Турниры</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <main>
        <h1>Турниры</h1>

        <div class="tournaments-container">
            <c:forEach var="tournament" items="${tournaments}">
                <div class="tournament-item">
                    <div class="tournament-header">
                        <span class="status">${tournament.status}</span>
                        <h3>${tournament.title}</h3>
                    </div>

                    <div class="tournament-info">
                        <p>${tournament.description}</p>
                        <p><strong>Дата:</strong> ${tournament.dateTime}</p>
                        <p><strong>Призовой фонд:</strong> ${tournament.prizeFund} руб</p>
                        <p><strong>Участников:</strong> ${tournament.participantsCount}</p>
                    </div>

                    <div class="tournament-actions">
                        <c:choose>
                            <c:when test="${tournament.status == 'завершён'}">
                                <a href="<c:url value='/tournament/results?id=${tournament.id}'/>">Результаты</a>
                            </c:when>
                            <c:when test="${tournament.status == 'опубликован'}">
                                <a href="<c:url value='/tournament/bracket?id=${tournament.id}'/>">Смотреть сетку</a>
                                <a href="<c:url value='/tournament/join?id=${tournament.id}'/>">Участвовать</a>
                            </c:when>
                            <c:when test="${tournament.status == 'черновик'}">
                                <span>Турнир в подготовке</span>
                            </c:when>
                        </c:choose>
                    </div>
                </div>
            </c:forEach>
        </div>
    </main>

    <jsp:include page="footer.jsp"/>
</body>
</html>