<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시글 등록</title>
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel="stylesheet" type="text/css" />
</head>
<body bgcolor="#ffefd5">
	<form action="bInsert.do" method="post" enctype="multipart/form-data">
		<table align="center">
			<tr>
				<td>제목</td>
				<td><input type="text" name="board_title"></td>
			</tr>
			<tr>
				<td>작성자</td>
				<td><input type="text" name="board_writer"></td>
			</tr>
			<tr>
				<td>첨부파일</td>
				<!-- 원래 vo에 있는 이름을 사용하게 되면 String 형태 여야함. file 형태로 가져가야 하므로 name을 다르게 지정함. -->
				<td><input type="file" name="upfile" multiple></td>
			</tr>
			<tr>
				<td>비밀번호</td>
				<td><input type="password" name="board_pwd"></td>
			</tr>
			<tr>
				<td>내용</td>
				<td><textarea cols="50" rows="7" name="board_content"></textarea></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
				<input type="submit" value="등록하기">&nbsp;&nbsp;
				<c:url var="bList" value="bList.do">
					<c:param name="page" value="1"/>
				</c:url>
				<a href=${bList }>목록으로</a>
				</td>
			</tr>
		</table>
	</form>
</body>
</html>