<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Вход</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <main>
        <h1>Вход</h1>

        <c:if test="${not empty error}">
            <div style="color: red;">${error}</div>
        </c:if>

        <form action="${pageContext.request.contextPath}/login" method="post">
            <div>
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>

            <div>
                <label for="password">Пароль:</label>
                <input type="password" id="password" name="password" required>
            </div>

            <button type="submit">Войти</button>
        </form>

        <p>Нет аккаунта? <a href="${pageContext.request.contextPath}/register">Зарегистрироваться</a></p>
    </main>

    <jsp:include page="footer.jsp"/>
</body>
</html>