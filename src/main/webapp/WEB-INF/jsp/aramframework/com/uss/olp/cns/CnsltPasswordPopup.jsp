<!doctype html>
<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"  %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : CnsltPasswordPopup.jsp
  * @Description : 작성비밀번호 확인
  * @Modification Information
  * @
  * @ 수정일              수정자          수정내용
  * @ ----------   ------   ---------------------------
  * @ 2014.11.11   조헌철          최초 생성
  *
  *  @author 아람컴포넌트 조헌철
  *  @since 2014.11.11
  *  @version 1.0
  *  @see
  *  
  */
%>
<html lang="ko">
<head>
<base target="_self">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>작성비밀번호 확인</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/aramframework/com/cmm/com.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/aramframework/com/cmm/button.css" type="text/css">

</head>

<body onload="fn_aram_init();">
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>

<DIV id="main" style="width:280px;margin:20px;">

<div class="content_title">
	<h2>작성 비밀번호 확인</h2>
</div>

<form:form commandName="cnsltManageVO" action="" method="post" onsubmit="fn_aram_confirm_qnapassword();">

<!-- 등록  폼 영역  -->
<table border="0" class="table-register">
<caption>작성비밀번호 확인</caption>
  	<tr> 
    	<th width="50%">
    		<label for="writngPassword">작성글 비밀번호</label>
    		<span class="required_icon"></span>
    	</th>
    	<td >
    		<input name="writngPassword" id="writngPassword" type="password" size="15" value="" maxlength="20" title="작성글 비밀번호">   
    	</td>
  	</tr>      
</table>
</form:form>

<!-- 줄간격조정  -->
<div style="margin-top:20px; width:100%"></div>

<!-- 확인/취소버튼  -->
<div style="width:100%; text-align:center;">
	<div class="button_area">
	  	<span class="button"><a href="javascript:fn_aram_confirm_qnapassword();">확인</a></span>
	  	<span class="button"><a href="JavaScript:fn_aram_cancel_qnapassword();">취소</a></span>
	</div>
</div>

</DIV>

<script type="text/javascript">

/* ********************************************************
 * 초기화
 ******************************************************** */
function fn_aram_init(){
    var varForm = document.getElementById("cnsltManageVO");
	// 작성글 비밀번호 입력란에 포커스..
	varForm.writngPassword.focus();
}

/* ********************************************************
 * 확인처리
 ******************************************************** */
function fn_aram_confirm_qnapassword(){
	window.returnValue = document.getElementById("writngPassword").value;	
	window.close();	
}

/* ********************************************************
 * 취소처리
 ******************************************************** */
function fn_aram_cancel_qnapassword() {
	self.close();
}

</script>

</body>
</html>
