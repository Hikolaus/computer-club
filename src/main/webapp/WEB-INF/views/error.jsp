<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Ошибка</title>

</head>
<body>
    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <div class="error-container">
        <div class="error-code">
            <c:choose>
                <c:when test="${not empty status}">${status}</c:when>
                <c:otherwise>500</c:otherwise>
            </c:choose>
        </div>

        <div class="error-message">
            <c:choose>
                <c:when test="${not empty error}">${error}</c:when>
                <c:when test="${status == 404}">Страница не найдена</c:when>
                <c:when test="${status == 403}">Доступ запрещен</c:when>
                <c:when test="${status == 500}">Внутренняя ошибка сервера</c:when>
                <c:otherwise>Произошла ошибка</c:otherwise>
            </c:choose>
        </div>

        <div class="error-details">
            <c:if test="${not empty message}">
                <p>${message}</p>
            </c:if>
            <p>Пожалуйста, попробуйте позже или обратитесь в техническую поддержку.</p>
        </div>

        <div>
            <a href="${pageContext.request.contextPath}/" class="btn">На главную</a>
            <a href="${pageContext.request.contextPath}/support" class="btn">Техподдержка</a>
            <button onclick="history.back()" class="btn">Назад</button>
        </div>
        <c:if test="${not empty exception and pageContext.request.serverName == 'localhost'}">
            <div style="margin-top: 30px; text-align: left; background: #f8f9fa; padding: 15px; border-radius: 5px;">
                <h4>Отладочная информация:</h4>
                <p><strong>Исключение:</strong> ${exception.class.name}</p>
                <p><strong>Сообщение:</strong> ${exception.message}</p>
                <c:if test="${not empty exception.stackTrace}">
                    <details>
                        <summary>Трассировка стека</summary>
                        <pre style="text-align: left; overflow-x: auto;">${exception.stackTrace}</pre>
                    </details>
                </c:if>
            </div>
        </c:if>
    </div>

    <jsp:include page="/WEB-INF/views/footer.jsp"/>
</body>
</html>