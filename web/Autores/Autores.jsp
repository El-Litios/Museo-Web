<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <div class="col-md-4">
                <h2><i class="fa fa-images"></i>GESTION DE AUTORES</h2><hr>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <h2>
                        <form method="POST" action="Servlet_Autores?op=2">
                            <div class="row">
                                <div class="col-md-8">
                                    <input type="text" class="form-control" name="buscar" placeholder="BUSCADOR"/>
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
                <a href="#nuevoautor" class="btn btn-success"  data-toggle="modal"><i class="fa fa-plus">Agregar Autor</i></a>
                <br>
                <br>
                <a href="#nuevanacionalidad" class="btn btn-success" data-toggle="modal"><i class="fa fa-plus">Agregar Nacionalidad</i></a>
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
            <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Lista de Autores</h3>
        </div>
        <div class="panel-body">
            <table class="table table-bordered table-striped table-responsive table-hover">
        <thead>
            <tr>

                <th>Nombre de Autores</th>
                <th>Pseudonimo</th>
                <th>Nacionalidad</th>
                <th>Pais</th>
                <th colspan="3">Opciones</th>
                

            </tr>
        </thead>
        <tbody>
        <c:forEach items="${lista}" var="fila">
            <tr>
                <td><c:out value="${fila.nom_autor}"/></td>
                <td><c:out value="${fila.pseu_autor}"/></td>
                <td><c:out value="${fila.nom_nac}"/></td>
                <td><c:out value="${fila.nom_pais}"/></td>
                
                <td style="text-align: center;"><a href="#editar" data-id="<c:out value="${fila.cod_autor}"/>" 
                       data-nom="<c:out value="${fila.nom_autor}"/>" data-pseu="<c:out value="${fila.pseu_autor}"/>"
                       data-fnac="<c:out value="${fila.fec_naci}"/>" data-fdef="<c:out value="${fila.fec_def}"/>"
                       data-nac="<c:out value="${fila.nom_nac}"/>" 
                       class="btn btn-warning btn-sm" data-toggle="modal">
                       <span class="glyphicon glyphicon-remove"></span>Editar</a></td>
                       <jsp:include page="Modal_Editar_Autores.jsp"/>
                       
                <td style="text-align: center;">
                  <%if(((String)session.getAttribute("rol")).equals("Administrador")){%>
                    <a href="#eliminar" data-id="<c:out value="${fila.cod_autor}"/>" 
                       data-nom="<c:out value="${fila.nom_autor}"/>"
                       class="btn btn-danger btn-sm" data-toggle="modal">
                       <span class="glyphicon glyphicon-remove"></span>Borrar
                    </a>
                       <% }%>
                </td>
                       <jsp:include page="Modal_Eliminar_Autores.jsp"/>
                       
            </tr>
        </c:forEach>
        </tbody>
    </table>
        </div>
    </div>
</div>
<jsp:include page="Modal_Agregar_Autores.jsp"/>
<jsp:include page="Modal_Agregar_Nac.jsp"/>
<jsp:include page="../Footer.jsp"/>