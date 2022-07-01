<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java"
pageEncoding="UTF-8" %>
<html lang="ko">
   <head>
      <meta charset="UTF-8" />
      <link rel="icon" href="/img/just-eat-r-128.png" />
      <title>SNS 로그인 | Just Eat</title>
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
            <div class="member-title">로그인</div>
            <div class="member-title" style="font-size: 16px">
               Just Eat 계정 사용
            </div>
            <button
               id="kakao"
               class="member-btn-sns"
               onclick="location.href='https://kauth.kakao.com/oauth/authorize?client_id=5739de64ac097aace6fd7e1231e8f94b&redirect_uri=http://localhost:3070/members/kakao&response_type=code'"
               type="button"
            >
               <img
                  id="kakao"
                  src="https://www.svgrepo.com/show/368252/kakao.svg"
                  style="height: 24px"
               />
               <span class="sns-text">1초 만에 카카오로 회원가입하기</span>
            </button>
            <input class="member-input-text" type="text" placeholder="이메일" />
            <input
               class="member-input-text"
               type="password"
               placeholder="비밀번호"
            />
            <button class="member-btn-a" onclick="location.href='/members'">
               로그인
            </button>
         </div>
      </div>
   </body>
</html>