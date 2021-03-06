<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="/WEB-INF/struts-layout.tld" prefix="layout" %>
<c:set var="adminBean" scope="session" value="${adminBean}"/>
<c:set var="productClassListingForm" scope="request" value="${productClassListingForm}"/>

<script language="JavaScript">
function submitNewForm(page) {
    document.forms[0].action = '/<c:out value='${adminBean.contextPath}'/>/admin/productClass/productClassMaint.do';
    document.forms[0].process.value = "create";
    document.forms[0].submit();
    return false;
}

function submitForm(methodType) {
    document.forms[0].action = '/<c:out value='${adminBean.contextPath}'/>/admin/productClass/productClassListing.do';
    document.forms[0].process.value = methodType;
    document.forms[0].submit();
    return false;
}
</script>
<html:form action="/admin/productClass/productClassListing.do" method="post">
<html:hidden property="process" value="list"/>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="jc_top_navigation">
  <tr> 
    <td>Administration - Product Class Listing</td>
  </tr>
</table>
<br>
<table width="100%" border="0" cellspacing="0" cellpadding="0">
  <tr> 
    <td width="0%" valign="top"> 
      <div class="jc_search_panel_open"> 
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
          <tr> 
            <td> 
              <table class="jc_panel_table_header" width="100%" border="0" cellspacing="0" cellpadding="0">
                <tr> 
                  <td>Search</td>
                  <td> 
                    <div align="right"> 
                      <html:submit property="submitButton" value="Search" styleClass="jc_submit_button" onclick="return submitForm('list');"/>
                      <html:submit property="submitButton" value="New" styleClass="jc_submit_button" onclick="return submitNewForm('');"/>
                    </div>
                  </td>
                </tr>
              </table>
            </td>
          </tr>
          <tr> 
            <td>&nbsp; </td>
          </tr>
          <tr> 
            <td class="jc_input_label">Product class</td>
          </tr>
          <tr> 
            <td class="jc_input_object"> <layout:text layout="false" property="srProductClassName" mode="E,E,E" styleClass="jc_input_object"/> 
            </td>
          </tr>
          <tr> 
            <td>&nbsp; </td>
          </tr>
          <tr> 
            <td>&nbsp; </td>
          </tr>
        </table>
      </div>
    </td>
    <td width="100%" valign="top" class="jc_list_panel_open"> 
      <c:if test="${productClassListingForm.productClasses != null}">
        <table class="jc_panel_table_header" width="100%" border="0" cellspacing="0" cellpadding="0" class="jc_panel_table_header">
          <tr> 
            <td>Product Class Listing 
              Result</td>
            <td> 
              <div align="right">
                <html:submit property="submitButton" value="Remove" styleClass="jc_submit_button" onclick="return submitForm('remove');"/>
                <html:submit property="submitButton" value="New" styleClass="jc_submit_button" onclick="return submitNewForm('create');"/>
              </div>
            </td>
          </tr>
		</table>
        <span class="jc_input_error">
        <br>
        <logic:messagesPresent property="error" message="true"> 
          <html:messages property="error" id="errorText" message="true"> 
          <bean:write name="errorText"/><br><br>
          </html:messages> 
        </logic:messagesPresent>
        </span>
        <table width="100%" border="0" cellspacing="0" cellpadding="1">
           <tr> 
            <td class="jc_list_table_header"></td>
            <td class="jc_list_table_header">Product Class</td>
            <td class="jc_list_table_header">
              <div align="center">System</div>
            </td>
          </tr>
          <c:forEach var="productClass" items="${productClassListingForm.productClasses}">
          <tr class="jc_list_table_row"> 
            <td width="50" class="jc_list_table_content">
              <div align="center">
	            <c:choose>
				  <c:when test="${productClass.systemRecord == 'Y'}">
				    <input type="checkbox" name="productClassIds" value="${productClass.productClassId}" disabled>
				  </c:when>
				  <c:otherwise>
					<input type="checkbox" name="productClassIds" value="${productClass.productClassId}">
				  </c:otherwise>
				</c:choose>
              </div>
            </td>
            <td width="300" class="jc_list_table_content">
              <html:link page="/admin/productClass/productClassMaint.do?process=edit" paramId="productClassId" paramName="productClass" paramProperty="productClassId">
                <c:out value="${productClass.productClassName}"/>
              </html:link>
            </td>
            <td>
              <div align="center">${productClass.systemRecord}</div>
            </td>
          </tr>
          </c:forEach>
        </table>
      </c:if>
    </td>
  </tr>
</table>
</html:form>
