<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>

<!--Mostrar datos de galeria-->
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <c:forEach items="${listaDetalle}" var="fila">
                <div class="col-md-6">
                    <h2><i class="fa fa-images"></i> <c:out value="${fila.nombre}"/> </h2>
                </div> 
                <div class="col-md-6">
                    <h2><i class="fa fa-images"></i> <c:out value="${fila.em}"/> </h2>
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
                    <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Lista de Tours</h3>
                </div>
                <div class="col-md-2">
                    <a href="#nuevotour" class="btn btn-success" data-toggle="modal">
                        <span class="glyphicon glyphicon-plus"></span> Tour
                    </a>
                </div>
            </div>
        </div>
    <div class="panel-body">
        <table class="table table-bordered table-striped table-responsive table-hover">
                <thead>
                        <tr>
                            <th>Fecha Inicio</th>
                            <th>Hora</th>
                            <th>Insumos</th>
                            <th>Evento Asociado</th>
                            <th>Visitante</th>
                            <th>Encargado</th>
                            <th>Cantidad de Personas</th>
                            <th colspan="2" style="text-align: center">Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaTours}" var="fila">
                            <tr>
                                <td><c:out value="${fila.fecha_tour}"/></td>
                                <td><c:out value="${fila.hora_tour}"/></td>
                                <td><c:out value="${fila.insumos_tour}"/></td>
                                <td><c:out value="${fila.nom_ev}"/></td>
                                <td><c:out value="${fila.nom_visita}"/></td>
                                <td><c:out value="${fila.nom_encargado}"/></td>
                                <td><c:out value="${fila.cant_visita}"/></td>
                                
                                
                                <td style="text-align: center;"><a href="#editar" data-id="<c:out value="${fila.cod_tour}"/>" 
                                data-fec="<c:out value="${fila.fecha_tour}"/>" data-hora="<c:out value="${fila.hora_tour}"/>"
                                data-ins="<c:out value="${fila.insumos_tour}"/>" data-ev="<c:out value="${fila.nom_ev}"/>"
                                data-nomv="<c:out value="${fila.nom_visita}"/>" data-nome="<c:out value="${fila.nom_encargado}"/>"
                                data-cant="<c:out value="${fila.cant_visita}"/>"
                                class="btn btn-warning btn-sm" data-toggle="modal">
                                <span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                                <jsp:include page="Modal_Editar_Tour.jsp"/>
                       
                                <td style="text-align: center;">
                                   <% if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                                    <a href="#eliminar" data-id="<c:out value="${fila.cod_tour}"/>" 
                                    data-fec="<c:out value="${fila.fecha_tour}"/>" data-hora="<c:out value="${fila.hora_tour}"/>"
                                    data-ins="<c:out value="${fila.insumos_tour}"/>" data-ev="<c:out value="${fila.nom_ev}"/>"
                                    data-nomv="<c:out value="${fila.nom_visita}"/>" data-nome="<c:out value="${fila.nom_encargado}"/>"
                                    data-cant="<c:out value="${fila.cant_visita}"/>" 
                                       class="btn btn-danger btn-sm" data-toggle="modal">
                                       <span class="glyphicon glyphicon-remove"></span> Borrar
                                    </a>
                                   <% }%>
                                </td>
                                 <jsp:include page="Modal_Eliminar_Tour.jsp"/>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    </div>
</div>
                            

<jsp:include page="Modal_Agregar_Tour.jsp"/>
<jsp:include page="../Footer.jsp"/>
