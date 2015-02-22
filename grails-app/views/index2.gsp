
<head>
    <meta name="layout" content="login_bar"/>       
</head>

<div class="container">
    <div class="row vertical-offset-100">
        <div class="col-md-4 col-md-offset-4">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="panel-title">Register</h3>
                </div>
                <div class="panel-body">
                    <form method="post" class="formit" action="/SIUrbanos/user/save">
                        <fieldset>
                            <div class="form-group">
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
        </div>
    </div>
</div>