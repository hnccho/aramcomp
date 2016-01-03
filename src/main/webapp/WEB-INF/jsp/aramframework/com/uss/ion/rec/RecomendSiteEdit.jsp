<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%
 /**
  * @Class Name : RecomendSiteEdit.jsp
  * @Description : 추천사이트 수정
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
	<h2>추천사이트 수정</h2>
</div>

<div id="search_area">
	<div class="button_area">
		<span class="button"><a href="#" onclick="javascript:fn_aram_update(); return false;"><spring:message code="button.save" /></a></span>
		<span class="button"><a href="#" onclick="javascript:fn_aram_list(); return false;"><spring:message code="button.list" /></a></span>
	</div>
</div>

<form:form commandName="recomendSiteVO" action="" method="post">
<input type="hidden" name="curTrgetId" value="${curTrgetId}" />
<input type="hidden" name="curMenuNo" value="${curMenuNo}" />

<form:hidden path="recomendSiteId" />

<!-- 등록  폼 영역  -->
<table class="table-register" summary="추천사이트 정보 수정테이블">
  	<tr>
    	<th width="20%">
    		<span class="required_icon"></span>
    		<label for="recomendSiteNm">추천사이트명</label>
    	</th>
    	<td width="80%">
      		<form:input path="recomendSiteNm" size="70" maxlength="70" />
      		<form:errors path="recomendSiteNm" cssClass="error"/>
    	</td>
  	</tr>
  	<tr>
    	<th>
    		<span class="required_icon"></span>
    		<label for="recomendSiteUrl">추천사이트 URL</label>
    	</th>
    	<td>
      		<form:input path="recomendSiteUrl" size="70" maxlength="70" />
      		<form:errors path="recomendSiteUrl" cssClass="error"/>
    	</td>
  	</tr>
  	<tr>
    	<th>
    		<span class="required_icon"></span>
    		<label for="recomendSiteDc">추천사이트 설명</label>
    	</th>
    	<td>
      		<form:textarea path="recomendSiteDc" cols="200" rows="10" cssClass="txArea" />
      		<form:errors path="recomendSiteDc" cssClass="error"/>
    	</td>
  	</tr>
  	<tr>
    	<th>
    		<span class="required_icon"></span>
    		<label for="recomendResnCn">추천사유내용</label>
    	</th>
    	<td>
      		<form:textarea path="recomendResnCn" cols="200" rows="10" cssClass="txArea" />
      		<form:errors path="recomendResnCn" cssClass="error"/>
    	</td>
  	</tr>
 	<tr>
    	<th>
    		<span class="norequired_icon"></span>
    		<label for="recomendConfmAt">추천승인여부</label>
    	</th>
    	<td>
       		 승인:   <input type="radio" name="recomendConfmAt" class="radio1" value="Y" onClick="javascript:fn_aram_confirm();"
            <c:if test="${recomendSiteVO.recomendConfmAt == 'Y'}">checked</c:if>>&nbsp;
       		 미승인: <input type="radio" name="recomendConfmAt" class="radio1" value="N" onClick="javascript:fn_aram_cancel();"
            <c:if test="${recomendSiteVO.recomendConfmAt == 'N'}">checked</c:if>>&nbsp;
    	</td>
  	</tr>
  	<tr>
    	<th>
    		<span class="norequired_icon"></span>
    		<label for="confmDe">승인일자</label>
    	</th>
    	<td>
      		<form:hidden path="confmDe" />
	    	<c:if test="${!empty recomendSiteVO.confmDe}">
 				<c:set var="confmDeVal" value="${fn:substring(recomendSiteVO.confmDe, 0,4)}-${fn:substring(recomendSiteVO.confmDe, 4,6)}-${fn:substring(recomendSiteVO.confmDe, 6,8)}"/>
      		</c:if>
      		<input name="confmDeView" id="confmDeView" type="text" size="10" value="${confmDeVal}"  readonly />
      		<a href="#" onClick="javascript:fn_aram_NormalCalendar(document.forms[0].confmDe, document.forms[0].confmDeView); return false;">
      			<img name="calendarImg" src="${pageContext.request.contextPath}/images/aramframework/com/cmm/icon/bu_icon_carlendar.gif"  align="middle" style="border:0px" alt="달력창팝업버튼이미지">
      		</a>
      		<form:errors path="confmDe" cssClass="error"/>
    	</td>
  	</tr>
</table>

<!-- 검색조건 유지 -->
<form:hidden path="searchCondition" />
<form:hidden path="searchKeyword" />
<form:hidden path="pageIndex" />
<form:hidden path="recordPerPage" />
<!-- 검색조건 유지 -->
</form:form>

</DIV>

<script type="text/javascript" src="${pageContext.request.contextPath}/validator.do"></script>
<validator:javascript formName="recomendSiteVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/aramframework/com/sym/cal/CalPopup.js"></script>

<script type="text/javascript">

/* ********************************************************
 * 저장처리화면
 ******************************************************** */
function fn_aram_update(){
	var varForm = document.getElementById("recomendSiteVO");
	
    if (!validateRecomendSiteVO(varForm)) {
        return;
    }   
    
    if (confirm("<spring:message code='common.update.msg' />")) {
    	varForm.action = "${pageContext.request.contextPath}/uss/ion/rec/updateRecomendSite.do";
    	varForm.submit();
    }
}

/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fn_aram_list() {
	var varForm = document.getElementById("recomendSiteVO");
    varForm.action = "${pageContext.request.contextPath}/uss/ion/rec/listRecomendSite.do";
    varForm.submit();
}

/* ********************************************************
 * 승인 클릭 시...
 ******************************************************** */
function fn_aram_confirm() {
	var varForm = document.getElementById("recomendSiteVO");
    // 승인일자에 널 처리..
    varForm.calendarImg.disabled = false;
}

/* ********************************************************
 * 미승인 클릭 시...
 ******************************************************** */
function fn_aram_cancel() {
	var varForm = document.getElementById("recomendSiteVO");
    // 승인일자에 널 처리..
    varForm.confmDe.value = "";
    varForm.calendarImg.disabled = true;
}

</script>

