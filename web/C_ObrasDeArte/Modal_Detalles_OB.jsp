<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--detalles obras de arte-->
<div class="modal fade"  id="detalles" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" dat-dismiss="modal" aria-hidden="true">&time;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Detalles</h4></center>
            </div>
            <div class="modal-body">
            <div id="tabla1">
                <div class="panel-info">
                    <div class="panel-heading">
                        <h3 class="panel-title"><span class="glyphicon glyphicon-list"></span> Lista de Obras de Arte</h3>
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
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach items="${lista}" var="fila">
                            <tr>
                                <td><c:out value="${fila.tit_obra}"/></td>
                                <td><c:out value="${fila.fcrea_obra}"/></td>
                                <td><c:out value="${fila.fing_obra}"/></td>
                                <td><c:out value="${fila.nom_autor}"/></td>
                                <td><c:out value="${fila.nom_tipoO}"/></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>    
            </div>
        </div>
    </div>
</div>
