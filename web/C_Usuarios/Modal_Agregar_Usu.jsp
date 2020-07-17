<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas galerias-->
<div class="modal fade" id="nuevousu" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" dat-dismiss="modal" aria-hidden="true">&time;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Agregar Nuevo Usuario</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form method="POST" action="Servlet_Usu?op=3">
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Nombre Usuario</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v1"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Password</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 2px;">Nombre Completo</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" id="datepicker" name="v3"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 2px;">Email</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" placeholder="Example@gmail.com"  name="v4"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2">
                                <label  style="position: relative; top: 7px;">Rol</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v5">
                                    <c:forEach items="${listaR}" var="fila">
                                        <option  value="${fila.rol_cod}"><c:out value="${fila.rol_nom}"/></option>
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