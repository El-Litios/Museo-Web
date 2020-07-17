<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas galerias-->
<div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Editar Seguros</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <!--Descripcion ACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Descripcion Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="desc" style="border: none;" value="desc" id="desc" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Fecha ACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Fecha Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="fec" style="border: none;" value="fec" id="fec" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Monto ACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Monto Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="monto" style="border: none;" value="monto" id="monto" style="border: none;" readonly/>
                        </div>
                    </div>
                    
                    <!--Separacion con un h4-->
                    <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
                    <br>
                    
                    <!--Formualrio para editar Seguros-->
                    <form method="POST" action="Servlet_SeguroDevoluciones?op=3">
                        <!--Codigo y Descripcion-->
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Descripcion</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" name="v2" class="form-control" value="" />
                            </div>
                        </div>   
                        <!--Fecha de Seguro-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha de Seguro</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" name="v3" class="form-control" value="" />
                            </div>
                        </div>
                        <!--Monto-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Monto</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" name="v4" class="form-control" value="" />
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
            $('#editar').on('show.bs.modal',function(e){
                var id=$(e.relatedTarget).data().id;
                var desc=$(e.relatedTarget).data().desc;
                var fec=$(e.relatedTarget).data().fec;
                var monto=$(e.relatedTarget).data().monto;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#desc').val(desc);
                $(e.currentTarget).find('#fec').val(fec);
                $(e.currentTarget).find('#monto').val(monto);
                
                
            })
    });
</script>
