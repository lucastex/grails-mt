<html>
    <head>
        <title>Agenda</title>
    </head>
    <body>
        <ul>
            <g:each in="${shows}" var="show">
                <li>
                    ${show.tenantId} will rock at ${show.city} on
                    <g:formatDate date="${show.when}" format="MM/dd/yy" /> for
                    <g:formatNumber number="${show.price}" currencyCode="USD" type="currency" />
                </li>
            </g:each>
        </ul>
    </body>
</html>