<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:useBean id="title" scope="request" type="java.lang.String"/>
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
            <%--@elvariable id="category" type="com.valenstain.movies.entity.Category"--%>
            <c:url var="action" value="/category/save"/>
            <form:form action="${action}" modelAttribute="category" method="post">
                <form:hidden path="id" />
                <div id="small-form">
                    <div class="title">Name:</div>
                    <div><form:input path="name"/><form:errors path="name" cssClass="error"/></div>
                    <div class="div-button"><button class="button">Save</button></div>
                </div>
            </form:form>
        </section>
    </main>
</div>
</body>
</html>