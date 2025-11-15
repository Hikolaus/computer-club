<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <title>Техподдержка</title>
</head>
<body>
    <jsp:include page="/WEB-INF/views/header.jsp"/>

    <main>
        <h1>Техподдержка</h1>

        <section>
            <h2>Часто задаваемые вопросы (Q&A)</h2>
            <div class="faq-section">
                <!-- Статические FAQ -->
                <div class="faq-item">
                    <h3>Как забронировать компьютер?</h3>
                    <p>Перейдите в раздел "Компьютеры" и выберите свободный компьютер для бронирования.</p>
                </div>
                <div class="faq-item">
                    <h3>Какие способы оплаты принимаются?</h3>
                    <p>Мы принимаем наличные, банковские карты и онлайн-платежи.</p>
                </div>
            </div>
        </section>

        <section>
            <h2>Связаться с поддержкой</h2>
            <form action="<c:url value='/support/create'/>" method="post">
                <div>
                    <label for="category">Категория обращения:</label>
                    <select id="category" name="categoryId" required>
                        <option value="">Выберите категорию</option>
                        <option value="1">Проблемы с оборудованием</option>
                        <option value="2">Проблемы с программным обеспечением</option>
                        <option value="3">Сетевые проблемы</option>
                        <option value="4">Оплата и бронирование</option>
                        <option value="5">Другое</option>
                    </select>
                </div>

                <div>
                    <label for="computerId">Компьютер (если применимо):</label>
                    <select id="computerId" name="computerId">
                        <option value="">Не применимо</option>
                        <c:forEach var="computer" items="${computers}">
                            <option value="${computer.id}">${computer.name}</option>
                        </c:forEach>
                    </select>
                </div>

                <div>
                    <label for="description">Сообщение о проблеме:</label>
                    <textarea id="description" name="description" rows="5" required></textarea>
                </div>

                <button type="submit">Отправить</button>
            </form>
        </section>

        <section>
            <h2>Открытые ранее тикеты</h2>
            <c:choose>
                <c:when test="${not empty tickets}">
                    <table border="1">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Компьютер</th>
                                <th>Категория</th>
                                <th>Статус</th>
                                <th>Дата создания</th>
                                <th>Действия</th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach var="ticket" items="${tickets}">
                                <tr>
                                    <td>${ticket.id}</td>
                                    <td>${ticket.computerName}</td>
                                    <td>${ticket.categoryName}</td>
                                    <td>
                                        <c:choose>
                                            <c:when test="${ticket.status == 'новое'}">
                                                <span style="color: blue;">Новое</span>
                                            </c:when>
                                            <c:when test="${ticket.status == 'в работе'}">
                                                <span style="color: orange;">В работе</span>
                                            </c:when>
                                            <c:when test="${ticket.status == 'решено'}">
                                                <span style="color: green;">Решено</span>
                                            </c:when>
                                        </c:choose>
                                    </td>
                                    <td>
                                        <fmt:formatDate value="${ticket.createdAt}" pattern="dd.MM.yyyy HH:mm"/>
                                    </td>
                                    <td>
                                        <a href="<c:url value='/support/ticket?id=${ticket.id}'/>">Просмотреть</a>
                                    </td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </c:when>
                <c:otherwise>
                    <p>Нет открытых обращений</p>
                </c:otherwise>
            </c:choose>
        </section>
    </main>

    <jsp:include page="footer.jsp"/>
</body>
</html>