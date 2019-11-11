<!doctype html>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
 /**
  * @Class Name : LoginLogDetail.jsp
  * @Description : 로그인 로그 상세조회
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
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>로그인 로그 상세조회</title>

<link rel="stylesheet" href="${pageContext.request.contextPath}/css/aramframework/com/cmm/com.css" type="text/css">
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/aramframework/com/cmm/button.css" type="text/css">

</head>

<body>
<noscript class="noScriptTitle">자바스크립트를 지원하지 않는 브라우저에서는 일부 기능을 사용하실 수 없습니다.</noscript>

<DIV id="main">

<div class="content_title">
	<h2>로그인 로그 정보</h2>
</div>

<div id="search_area">
	<div class="button_area">
   		<span class="button"><a href="#" onclick="javascript:fn_aram_list(); return false;"><spring:message code="button.list" /></a></span>
	</div>
</div>

<form:form modelAttribute="loginLogVO" action="" method="post"> 
<input type="hidden" name="curTrgetId" value="${curTrgetId}" />
<input type="hidden" name="curMenuNo" value="${curMenuNo}" />

<form:hidden path="logId" />
	
<table class="table-detail">
 	<tr>
    	<th width="20%">
    		로그ID
    	</th>
    	<td width="80%">
      		<c:out value="${loginLogVO.logId}"/>
    	</td>
  	</tr>
 	<tr>
    	<th>
    		발생일자
    	</th>
    	<td>
      		<c:out value="${loginLogVO.creatDt}"/>
    	</td>
  	</tr>
 	<tr>
    	<th>
    		로그유형
    	</th>
    	<td>
      		<c:out value="${loginLogVO.loginMthd}"/>
    	</td>
  	</tr>
 	<tr>
    	<th>
    		요청자
    	</th>
    	<td>
      		<c:out value="${loginLogVO.loginNm}"/>
    	</td>
  	</tr>
 	<tr>
    	<th>
    		요청자IP
    	</th>
    	<td>
      		<c:out value="${loginLogVO.loginIp}"/>
    	</td>
  	</tr>
</table>

<!-- 검색조건 유지 -->
<form:hidden path="searchBgnDe" />
<form:hidden path="searchEndDe" />
<input type="hidden" name="searchKeyword"   value="${loginLogVO.searchKeyword}" />
<input type="hidden" name="pageIndex"       value="${loginLogVO.pageIndex}" />
<input type="hidden" name="recordPerPage"   value="${loginLogVO.recordPerPage}" />
<!-- 검색조건 유지 -->
</form:form>

</DIV>	

<script type="text/javascript">

/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fn_aram_list(){
    var varForm = document.getElementById("loginLogVO");
    varForm.action = "${pageContext.request.contextPath}/sym/log/clg/listLoginLog.do";
    varForm.submit();	
}	

</script>

</body>
</html>
