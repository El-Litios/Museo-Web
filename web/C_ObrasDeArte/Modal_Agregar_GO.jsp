<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas galerias-->
<div class="modal fade" id="nuevago" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" dat-dismiss="modal" aria-hidden="true">&time;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Agregar Nuevo Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form method="POST" action="Servlet_GaleriasObras?op=2">
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Obra de Arte</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v1">
                                    <c:forEach items="${listaO}" var="fila">
                                        <option  value="${fila.cod_obra}"><c:out value="${fila.tit_obra}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Galeria Asociada</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v2">
                                    <c:forEach items="${listaG}" var="fila">
                                        <option  value="${fila.cod_gal}"><c:out value="${fila.nom_gal}"/></option>
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
