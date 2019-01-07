<%@ page contentType="text/html; charset=utf-8"%>
<%@ page import="aramframework.com.utl.fcc.service.DateUtil" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%
/**
 * @Class Name : VcatnList.jsp
 * @Description : 휴가 목록
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
	<h2>휴가 목록</h2>
</div>

<div id="search_area">
	<div class="button_area">
		<span class="button"><a href="#" onclick="javascript:fn_aram_search(); return false;"><spring:message code="button.inquire" /></a></span>
		<span class="button"><a href="#" onclick="javascript:fn_aram_regist(); return false;"><spring:message code="button.create" /></a></span>
	</div>
</div>

<form:form commandName="vcatnManageVO" action="" method="post">
<input type="hidden" name="curTrgetId" value="${curTrgetId}" />
<input type="hidden" name="curMenuNo" value="${curMenuNo}" />

<input type="hidden" name="applcntId">
<input type="hidden" name="vcatnSe">
<input type="hidden" name="bgnde">
<input type="hidden" name="endde">

<table class="table-register" summary="휴가관리 검색조건">
<caption>휴가관리 검색조건</caption>
  	<tr>
    	<th width="20%"  scope="row">
    		<span class="norequired_icon"></span>
    		<label for="searchKeyword">휴가년도</label>
    	</th>          
    	<td width="80%">
    		<form:select path="searchKeyword" title="휴가년도">
    			<form:option value="" label="전체" />
           		<form:options items="${yearList}" />
           	</form:select>년
    	</td>
  	</tr> 
</table>

<form:hidden path="searchCondition" value="1" />
<form:hidden path="pageIndex" />
</form:form>

<table class="table-list" summary="휴가관리 목록으로 순번 휴가구분 시작일 종료일 휴가사유 구분 승인자로 구성">
<caption>휴가관리 목록</caption>
<thead>
	<tr>  
		<th scope="col" width="7%" >No.</th>
		<th scope="col" width="10%">휴가구분</th>
		<th scope="col" width="10%">시작일</th>
		<th scope="col" width="10%">종료일</th>
		<th scope="col"            >휴가사유</th>
		<th scope="col" width="10%">구분</th>
		<th scope="col" width="15%">승인자</th>
	</tr>
</thead>     
<tbody>
	<c:if test="${fn:length(resultList) == 0}">
	<tr> 
		<td class="lt_text3" colspan="7"><spring:message code="common.nodata.msg" /></td>
	</tr>   	          				 			   
	</c:if>
	
 	<c:set var="searchVO" value="${vcatnManageVO}"/>
 	<c:set var="startIndex" value="${(searchVO.pageIndex-1) * searchVO.recordPerPage}"/>
	<c:forEach items="${resultList}" var="result" varStatus="status">
	<tr class="link" onclick="javascript:fn_aram_detail('<c:out value="${result.applcntId}"/>','<c:out value="${result.vcatnSe}"/>','<c:out value="${result.bgnde}"/>','<c:out value="${result.endde}"/>'); return false;">

 		<c:set var="index" value="${startIndex + status.count}"/>
		<c:set var="reverseIndex" value="${searchVO.totalRecordCount - index + 1}"/>
		<td class="lt_text3"><c:out value="${reverseIndex}"/></td>

		<td class="lt_text3"><c:out value="${result.vcatnSeNm }"/></td>
		<td class="lt_text3">
        	<c:out value='${fn:substring(result.bgnde, 0,4)}-${fn:substring(result.bgnde, 4,6)}-${fn:substring(result.bgnde, 6,8)}'/>
		</td>
		<td class="lt_text3">
        	<c:out value='${fn:substring(result.endde, 0,4)}-${fn:substring(result.endde, 4,6)}-${fn:substring(result.endde, 6,8)}'/>
		</td>
		<td class="lt_textL"><c:out value="${result.vcatnResn}"/></td>
		<td class="lt_text3">
	         <c:if test="${result.confmAt eq 'A'}">신청중</c:if>
	         <c:if test="${result.confmAt eq 'C'}">승인</c:if>
	         <c:if test="${result.confmAt eq 'R'}">반려</c:if>
		</td>
		<td class="lt_textL"><c:out value="${result.sanctnerNm}"/></td>
	</tr>    
	</c:forEach>
</tbody>  
</table>

<div id="page_navigation">
    <ui:pagination paginationInfo="${paginationInfo}" type="image" jsFunction="fn_aram_linkPage" />
</div>

</DIV>

<script type="text/javascript">

/*********************************************************
 * 페이징 처리 함수
 ******************************************************** */
function fn_aram_linkPage(pageNo){
    var varForm = document.getElementById("vcatnManageVO");
	varForm.pageIndex.value = pageNo;
	varForm.action = "${pageContext.request.contextPath}/uss/ion/vct/listVcatn.do";
	varForm.submit();
}

/* ********************************************************
 * 조회 처리 
 ******************************************************** */
 /*설명 : 목록 조회 */
function fn_aram_search(){
    var varForm = document.getElementById("vcatnManageVO");
	varForm.pageIndex.value = "1";
	varForm.action = "${pageContext.request.contextPath}/uss/ion/vct/listVcatn.do";
	varForm.submit();
}

/* ********************************************************
 * 상세화면 호출함수
 ******************************************************** */
function fn_aram_detail(applcntId,vcatnSe,bgnde,endde){
    var varForm = document.getElementById("vcatnManageVO");
	varForm.applcntId.value  = applcntId;
	varForm.vcatnSe.value    = vcatnSe;
	varForm.bgnde.value      = bgnde;
	varForm.endde.value      = endde;
	varForm.action           = "${pageContext.request.contextPath}/uss/ion/vct/detailVcatn.do";
	varForm.submit();
}

/* ********************************************************
 * 등록 화면 호출 함수 
 ******************************************************** */
function fn_aram_regist(){
    var varForm = document.getElementById("vcatnManageVO");
	varForm.applcntId.value  = "";
	varForm.vcatnSe.value    = "";
	varForm.bgnde.value      = "";
	varForm.endde.value      = "";
	varForm.action           = "${pageContext.request.contextPath}/uss/ion/vct/registVcatn.do";
	varForm.submit();
}

</script>
