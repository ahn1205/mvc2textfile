<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/css/custom.css">

        <title>BBS Test</title>

</head>
<body>
   <%@ include file="../include/header.jsp" %>
   
     <section> 	
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 col-sm-12 join-form">
                    <h2>게시판 수정<small>(디자인이궁금하세요?)</small></h2>
					<form name="boardForm" action="update.board" method="post">
                        <div class="form-group">
                        <!-- hidden타입은 화면에서 보이지 않지만 반드시 넘겨줘야하는 값을 숨겨서 보낼때 사용합니다 -->
						<input type="hidden" name="writer" value="${vo.writer }" >
						
                            <label>글번호</label>
                            <input type="text" name="bno" class="form-control" value="${vo.bno }" readonly>
                        </div>
                        <div class="form-group">
                            <label>글쓴이</label>
                            <input type="text" name="writer"  class="form-control" value="${vo.writer }" disabled>
                        </div>
                        <div class="form-group">
                            <label>제목</label>
                            <input type="text" name="title"  class="form-control" value="${vo.title }">
                        </div>
                        <div class="form-group">
                            <label>내용</label>
                            <textarea class="form-control" name="content"  rows="5">${vo.content}</textarea>
                        </div>

                        <!--구현로직: 버튼은 온클릭을 사용하던 자바스크립트를 이용해야 합니다-->
                        <div class="form-group">
                            <button type="button" class="btn btn-success" onclick="location.href='bbs.board'">목록</button>
                            <button type="button" class="btn btn-info" onclick="check()">수정</button>
                            <button type="button" class="btn btn-default" onclick="location.href='delete.board?bno=${vo.bno}&writer=${vo.writer }'">삭제</button>
                        </div>

                    </form>
                </div>
            </div>
        </div>
     </section>
<%@ include file ="../include/footer.jsp" %>

<script>
	function check(){
		if(document.boardForm.title.value ==''){
			alert("제목은 필수사항입니다.")
			return false;
		} else if(confirm("수정하시겠습니까?")){
			document.boardForm.submit();
		}
	}
</script>
</body>
</html>