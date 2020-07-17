<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>

<!--Mostrar datos de Prestamos-->
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <c:forEach items="${listaDetalles}" var="fila">
                <div class="col-md-4">
                    <h2><i class="fa fa-images"></i> <c:out value="${fila.fec_prestamo}"/> </h2>
                </div> 
                <div class="col-md-4">
                    <h2><c:out value="${fila.nom_museo}"/> </h2>
                </div> 
                <div class="col-md-4">
                    <h2><c:out value="${fila.nom_estado}"/> </h2>
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

<!-- TABLA DE DETALLES DE PRESTAMOS CON OBRAS DE ARTE --->
<div class="panel-info">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-10">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Detalles de Prestamo</h3>
                </div>
                <div class="col-md-2">
                    <a href="#detpresmodal" class="btn btn-success" data-toggle="modal">
                        <span class="glyphicon glyphicon-plus"></span> Detalles
                    </a>
                </div>
            </div>
        </div>
    <div class="panel-body">
        <table class="table table-bordered table-striped table-responsive table-hover">
                <thead>
                        <tr>
                            <th>Observacion</th>
                            <th>Titulo de Obra</th>
                            <th colspan="2" style="text-align: center">Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ListaD}" var="fila">
                            <tr>
                                <td><c:out value="${fila.obser_detallep}"/></td>
                                <td><c:out value="${fila.tit_obra}"/></td>
                                
                                <td style="text-align: center;"><a href="#editardetalleprestamo" data-id="<c:out value="${fila.cod_detallep}"/>" 
                                data-obs="<c:out value="${fila.obser_detallep}"/>" data-tit="<c:out value="${fila.tit_obra}"/>"
                                class="btn btn-warning btn-sm" data-toggle="modal">
                                <span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                                <jsp:include page="ModalEditarDetallePrestamo.jsp"/>
                       
                                <td style="text-align: center;">
                                   <% if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                                    <a href="#eliminardetalleprestamo" data-id="<c:out value="${fila.cod_detallep}"/>" 
                                       class="btn btn-danger btn-sm" data-toggle="modal">
                                       <span class="glyphicon glyphicon-remove"></span> Borrar
                                    </a>
                                   <% }%>
                                </td>
                                 <jsp:include page="ModalEliminarDetallePrestamo.jsp"/>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    </div>
</div>
                            
<!-- TABLA DE DEVOLUCIONES EN PRESTAMOS-->
<div class="panel-info">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-10">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span>Tabla de Devoluciones</h3>
                </div>
                <div class="col-md-2">
                    <a href="#devmodal" class="btn btn-success" data-toggle="modal">
                        <span class="glyphicon glyphicon-plus"></span> Devoluciones
                    </a>
                </div>
            </div>
        </div>
    <div class="panel-body">
        <table class="table table-bordered table-striped table-responsive table-hover">
                <thead>
                        <tr>
                            <th>Fecha de Devolucion</th>
                            <th>Documentos Asociados</th>
                            <th>Comentarios</th>
                            <th colspan="2">Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaDev}" var="fila">
                            <tr>
                                <td><c:out value="${fila.fec_devo}"/></td>
                                <td><c:out value="${fila.docs_devo}"/></td>
                                <td><c:out value="${fila.comen_devo}"/></td>

                                
                                <td style="text-align: center;"><a href="#editardevoluciones" data-id="<c:out value="${fila.cod_devo}"/>" 
                                data-fec="<c:out value="${fila.fec_devo}"/>" data-docs="<c:out value="${fila.docs_devo}"/>" 
                                data-comen="<c:out value="${fila.comen_devo}"/>"
                                class="btn btn-warning btn-sm" data-toggle="modal">
                                <span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                                <jsp:include page="ModalEditarDevoluciones.jsp"/>
                       
                                <td style="text-align: center;">
                                   <% if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                                    <a href="#eliminardevoluciones" data-id="<c:out value="${fila.cod_devo}"/>" 
                                       class="btn btn-danger btn-sm" data-toggle="modal">
                                       <span class="glyphicon glyphicon-remove"></span> Borrar
                                    </a>
                                   <% }%>
                                </td>
                                 <jsp:include page="ModalEliminarDevoluciones.jsp"/>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    </div>
</div>

<!-- TABLA DE PRESTAMOS SEGUROS EN PRESTAMOS-->
<div class="panel-info">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-10">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span>Seguros Asociados</h3>
                </div>
                <div class="col-md-2">
                    <a href="#segpresmodal" class="btn btn-success" data-toggle="modal">
                        <span class="glyphicon glyphicon-plus"></span> Seguros Asociados
                    </a>
                </div>
            </div>
        </div>
    <div class="panel-body">
        <table class="table table-bordered table-striped table-responsive table-hover">
                <thead>
                        <tr>
                            <th>Descripcion del Seguro</th>
                            <th>Fecha de Seguro</th>
                            <th>Monto Asociado</th>
                            <th colspan="2">Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${ListaS}" var="fila">
                            <tr>
                                <td><c:out value="${fila.desc_seguro}"/></td>
                                <td><c:out value="${fila.fec_seguro}"/></td>
                                <td><c:out value="${fila.monto_seguro}"/></td>
                                
                                <td style="text-align: center;"><a href="#editarsegpres" data-id="<c:out value="${fila.cod_preseg}"/>" 
                                data-fec="<c:out value="${fila.desc_seguro}"/>"  
                                class="btn btn-warning btn-sm" data-toggle="modal">
                                <span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                                <jsp:include page="ModalEditarSegPres.jsp"/>
                       
                                <td style="text-align: center;">
                                   <% if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                                    <a href="#eliminarsegpres" data-id="<c:out value="${fila.cod_preseg}"/>" 
                                       class="btn btn-danger btn-sm" data-toggle="modal">
                                       <span class="glyphicon glyphicon-remove"></span> Borrar
                                    </a>
                                   <% }%>
                                </td>
                                 <jsp:include page="ModalEliminarSegPres.jsp"/>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    </div>
</div>
<jsp:include page="ModalAgregarDetalle.jsp"/>
<jsp:include page="ModalAgregarDevoluciones.jsp"/>
<jsp:include page="ModalAgregarSegPres.jsp"/>
<jsp:include page="../Footer.jsp"/>
