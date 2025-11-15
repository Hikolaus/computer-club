<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<header>
    <nav>
        <a href="${pageContext.request.contextPath}/">Главная</a>
        <a href="${pageContext.request.contextPath}/computers">Компьютеры</a>
        <a href="${pageContext.request.contextPath}/tournaments">Турниры</a>
        <a href="${pageContext.request.contextPath}/tariffs">Цены</a>
        <a href="${pageContext.request.contextPath}/support">Контакты</a>

        <c:choose>
            <c:when test="${empty sessionScope.user}">
                <a href="${pageContext.request.contextPath}/login">Вход</a>
            </c:when>
            <c:otherwise>
                <span>${sessionScope.user.name}</span>
                <a href="${pageContext.request.contextPath}/profile">Профиль</a>
            </c:otherwise>
        </c:choose>
    </nav>
</header>