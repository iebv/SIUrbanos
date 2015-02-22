<!--
  To change this license header, choose License Headers in Project Properties.
  To change this template file, choose Tools | Templates
  and open the template in the editor.
-->

<%@ page contentType="text/html;charset=UTF-8" %>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="${resource(dir: 'css', file: 'login.css')}" type="text/css"> 
        <g:layoutHead/>
    </head>
    <body>
        <!--BARRA DE NAVEGACION-->
        <div class="navbar navbar-default navbar-fixed-top">
            <div class="container">
                <div class="navbar-header">
                    <button class="navbar-toggle" type="button" data-toggle="collapse" data-target="#navbar-main">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">SI Urbanos</a>
                </div>
                <center>
                    <div class="navbar-collapse collapse" id="navbar-main">
        <!--                <ul class="nav navbar-nav">
                            <li class="active"><a href="#">Link</a>
                            </li>
                            <li><a href="#">Link</a>
                            </li>
                            <li><a href="#">Link</a>
                            </li>
                            <li><a href="#">Link</a>
                            </li>
                            <li><a href="#">Link</a>
                            </li>
                            <li class="dropdown">
                                <a href="#" class="dropdown-toggle" data-toggle="dropdown">Dropdown <b class="caret"></b></a>
                                <ul class="dropdown-menu">
                                    <li><a href="#">Action</a>
                                    </li>
                                    <li><a href="#">Another action</a>
                                    </li>
                                    <li><a href="#">Something else here</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li><a href="#">Separated link</a>
                                    </li>
                                    <li class="divider"></li>
                                    <li><a href="#">One more separated link</a>
                                    </li>
                                </ul>
                            </li>
                        </ul>-->
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
                                <input type="text" class="form-control" name="password" placeholder="Password">
                            </div>
                            <button type="submit" class="btn btn-default">Log In</button>
                        </form>
                        </g:else>
                        <g:if test="${flash.message}">
                            <div class="message" role="status">${flash.message}</div>
                        </g:if>
                    </div>
                </center>
            </div>
        </div>
        <g:layoutBody/>
    </body>
</html>
