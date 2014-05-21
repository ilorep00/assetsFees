<%@ include file="/WEB-INF/views/include.jsp" %>

<html>
  <head><title><fmt:message key="title"/></title></head>
  <body>
    <h1><fmt:message key="heading"/></h1>
    <p><fmt:message key="greeting"/> <c:out value="${model.now}"/></p>
    <h3>Fees:</h3>
    <c:forEach items="${model.products}" var="prod">
      Expiration date: <c:out value="${prod.getExpiration()}"/> <i> Import of term: <c:out value="${prod.getImportOfTerm()}"/></i> <i> Capital Amortization: <c:out value="${prod.getAmortization()}"/></i> <i> Interests: <c:out value="${prod.getInterests()}"/></i> <i> Pending capital: <c:out value="${prod.getOutstandingCapital()}"/></i> <i> Is paid: <c:out value="${prod.isPaid()}"/></i><br><br>
    </c:forEach>
    <br>
    <a href="<c:url value="changemethod.htm"/>">Change Method</a>
    <br>
  </body>
</html>