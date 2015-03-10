
<head>
    <meta name="layout" content="login_bar"/>       
</head>

<div class="container" style="margin-top: 250px;">
    <div class="row vertical-offset-100">
        <div class="col-md-4 col-md-offset-4">
            <g:if test="${!session.user}">
                <div class="panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Register</h3>
                    </div>
                    <div class="panel-body">
                        <g:hasErrors bean="${userInstance}">
                            <ul class="errors" role="alert">
                                <g:eachError bean="${userInstance}" var="error">
                                    <li <g:if test="${error in org.springframework.validation.FieldError}">data-field-id="${error.field}"</g:if>><g:message error="${error}"/></li>
                                    </g:eachError>
                            </ul>
                        </g:hasErrors>

                        <form method="post" class="formit" action="/SIUrbanos/user/save">
                            <fieldset>
                                <div class="form-group">
                                    <p style="font-size: 12px;">El ID es la cédula del ciudadano</p>
                                    <input class="form-control" placeholder="ID" name="idUser" type="text">

                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Name" name="userName" type="text" value="">
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>

                                <input class="btn btn-primary btn-lg btn-block" type="submit" value="Register">
                            </fieldset>
                        </form>

                    </div>
                </div>
            </g:if>
        </div>
    </div>
</div>