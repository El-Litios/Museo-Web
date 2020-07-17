<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>
<!--Mostrar datos de galeria-->
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <c:forEach items="${listaDetalle}" var="fila">
                <div class="col-md-3">
                    <h2>
                        <i class="fa fa-images"></i> 
                        <c:out value="${fila.nom_visita}"/> 
                    </h2>
                </div> 
                <div class="col-md-3">
                    <h2>
                        <c:out value="${fila.nom_encargado}"/> 
                    </h2>
                </div> 
                <div class="col-md-3">
                    <h2>
                        <c:out value="${fila.curso_visita}"/>
                    </h2>
                </div>
                <div class="col-md-3">
                    <h2>
                        <c:out value="${fila.cant_visita}"/>
                    </h2>
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

<!-- TABLA DE TOURS --->
<div class="panel-info">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-10">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Tours Asociados</h3>
                </div>
                <div class="col-md-2">
                    
                </div>
            </div>
        </div>
    <div class="panel-body">
        <table class="table table-bordered table-striped table-responsive table-hover">
                <thead>
                        <tr>
                            <th>Fecha de Inicio</th>
                            <th>Hora</th>
                            <th>Insumos Disponibles</th>
                            <th>Guia Designado</th>
                            <th>Evento</th>
                            <th>Fecha de Evento</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaTour}" var="fila">
                            <tr>
                                <td><c:out value="${fila.fecha_tour}"/></td>
                                <td><c:out value="${fila.hora_tour}"/></td>
                                <td><c:out value="${fila.insumos_tour}"/></td>
                                <td><c:out value="${fila.nombre}"/></td>
                                <td><c:out value="${fila.nom_ev}"/></td>
                                <td><c:out value="${fila.fec_ini}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    </div>
</div>
<jsp:include page="../Footer.jsp"/>
