<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    
    <style type="text/css">

    </style>
    
    
</head>
<body>
    <%@ include file="../include/header.jsp" %>
    
<section>
        <div class="container">
            <div class="row join-wrap">
                
                <div class="col-xs-12 col-md-9 join-form">
                    
                    <div class="titlebox">
                        MEMBER                   
                    </div>
                    <div>
                        <p>${sessionScope.id }(${sessionScope.name })님 회원정보</p>
                    </div>
                    <div>
                        <button type="button" class="btn btn-primary" onclick="location.href='mypageinfo.users'">회원정보변경</button>
                        <button type="button" class="btn btn-primary" id="delCheck">회원 탈퇴</button>
                        
                    </div>
                    <div class="delete-hidden">
                        <form name="deleteForm" action="delete.users" method="post">
                        <input type="password" name="pw" class="form-control" placeholder="비밀번호를 입력하세요">
                        <button type="button" class="btn btn-primary" onclick="document.deleteForm.submit()" >확인</button>
                        </form>
                    </div>
                    
                    <br>
                    <div>
                        <p>${sessionScope.id }(${sessionScope.name })님의 작성 게시물</p>
                        <table class="table table-striped" style="text-align: center; border: 2px solid #737373">
                    <thead>
                        <tr>
                            <th style="text-align: center;">번호</th>
                            <th style="text-align: center;">제목</th>
                            <th style="text-align: center;">작성자</th>
                            <th style="text-align: center;">작성일</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr>
                            <td>1</td>
                            <td><a>Test</a></td>
                            <td>Min</td>
                            <td>2019-09-14 08:05</td>
                        </tr>
                        <tr>
                            <td>2</td>
                            <td><a>Lorem Ipsum is simply dummyg industry.</a></td>
                            <td>MBW</td>
                            <td>2019-09-15 13:05</td>
                        </tr>

                    </tbody>
                </table>
                    </div>
                    
                    
                </div>


            </div>

        </div>

    </section>
    
    
    <%@ include file="../include/footer.jsp" %>
    
    
    
    <script>
        //탈퇴버튼 디스플레이 처리
        var delCheck = document.getElementById("delCheck");
        delCheck.onclick = function() {
            var del  = document.querySelector(".delete-hidden");
            if(del.style.display == "none" || del.style.display == "") {
                del.style.display = "inline";
            } else {
                del.style.display = "none";
            }
        }
    </script>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
</body>
</html>