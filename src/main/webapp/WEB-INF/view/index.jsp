<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %> <%@ taglib prefix="c"
uri="http://java.sun.com/jsp/jstl/core"%>
<c:set
  var="signInOutLink"
  value="${sessionScope.session==null ? '/members' : '/members/logout'}"
/>
<c:set
  var="signInOut"
  value="${sessionScope.session==null ? '로그인' : '로그아웃'}"
/>
<c:set
  var="userName"
  value="${sessionScope.session==null ? '' : sessionScope.session.name}"
/>
<html lang="ko">
  <head>
    <meta charset="UTF-8" />
    <link rel="icon" href="/img/just-eat-r-128.png" />
    <title>Welcome | Just Eat</title>
    <link rel="stylesheet" href="/css/style.css" />
  </head>
  <body>
    <div class="member-out-box">
      <div class="member-submit-box">
        <img
          class="icon"
          src="/img/just-eat-r-1280.png"
          style="height: 120px"
        />
        <h1>Just Eat</h1>
        <c:if test="${sessionScope.session != null}">
          <div class="member-title">안녕하세요. ${userName} 님</div>
        </c:if>
        <div class="member-title">Just Eat 에 오신 것을 환영합니다.</div>
        <a class="member-btn-a" href="<c:url value='/self'/>">셀프 테스트</a>
        <c:if test="${sessionScope.session != null}">
            <a class="member-btn-a" href="<c:url value='/members/${sessionScope.session.member_id}'/>">회원 정보 수정</a>
        </c:if>
        <a class="member-btn-a" href="<c:url value='${signInOutLink}'/>">${signInOut}</a>
      </div>
    </div>
  </body>
</html>
