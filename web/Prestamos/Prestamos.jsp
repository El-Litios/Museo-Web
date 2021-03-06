<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <div class="col-md-4">
                <h2><i class="fa fa-images"></i> GESTION DE PRESTAMOS</h2><hr>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <h2>
                        <form method="POST" action="Servlet_Prestamos?op=5">
                            <div class="row">
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="buscar" placeholder="Escribir aqui"/>
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
                <a href="#nuevoprestamo" class="btn btn-success" id="btn1" data-toggle="modal"><i class="fa fa-plus">Nueva Prestamo</i></a>
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
            <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Lista de Galerias</h3>
        </div>
        <div class="panel-body">
            <table class="table table-bordered table-striped table-responsive table-hover">
        <thead>
            <tr>
                <th>Fecha de Prestamo</th>
                <th>Costo de Prestamo</th>
                <th>Estado</th>
                <th>Museo Destino</th>
                <th>Comentarios</th>
                <th colspan="3">Opciones</th>
            </tr>
        </thead>
        <tbody>
        <c:forEach items="${lista}" var="fila">
            <tr>
                <td><c:out value="${fila.fec_prestamo}"/></td>
                <td><c:out value="${fila.codto_asociado}"/></td>
                <td><c:out value="${fila.nom_estado}"/></td>
                <td><c:out value="${fila.nom_museo}"/></td>
                <td><c:out value="${fila.comen_prestamo}"/></td>
                
                <td>
                    <a href="Servlet_Prestamos?op=6&codigo=${fila.cod_prestamo}" 
                       class="btn btn-success">
                       <span class="glyphicon glyphicon-list-alt"></span>Detalle</a>
                </td>
                <td style="text-align: center;"><a href="#editar" 
                       data-id="<c:out value="${fila.cod_prestamo}"/>" data-fec="<c:out value="${fila.fec_prestamo}"/>" 
                       data-costo="<c:out value="${fila.codto_asociado}"/>" data-estado="<c:out value="${fila.nom_estado}"/>"
                       data-museo="<c:out value="${fila.nom_museo}"/>" data-comen="<c:out value="${fila.comen_prestamo}"/>"
                       class="btn btn-warning btn-sm" data-toggle="modal">
                       <span class="glyphicon glyphicon-remove"></span>Editar</a></td>
                       <jsp:include page="Modal_Editar_Prestamos.jsp"/>
                       
                <td style="text-align: center;"><a href="#eliminar" data-id="<c:out value="${fila.cod_prestamo}"/>" 
                       data-fec="<c:out value="${fila.fec_prestamo}"/>"
                       class="btn btn-danger btn-sm" data-toggle="modal">
                       <span class="glyphicon glyphicon-remove"></span>Borrar</a></td>
                       <jsp:include page="Modal_Eliminar_Prestamos.jsp"/>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        </div>
    </div>
</div>     
<jsp:include page="Modal_Agregar_Prestamos.jsp"/>
<jsp:include page="../Footer.jsp"/>