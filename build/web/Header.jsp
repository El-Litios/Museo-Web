<%-- 
    Document   : index
    Created on : 26-03-2020, 8:35:38
    Author     : Mark-
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>ELMuseoWEB</title>
        <meta charset="UTF/8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--LINK A ESTILO VISUAL-->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <link href="css/all.css" rel="stylesheet" type="text/css"/>
        <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
        <title>Museo</title>
    </head>
    <body>
        <nav class="navbar navbar-inverse">
        <div class="container-fluid">
          <!-- Brand and toggle get grouped for better mobile display -->
          <div class="navbar-header">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
              <span class="sr-only">Toggle navigation</span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
              <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="index.jsp">Museo</a>
          </div>
          
          <!-- Collect the nav links, forms, and other content for toggling -->
          <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
              <% if ((String)session.getAttribute("nombre")==null){ %>
              <li class="active"><a href="index.jsp">Inicio <span class="sr-only">(current)</span></a></li>
              <li><a href="#">Servicios</a></li>
              <%}else if(((String)session.getAttribute("rol")).equals("Acceso a la Plataforma")){%> 
                <li><a href="Servlet_Rol?op=1">Lista de Roles</a></li>
                <!--MOSTRAR ACCESO A LISTA DE USUARIOS-->
                <li><a href="Servlet_Usu?op=1">Lista de Usuarios</a></li>
                <!--MOSTRAR ESPECILIDADES DEL USUARIO-->
                <li><a href="Servlet_Especialidad?op=1">Lista de Usuarios</a></li>
                <!--MOSTRAR ACCESO A LISTA DE OBRAS DE ARTE--
                <li><a href="Servlet_ObraDeArte?op=1">Obras de Arte</a></li>
                <!--MOSTRAR ACCESO A LISTA DE ADMINISTRADORES
                <li><a href="Servlet_Administrador?op=1">Lista de Admins</a></li>
                <!--MOSTRAR ACCESO A LISTA DE UBICACIONES
                <li><a href="Servlet_Ubicaciones?op=1">Lista de Ubicaciones</a></li>
                <!--MOSTRAR ACCESO A LISTA DE GALERIAS
                <li><a href="Servlet_Galerias?op=1">Lista de Galerias</a></li>
                <!--MOSTRAR ACCESO A LISTA DE PAISES--
                <li><a href="Servlet_Paises?op=1">Paises</a></li>
                <!--MOSTRAR ACCESO A LISTA DE NACIONALIDADES--
                <li><a href="Servlet_Nacionalidades?op=1">Nacionalidades</a></li>
                <!--MOSTRAR OPCIONES DEL ADMINISTRADOR --
                <li><a href="Servlet_Autores?op=1">Autores</a></li>
                <!--MOSTRAR ACCESO A LISTA DE TIPOS DE OBRA--
                <li><a href="Servlet_TipoDeObra?op=1">T.Obras</a></li>
                <!--MOSTRAR ACCESO A LISTA DE OBRAS DE ARTE--
                <li><a href="Servlet_ObraDeArte?op=1">Obras de Arte</a></li>
                <!--MOSTRAR ACCESO A LISTA DE OBRAS DE ARTE--
                <li><a href="Servlet_GaleriasObras?op=1">Obras en Galerias</a></li>
                <!--MOSTRAR ACCESO A LISTA DE TIPOS DE EVENTOS--
                <li><a href="Servlet_TipoEvento?op=1">T. Eventos</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE EVENTOS--
                <li><a href="Servlet_Evento?op=1">Eventos</a></li>-->
                
                <%}else if(((String)session.getAttribute("rol")).equals("Catalogo y Mantencion")) {%>
                <!--MOSTRAR OPCIONES DEL ADMINISTRADOR -->
                <li><a href="Servlet_Autores?op=1">Autores</a></li>
                <!--MOSTRAR ACCESO A LISTA DE OBRAS DE ARTE-->
                <li><a href="Servlet_ObraDeArte?op=1">Obras de Arte</a></li>
                <!--MOSTRAR ACCESO A LISTA DE GALERIAS-->
                <li><a href="Servlet_Galerias?op=1">Lista de Galerias</a></li>
                <!--MOSTRAR ACCESO A LISTA DE OBRAS DE ARTE-->
                <li><a href="Servlet_GaleriasObras?op=1">Obras en Galerias</a></li>
                 <!--MOSTRAR ACCESO A LISTA  DE EVENTOS-->
                <li><a href="Servlet_Evento?op=1">Eventos</a></li>
                
                <%}else if(((String)session.getAttribute("rol")).equals("Prestamos y Devoluciones")) {%>
                <!--MOSTRAR ACCESO A LISTA  DE MUSEOS-->
                <li><a href="Servlet_Museos?op=1">Museos</a></li>
                <!--MOSTRAR ACCESO A LISTA PRESTAMOS-->
                <li><a href="Servlet_Prestamos?op=1">Prestamos</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE SEGUROS DE DEVOLUCIONES-->
                <li><a href="Servlet_SeguroDevoluciones?op=1">Seguro de Devolucion</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE SEGUROS DE PRESTAMOS-->
                <li><a href="Servlet_SeguroPrestamos?op=1">Seguro de Prestamos</a></li>
                
                <%}else if(((String)session.getAttribute("rol")).equals("Administrador")) {%>
                <!--MOSTRAR ACCESO A LISTA DE USUARIOS-->
                <li><a href="Servlet_Usu?op=1">Lista de Usuarios</a></li>
                <!--MOSTRAR ACCESO A LISTA DE ADMINISTRADORES-->
                <li><a href="Servlet_Administrador?op=1">Lista de Admins</a></li>
                <!--MOSTRAR ACCESO A LISTA DE GALERIAS-->
                <li><a href="Servlet_Galerias?op=1">Lista de Galerias</a></li>
                <!--MOSTRAR OPCIONES DEL ADMINISTRADOR -->
                <li><a href="Servlet_Autores?op=1">Autores</a></li>
                <!--MOSTRAR ACCESO A LISTA DE OBRAS DE ARTE-->
                <li><a href="Servlet_ObraDeArte?op=1">Obras de Arte</a></li>
                <!--MOSTRAR ACCESO A LISTA DE OBRAS DE ARTE-->
                <li><a href="Servlet_GaleriasObras?op=1">Obras en Galerias</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE EVENTOS-->
                <li><a href="Servlet_Evento?op=1">Eventos</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE MUSEOS-->
                <li><a href="Servlet_Museos?op=1">Museos</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE PRESTAMOS-->
                <li><a href="Servlet_Prestamos?op=1">Prestamos</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE ESPECIALIDADES DE USUARIOS-->
                <li><a href="Servlet_Especialidad?op=1">Especialidades</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE RESTAURACIONES-->
                <li><a href="Servlet_Restauraciones?op=1">Restauraciones</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE SEGUROS DE DEVOLUCIONES-->
                <li><a href="Servlet_SeguroDevoluciones?op=1">Seguro de Devolucion</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE SEGUROS DE PRESTAMOS-->
                <li><a href="Servlet_SeguroPrestamos?op=1">Seguro de Prestamos</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE VISITANTES-->
                <li><a href="Servlet_Visitas?op=1">Visitantes</a></li>
                <!--MOSTRAR ACCESO A LISTA  DE GUIA TURISTICOS-->
                <li><a href="Servlet_GuiasTuristicos?op=1">Gestion de Tours</a></li>

                <%}else if(((String)session.getAttribute("rol")).equals("Restaurador")) {%>
                <!--MOSTRAR ACCESO A LISTA  DE RESTAURACIONES-->
                <li><a href="Servlet_Restauraciones?op=1">Restauraciones</a></li>
                <%}%>
            </ul>
            <ul class="nav navbar-nav navbar-right">
              <% if ((String)session.getAttribute("nombre")==null){ %>
                <li><a href="Login.jsp">Login</a></li>
                <li><a href="Registro.jsp">Registrar</a></li>
              <%}else{ 
                out.println("<li><a href=#> Hola: "+(String)session.getAttribute("nombre")+"</a></li>");
                out.println("<li><a href=#> Rol: "+(String)session.getAttribute("rol")+"</a></li>");
                out.println("<li><a href=Servlet_Usu?op=8>Cerrar Sesion</a></li>");
                }%>
                </ul>
              </li>
            </ul>
          </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
        </nav>
        <div class="container">
            