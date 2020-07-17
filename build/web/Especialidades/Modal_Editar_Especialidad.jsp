<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--editar especialidades de usuarios-->
<div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <!--Nombre de usuario Actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Usuario Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="nom" style="border: none;" value="nom" id="nom" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Especialidad actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Especialidad Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="esp" style="border: none;" value="esp" id="esp" style="border: none;" readonly/>
                        </div>
                    </div>
                    
                    <!--Separacion con un h4-->
                    <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
                    <br>
                    
                    <form method="POST" action="Servlet_Especialidad?op=3">
                        <!--codigo y editar el usuario-->
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Nombre de usuario</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v2">
                                    <c:forEach items="${listaU}" var="fila">
                                        <option  value="${fila.usu_cod}"><c:out value="${fila.usu_nom}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <!--Editar especialidad-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Especialidad</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v3">
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
<!--CREAR SCRIPT (FUNCION) PARA RECIBIR DATOS UTILIZANDO JAVASCRIPT-->
<script>
    $(document).ready(function (e){
            $('#editar').on('show.bs.modal',function(e){
                var id=$(e.relatedTarget).data().id;
                var nom=$(e.relatedTarget).data().nom;
                var esp=$(e.relatedTarget).data().esp;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#nom').val(nom);  
                $(e.currentTarget).find('#esp').val(esp);
            })
    });
</script>
