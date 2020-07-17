<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <div class="col-md-4">
                <h2><i class="fa fa-images"></i> GESTION DE ESPECIALIDADES</h2><hr>
            </div>
            <div class="col-md-6">
                <div class="form-group">
                    <h2>
                        
                    </h2>
                </div>
            </div>
            <div class="col-md-2">
            </div>
        </div>  
    </div>
</div>
<!--MOSTRAR DATOS-->
<div id="tabla1">
    <div class="panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Guias Turisticos Disponibles</h3>
        </div>
        <div class="panel-body">
            <table class="table table-bordered table-striped table-responsive table-hover">
        <thead>
            <tr>

                <th>Nombre de Usuario</th>
                <th>Nombre Completo</th>
                <th>Email</th>
                <th colspan="2">Opciones</th>

            </tr>
        </thead>
        <tbody>
        <c:forEach items="${lista}" var="fila">
            <tr>
                <td><c:out value="${fila.usu_nom}"/></td>
                <td><c:out value="${fila.nombre}"/></td>
                <td><c:out value="${fila.em}"/></td>
                
                <td style="text-align: center">
                    <a href="Servlet_GuiasTuristicos?op=2&codigo=${fila.cod_eu}" 
                       class="btn btn-success">
                       <span class="glyphicon glyphicon-list-alt"></span>Detalle</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
        </div>
    </div>
</div>     

<jsp:include page="../Footer.jsp"/>
