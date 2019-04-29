<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>
<div id="create-request" class="content scaffold-create" role="main">
    <g:form resource="${this.userRequest}" method="POST">
        <fieldset class="form">
            Search for coordinates based on zip code:
            <g:field type="text" name="zipcode" min="5" max="10"  value="${userRequest?.requestAt}"/>
             <g:actionSubmit action="requestByZipCode"  value="Queue Search" />
             Get Area of sector:
            <g:field type="text" name="sector" min="5" max="10"/>
            <g:actionSubmit action="requestBySector"  value="Queue Search" />
        </fieldset>

    </g:form>


    <f:table collection="${requestList}"
             properties="['requestAt', 'requestType','usersInput','requestStatus','requestStartAt','requestCompletedAt']"/>

</div>
</body>
</html>