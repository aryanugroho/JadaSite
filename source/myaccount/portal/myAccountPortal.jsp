<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:set var="emptyTemplateInfo" scope="request" value="${emptyTemplateInfo}"/>
<c:out escapeXml="false" value="${emptyTemplateInfo.templatePrefix}"/>
<jsp:include page="/myaccount/portal/myAccountPortalBody.jsp" />
<c:out escapeXml="false" value="${emptyTemplateInfo.templateSuffix}"/>