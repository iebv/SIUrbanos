
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="layout" content="menu_bar">
        
        <title>Servicios</title>
    </head>
    <body>

        <section style="margin-top: 100px;">
            <div class="container">
                <div class="jumbotron text-center">
                    <h4>Recargar Tarjeta </h4>
                    <a href="#">
                        <img src="${resource(dir:"images", file: "reload.png") }"/>
                    </a>
                </div>
        </section>	
        <section >
            <div class="container">
                <div class="jumbotron text-center">
                    <h4>Historial de recargas</h4>
                    <a href="${createLink(controller:'recharge', action:'historialRecargas')}">
                        <img src="${resource(dir:"images", file: "recargas.png") }"/>
                    </a>
                </div>
        </section>
        <section >
            <div class="container">
                <div class="jumbotron text-center">
                    <h4>Historial de viajes </h4>
                    <a href="#">
                        <img src="${resource(dir:"images", file: "viajes.png") }"/>
                    </a>
                </div>
        </section>	
    </body>
</html>
