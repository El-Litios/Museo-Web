<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas galerias-->
<div class="modal fade" id="nuevaespecialidad" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Agregar Nuevo Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form method="POST" action="Servlet_Especialidad?op=2">
                        <!--Usuarios-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Nombre de usuario</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v1">
                                    <c:forEach items="${listaU}" var="fila">
                                        <option  value="${fila.usu_cod}"><c:out value="${fila.usu_nom}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <!--Especialidades-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Especialidades</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v2">
                                    <c:forEach items="${listaE}" var="fila">
                                        <option  value="${fila.cod_especialidades}"><c:out value="${fila.nom_especilidades}"/></option>
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