<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <div class="col-md-4">
                <h2><i class="fa fa-images"></i>GESTION DE TIPOS DE EVENTOS</h2><hr>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <h2>
                        <form method="POST" action="Servlet_TipoEvento?op=5">
                            <div class="row">
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="buscar" placeholder="Tipo Evento"/>
                                </div>
                                <div class="col-md-4">
                                    <button type="submit" class="btn btn-success"><i class="fa fa-search"></i>Buscar</button>
                                </div>
                            </div>
                        </form>
                    </h2>
                </div>
            </div>
            <div class="col-md-2">
                <br>
                <a href="#nuevotev" class="btn btn-success" id="btn1" data-toggle="modal"><i class="fa fa-plus"> Tipo Evento</i></a>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-12">
                <font color="red" size="6">
                       <% 
                       if (request.getParameter("mnsj")!=null) {
                           out.println(request.getParameter("mnsj"));    
                           }    
                            %>
                </font>
            </div>
        </div>
    </div>
</div>
<!--MOSTRAR DATOS-->
<div id="tabla1">
    <div class="panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Lista de los Tipos de Eventos</h3>
        </div>
        <div class="panel-body">
            <table class="table table-bordered table-striped table-responsive table-hover">
        <thead>
            <tr>

                <th>Tipo de Evento</th>
                <th colspan="2">Opciones</th>

            </tr>
        </thead>
        <tbody>
        <c:forEach items="${lista}" var="fila">
            <tr>
                <td><c:out value="${fila.nom_tev}"/></td>
                
                <td style="text-align: center;"><a href="#editar" data-id="<c:out value="${fila.cod_tev}"/>" 
                       data-nom="<c:out value="${fila.nom_tev}"/>"
                       class="btn btn-warning btn-sm" data-toggle="modal">
                       <span class="glyphicon glyphicon-pencil"></span>Editar</a></td>
                       <jsp:include page="Modal_Editar_TEV.jsp"/>
                <td style="text-align: center;">
                   <% if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                    <a href="#eliminar" data-id="<c:out value="${fila.cod_tev}"/>" 
                       data-nom="<c:out value="${fila.nom_tev}"/>"
                       class="btn btn-danger btn-sm" data-toggle="modal">
                       <span class="glyphicon glyphicon-remove"></span>Borrar
                    </a>
                       <% }%>
                </td>
                       <jsp:include page="Modal_Eliminar_TEV.jsp"/>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        </div>
    </div>
</div>     
<jsp:include page="Modal_Agregar_TEV.jsp"/>
<jsp:include page="../Footer.jsp"/>
