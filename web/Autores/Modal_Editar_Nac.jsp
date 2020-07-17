<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas galerias-->
<div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Nacion Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="nombre" style="border: none;" value="nombre" id="nombre" style="border: none;" readonly/>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Pais Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="pais" style="border: none;" value="pais" id="pais" style="border: none;" readonly/>
                        </div>
                    </div>
                    <form method="POST" action="Servlet_Nacionalidades?op=5">
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Nacionalidad</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2">
                                <label  style="position: relative; top: 7px;">Pais</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v3">
                                    <c:forEach items="${listaP}" var="fila">
                                        <option  value="${fila.cod_pais}"><c:out value="${fila.nom_pais}"/></option>
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
                var pais=$(e.relatedTarget).data().pais;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#nombre').val(nom);
                $(e.currentTarget).find('#pais').val(pais);
            })
    });
</script>