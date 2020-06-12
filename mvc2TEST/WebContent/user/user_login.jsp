<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <!DOCTYPE html>
<html>

<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/custom.css">
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    <title>BBS Test</title>
    
    <!--login만 적용되는 css-->   
    <style>
        .table-striped>tbody>tr {
            background-color: #f9f9f9
        }

        .join-form {
            margin: 100px auto;
            padding: 20px;
            width: 50%;
            float: none;
            background-color: white;
        }
    </style>
</head>

<body>
    <%@ include file="../include/header.jsp" %>

    <section>
        <div class="container">
            <div class="row">
                <div class="col-lg-6 col-md-9 col-sm-12 join-form">
                    <h2>로그인<small>(가운데정렬)</small></h2>
                    
                    
                    <form name="regForm" action="loginForm.users" method="post">
                        <div class="form-group">
                            <label for="id">아이디</label>
                            <input type="text" class="form-control" name="id" placeholder="아이디">
                        </div>
                        <div class="form-group">
                            <label for="password">비밀번호</label>
                            <input type="password" class="form-control" name="pw" placeholder="비밀번호 ">
                        </div>
                        
                        <div class="form-group">
                            <button type="button" value= "회원 가입" class="btn btn-lg btn-success btn-block"  onclick="location.href='join.users'">회원가입</button>
                        </div>

                        <div class="form-group">
                            <button type="button" class="btn btn-lg btn-info btn-block" onclick="check()">로그인</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>


    </section>
  <%@ include file="../include/footer.jsp" %>
  
  
<script>
	function check(){
		//form는 유일하게 document.태그이름.태그이름 으로 하위 태그에 접근이 가능
		//console.log( document.regForm.id.value );
		
		if( document.regForm.id.value == '' ) {
			alert("아이디는 필수 사항입니다");
			return; //함수 종료
			
		} else if( (document.regForm.id.value.length < 4) || (document.regForm.id.value.length > 12) ) {
			alert("아이디는 4글자 이상 12글자 이하로 입력하세요");
			return;
			
		} else if(document.regForm.pw.value == '') {
			alert("비밀번호는 필수 사항입니다");
			return;
			
		} else if(document.regForm.pw.value.length<4){
			alert("비밀번호는 4글자 이상입니다");
			return;
			
		}  else {			
			document.regForm.submit(); //자바스크립트의 submit() 기능
		}	
	}

</script>

</body>

</html>