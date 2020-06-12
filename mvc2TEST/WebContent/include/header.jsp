	<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>


<head>
		<link rel="stylesheet" href="<%=request.getContextPath()%>/main.do/css/style.css">
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">

        <title>BBS Test</title>

</head>

	<nav class="navbar navbar-default" id="nav">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="${pageContext.request.contextPath}/main.do">MIN and PARK</a>
        </div>

        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li class="active"><a href="${pageContext.request.contextPath}/main.do" style="margin-right: 10px;">메인</a></li>
                <li><a href="bbs.board">게시판</a></li>
            </ul>
            
            <ul class="nav navbar-nav navbar-right">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">접속하기<span class="caret"></span></a>
                    <c:choose>
                    <c:when test="${sessionScope.id == null }">
                    <ul class="dropdown-menu">
                        <li><a href="login.users">로그인</a></li>
                        <li><a href="join.users">회원가입</a></li>
                    </ul>
                    </c:when>
                    <c:otherwise>
                    <ul class="dropdown-menu">
                        <li><a href="logout.users">로그아웃</a></li>
                        <li><a href="mypage.users">마이페이지</a></li>
                    </ul>
                    </c:otherwise>
                    </c:choose>
                </li>
            </ul>
       
        </div>
    </nav>  
