<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="validator" uri="http://www.springmodules.org/tags/commons-validator" %>
<%
/**
 * @Class Name : AdministrationWordEdit.jsp
 * @Description : 행정전문용어사전 수정
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
<%pageContext.setAttribute("crlf", "\r\n"); %>

<DIV id="main">

<div class="content_title">
	<h2>행정전문용어사전 수정</h2>
</div>

<div id="search_area">
	<div class="button_area">
		<span class="button"><a href="#" onclick="javascript:fn_aram_update(); return false;"><spring:message code="button.save" /></a></span>
		<span class="button"><a href="#" onclick="javascript:fn_aram_list(); return false;"><spring:message code="button.list" /></a></span>
	</div>
</div>

<form:form commandName="administrationWordVO" action="" method="post">
<input type="hidden" name="curTrgetId" value="${curTrgetId}" />
<input type="hidden" name="curMenuNo" value="${curMenuNo}" />

<form:hidden path="administWordId" />

<!--  등록  폼 영역  -->
<table class="table-register" summary="행정전문용어사전관리 수정을 제공한다.">
  	<tr>
    	<th width="20%">
    		<span class="required_icon"></span>
    		<label id="IdAdministWordNm">행정용어명</label>
    	</th>
    	<td width="80%">
      		<form:input path="administWordNm" size="73" cssClass="txInput" maxlength="255" onchange ="change(this.value)" />
      		<form:errors path="administWordNm" cssClass="error"/>
    	</td>
  	</tr>
  	<tr>
    	<th>
    		<span class="required_icon"></span>
    		<label id="IdAdministWordEngNm">행정용어영문명</label>
    	</th>
    	<td>
      		<form:input path="administWordEngNm" size="73" cssClass="txInput" maxlength="255"/>
      		<form:errors path="administWordEngNm" cssClass="error"/>
    	</td>
  	</tr>
  	<tr>
    	<th>
     		<span class="required_icon"></span>
    		<label id="IdAdministWordAbrv">행정용어약어명</label>
    	</th>
    	<td>
      		<form:input path="administWordAbrv" size="73" cssClass="txInput" maxlength="255"/>
      		<form:errors path="administWordAbrv" cssClass="error"/>
    	</td>
  	</tr>
  	<tr>
    	<th>
    		<span class="required_icon"></span>
    		<label id="IdAhemaRelm">주제영역</label>
    	</th>
    	<td>
      		<form:input path="themaRelm" size="73" cssClass="txInput" maxlength="255"/>
      		<form:errors path="themaRelm" cssClass="error"/>
    	</td>
  	</tr>
  	<tr>
    	<th>
     		<span class="required_icon"></span>
    		<label id="IdAordDomn">용어구분</label>
    	</th>
    	<td>
			<form:select path="wordDomn" title="용어구분선택">
				<form:option value="" label="선택" />
				<form:option value="1" label="표준어" />
				<form:option value="2" label="동의어" />
			</form:select>
    	</td>
  	</tr>
  	<tr>
    	<th>
    		<span class="norequired_icon"></span>
    		<label for="stdWord">관련표준용어</label>
    	</th>
    	<td>
      		<form:input path="stdWord" size="73" cssClass="txInput" maxlength="255"/>
      		<form:errors path="stdWord" cssClass="error"/>
    	</td>
  	</tr>
  	<tr>
        <th>
     		<span class="norequired_icon"></span>
    		<label for="administWordDf">행정전문용어 <br>정의</label>
    	</th>
    	<td>
        	<form:textarea path="administWordDf" rows="3" cols="20" cssClass="txArea"/>
    		<form:errors path="administWordDf" cssClass="error"/>
    	</td>
  	</tr>
  	<tr>
        <th>
     		<span class="norequired_icon"></span>
    		<label for="administWordDc">행정전문용어 <br>설명</label>
    	</th>
    	<td>
        	<form:textarea path="administWordDc" rows="3" cols="20" cssClass="txArea"/>
    		<form:errors path="administWordDc" cssClass="error"/>
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
<validator:javascript formName="administrationWordVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script type="text/javascript">

/* ********************************************************
 * 목록 으로 가기
 ******************************************************** */
function fn_aram_list(){
    var varForm = document.getElementById("administrationWordVO");
    varForm.action = "${pageContext.request.contextPath}/uss/olh/awm/listAdministrationWord.do";
    varForm.submit();
}

/* ********************************************************
 * 저장처리화면
 ******************************************************** */
function fn_aram_update(){
    var varForm = document.getElementById("administrationWordVO");
    
	if(!validateAdministrationWordVO(varForm)){
		return;
	}

	if(confirm("<spring:message code='common.update.msg'/>")){
		varForm.action =  "${pageContext.request.contextPath}/uss/olh/awm/updateAdministrationWord.do";
		varForm.submit();
	}
}

/* ********************************************************
* 영문일때 첫글자를 대문자로 변환
******************************************************** */
function change(str) {
    var varForm = document.getElementById("administrationWordVO");
  	leng =str.length;
  	for (i =0; i <=leng; i++) {
    	if (i==0) {
      		if (str.charAt(i) !=" "){
        		done =str.substring(0,1).toUpperCase();
      		} else {
        		done =" ";
      		}
    	} else {
      		if (str.charAt(i) ==" "){
        		done+=" ";
      		} else {
        		if (str.charAt(i-1)==" ") {
          			done+=str.substring(i,i+1).toUpperCase();
        		} else {
          			done+=str.substring(i,i+1).toLowerCase();
        		}
      		}  // if 종료
    	}  // for 종료
  	}
  	varForm.administWordNm.value=done;
  	return done;
}

</script>
