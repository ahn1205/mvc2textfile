<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="css/bootstrap.css">
        <link rel="stylesheet" href="css/custom.css">
        <title>BBS Test</title>
        
           
        <!--메인만 적용되는 css영역-->   
        <style>
            body {
                background-image: url(images/main.jpg);
                background-repeat: no-repeat;
                background-size: cover
            }
        </style>
    </head>

    <body>
    <%@ include file="include/header.jsp" %>
    
    
    <section>
    
    <div class="container" id="mainCon">
        <div class="jumbotron" id="jbDiv">
            <div class="container" id="introArea">
                <h1>게시판 사이트</h1>
                <p>해당 사이트는 교육용 사이트로써, 학생 여러분들이 알아서 수정, 추가, 삭제 해보시기 바랍니다.</p>
                <p>글을 써도 되고, 사진을 넣어도 되는 영역 입니다.</p>

            </div>

        </div>
        
        <div class="col-md-6 col-xs-12" style="padding: 0px 0px;">
            <h2 style="color:black">공지사항</h2>
             <select onchange="change(this)">
					<option value="10" ${pageVO.amount==10? 'selected':''}>10개 보기</option>
					<option value="15" ${pageVO.amount==15? 'selected':''}>15개 보기</option>
					<option value="20" ${pageVO.amount==20? 'selected':''}>20개 보기</option>
					<option value="50" ${pageVO.amount==50? 'selected':''}>50개 보기</option>
					<option value="100" ${pageVO.amount==100? 'selected':''}>100개 보기</option>					
			</select>
            
            <table class="table table-striped" style="text-align: center; border: 2px solid #737373">
                <thead>
                    <tr>
                        <th style="background-color: #9DCAFF; text-align: center;">번호</th>
                        <th style="background-color: #9DCAFF; text-align: center;">제목</th>
                        <th style="background-color: #9DCAFF; text-align: center;">작성자</th>
                        <th style="background-color: #9DCAFF; text-align: center;">작성일</th>
                        <th style="background-color: #9DCAFF; text-align: center;">조회수</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="vo" items="${boardList }">
                        <tr>
						<td>${vo.bno }</td>
						<td>
							<a href="content.board?bno=${vo.bno }">
								${vo.title }
							</a>
						</td>
						<td>${vo.writer }</td>
						<td><fmt:formatDate value="${vo.regdate }" pattern="yyyy-MM-dd hh:mm:ss"/></td>
						<td>${vo.hit }</td>
						</tr>
					</c:forEach>
                    </tbody>
                </table>
                    <div class="text-center">
                    <ul class="pagination pagination-sm">
                        <!-- 2. 이전버튼 활성화 여부 -->
						<c:if test="${pageVO.prev }">
							<li><a href="${pageContext.request.contextPath}/main.do?pageNum=${pageVO.startPage -1 }&amount=${pageVO.amount}">이전</a></li>
						</c:if>	
                        <!-- 1. 페이지 번호처리 -->
						<c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
							<li class="${num == pageVO.pageNum ? 'active' : '' }"><a href="${pageContext.request.contextPath}/main.do?pageNum=${num }&amount=${pageVO.amount}">${num }</a></li>
						</c:forEach>
                        <!-- 3. 다음버튼 활성화 여부 -->
						<c:if test="${pageVO.next }">
							<li><a href="${pageContext.request.contextPath}/main.do?pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}">다음</a></li>
						</c:if>
                    </ul>            
        </div>
        
    </div>
    </div>
    
    </section>
   
    <%@ include file="include/footer.jsp" %>
    
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>
    
<script>
		function change(a){
			location.href='bbs.board?pageNum=1&amount='+a.value; 
		}
</script>
    
    </body>
    
    

</html>
