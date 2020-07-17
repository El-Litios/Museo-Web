<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas galerias-->
<div class="modal fade" id="nuevaobra" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" dat-dismiss="modal" aria-hidden="true">&time;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Agregar Nuevo Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form method="POST" action="Servlet_ObraDeArte?op=2">
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Titulo</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v1"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha Creacion</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha Ingreso</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v3"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Autor</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v4">
                                    <c:forEach items="${listaA}" var="fila">
                                        <option  value="${fila.cod_autor}"><c:out value="${fila.nom_autor}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Tipo de Obra</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v5">
                                    <c:forEach items="${listaT}" var="fila">
                                        <option  value="${fila.cod_tipoO}"><c:out value="${fila.nom_tipoO}"/></option>
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