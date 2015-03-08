<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'menu.css')}" type="text/css"> 
        <link rel="stylesheet" href="https://bootswatch.com/darkly/bootstrap.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.1/jquery.min.js"></script>
        <g:layoutHead/>
    </head>
    <body>
        <!--BARRA DE NAVEGACION-->
        <div class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <a class="navbar-brand" href="#">SI Urbanos</a>
                </div>
                
                    <div class="navbar-collapse collapse" id="navbar-main">

                        <g:if test="${session.user}">
                            <form method="POST" class="navbar-form navbar-right" action="/SIUrbanos/user/logout/">

                                <button type="submit" class="btn btn-default">Log out</button>
                            </form>				
                        </g:if>
                        <g:else>
                            <form method="POST" class="navbar-form navbar-right" action="/SIUrbanos/user/login/">
                                <div class="form-group">
                                    <input type="text" class="form-control" name="id" placeholder="ID">
                                </div>
                                <div class="form-group">
                                    <input type="password" class="form-control" name="password" placeholder="Password">
                                </div>
                                <button type="submit" class="btn btn-default">Log In</button>
                            </form>
                        </g:else>
                        <g:if test="${flash.message}">
                            <div class="message" role="status">${flash.message}</div>
                        </g:if>
                    </div>
                    <a id="menu-toggle" href="#" class="btn btn-primary btn-lg toggle"><i class="glyphicon glyphicon-bookmark"></i></a>
                    <div id="sidebar-wrapper">
                        <ul class="sidebar-nav">
                            <a id="menu-close" href="#" class="btn btn-default btn-lg pull-right toggle"><i class="glyphicon glyphicon-remove"></i></a>
                            <li class="sidebar-brand">
                                <a href="#">SI Urbanos</a>
                            </li>
                            <li>
                                <a href="#">Inicio</a>
                            </li>
                            <li>
                                <a href="${createLink(controller:'card', action:'recargar')}">Recargar</a>
                            </li>
                            <li>
                                <a href="${createLink(controller:'recharge', action:'historialRecargas')}">Historial de recargas</a>
                                
                            </li>
                            <li>
                                <a href="${createLink(controller:'route', action:'historialRutas')}">Historial de viajes</a>
                            </li>
                        </ul>
                    </div>
                
            </div>
        </div>

        <script>
            $("#menu-close").click(function(e) {
            e.preventDefault();
            $("#sidebar-wrapper").toggleClass("active");
            });
            $("#menu-toggle").click(function(e) {
            e.preventDefault();
            $("#sidebar-wrapper").toggleClass("active");
            });
        </script>
        <g:layoutBody/>
    </body>
</html>
