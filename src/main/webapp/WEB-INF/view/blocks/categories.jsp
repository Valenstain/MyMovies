<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="categories" scope="request" type="java.util.List"/>
<ul>
    <li><a href="<c:url value="/" />">All movies</a></li>
    <c:forEach var="cat" items="${categories}">
    <li><a href="<c:url value="/category/${cat.id}" />">${cat.name}</a></li>
    </c:forEach>
</ul>