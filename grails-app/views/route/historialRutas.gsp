
<%@ page import="siurbanos.Route" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="menu_bar">
        <g:javascript src="tabla-historial-1.js"/>
        <g:javascript src="tabla-historial-2.js"/>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'tabla-historial.css')}" type="text/css"> 
        
        <title>Historial de rutas</title>
    </head>
    <body>
        <div style="width: 80%; margin:100px auto;">
        <table id="tabla-rutas" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Id Tarjeta</th>
                    <th>Ruta</th>
                    <th>Fecha ruta</th>
                </tr>
            </thead>
            <tbody>
                <g:each var="route" in="${routes}" >
                    <tr>
                        <td>${route.card.idCard}</td>
                        <td> ${route.routeName}</td>
                        <td><g:formatDate type="datetime" style="MEDIUM" date="${route.date}"/></td>
                    </tr>
                </g:each>
             
            </tbody>
            
        </table>      

        <script>
            $(document).ready(function() {
            $('#tabla-rutas').dataTable();
            } );
        </script>

        </div>


    </body>
</html>

