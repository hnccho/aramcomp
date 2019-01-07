<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<% 
/**
 * @Class Name : NtwrkSvcMntrngEdit.jsp
 * @Description : 네트워크서비스모니터링 수정
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
<DIV id="main">

<div class="content_title">
	<h2>네트워크서비스모니터링 수정</h2>
</div>

<div id="search_area">
	<div class="button_area">
		<span class="button"><a href="#" onclick="javascript:fn_aram_update(); return false;"><spring:message code="button.save" /></a></span>
		<span class="button"><a href="#" onclick="javascript:fn_aram_list(); return false;"><spring:message code="button.list" /></a></span>
	</div>
</div>

<form:form commandName="ntwrkSvcMntrngVO" method="post" action="">
<input type="hidden" name="curTrgetId" value="${curTrgetId}" />
<input type="hidden" name="curMenuNo" value="${curMenuNo}" />

<form:hidden path="sysIp" />

<table class="table-register" summary="이 표는 네트워크서비스모니터링 대상 정보를 등록할 수 있는 표이며, 시스템IP, 시스템포트, 시스템명, 관리자명, 관리자이메일주소 정보로 구성되어 있습니다 .">
<caption>네트워크서비스모니터대상 수정</caption>
<tbody>
	<tr> 
		<th width="20%">
			<span class="required_icon"></span>
			<label for="sysIp1">시스템IP</label>
		</th>
		<td width="80%">
			<form:input path="sysIp1" size="3" maxlength="3" title="시스템IP1"/> . 
			<form:input path="sysIp2" size="3" maxlength="3" title="시스템IP2"/> . 
			<form:input path="sysIp3" size="3" maxlength="3" title="시스템IP3"/> .
			<form:input path="sysIp4" size="3" maxlength="3" title="시스템IP4"/>
			<form:errors path="sysIp1" cssClass="error"/>
			<form:errors path="sysIp2" cssClass="error"/>
			<form:errors path="sysIp3" cssClass="error"/>
			<form:errors path="sysIp4" cssClass="error"/>
		</td>
	</tr>
	<tr> 
	    <th>
	    	<span class="required_icon"></span>
	    	<label for="sysPort">시스템포트</label>
	    </th>
	    <td>
	      <form:input path="sysPort" size="5" maxlength="5" title="시스템포트"/>
	      <form:errors path="sysPort" cssClass="error"/>
	    </td>
	</tr>
	<tr> 
	    <th>
	    	<span class="required_icon"></span>
	    	<label for="sysNm">시스템명</label>
	    </th>
	    <td>
	      	<form:input path="sysNm" size="65" maxlength="255" title="시스템명"/>
	      	<form:errors path="sysNm" cssClass="error"/>
	    </td>
	</tr>
	<tr> 
	    <th>
	    	<span class="required_icon"></span>
	    	<label for="mngrNm">관리자명</label>
	    </th>
	    <td>
	      	<form:input path="mngrNm" size="5" maxlength="60" title="관리자명"/>
	      	<form:errors path="mngrNm" cssClass="error"/>
	    </td>
	</tr>
	<tr> 
	    <th>
	    	<span class="required_icon"></span>
	    	<label for="mngrEmailAddr">관리자이메일주소</label>
	    </th>
	    <td>
	      	<form:input path="mngrEmailAddr" size="25" maxlength="50" title="관리자이메일주소"/>
    	  	<form:errors path="mngrEmailAddr" cssClass="error"/>
	    </td>
	</tr>
</tbody>
</table>
	
<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="${searchVO.searchCondition}" />
<input type="hidden" name="searchKeyword"   value="${searchVO.searchKeyword}" />
<input type="hidden" name="pageIndex"       value="${searchVO.pageIndex}" />
<input type="hidden" name="recordPerPage"   value="${searchVO.recordPerPage}" />
<!-- 검색조건 유지 -->
</form:form>

</div>

<script type="text/javascript" src="${pageContext.request.contextPath}/validator.do"></script>
<validator:javascript formName="ntwrkSvcMntrngVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/aramframework/com/sym/cal/CalPopup.js"></script>
<script type="text/javascript">

/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fn_aram_list(){
    var varForm = document.getElementById("ntwrkSvcMntrngVO");
    varForm.action = "${pageContext.request.contextPath}/utl/sys/nsm/listNtwrkSvcMntrng.do";
    varForm.submit();	
}	

function fn_aram_update() {
    var varForm = document.getElementById("ntwrkSvcMntrngVO");
    
	if (!validateNtwrkSvcMntrngVO(varForm)){
		return;
	}
	
	if(confirm("<spring:message code='common.update.msg'/>")){
		varForm.action = "${pageContext.request.contextPath}/utl/sys/nsm/updateNtwrkSvcMntrng.do";
		varForm.submit();					
	}
}

</script>
