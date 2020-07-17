<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--editar Visitas-->
<div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <!--Nombre de Visita Actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Nombre Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="nom" style="border: none;" value="nom" id="nom" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Nombre de Encargado Actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Encargado actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="enc" style="border: none;" value="enc" id="enc" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Curso de Visita Actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Curso Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="curso" style="border: none; text-align: center" value="curso" id="curso" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!-- Museo destino actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Cantidad Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="cant" style="border: none;" value="cant" id="cant" style="border: none;" readonly/>
                        </div>
                    </div>
                    
                    <!--Separacion con un h4-->
                    <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
                    <br>
                    
                    <!--Formualrio para editar Los Prestamos-->
                    <form method="POST" action="Servlet_Visitas?op=3">
                        <!-- codigo y Nombre-->
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Nombre</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <!-- Encargado -->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Encargado</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v3"/>
                            </div>
                        </div>
                        <!-- Curso-->
                        <div class="row form-group">
                            
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Curso</label>
                            </div>
                           <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v4"/>
                            </div>
                        </div>
                        <!-- Cantidad-->
                        <div class="row">
                            <div class="col-sm-2">
                                <label  style="position: relative; top: 7px;">Cantidad de Personas</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="number" class="form-control" value="" name="v5"/>
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
                var nom=$(e.relatedTarget).data().nom;
                var enc=$(e.relatedTarget).data().enc;
                var curso=$(e.relatedTarget).data().curso;
                var cant=$(e.relatedTarget).data().cant;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#nom').val(nom);
                $(e.currentTarget).find('#enc').val(enc);
                $(e.currentTarget).find('#curso').val(curso);
                $(e.currentTarget).find('#cant').val(cant);
            })
    });
</script>
