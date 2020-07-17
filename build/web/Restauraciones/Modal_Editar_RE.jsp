<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Editar Restauraciones-->
<div class="modal fade" id="editarrest" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <!--Fecha de Restauracion Actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Fecha de Restauracion Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="fecp" style="border: none;" value="fecp" id="fecp" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Fecha de retorno Actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Fecha Retorno Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="fece" style="border: none;" value="fece" id="fece" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Obra de Arte Actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Obra de Arte Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="ob" style="border: none;" value="ob" id="ob" style="border: none;" readonly/>
                        </div>
                    </div>
                    
                    
                    <!--Separacion con un h4-->
                    <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
                    <br>
                    
                    <!--Formualrio para editar las Obras de Arte-->
                    <form method="POST" action="Servlet_Restauraciones?op=4">
                        <!--Codigo y Fecha de Restauracion-->
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha de Restauracion</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <!--Fecha de Retorno-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha de Retorno</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v3"/>
                            </div>
                        </div>
                        <!--Obra Asociada-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Obra de Arte</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v4">
                                    <c:forEach items="${listaO}" var="fila">
                                        <option  value="${fila.cod_obra}"><c:out value="${fila.tit_obra}"/></option>
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
            $('#editarrest').on('show.bs.modal',function(e){
                var id=$(e.relatedTarget).data().id;
                var fecp=$(e.relatedTarget).data().fecp;
                var fece=$(e.relatedTarget).data().fece;
                var ob=$(e.relatedTarget).data().ob;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#fecp').val(fecp);
                $(e.currentTarget).find('#fece').val(fece);
                $(e.currentTarget).find('#ob').val(ob);
                
            })
    });
</script>
