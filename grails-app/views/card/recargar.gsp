<!DOCTYPE html>
<html>

    <head>
        <meta name="layout" content="menu_bar">
    </head>

    <body>
        <div class="section">
            <div class="container">
                <div class="row" style="margin-top: 80px;">
                    <div class="col-md-6" >
                        <img src="${resource(dir:"images", file: "saldo.png")}"/>
                        <h1>Saldo Actual</h1>
                        <h2>$ ${session?.user?.card?.amount}</h2>
                    </div>
                    <div class="col-md-6">
                        <img src="${resource(dir:"images", file: "recargar.png")}"/>
                        <h1>Monto a recargar</h1>
                        <form method="post" class="formit" action="/SIUrbanos/card/recargar">
                            <input class="form-control" name="montoRecarga" type="number" min="0" value="0">
                            <br>
                            <input class="btn btn-primary btn-lg btn-block" type="submit" value="Recargar">
                        </form>
                      
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>