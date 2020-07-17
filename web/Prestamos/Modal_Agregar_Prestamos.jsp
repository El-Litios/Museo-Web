<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevos prestamos-->
<div class="modal fade" id="nuevoprestamo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Agregar Nuevo Prestamo</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form method="POST" action="Servlet_Prestamos?op=2">
                        <!--Fecha de Prestamo-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha de Prestamo</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v1"/>
                            </div>
                        </div>
                        <!--Comentarios-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Comentarios</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <!--Costos-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Costo $</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v3"/>
                            </div>
                        </div>
                        <!--Museo asociado-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Museo Destino</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v4">
                                    <c:forEach items="${listaM}" var="fila">
                                        <option  value="${fila.cod_museo}"><c:out value="${fila.nom_museo}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <!--Estado de Prestamo-->
                        <div class="row">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Estado de Prestamo</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v5">
                                    <c:forEach items="${listaE}" var="fila">
                                        <option  value="${fila.cod_estado}"><c:out value="${fila.nom_estado}"/></option>
                                    </c:forEach>
                                </select>        
                            </div>
                        </div>
                </div>
            </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            <span class="glyphicon glyphicon-remove"></span> Cancelar
                        </button>
                        <button type="submit" name="agregar" class="btn btn-primary">
                            <span class="glyphicon glyphicon-floppy-disk"></span> Guardar Registro
                        </button>
                </form>
            </div>
        </div>
    </div>
</div>
