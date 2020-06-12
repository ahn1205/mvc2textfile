<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    
</head>
<body>
    <%@ include file="../include/header.jsp" %>
    
<section>
        <div class="container">
            <div class="row join-wrap">
                <!--join-form을 적용한다 float해제 margin:0 auto-->
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                        MEMBER INFO                    
                    </div>
                    
                    <p>*표시는 필수 입력 표시입니다</p>
                    <form name="regForm" action="mypageinfoForm.users" method="post">
                    <table class="table">
                        <tbody class="m-control">
                            <tr>
                                <td class="m-title">*ID</td>
                                <td><input name="id" value="${user_vo.id }" class="form-control input-sm"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*이름</td>
                                <td><input name="name" value="${user_vo.name }" class="form-control input-sm"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*비밀번호</td>
                                <td><input name="pw" class="form-control input-sm"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*비밀번호확인</td>
                                <td><input name="pwcheck" class="form-control input-sm"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*E-mail</td>
                                <td>
                                    <input name="email" value="${user_vo.email }" class="form-control input-sm">@
                                    <select name="email2" class="form-control input-sm sel">
                                        <option ${user_vo.email2 == naver.com? 'selected':'' } >naver.com</option>
                                        <option ${user_vo.email2 == gmail.com? 'selected':'' }>gmail.com</option>
                                        <option ${user_vo.email2 == daum.net? 'selected':'' }>daum.net</option>
                                    </select>
                                    <button class="btn btn-info">중복확인</button>
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*휴대폰</td>
                                <td>
                                    <input name="hp" value="${ user_vo.hp }" class="form-control input-sm sel"> -
                                    <input name="hp2" value="${ user_vo.hp2 }" class="form-control input-sm sel"> -
                                    <input name="hp3" value="${ user_vo.hp3 }" class="form-control input-sm sel">
                                </td>
                            </tr>
                            <tr>
                                <td class="m-title">*주소</td>
                                <td><input name="address" value="${ user_vo.address }" class="form-control input-sm add"></td>
                            </tr>
                            <tr>
                                <td class="m-title">*상세주소</td>
                                <td><input name="address2" value="${ user_vo.address2 }" class="form-control input-sm add"></td>
                            </tr>
                        </tbody>
                    </table>
                    </form>
                    <div class="titlefoot">
                        <button class="btn" onclick="document.regForm.submit()">수정</button>
                        <button class="btn" onclick="location.href='mypage.user'">목록</button>
                    </div>
                    
                </div>


            </div>

        </div>

    </section>
    
    
    <%@ include file="../include/footer.jsp" %>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>