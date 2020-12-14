<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 상세 보기</title>
</head>
<body bgcolor="#FFEFD5">
		<table align="center" cellpadding="10" cellspacing="0" border="1" width="70%"> 
			<tr align="center" valign="middle"> 
				<th colspan="2">${board.board_num }번글 상세보기</th>
			</tr>
			<tr>
				<td height="15" width="middle">제목</td>
				<td>${board.board_title }</td>
			</tr>
			<tr>
				<td>작성자</td>
				<td>${board.board_writer }</td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<td>
					<c:if test="${empty board.board_file}">          
						첨부파일 없음          
					</c:if>
					<c:if test="${!empty board.board_file}">          
						<a href="${pageContext.request.contextPath}/resources/uploadFiles/${board.board_file}" download>${board.board_file}</a>                   
					</c:if> 
				</td>
			</tr>
			<tr>
				<td>내용</td>
				<td>${board.board_content }</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<c:url var="bupview" value="bRenew.do">
					<c:param name="board_num" value="${board.board_num }"/>
					<%-- <c:param name="page" value="${currentPage }"/> --%>
				</c:url>
				<c:url var="bdel" value="bDelete.do">
					<c:param name="board_num" value="${board.board_num }"/>
				</c:url>
				<a href="${bupview }">수정하기</a>
					&nbsp;&nbsp;
				<a href="${bdel }">삭제하기</a>
					&nbsp;&nbsp;
				<c:url var="bList" value="bList.do">
					<c:param name="page" value="1"/>
				</c:url>
				<a href=${bList }>목록으로</a>
				</td>
			</tr>
		</table>
</body>
</html>