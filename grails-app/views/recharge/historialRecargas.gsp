
<%@ page import="siurbanos.Recharge" %>
<!DOCTYPE html>
<html>
    <head>
        <meta name="layout" content="menu_bar">
        <g:javascript src="tabla-historial-1.js"/>
        <g:javascript src="tabla-historial-2.js"/>
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'tabla-historial.css')}" type="text/css"> 
        
        <title>Historial de recargas</title>
    </head>
    <body>
        <div style="width: 80%; margin:100px auto;">
        <table id="tabla-recargas" class="table table-striped table-bordered" cellspacing="0" width="100%">
            <thead>
                <tr>
                    <th>Id Tarjeta</th>
                    <th>Valor recarga</th>
                    <th>Fecha recarga</th>
                </tr>
            </thead>
            <tbody>
                <g:each var="recharge" in="${recharges}" >
                    <tr>
                        <td>${recharge.card.idCard}</td>
                        <td>$ ${recharge.amountRecharge}</td>
                        <td><g:formatDate format="yyyy-MM-dd" date="${recharge.dateRecharge}"/></td>
                    </tr>
                </g:each>
             
            </tbody>
            
        </table>      

        <script>
            $(document).ready(function() {
            $('#tabla-recargas').dataTable();
            } );
        </script>

        </div>


    </body>
</html>
