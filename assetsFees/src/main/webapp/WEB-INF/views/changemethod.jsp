<%@ include file="/WEB-INF/views/include.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
  <title><fmt:message key="title"/></title>
  <style>
    .error { color: red; }
  </style>  
</head>
<body>
<h1><fmt:message key="priceincrease.heading"/></h1>
Select the number of the method:<br><br>
1: American method<br><br>
2: French method<br><br>
3: German method<br><br>
4: Italian method<br><br>
5: Progressive method<br><br>
<form:form method="post" commandName="changeMethod">
  <table width="95%" bgcolor="f8f8ff" border="0" cellspacing="0" cellpadding="5">
    <tr>
      <td align="right" width="20%">Type of method:</td>
        <td width="20%">
          <form:input path="type"/>
        </td>
        <td width="60%">
          <form:errors path="type" cssClass="error"/>
        </td>
    </tr>
  </table>
  <br>
  <input type="submit" value="Execute">
</form:form>
<a href="<c:url value="hello.htm"/>">Home</a>
</body>
</html>