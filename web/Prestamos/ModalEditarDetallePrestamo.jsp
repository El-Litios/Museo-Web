<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--Editar detalles de prestamos en Prestamos-->
<div class="modal fade" id="editardetalleprestamo" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <!--Observacion Actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Observacion Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="obs" style="border: none;" value="obs" id="obs" style="border: none;" readonly/>
                        </div>
                    </div>
                     <!--Obra de Arte Actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Obra de Arte Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="tit" style="border: none;" value="tit" id="tit" style="border: none;" readonly/>
                        </div>
                    </div>
                     
                    <!--Separacion con un h4-->
                    <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
                    <br>
                    
                    <!--Formualrio para editar los Detalles de Prestamos dentro de Prestamos-->
                    <form method="POST" action="Servlet_Prestamos?op=8">
                        
                        <!--Codigo y Observaciones-->
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Observaciones</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value=""  name="v2"/>
                            </div>
                        </div>
                         <!--Obras de arte-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Obra de Arte</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v3">
                                    <c:forEach items="${ListaO}" var="fila">
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
            $('#editardetalleprestamo').on('show.bs.modal',function(e){
                var id=$(e.relatedTarget).data().id;
                var tit=$(e.relatedTarget).data().tit;
                var obs=$(e.relatedTarget).data().obs;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#obs').val(obs);
                $(e.currentTarget).find('#tit').val(tit);
                
            })
    });
</script>
