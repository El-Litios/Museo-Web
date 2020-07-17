<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas galerias-->
<div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
             <button type="button" class="close" dat-dismiss="modal" aria-hidden="true">&time;</button>
             <center><h4 class="modal-title" id="ModalLabel1">Formulario Administradores</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Email actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="em" style="border: none;" value="em" id="em" style="border: none;" readonly/>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Pass Secreta Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="pass" style="border: none;" value="pass" id="pass" style="border: none;" readonly/>
                        </div>
                    </div>
                     <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Usuario Asociado</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="usu" style="border: none;" value="usu" id="usu" style="border: none;" readonly/>
                        </div>
                    </div>
                    <center><h4 class="modal-body" id="ModalLabel1">Editar Registros</h4></center>
                    <form method="POST" action="Servlet_Administrador?op=3">
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Email Administrador</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Password</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v3"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2">
                                <label  style="position: relative; top: 7px;">Usuario Asociado</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v4">
                                    <c:forEach items="${listaU}" var="fila">
                                        <option  value="${fila.usu_cod}"><c:out value="${fila.usu_nom}"/></option>
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
                var em=$(e.relatedTarget).data().em;
                var pass=$(e.relatedTarget).data().pass;
                var usu=$(e.relatedTarget).data().usu;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#em').val(em);
                $(e.currentTarget).find('#pass').val(pass);
                $(e.currentTarget).find('#usu').val(usu);
                
            })
    });
</script>