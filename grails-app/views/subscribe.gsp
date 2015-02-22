
<head>
    <link rel="stylesheet" href="${resource(dir: 'css', file: 'subscribe.css')}" type="text/css"> 
</head>

<body>
    <div class="container">
        

        <div class="jumbotron">
            
            <div class="page-header">
                <h1>Obtenga su </h1>
                
            </div>
            <div><img src="${resource(dir:"images", file: "tarjeta.png") }"/></div>
        </div>

        <form class="form-horizontal">
<!--            <div class="form-group">
                <label class="control-label col-xs-3">Email:</label>
                <div class="col-xs-9">
                    <input type="email" placeholder="Email" id="inputEmail" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3">Password:</label>
                <div class="col-xs-9">
                    <input type="password" placeholder="Password" id="inputPassword" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3">Confirmar Password:</label>
                <div class="col-xs-9">
                    <input type="password" placeholder="Confirmar Password" class="form-control">
                </div>
            </div>-->
            <div class="form-group">
                <label class="control-label col-xs-3">Nombre:</label>
                <div class="col-xs-9">
                    <input type="text" placeholder="Nombre" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3">Apellido:</label>
                <div class="col-xs-9">
                    <input type="text" placeholder="Apellido" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3">Telefono:</label>
                <div class="col-xs-9">
                    <input type="tel" placeholder="Teléfono" class="form-control">
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3">F. Nacimiento:</label>
                <div class="col-xs-3">
                    <select class="form-control">
                        <option>Dia</option>
                    </select>
                </div>
                <div class="col-xs-3">
                    <select class="form-control">
                        <option>Mes</option>
                    </select>
                </div>
                <div class="col-xs-3">
                    <select class="form-control">
                        <option>Año</option>
                    </select>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3">Dirección:</label>
                <div class="col-xs-9">
                    <textarea placeholder="Dirección" class="form-control" rows="3"></textarea>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-xs-3">Genero:</label>
                <div class="col-xs-2">
                    <label class="radio-inline">
                        <input type="radio" value="male" name="genderRadios"> Maculino
                    </label>
                </div>
                <div class="col-xs-2">
                    <label class="radio-inline">
                        <input type="radio" value="female" name="genderRadios"> Femenino
                    </label>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-9">
                    <label class="checkbox-inline">
                        <input type="checkbox" value="news"> Enviar noticias.
                    </label>
                </div>
            </div>
            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-9">
                    <label class="checkbox-inline">
                        <input type="checkbox" value="agree">  Accepto <a href="#">Terminos y condiciones</a>.
                    </label>
                </div>
            </div>
            <br>
            <div class="form-group">
                <div class="col-xs-offset-3 col-xs-9">
                    <input type="submit" value="Enviar" class="btn btn-primary">
                    <input type="reset" value="Limpiar" class="btn btn-default">
                </div>
            </div>
        </form>


    </div>


<!-- Js vinculados -->
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <script src="js/responsive.js"></script>
    <script src="js/bootstrap.min.js"></script>


</body>