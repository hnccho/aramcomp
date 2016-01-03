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
 * @Class Name : SchdulRegist.jsp
 * @Description : 일정관리 등록 페이지
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
        <div id="content">
            <div id="cur_loc">
                <ul>
                    <li>HOME</li>
                    <li>&gt;</li>
                    <li>사용자관리</li>
                    <li>&gt;</li>
                    <li><strong>일정관리 등록</strong></li>
                </ul>
            </div>
            <!-- 검색 필드 박스 시작 -->
            <div id="search_field">
                <div id="search_field_loc"><h2><strong>일정관리 등록</strong></h2></div>
            </div>

            <form:form commandName="schdulManageVO" action="" method="post" enctype="multipart/form-data">
            <form:hidden path="othbcScope" value="2" />

                <div class="modify_user">
                    <table>
                        <tr>
                            <th width="20%"  class="required_text">
                            	일정구분	
						        <img src="${pageContext.request.contextPath}/images/home/sample/required.gif" width="15" height="15" alt="required" />
                            </th>
                            <td width="80%">
                                <form:select path="schdulSe">
                                    <form:option value="" label="선택"/>
                                    <form:options items="${COM030_schdulSe}" itemValue="code" itemLabel="codeNm"/>
                                </form:select>
                                <form:errors path="schdulSe" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <th width="20%"  class="required_text">
                            	중요도
						        <img src="${pageContext.request.contextPath}/images/home/sample/required.gif" width="15" height="15" alt="required" />
                            </th>
                            <td width="80%">
                                <form:select path="schdulIpcrCode">
                                    <form:option value="" label="선택"/>
                                    <form:options items="${schdulIpcrCode}" itemValue="code" itemLabel="codeNm"/>
                                </form:select>
                                <form:errors path="schdulIpcrCode" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <th width="20%"  class="required_text">
                            	일정명
						        <img src="${pageContext.request.contextPath}/images/home/sample/required.gif" width="15" height="15" alt="required" />
                            </th>
                            <td width="80%">
                                <form:input path="schdulNm" size="73" cssClass="txInput"  />
                                <form:errors path="schdulNm" cssClass="error"/>
                            </td>
                        </tr>
                        <tr>
                            <th  class="required_text">
                            	일정 내용
						        <img src="${pageContext.request.contextPath}/images/home/sample/required.gif" width="15" height="15" alt="required" />
                            </th>
                            <td>
                                <form:textarea path="schdulCn" rows="3" cols="80" />
                                <form:errors path="schdulCn" cssClass="error"/>
                            </td>
                        </tr>
                        <tr> 
                          	<th width="20%"  class="required_text">
                          		반복구분
						        <img src="${pageContext.request.contextPath}/images/home/sample/required.gif" width="15" height="15" alt="required" />
                          	</th>
                          	<td width="80%">
                              	<form:radiobutton path="reptitSeCode" value="1" />당일
                              	<form:radiobutton path="reptitSeCode" value="2"/>반복
                              	<form:radiobutton path="reptitSeCode" value="3"/>연속
                              	<form:errors path="reptitSeCode" cssClass="error"/>
                          	</td>
                        </tr>
                        
                        <tr> 
                            <th width="20%"  class="required_text">
                            	날짜/시간
						        <img src="${pageContext.request.contextPath}/images/home/sample/required.gif" width="15" height="15" alt="required" />
                            </th>
                            <td width="80%">
                				<input type="hidden" name="schdulBgnde" id="schdulBgnde" value="" />  
                                <form:input path="schdulBgndeYYYMMDD" size="10" readonly="true" maxlength="10" />
                                <a href="#" onClick="javascript:fn_aram_NormalCalendar('', document.forms[0].schdulBgndeYYYMMDD); return false;">
                                	<img src="${pageContext.request.contextPath}/images/home/sample/calendar.gif"  align="middle" style="border:0px" alt="일정시작달력" title="일정시작달력">
                                </a>
                                &nbsp;&nbsp;~&nbsp;&nbsp;
                				<input type="hidden" name="schdulEndde" id="schdulEndde" value="" /> 
                                <form:input path="schdulEnddeYYYMMDD" size="10" readonly="true" maxlength="10" />
                                <a href="#" onClick="javascript:fn_aram_NormalCalendar('', document.forms[0].schdulEnddeYYYMMDD); return false;">
                                	<img src="${pageContext.request.contextPath}/images/home/sample/calendar.gif" align="middle" style="border:0px" alt="일정종료달력" title="일정종료달력">
                                </a>&nbsp;&nbsp;
                                    
                                <form:select path="schdulBgndeHH">
                                    <form:options items="${schdulBgndeHH}" itemValue="code" itemLabel="codeNm"/>
                                </form:select>시
                                <form:select path="schdulBgndeMM">
                                    <form:options items="${schdulBgndeMM}" itemValue="code" itemLabel="codeNm"/>
                                </form:select>분
                                ~
                                <form:select path="schdulEnddeHH">
                                    <form:options items="${schdulEnddeHH}" itemValue="code" itemLabel="codeNm"/>
                                </form:select>시
                                <form:select path="schdulEnddeMM">
                                    <form:options items="${schdulEnddeMM}" itemValue="code" itemLabel="codeNm"/>
                                </form:select>분
                            </td>
                        </tr>
                          
                        <!-- 첨부파일 테이블 레이아웃 설정 Start.. -->
                        <tr>
                            <th  class="required_text">파일첨부</th>
                            <td>
								<input type="hidden" name="posblAtchFileNumber" id="posblAtchFileNumber" value="3" />  
 
                                <input name="file_1" id="egovComFileUploader" title="파일첨부" type="file" />
                                <div id="egovComFileList"></div>
                            </td>
                        </tr>
                        <!-- 첨부파일 테이블 레이아웃 End. -->

                    </table>
                </div>
                
				<!-- 첨부파일 업로드 가능화일 설정 Start..-->
				<script type="text/javascript">
					fn_init_FileAttachment();
				</script>
				<!--  첨부파일 업로드 가능화일 설정 End.--> 
				
                <!-- 버튼 시작(상세지정 style로 div에 지정) -->
            	<div class="buttons buttons_padding">
                    <!-- 목록/저장버튼  -->
                 	<div class="buttons_center">
                       	<a href="#" onclick="JavaScript:fn_aram_list_indvdlSchdulManage(); return false;"><spring:message code="button.list" /></a> 
                       	<a href="#" onclick="JavaScript:fn_aram_insert_indvdlSchdulManage(); return false;"><spring:message code="button.save" /></a> 
					</div>
                </div>
                <!-- 버튼 끝 -->                           
            </form:form>

        </div>  
        
<script type="text/javascript" src="${pageContext.request.contextPath}/validator.do"></script>
<validator:javascript formName="schdulManageVO" staticJavascript="false" xhtml="true" cdata="false"/>

<script type="text/javascript" src="${pageContext.request.contextPath}/js/aramframework/com/sym/cal/CalPopup.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/aramframework/com/cmm/fms/MultiFile.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath}/js/aramframework/com/cmm/utl/CmmUtl.js"></script>
<script type="text/javascript">

/* ********************************************************
 * 초기화
 ******************************************************** */
window.onload = function() {

    document.getElementsByName('reptitSeCode')[0].checked = true;
    if("${schdulManageVO.schdulBgnde}".length> 0){
        var schdulBgnde = "${schdulManageVO.schdulBgnde}";
        document.getElementById("schdulBgndeYYYMMDD").value = schdulBgnde.substring(0,4) + "-" + schdulBgnde.substring(4,6) + "-" + schdulBgnde.substring(6,8);
    }
    if("${schdulManageVO.schdulEndde}".length> 0){
        var schdulEndde = "${schdulManageVO.schdulEndde}";
        document.getElementById("schdulEnddeYYYMMDD").value = schdulEndde.substring(0,4) + "-" + schdulEndde.substring(4,6) + "-" + schdulEndde.substring(6,8);
    }
};

/* ********************************************************
* 목록 으로 가기
******************************************************** */
function fn_aram_list(){
    var varForm = document.getElementById("schdulManageVO");
	varForm.action = "${pageContext.request.contextPath}/cop/smt/sim/listSchdulMonth.do";
    varForm.submit();
}

/* ********************************************************
* 저장처리화면
******************************************************** */
function fn_aram_insert(){
  	var form = document.getElementById("schdulManageVO");
  	
  	if(!validateschdulManageVO(document.schdulManageVO)){  
      	return;
  	}
  	
  	var schdulBgndeYYYMMDD = document.getElementById('schdulBgndeYYYMMDD').value;
  	var schdulEnddeYYYMMDD = document.getElementById('schdulEnddeYYYMMDD').value;
  	schdulBgndeYYYMMDD = schdulBgndeYYYMMDD.replaceAll('-','');
  	schdulEnddeYYYMMDD = schdulEnddeYYYMMDD.replaceAll('-','');
  	if(schdulBgndeYYYMMDD> schdulEnddeYYYMMDD) { alert("일정종료일자가  일정시작일자보다 작을수 없습니다"); return false; }
  	form.schdulBgnde.value = schdulBgndeYYYMMDD.replaceAll('-','') + fn_aram_SelectBoxValue('schdulBgndeHH') +  fn_aram_SelectBoxValue('schdulBgndeMM') + '00';
  	form.schdulEndde.value = schdulEnddeYYYMMDD.replaceAll('-','') + fn_aram_SelectBoxValue('schdulEnddeHH') +  fn_aram_SelectBoxValue('schdulEnddeMM') + '00';

	if (confirm("<spring:message code='common.regist.msg' />"))    {  
		varForm.action = "${pageContext.request.contextPath}/cop/smt/sim/insertSchdul.do";
        form.submit();
  	}
}

/* ********************************************************
* PROTOTYPE JS FUNCTION
******************************************************** */
String.prototype.trim = function(){
  	return this.replace(/^\s+|\s+$/g, "");
};

String.prototype.replaceAll = function(src, repl){
   	var str = this;
   	if(src == repl){return str;}
   	while(str.indexOf(src) != -1) {
      	str = str.replace(src, repl);
   	}
   	return str;
};

</script>
