<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>
<!--Mostrar datos de galeria-->
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <c:forEach items="${listaDetalle}" var="fila">
                <div class="col-md-4">
                    <h2><i class="fa fa-images"></i> <c:out value="${fila.nom_gal}"/> </h2>
                </div> 
                <div class="col-md-4">
                    <h2><c:out value="${fila.nom_ubi}"/> </h2>
                </div> 
                <div class="col-md-4">
                    <h2>
                        <a href="#editar" data-id="<c:out value="${fila.cod_gal}"/>" 
                       data-nom="<c:out value="${fila.nom_gal}"/>" data-nombreu="<c:out value="${fila.nom_ubi}"/>"
                       class="btn btn-warning btn-sm" data-toggle="modal">
                       <span class="glyphicon glyphicon-remove"></span>Editar</a>
                    </h2>
                </div>
                <jsp:include page="ModalEditar.jsp"/>
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

<!-- TABLA DE EVENTOS --->
<div class="panel-info">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-10">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Eventos O Exposiciones</h3>
                </div>
                <div class="col-md-2">
                    <a href="#eventomodal" class="btn btn-success" data-toggle="modal">
                        <span class="glyphicon glyphicon-plus"></span> Nuevo Evento
                    </a>
                </div>
            </div>
        </div>
    <div class="panel-body">
        <table class="table table-bordered table-striped table-responsive table-hover">
                <thead>
                        <tr>
                            <th>Nombre</th>
                            <th>Fecha de Inicio</th>
                            <th>Fecha de Fin</th>
                            <th>Tipo de Evento</th>
                            <th colspan="2" style="text-align: center">Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaEventos}" var="fila">
                            <tr>
                                <td><c:out value="${fila.nom_ev}"/></td>
                                <td><c:out value="${fila.fec_ini}"/></td>
                                <td><c:out value="${fila.fec_fin}"/></td>
                                <td><c:out value="${fila.nom_tev}"/></td>
                                
                                <td style="text-align: center;"><a href="#editarevento" data-id="<c:out value="${fila.cod_ev}"/>" 
                                data-nom="<c:out value="${fila.nom_ev}"/>" data-ini="<c:out value="${fila.fec_ini}"/>"
                                data-fin="<c:out value="${fila.fec_fin}"/>" 
                                data-tev="<c:out value="${fila.nom_tev}"/>"
                                class="btn btn-warning btn-sm" data-toggle="modal">
                                <span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                                <jsp:include page="Modal_Editar_EV.jsp"/>
                       
                                <td style="text-align: center;">
                                   <% if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                                    <a href="#eliminar" data-id="<c:out value="${fila.cod_ev}"/>" 
                                       data-nom="<c:out value="${fila.nom_ev}"/>"
                                       class="btn btn-danger btn-sm" data-toggle="modal">
                                       <span class="glyphicon glyphicon-remove"></span> Borrar
                                    </a>
                                   <% }%>
                                </td>
                                 <jsp:include page="Modal_Eliminar_EV.jsp"/>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    </div>
</div>
                            
<!-- TABLA DE OBRAS DE ARTE-->
<div class="panel-info">
        <div class="panel-heading">
            <div class="row">
                <div class="col-md-10">
                    <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Obras de Arte</h3>
                </div>
                <div class="col-md-2">
                    <a href="#nuevago" class="btn btn-success" data-toggle="modal">
                        <span class="glyphicon glyphicon-plus"></span> Obras en Galeria
                    </a>
                </div>
            </div>
        </div>
    <div class="panel-body">
        <table class="table table-bordered table-striped table-responsive table-hover">
                <thead>
                        <tr>
                            <th>Titulo</th>
                            <th>Fecha de Creacion</th>
                            <th>Fecha de Ingreso</th>
                            <th>Autor</th>
                            <th>Tipo de Obra</th>
                            <th colspan="2">Operaciones</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${listaGO}" var="fila">
                            <tr>
                                <td><c:out value="${fila.tit_obra}"/></td>
                                <td><c:out value="${fila.fcrea_obra}"/></td>
                                <td><c:out value="${fila.fing_obra}"/></td>
                                <td><c:out value="${fila.nom_autor}"/></td>
                                <td><c:out value="${fila.nom_tipoO}"/></td>
                                
                                <td style="text-align: center;"><a href="#EditarGaleriasObras" data-id="<c:out value="${fila.cod_galob}"/>" 
                                data-titulo="<c:out value="${fila.tit_obra}"/>"
                                class="btn btn-warning btn-sm" data-toggle="modal">
                                <span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                                <jsp:include page="Modal_Editar_GO.jsp"/>
                       
                                <td style="text-align: center;">
                                   <% if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                                    <a href="#EliminarGaleriasObras" data-id="<c:out value="${fila.cod_galob}"/>" 
                                       data-titulo="<c:out value="${fila.tit_obra}"/>"
                                       class="btn btn-danger btn-sm" data-toggle="modal">
                                       <span class="glyphicon glyphicon-remove"></span> Borrar
                                    </a>
                                   <% }%>
                                </td>
                                 <jsp:include page="Modal_Eliminar_GO.jsp"/>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
    </div>
</div>
<jsp:include page="eventomodal.jsp"/>
<jsp:include page="Modal_Agregar_GO.jsp"/>
<jsp:include page="../Footer.jsp"/>