<jsp:useBean id="title" scope="request" type="java.lang.String"/>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
            <%--@elvariable id="movie" type="com.valenstain.movies.entity.Movie"--%>
            <c:url var="action" value="/movie/save"/>
            <form:form action="${action}" modelAttribute="movie" method="post">
                <form:hidden path="id" />
                <form:hidden path="category.id" />
                <div id="form">
                    <div class="title">Category:</div>
                    <div><form:input path="category.name"/><form:errors path="category.name" cssClass="error"/></div>
                    <div class="title">Name:</div>
                    <div><form:input path="name"/><form:errors path="name" cssClass="error"/></div>
                    <div class="title">Link:</div>
                    <div><form:input path="link"/></div>
                    <div class="title">Start time:</div>
                    <div><form:input path="startTime" placeholder="hh:mm dd.mm.yyyy"/><form:errors path="startTime" cssClass="error"/></div>
                    <div class="title">Description:</div>
                    <div><form:textarea path="description"/></div>
                    <div class="div-button"><button class="button">Save</button></div>
                </div>
            </form:form>
        </section>
    </main>
</div>
</body>
</html>