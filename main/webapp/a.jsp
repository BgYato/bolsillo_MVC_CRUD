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
                    <li><a href="index.html">Inicio</a></li>
                    <li><a href="cuenta.html">Cuenta</a></li>                    
                </ul>
            </div>
        </div>
    </div>

    <div class="cuenta-section">  
        <div class="tarjeta" id="tarjeta" style="display: none;">
            <div class="alerta-ok">
                <div class="alerta-ok_p">	
                    <p>Felicidades, has transferido satisfactoriamente la cantidad de dinero.</p>
                </div>
            </div>
        </div>

        <div class="cuenta-crear">
            <img src="public/img/logo_transfer.png" alt="Logo de transferir" class="cuenta-crear_img">
        </div>
        <div class="cuenta-iniciar">
            <h4>Transferencias bancarias</h4>
            <form action="dashboard.html" class="cuenta_form">
                <div class="cuenta_form-group">
                    <label for="num" class="cuenta_form-label">Tu número teléfonico.</label>
                    <input type="tel" name="num" id="num" class="cuenta_form-input" value="3123247042" required>
                </div>
                <div class="cuenta_form-group">
                    <label for="num2" class="cuenta_form-label">Número de destino.</label>
                    <input type="tel" name="num2" id="num2" class="cuenta_form-input" placeholder="Ingrese el número destinario">
                </div>
                <div class="cuenta_form-group">
                    <label for="monto" class="cuenta_form-label">Monto a enviar.</label>
                    <input type="number" min="1000" max="1000000" name="monto" id="monto" class="cuenta_form-input" placeholder="Ingrese el monto a enviar">
                </div>
                <div class="cuenta_form-group">
                    <label for="pwd" class="cuenta_form-label">Escriba su contraseña.</label>
                    <input type="password" name="pwd" id="pwd" class="cuenta_form-input" placeholder="****">
                </div>
                <input type="button" value="Enviar" class="cuenta_form-input_submit" onclick="abrirAlerta();">
            </form>
        </div>
    </div>
    <!-- Enlaces a JS -->
    <script src="public/js/app.js"></script>
</body>
</html>