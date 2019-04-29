<table border="1">
    <thead>
    <tr>
        <g:each in="${domainProperties}" var="p" status="i">
            <g:sortableColumn property="${p.property}" title="${p.label}" />
        </g:each>
        <td>
            Fetch result
        </td>
    </tr>
    </thead>
    <tbody>
    <g:each in="${collection}" var="bean" status="i">
        <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">
            <g:each in="${domainProperties}" var="p" status="j">
                    <td><f:display bean="${bean}" property="${p.property}"  displayStyle="${displayStyle?:'table'}" theme="${theme}"/></td>
            </g:each>
            <td><g:link method="GET" resource="${bean}">
                [Get] </g:link>
            </td>

        </tr>
    </g:each>
    </tbody>
</table>
