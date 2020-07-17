<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>

<!--Mostrar datos de galeria-->
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <c:forEach items="${listaDetalle}" var="fila">
                <div class="col-md-12">
                    <h2><i class="fa fa-images"></i> <c:out value="${fila.nom_estado}"/> </h2>
                </div> 
            </c:forEach>    
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

<!-- TABLA DE RESTAURACIONES --->
<div class="panel-info">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-10">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Lista de Restauraciones</h3>
                </div>
                <div class="col-md-2">
                    <a href="#nuevarestauracion" class="btn btn-success" data-toggle="modal">
                        <span class="glyphicon glyphicon-plus"></span> Nueva Restauracion
                    </a>
                </div>
            </div>
        </div>
    <div class="panel-body">
        <table class="table table-bordered table-striped table-responsive table-hover">
                <thead>
                        <tr>
                            <th>Fecha Programada</th>
                            <th>Fecha Estimada de Entrega</th>
                            <th>Obra de Arte</th>
                            <th>Fecha de Creacion Obra</th>
                            <th>Fecha de Ingreso Obra</th>
                            <th colspan="2" style="text-align: center">Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaR}" var="fila">
                            <tr>
                                <td><c:out value="${fila.fecha_progra}"/></td>
                                <td><c:out value="${fila.fecha_estimada}"/></td>
                                <td><c:out value="${fila.tit_obra}"/></td>
                                <td><c:out value="${fila.fcrea_obra}"/></td>
                                <td><c:out value="${fila.fing_obra}"/></td>
                                
                                <td style="text-align: center;"><a href="#editarrest" data-id="<c:out value="${fila.cod_restauracion}"/>" 
                                data-fecp="<c:out value="${fila.fecha_progra}"/>" data-fece="<c:out value="${fila.fecha_estimada}"/>"
                                data-ob="<c:out value="${fila.tit_obra}"/>" 
                                class="btn btn-warning btn-sm" data-toggle="modal">
                                <span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                                <jsp:include page="Modal_Editar_RE.jsp"/>
                       
                                <td style="text-align: center;">
                                   <% if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                                    <a href="#eliminarrest" data-id="<c:out value="${fila.cod_restauracion}"/>" 
                                       class="btn btn-danger btn-sm" data-toggle="modal">
                                       <span class="glyphicon glyphicon-remove"></span> Borrar
                                    </a>
                                   <% }%>
                                </td>
                                 <jsp:include page="Modal_Eliminar_RE.jsp"/>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    </div>
</div>
                            

<jsp:include page="Modal_Agregar_RE.jsp"/>
<jsp:include page="../Footer.jsp"/>
