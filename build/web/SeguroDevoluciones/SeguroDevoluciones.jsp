<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <div class="col-md-4">
                <h2><i class="fa fa-images"></i> SEGUROS DE DEVOLUCION</h2><hr>
            </div>
            <div class="col-md-6">
            </div>
            <div class="col-md-2">
                <br>
                <a href="#nuevoseguro" class="btn btn-success" id="btn1" data-toggle="modal"><i class="fa fa-plus">Nuevo Seguro</i></a>
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
            <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Lista de Seguros Disponibles</h3>
        </div>
        <div class="panel-body">
            <table class="table table-bordered table-striped table-responsive table-hover">
        <thead>
            <tr>

                <th>Descripcion</th>
                <th>Fecha de Seguro</th>
                <th>Monto Disponible</th>
                <th colspan="3" style="text-align: center">Opciones</th>

            </tr>
        </thead>
        <tbody>
        <c:forEach items="${lista}" var="fila">
            <tr>
                <td><c:out value="${fila.desc_seguro}"/></td>
                <td><c:out value="${fila.fec_seguro}"/></td>
                <td><c:out value="${fila.monto_seguro}"/></td>
                
                <td>
                    <a href="Servlet_SeguroDevoluciones?op=5&codigo=${fila.cod_seguro}" 
                       class="btn btn-success">
                       <span class="glyphicon glyphicon-list-alt"></span>Detalle</a>
                </td>
                <td style="text-align: center;"><a href="#editar" data-id="<c:out value="${fila.cod_seguro}"/>" 
                       data-desc="<c:out value="${fila.desc_seguro}"/>" data-fec="<c:out value="${fila.fec_seguro}"/>"
                       data-monto="<c:out value="${fila.monto_seguro}"/>"
                       class="btn btn-warning btn-sm" data-toggle="modal">
                       <span class="glyphicon glyphicon-remove"></span>Editar</a></td>
                       <jsp:include page="Modal_Editar_SD.jsp"/>
                       
                       
                <%if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                    <td style="text-align: center;"><a href="#eliminar" data-id="<c:out value="${fila.cod_seguro}"/>" 
                       class="btn btn-danger btn-sm" data-toggle="modal">
                       <span class="glyphicon glyphicon-remove"></span>Borrar</a>
                       <% }%>
                </td>
                       <jsp:include page="Modal_Eliminar_SD.jsp"/>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        </div>
    </div>
</div>     
<jsp:include page="Agregar_Modal_SD.jsp"/>
<jsp:include page="../Footer.jsp"/>
