<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas devoluciones dentro de Prestamos-->
<div class="modal fade" id="devmodal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Agregar Devolucion</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form method="POST" action="Servlet_Prestamos?op=10">
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha de Devolucion</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v1"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Documentos Asociados</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Comentarios</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v3"/>
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
