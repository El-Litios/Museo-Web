<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <div class="col-md-4">
                <h2><i class="fa fa-images"></i>GESTION OBRAS EN GALERIAS</h2><hr>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <h2>
                        <form method="POST" action="Servlet_GaleriasObras?op=5">
                            <div class="row">
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="buscar" placeholder="Obras en Galeria"/>
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
                <a href="#nuevago" class="btn btn-success" id="btn1" data-toggle="modal"><i class="fa fa-plus"> Obras a Galerias</i></a>
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
            <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Lista de Obras en Galerias</h3>
        </div>
        <div class="panel-body">
            <table class="table table-bordered table-striped table-responsive table-hover">
        <thead>
            <tr>  

                <th>Obra de Arte</th>
                <th>Galeria Asociada</th>
                <th colspan="2">Opciones</th>

            </tr>
        </thead>
        <tbody>
        <c:forEach items="${lista}" var="fila">
            <tr>
                <td><c:out value="${fila.tit_obra}"/></td>
                <td><c:out value="${fila.nom_gal}"/></td>
                
                <td style="text-align: center;"><a href="#editar" data-id="<c:out value="${fila.cod_galob}"/>" 
                       data-obra="<c:out value="${fila.tit_obra}"/>" data-gal="<c:out value="${fila.nom_gal}"/>"
                       class="btn btn-warning btn-sm" data-toggle="modal">
                       <span class="glyphicon glyphicon-pencil"></span> Editar</a></td>
                       <jsp:include page="Modal_Editar_GO.jsp"/>
                       
                <td style="text-align: center;">
                   <% if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                    <a href="#eliminar" data-id="<c:out value="${fila.cod_galob}"/>" 
                       data-obra="<c:out value="${fila.tit_obra}"/>" data-gal="<c:out value="${fila.nom_gal}"/>"
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
</div>     
<jsp:include page="Modal_Agregar_GO.jsp"/>
<jsp:include page="../Footer.jsp"/>
