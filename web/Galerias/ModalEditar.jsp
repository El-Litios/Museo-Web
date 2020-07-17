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
                            <label class="control-label" style="position: relative; top: 7px; color: black" >Ubicacion Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="nombreu" style="border: none;" value="nombreu" id="nombreu" style="border: none;" readonly/>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px; color: black">Nombre Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="nombre" style="border: none;" value="nombre" id="nombre" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Separacion con un h4-->
                    <center><h4 style="color: black" class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
                    <br>
                    <div class="container-fluid">
                    <form method="POST" action="Servlet_Galerias?op=5">
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px; color: black">Nombre</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2">
                                <label  style="position: relative; top: 7px; color: black">Ubicacion</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v3">
                                    <c:forEach items="${listau}" var="fila">
                                        <option  value="${fila.cod_ubi}"><c:out value="${fila.nom_ubi}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                    </div>    
                </div>
            </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">
                            <span class="glyphicon glyphicon-remove"></span> Cancelar
                        </button>
                        <button type="submit" name="agregar" class="btn btn-primary">
                            <span class="glyphicon glyphicon-floppy-disk"></span> Editar Registro
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
                var nombreu=$(e.relatedTarget).data().nombreu;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#nombre').val(nom);
                $(e.currentTarget).find('#nombreu').val(nombreu);
            })
    });
</script>