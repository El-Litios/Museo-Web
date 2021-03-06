<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>
<!--Mostrar datos de devoluciones asociados a seguros-->
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <c:forEach items="${listaDetalles}" var="fila">
                <div class="col-md-8">
                    <h2><i class="fa fa-images"></i> <c:out value="${fila.fec_seguro}"/> </h2>
                </div> 
                <div class="col-md-4">
                    <h2><c:out value="${fila.monto_seguro}"/> </h2>
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

<!-- TABLA DE PRESTAMOS ASOCIADOS A SEGUROS --->
<div class="panel-info">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-10">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Prestamos Asociadas</h3>
                </div>
                <div class="col-md-2">
                    <a href="#agregar" class="btn btn-success" data-toggle="modal">
                        <span class="glyphicon glyphicon-plus"></span> Prestamos Asociados
                    </a>
                </div>
            </div>
        </div>
    <div class="panel-body">
        <table class="table table-bordered table-striped table-responsive table-hover">
                <thead>
                        <tr>
                            <th>Fecha de Prestamo</th>
                            <th>Costo Asociados (Prestamo)</th>
                            <th>Estado del Prestamo</th>
                            <th>Museo Destino</th>
                            <th colspan="2" style="text-align: center">Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaSP}" var="fila">
                            <tr>
                                <td><c:out value="${fila.fec_prestamo}"/></td>
                                <td><c:out value="${fila.codto_asociado}"/></td>
                                <td><c:out value="${fila.nom_estado}"/></td>
                                <td><c:out value="${fila.nom_museo}"/></td>
                                
                                <td style="text-align: center;"><a href="#editar" data-id="<c:out value="${fila.cod_preseg}"/>" 
                                data-fec="<c:out value="${fila.fec_prestamo}"/>" 
                                class="btn btn-warning btn-sm" data-toggle="modal">
                                <span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                                <jsp:include page="Modal_Editar_PreSeg.jsp"/>
                       
                                <td style="text-align: center;">
                                   <% if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                                    <a href="#eliminar" data-id="<c:out value="${fila.cod_preseg}"/>" 
                                       class="btn btn-danger btn-sm" data-toggle="modal">
                                       <span class="glyphicon glyphicon-remove"></span> Borrar
                                    </a>
                                   <% }%>
                                </td>
                                 <jsp:include page="Modal_Eliminar_PreSeg.jsp"/>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    </div>
</div>
<jsp:include page="Modal_Agregar_PreSeg.jsp"/>
<jsp:include page="../Footer.jsp"/>