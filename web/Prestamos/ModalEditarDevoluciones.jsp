<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas galerias-->
<div class="modal fade" id="editardevoluciones" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <!--Fecha actual de Devcluciones-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Fecha Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="fec" style="border: none;" value="fec" id="fec" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Documentos asociados actuales-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Documentos Actuales</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="docs" style="border: none;" value="docs" id="docs" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Comentarios Actuales-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Comentarios Actuales</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="comen" style="border: none;" value="comen" id="comen" style="border: none;" readonly/>
                        </div>
                    </div>
                     
                    <!--Separacion con un h4-->
                    <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
                    <br>
                    
                    <!--Formualrio para editar las Obras de Arte-->
                    <form method="POST" action="Servlet_Prestamos?op=11">
                        
                        <!--Codigo y Observaciones-->
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha de Devolucion</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value=""  name="v2"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Documentos Asociados</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value=""  name="v3"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Comentarios</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value=""  name="v4"/>
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
<!--CREAR SCRIPT (FUNCION) PARA RECIBIR DATOS UTILIZANDO JAVASCRIPT-->
<script>
    $(document).ready(function (e){
            $('#editardevoluciones').on('show.bs.modal',function(e){
                var id=$(e.relatedTarget).data().id;
                var fec=$(e.relatedTarget).data().fec;
                var docs=$(e.relatedTarget).data().docs;
                var comen=$(e.relatedTarget).data().comen;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#fec').val(fec);
                $(e.currentTarget).find('#docs').val(docs);
                $(e.currentTarget).find('#comen').val(comen);
                
            })
    });
</script>
