<html>
    <head>
        <title>ELMuseoWEB</title>
        <meta charset="UTF/8">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <!--LINK A ESTILO VISUAL-->
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
        <title>Museo</title>
    </head>
    <body style="background-image: url('Imagenes/MuseoFrente.jpg');  background-repeat: no-repeat; background-attachment: fixed; background-size: 100% 100%;">
        <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
              <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
              </button>
              <a class="navbar-brand" href="#">Museo</a>
            </div>
          </div><!-- /.navbar-collapse -->
        </div><!-- /.container-fluid -->
        </nav>
        <div class="container" id="contenedor1">
            <h1 id="titulo">Sistema de Gestion del Museo</h1><hr/>
             <div class="panel-info">
                <div class="panel-heading">
                   <h3 class="panel-title">Ingreso al sistema</h3>
                </div>
                <div class="panel-body">
                   <form action="Servlet_Usu?op=7" method="POST">
                       <div class="form-group">
                           <input type="text" class="form-control" name="v1" placeholder="Usuario" required/>
                       </div>
                       <div class="form-group">
                            <input type="password" class="form-control" name="v2" placeholder="Contraseña" required/>
                       </div>
                       <input type="submit" value="Iniciar sesion" class="btn btn-primary" style="float:right"/>
                   </form>
                   <font color="red" size="2">
                       <% 
                       if (request.getParameter("mnsj")!=null) {
                           out.println(request.getParameter("mnsj"));    
                           }    
                            %>
                   </font>
                </div>
             </div>
<jsp:include page="Footer.jsp"/>