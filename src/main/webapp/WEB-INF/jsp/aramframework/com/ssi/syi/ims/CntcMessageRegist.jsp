<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%
 /**
  * @Class Name  : CntcMessageRegist.jsp
  * @Description : 연계메시지 등록
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
	<h2>연계메시지 등록</h2>
</div>

<div id="search_area">
	<div class="button_area">
		<span class="button"><a href="#" onclick="javascript:fn_aram_insert(); return false;"><spring:message code="button.save" /></a></span>
		<span class="button"><a href="#" onclick="javascript:fn_aram_list(); return false;"><spring:message code="button.list" /></a></span>
	</div>
</div>

<form:form commandName="cntcMessageVO" action="" method="post">
<input type="hidden" name="curTrgetId" value="${curTrgetId}" />
<input type="hidden" name="curMenuNo" value="${curMenuNo}" />

<!-- 등록  폼 영역  -->
<table class="table-register" summary="연계메시지 등록을 제공한다.">
  	<tr>
    	<th width="20%">
    		<span class="required_icon"></span>
    		연계메시지ID
    	</th>
    	<td width="80%">
      		<form:input  path="cntcMessageId" title="연계메시지ID" size="20" maxlength="20" readonly="readonly" cssClass="readOnlyClass"/>
      		<form:errors path="cntcMessageId" cssClass="error"/>
    	</td>
  	</tr>
  	<tr>
    	<th>
    		<span class="required_icon"></span>
    		연계메시지명
    	</th>
    	<td>
      		<form:input  path="cntcMessageNm" title="연계메시지명" size="60" maxlength="60"/>
      		<form:errors path="cntcMessageNm" cssClass="error"/>
    	</td>
  	</tr>
  	<tr>
    	<th>
    		<span class="norequired_icon"></span>
    		상위연계메시지ID
    	</th>
    	<td>
        	<form:select path="upperCntcMessageId"  title="상위연계메시지ID">
            	<form:option value="" label="--선택하세요--"/>
            	<form:options items="${cntcMessageList}" itemValue="cntcMessageId" itemLabel="cntcMessageNm"/>
        	</form:select>
    	</td>
  	</tr>
</table>

</form:form>

</DIV>

<script type="text/javascript" src="${pageContext.request.contextPath}/validator.do"></script>
<validator:javascript formName="cntcMessageVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script type="text/javascript">

/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fn_aram_list(){
    var varForm = document.getElementById("cntcMessageVO");
    varForm.action = "${pageContext.request.contextPath}/ssi/syi/ims/listCntcMessage.do";
    varForm.submit();
}

/* ********************************************************
 * 등록처리
 ******************************************************** */
function fn_aram_insert(){
    var varForm = document.getElementById("cntcMessageVO");
    
	if(!validateCntcMessageVO(varForm)){
		return;
	}
	
	if (confirm("<spring:message code='common.regist.msg' />")) {
		varForm.action = "${pageContext.request.contextPath}/ssi/syi/ims/insertCntcMessage.do";
		varForm.submit();
	}
}

</script>
