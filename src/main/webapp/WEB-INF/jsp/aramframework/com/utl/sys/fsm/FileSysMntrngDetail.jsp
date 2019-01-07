<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<% 
/**
 * @Class Name : FileSysMntrngDetail.jsp
 * @Description : 파일시스템모니터링 상세조회
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
	<h2>파일시스템모니터링 상세조회</h2>
</div>

<div id="search_area">
	<div class="button_area">
		<span class="button"><a href="#" onclick="javascript:fn_aram_edit(); return false;"><spring:message code="button.update" /></a></span>
		<span class="button"><a href="#" onclick="javascript:fn_aram_delete(); return false;"><spring:message code="button.delete" /></a></span>
		<span class="button"><a href="#" onclick="javascript:fn_aram_list(); return false;"><spring:message code="button.list" /></a></span>
	</div>
</div>

<form:form commandName="fileSysMntrngVO" method="post" action="">
<input type="hidden" name="curTrgetId" value="${curTrgetId}" />
<input type="hidden" name="curMenuNo" value="${curMenuNo}" />

<form:hidden path="fileSysId" />

<table class="table-detail" summary="이 표는 파일시스템모니터링 대상 정보를 제공하며, 파일시스템명, 파일시스템관리명, 파일시스템 크기, 파일시스템 임계치, 파일시스템사용량, 관리자명, 관리자이메일주소, 모니터링상태, 마지막생성일시 정보로 구성되어 있습니다 .">
<caption>파일시스템모니터대상 상세보기</caption>
<tbody>
	<tr> 
		<th width="20%">
			파일시스템명
		</th>
		<td width="80%">
			<c:out value='${fileSysMntrngVO.fileSysNm}'/>
		</td>
	</tr>
	<tr> 
	    <th>
	    	파일시스템관리명
	    </th>
	    <td>
	      <c:out value='${fileSysMntrngVO.fileSysManageNm}'/>
	    </td>
	</tr>
	<tr> 
	    <th>
	    	파일시스템 크기
	    </th>
	    <td>
	      <c:out value='${fileSysMntrngVO.fileSysMg}'/>G
	    </td>
	</tr>
	<tr> 
	    <th>
	    	파일시스템 임계치
	    </th>
	    <td>
	      	<c:out value='${fileSysMntrngVO.fileSysThrhldRt}'/>% (<c:out value='${fileSysMntrngVO.fileSysThrhld}'/>G)
	    </td>
	</tr>
	<tr> 
	    <th>
	    	파일시스템 사용량
	    </th>
	    <td>
	      	<c:out value='${fileSysMntrngVO.fileSysUsgRt}'/>% (<c:out value='${fileSysMntrngVO.fileSysUsgQty}'/>G)
	    </td>
	</tr>
	<tr> 
	    <th>
	    	관리자명
	    </th>
	    <td>
	      	<c:out value='${fileSysMntrngVO.mngrNm}'/>
	    </td>
	</tr>
	<tr> 
	    <th>
	    	관리자이메일주소
	    </th>
	    <td>
	      	<c:out value='${fileSysMntrngVO.mngrEmailAddr}'/>
	    </td>
	</tr>
	<tr> 
	    <th>
	    	모니터링상태
	    </th>
	    <td>
	      	<c:out value="${fileSysMntrngVO.mntrngSttus}" />
	    </td>
	</tr>
	<tr> 
	    <th>
	    	마지막 생성일시
	    </th>
	    <td>
	      	<c:out value="${fileSysMntrngVO.creatDt}" />
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
<validator:javascript formName="fileSysMntrngVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/aramframework/com/sym/cal/CalPopup.js"></script>
<script type="text/javascript">

/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fn_aram_list(){
    var varForm = document.getElementById("fileSysMntrngVO");
    varForm.action = "${pageContext.request.contextPath}/utl/sys/fsm/listFileSysMntrng.do";
    varForm.submit();	
}	

function fn_aram_edit() {
    var varForm = document.getElementById("fileSysMntrngVO");
    varForm.action = "${pageContext.request.contextPath}/utl/sys/fsm/editFileSysMntrng.do";
    varForm.submit();	
}

function fn_aram_delete(){
    var varForm = document.getElementById("fileSysMntrngVO");
    
	if(confirm("<spring:message code='common.delete.msg'/>")){
		varForm.action = "${pageContext.request.contextPath}/utl/sys/fsm/deleteFileSysMntrng.do";
		varForm.submit();
	}
}

</script>
