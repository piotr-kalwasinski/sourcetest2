<%--
  Created by IntelliJ IDEA.
  User: piotr
  Date: 4/29/19
  Time: 10:00 PM
--%>

<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>

</head>

<body>

<div id="create-request" class="content scaffold-create" role="main">
    <g:form resource="${this.userRequest}" method="POST">
        <fieldset class="form">
            Result
            <g:field type="text"  name="result" size="100" value="${userRequest?.requestResponse}"/>
            <g:actionSubmit action="index"  value="Back" />
        </fieldset>

    </g:form>
</div>

</body>
</html>