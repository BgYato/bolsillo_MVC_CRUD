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
                    <li><a href="index.jsp">Inicio</a></li>
                    <li><a href="cuenta.jsp">Cuenta</a></li>                    
                </ul>
            </div>
        </div>
    </div>

    <div class="lateral">
        <div class="side-bar">
            <img src="public/img/i_user.png" alt="Icono de usuario" class="lateral_icon">
            <h3>Tu cuenta</h3>
            <!-- Lista -->
            <ul>
                <li><a href="usuario?cuenta=inicio" span class="item">Inicio</span></a></li>
                <li><a href="usuario?cuenta=transferir"><span class="item">Transferir</span></a></li>
                <li><a href="usuario?cuenta=recargar"><span class="item">Recargar</span></a></li>
                <li><a href="#" onclick="alertNoDisponible()"><span class="item">Movimientos</span></a></li>
                <li><a href="usuario?cuenta=configuracion"><span class="item">Configuración</span></a></li>
                <li><a href="usuario?cuenta=salir"><span class="item">Cerrar sesión</span></a></li>
            </ul>
        </div>
    </div>    
    <div class="db_section">
        <h2>Bienvenido de nuevo a tu cuenta.</h2>
        <p>Consulta tu información importante</p>
        <div class="row">
            <div class="column">
                <strong>Resumen</strong>
                <p>Lorem, ipsum dolor sit amet consectetur adipisicing elit. Officia laboriosam commodi incidunt vitae. Sapiente ut, ad delectus at commodi laborum nihil totam consectetur amet et quas alias ipsam. In natus, accusamus exercitationem sunt molestias voluptatibus dicta facere sapiente cum voluptatum nulla dolorem fugiat corporis amet doloribus ea nemo vero sint tempora cumque delectus corrupti sed ut incidunt? Dolor, distinctio commodi.</p>
            </div>
            <div class="column">
                <strong>Informacion personal</strong>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Asperiores ratione facere error, totam iste consequatur. Fuga ex qui neque praesentium ut nobis non minima provident ratione dicta molestiae quia, commodi excepturi magnam enim corrupti dolor architecto ea! Explicabo, officiis earum.</p>
            </div>
            <div class="column">
                <strong>Dinero</strong>
                <p>Lorem ipsum dolor sit amet consectetur adipisicing elit. Pariatur, eius! </p>
            </div>
        </div>
    </div>
    <!-- Enlaces a JS -->
    <script src="public/js/app.js"></script>
</body>
</html>