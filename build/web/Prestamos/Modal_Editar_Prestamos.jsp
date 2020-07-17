<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--editar prestamos-->
<div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <!-- Fecha de Prestamo Actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Fecha Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="fec" style="border: none;" value="fec" id="fec" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!-- Costo del prestamo-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Costo actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="costo" style="border: none;" value="costo" id="costo" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!-- Estado del prestamo-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Estado Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="estado" style="border: none;" value="estado" id="estado" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!-- Museo destino actual-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Museo Destino Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="museo" style="border: none;" value="museo" id="museo" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!-- Comentarios actuales-->
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
                    <!--Formualrio para editar Los Prestamos-->
                    <form method="POST" action="Servlet_Prestamos?op=3">
                        <!-- codigo y Fecha-->
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <!-- Costo -->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Costo de Prestamo</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v4"/>
                            </div>
                        </div>
                        <!-- Estado-->
                        <div class="row form-group">
                            
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Estado de Prestamo</label>
                            </div>
                           <div class="col-sm-10">
                                <select class="form-control" name="v6">
                                    <c:forEach items="${listaE}" var="fila">
                                        <option  value="${fila.cod_estado}"><c:out value="${fila.nom_estado}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <!-- Museo-->
                        <div class="row">
                            <div class="col-sm-2">
                                <label  style="position: relative; top: 7px;">Museo</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v5">
                                    <c:forEach items="${listaM}" var="fila">
                                        <option  value="${fila.cod_museo}"><c:out value="${fila.nom_museo}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <br>
                        <!-- Comentarios -->
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
<!--CREAR SCRIPT (FUNCION) PARA RECIBIR DATOS UTILIZANDO JAVASCRIPT-->
<script>
    $(document).ready(function (e){
            $('#editar').on('show.bs.modal',function(e){
                var id=$(e.relatedTarget).data().id;
                var fec=$(e.relatedTarget).data().fec;
                var costo=$(e.relatedTarget).data().costo;
                var estado=$(e.relatedTarget).data().estado;
                var museo=$(e.relatedTarget).data().museo;
                var comen=$(e.relatedTarget).data().comen;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#fec').val(fec);
                $(e.currentTarget).find('#costo').val(costo);
                $(e.currentTarget).find('#estado').val(estado);
                $(e.currentTarget).find('#museo').val(museo);
                $(e.currentTarget).find('#comen').val(comen);
            })
    });
</script>
