<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:include page="../Header.jsp"/>
<div class="panel panel-primary">
    <div class="panel-heading">
        <div class="row">
            <div class="col-md-12">
                <h2><i class="fa fa-images"></i> ESTADO DE RESTAURACION</h2><hr>
            </div>
        </div>  
    </div>
</div>
<!--MOSTRAR DATOS-->
<div id="tabla1">
    <div class="panel-info">
        <div class="panel-heading">
            <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Lista de Estados de Restauracion</h3>
        </div>
        <div class="panel-body">
            <table class="table table-bordered table-striped table-responsive table-hover">
        <thead>
            <tr>

                <th>Estado</th>
                <th colspan="1" style="text-align: center">Operacion</th>

            </tr>
        </thead>
        <tbody>
        <c:forEach items="${lista}" var="fila">
            <tr>
                <td><c:out value="${fila.nom_estado}"/></td>
                <td style="text-align: center">
                    <a href="Servlet_Restauraciones?op=2&codigo=${fila.cod_estado}" 
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
