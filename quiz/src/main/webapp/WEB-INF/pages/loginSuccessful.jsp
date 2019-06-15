<%@ page language="java" contentType="text/html; charset=UTF-8" errorPage="errorPage.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<%-- ${user} --%>
<spring:url value="/quiz" var="url" htmlEscape="true"/>
<div class="container">
    <div class="form-row text-center">
        <div class="col-sm-4"></div>
        <div class="col-sm-4">
            <div class="col text-center"></div>
            <form:form id="form" modelAttribute="user" method="post" action="${url}" class="form-signin">
                <div class="form-group">
                    <form:button class="btn btn-lg btn-primary btn-block">Start quiz</form:button>
                </div>
            </form:form>
        </div>
        <div class="col-sm-4"></div>

    </div>
</div>