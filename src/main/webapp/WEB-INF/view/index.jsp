<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="movies" scope="request" type="java.util.List"/>
<jsp:useBean id="title" scope="request" type="java.lang.String"/>
<jsp:useBean id="catId" scope="request" type="java.lang.Integer"/>
<jsp:useBean id="countMovies" scope="request" type="java.lang.Integer"/>
<jsp:include page="blocks/doctype.jsp" />
<html lang="en">
    <head>
        <jsp:include page="blocks/head.jsp"/>
    </head>
<body>
    <div id="central">
        <header id="header">
            <jsp:include page="blocks/header.jsp"/>
        </header>
        <main id="main">
            <nav id="menu">
                <jsp:include page="blocks/categories.jsp"/>
            </nav>
            <section id="content">
                <h1>${title}</h1>
                <table id="list-movies">
                    <thead>
                    <tr>
                        <th>Name</th>
                        <th>Start</th>
                        <th colspan="2">Actions</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:choose>
                        <c:when test="${movies.size() > 0}">
                            <c:forEach var="movie" items="${movies}">
                                <tr>
                                    <td><a href="${movie.link}" target="_blank" class="link">${movie.name}</a></td>
                                    <td>${movie.startTime}</td>
                                    <td><a href="<c:url value="/movie/${movie.id}"/>" class="button">Edit</a></td>
                                    <td><a href="<c:url value="/delete-movie/${movie.id}"/>" class="button">Delete</a></td>
                                </tr>
                            </c:forEach>
                        </c:when>
                        <c:otherwise>
                            <tr>
                                <td colspan="5" class="empty">Empty</td>
                            </tr>
                        </c:otherwise>
                    </c:choose>
                    </tbody>
                </table>
                <div id="control_buttons">
                    <ul>
                        <li><a href="<c:url value="/movie/add/${catId}"/>" class="button">Add movie</a></li>
                        <li><a href="<c:url value="/category/add"/>" class="button">Add category</a></li>
                        <c:if test="${catId > 0}">
                        <li><a href="<c:url value="/category/edit/${catId}"/>" class="button">Edit category</a></li>
                        <c:if test="${countMovies == 0}"><li><a href="<c:url value="/category/delete/${catId}"/>" class="button">Delete category</a></li></c:if>
                        </c:if>
                    </ul>
                    <c:if test="${countMovies > 0 && catId > 0}">
                        <p class="info">Can't delete category, there are movies.</p>
                    </c:if>
                </div>
            </section>
        </main>
    </div>
</body>
</html>