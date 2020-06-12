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
        
        <!--게시판만 적용되는 css-->            
        <style>

            .table-striped > tbody > tr {
                background-color: rgba(255, 255, 255)
            }
            .row h2 {
                color: aliceblue;
                
            }
            .pagination-sm {
                margin: 0;
            }
            
        </style>
    </head>

    <body>
    
      <%@ include file="../include/header.jsp" %>
    
        
     <section>
        
        <div class="container">
            <div class="row">
                
                <h2>게시판 목록</h2>
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
							<li><a href="bbs.board?pageNum=${pageVO.startPage -1 }&amount=${pageVO.amount}">이전</a></li>
						</c:if>	
                        <!-- 1. 페이지 번호처리 -->
						<c:forEach var="num" begin="${pageVO.startPage }" end="${pageVO.endPage }">
							<li class="${num == pageVO.pageNum ? 'active' : '' }"><a href="bbs.board?pageNum=${num }&amount=${pageVO.amount}">${num }</a></li>
						</c:forEach>
                        <!-- 3. 다음버튼 활성화 여부 -->
						<c:if test="${pageVO.next }">
							<li><a href="bbs.board?pageNum=${pageVO.endPage + 1 }&amount=${pageVO.amount}">다음</a></li>
						</c:if>
                    </ul>	
                    <button class="btn btn-info pull-right" onclick="location.href='bbs_writer.board'">글쓰기</button>
                </div>
                
            </div>
        </div>
    </section>
        
 <%@ include file="../include/footer.jsp" %>
    <script src="https://code.jquery.com/jquery-3.1.1.min.js"></script>
    <script src="js/bootstrap.js"></script>

<script>
		function change(a){
			location.href='bbs.board?pageNum=1&amount='+a.value; 
		}
</script>


    </body>

</html>