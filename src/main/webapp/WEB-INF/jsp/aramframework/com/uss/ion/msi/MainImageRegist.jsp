<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%
/**
 * @Class Name : MainImageRegist.jsp
 * @Description : 메인화면이미지 등록
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
	<h2>메인화면이미지 등록</h2>
</div>

<div id="search_area">
	<div class="button_area">
		<span class="button"><a href="#" onclick="javascript:fn_aram_insert(); return false;"><spring:message code="button.save" /></a></span>
		<span class="button"><a href="#" onclick="javascript:fn_aram_list(); return false;"><spring:message code="button.list" /></a></span>
	</div>
</div>

<form:form commandName="mainImageVO" method="post" action="" enctype="multipart/form-data"> 
<input type="hidden" name="curTrgetId" value="${curTrgetId}" />
<input type="hidden" name="curMenuNo" value="${curMenuNo}" />

<input type="hidden" name="image">
<input type="hidden" name="imageId">

<table class="table-register" summary="메인화면이미지를 등록한다.">
<caption>메인화면이미지 등록</caption>
  	<tr>
    	<th width="20%">
     		<span class="required_icon"></span>
    		이미지명
    	</th>
    	<td>
    		<form:input path="imageNm" title="이미지명" maxLength="10" size="20" />
    	</td>
  	</tr>
  	<tr>
    	<th>
     		<span class="required_icon"></span>
    		이미지
    	</th>
    	<td>
			<input type="hidden" name="posblAtchFileNumber" value="1">
        	<input type="file" name="file_1" id="egovComFileUploader" title="이미지" onchange="javascript:fn_aram_change_image();">
    	</td>
  	</tr>
  	<tr>
    	<th>
    		<span class="norequired_icon"></span>
    		이미지설명
    	</th>
    	<td>
    		<form:input path="imageDc" title="이미지설명" maxLength="100" size="80" />
    	</td>
  	</tr>
  	<tr>
    	<th>
     		<span class="required_icon"></span>
    		반영여부
    	</th>
    	<td>
      		<form:select path="reflctAt" title="반영여부">
          		<form:option value="Y" label="Y" />
          		<form:option value="N" label="N" />
      		</form:select>
   		</td>
  	</tr>
  	<tr>
    	<th>
     		<span class="norequired_icon"></span>
    		등록일시
    	</th>
    	<td>
    		<form:input path="regDate" title="등록일시" maxLength="50" size="20" class="readOnlyClass" readonly="true" />
    	</td>
  	</tr>
</table>

<!-- 검색조건 유지 -->
<input type="hidden" name="searchCondition" value="${searchVO.searchCondition}" />
<input type="hidden" name="searchKeyword"   value="${searchVO.searchKeyword}" />
<input type="hidden" name="pageIndex"       value="${searchVO.pageIndex}" />
<input type="hidden" name="recordPerPage"   value="${searchVO.recordPerPage}" />
<!-- 검색조건 유지 -->
</form:form>

</DIV>

<script type="text/javascript" src="${pageContext.request.contextPath}/validator.do"></script>
<validator:javascript formName="mainImageVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/aramframework/com/cmm/fms/MultiFile.js"></script>
<script type="text/javascript">

function fn_aram_list() {
    var varForm = document.getElementById("mainImageVO");
    varForm.action = "${pageContext.request.contextPath}/uss/ion/msi/listMainImage.do";
    varForm.submit();
}

function fn_aram_insert() {
    var varForm = document.getElementById("mainImageVO");
    
    if(!validateMainImageVO(varForm)){
        return;
    }

    if(varForm.image.value == '') {
        alert("이미지는 필수 입력값입니다.");
        return;
    }

	if(confirm("<spring:message code='common.regist.msg'/>")){
        varForm.action = "${pageContext.request.contextPath}/uss/ion/msi/insertMainImage.do";
        varForm.submit();
    }
}

function fn_aram_change_image() {
    var varForm = document.getElementById("mainImageVO");
    varForm.image.value = varForm.file_1.value;
}

</script>
