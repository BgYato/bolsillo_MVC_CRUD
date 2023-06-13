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
                    <li><a href="usuario?navegacion=inicio">Inicio</a></li>
                    <li><a href="usuario?navegacion=inicio">Cuenta</a></li>
                </ul>
            </div>
        </div>
    </div>

    <div class="relleno-header"></div>
    
    <%
        String mensaje = (String) request.getAttribute("mensaje");
    %>
    
    <c:if test="${mensaje eq 'exito'}">
        <div class="alert-success">
            <p>La operación se ha realizado con éxito.</p>
        </div>
    </c:if>
    <c:if test="${mensaje eq 'error'}">
        <div class="alert-error">
            <p>Ha ocurrido un error durante el proceso.</p>
        </div>
    </c:if>
    <c:if test="${mensaje eq 'existe'}">
        <div class="alert-error">
            <p>La cuenta ya existe.</p>
        </div>
    </c:if>
    <c:if test="${mensaje eq 'no-existe'}">
        <div class="alert-error">
            <p>La cuenta no existe o la contraseña es incorrecta.</p>
        </div>
    </c:if>

    <div class="burbujas-daviplata">
        <div class="b1"></div>
        <div class="b2"></div>
        <div class="b3"></div>
    </div>
    <div class="cuenta_nequi-logo">
        <img src="public/img/logo_daviplata.png" alt="Logo de Nequi">
    </div>

    <div class="cuenta-section">
        <div class="cuenta-crear">
            <h4>Crear cuenta</h4>
            <form action="usuario" class="cuenta_form" method="post">
                <div class="cuenta_form-group">
                    <label for="nombre" class="cuenta_form-label">Nombre completo.</label>
                    <input type="text" name="nombre" id="nombre" class="cuenta_form-input" placeholder="Registre su nombre" required>
                </div>
                <div class="cuenta_form-group">
                    <label for="correo" class="cuenta_form-label">Correo.</label>
                    <input type="email" name="correo" id="correo" class="cuenta_form-input" placeholder="Registre su correo">
                </div>
                <div class="cuenta_form-group">
                    <label for="num" class="cuenta_form-label">Número teléfonico.</label>
                    <input type="tel" name="num" id="num" class="cuenta_form-input" placeholder="Registre su número">
                </div>
                <div class="cuenta_form-group">
                    <label for="pwd" class="cuenta_form-label">Contraseña.</label>
                    <input type="password" name="pwd" id="pwd" class="cuenta_form-input" placeholder="Registre su contraseña">
                </div>     
                <div class="cuenta_form-group">
                    <label for="corresponsal" class="cuenta_form-label">Corresponsal.</label>
                    <select name="corresponsal" id="corresponsal" class="cuenta_form-input">
                        <option value="daviplata" selected>Daviplata</option>
                    </select>
                </div>                
                <input type="button"  id="form_cuenta-submit-re-nequi" value="Registrar" class="cuenta_form-input_submit color-rojo" name="datos">
            </form>
        </div>
        <div class="cuenta-iniciar">
            <h4>Iniciar sesión</h4>
            <form action="usuario" class="cuenta_form" method="post">
                <div class="cuenta_form-group">
                    <label for="num" class="cuenta_form-label">Número teléfonico.</label>
                    <input type="tel" name="num" id="num" class="cuenta_form-input" placeholder="Ingrese su número de teléfono" required>
                </div>
                <div class="cuenta_form-group">
                    <label for="pwd" class="cuenta_form-label">Contraseña.</label>
                    <input type="tel" name="pwd" id="pwd" class="cuenta_form-input" placeholder="Ingrese su contraseña">
                </div>
                <input type="submit"  id="form_cuenta-submit-in" name="datos" value="Ingresar" class="cuenta_form-input_submit color-rojo">
            </form>
        </div>
    </div>
    <!-- Enlaces a JS -->
    <script src="public/js/app.js"></script>
</body>
</html>