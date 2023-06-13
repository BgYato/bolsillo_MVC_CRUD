<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Bolsillo virtual | Inicio</title>

    <!-- Enlaces a CSS -->
    <link rel="stylesheet" href="public/css/style.css">
</head>
<body>
    <div class="header">
        <img src="public/img/logo_pagina.png" alt="Logo pagina" class="logo_pagina">
        <div class="nav-bar">
            <div class="nav-item">
                <ul>
                    <li><a href="bolsillo?navegacion=inicio">Inicio</a></li>
                    <li><a href="bolsillo?navegacion=inicio">Cuenta</a></li>                    
                </ul>
            </div>
        </div>
    </div>

    <div class="relleno-header"></div>

    <div class="cuenta-section">  
        <h2 style="margin-top: 30vh; text-align: center;">Tu saldo total es de: <%=request.getAttribute("consultarSaldo")%></h2>
        <h2 style="margin-top: 3vh; text-align: center;">El monto recargado fue de: <%=request.getAttribute("operacion")%></h2>
    </div>
    <!-- Enlaces a JS -->
    <script src="public/js/app.js"></script>
</body>
</html>