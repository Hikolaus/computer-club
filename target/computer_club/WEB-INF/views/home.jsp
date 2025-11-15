<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Компьютерный клуб</title>
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css">
</head>
<body>
    <%-- Используем общий header вместо дублирующего кода --%>
    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <main>
        <section class="hero">
            <h1>Добро пожаловать в компьютерный клуб</h1>
            <p>Лучшее место для игр и работы</p>
        </section>

        <section class="available-computers">
            <h2>Доступные компьютеры</h2>
            <div class="computers-grid">
                <c:forEach var="computer" items="${computers}">
                    <div class="computer-card">
                        <h3>${computer.name}</h3>
                        <p>CPU: ${computer.cpu}</p>
                        <p>GPU: ${computer.gpu}</p>
                        <p>RAM: ${computer.ram} ГБ</p>
                        <p class="price">${computer.pricePerHour} руб/час</p>
                        <c:if test="${computer.status == 'свободен'}">
                            <a href="<c:url value='/book?computerId=${computer.id}'/>" class="btn-book">Забронировать</a>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </section>

        <section class="tournaments">
            <h2>Ближайшие турниры</h2>
            <div class="tournaments-list">
                <c:forEach var="tournament" items="${tournaments}">
                    <div class="tournament-card">
                        <h3>${tournament.title}</h3>
                        <p>${tournament.description}</p>
                        <p>Призовой фонд: ${tournament.prizeFund} руб</p>
                        <p>Дата: ${tournament.dateTime}</p>
                        <c:if test="${tournament.status == 'опубликован'}">
                            <a href="<c:url value='/tournament/join?id=${tournament.id}'/>" class="btn-participate">Участвовать</a>
                        </c:if>
                    </div>
                </c:forEach>
            </div>
        </section>
    </main>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>

    <script src="${pageContext.request.contextPath}/js/main.js"></script>
</body>
</html>