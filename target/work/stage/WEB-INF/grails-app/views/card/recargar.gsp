<!DOCTYPE html>
<html>
    
    <head>
        <meta name="layout" content="menu_bar">
    </head>
    
    <body>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-6" style="margin-top: 50px;">
                        <img src="${resource(dir:"images", file: "saldo.png")}"/>
                        <h1>Saldo Actual</h1>
                        <h2>$ ${session?.user?.card.idCard}</h2>
                    </div>
                    <div class="col-md-6">
                        <img src="http://pingendo.github.io/pingendo-bootstrap/assets/placeholder.png"
                        class="img-responsive">
                        <h1>Monto a recargar</h1>
                        <p></p>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisici elit,
                            <br>sed eiusmod tempor incidunt ut labore et dolore magna aliqua.
                            <br>Ut enim ad minim veniam, quis nostrud</p>
                        <p></p>
                    </div>
                </div>
            </div>
        </div>
        <div class="section">
            <div class="container">
                <div class="row">
                    <div class="col-md-12">
                        <a class="btn btn-block btn-lg btn-success">Click me</a>
                    </div>
                </div>
            </div>
        </div>
    </body>

</html>