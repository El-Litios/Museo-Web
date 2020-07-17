<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas galerias-->
<div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" dat-dismiss="modal" aria-hidden="true">&time;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <!--TITULO ACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Titulo Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="titulo" style="border: none;" value="titulo" id="titulo" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Fecha Creacion ACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">F.Creacion Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="fcrea" style="border: none;" value="fcrea" id="fcrea" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Fecha Ingreso ACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">F.Ingreso Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="fing" style="border: none;" value="fing" id="fing" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Autor ACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Autor Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="autor" style="border: none;" value="autor" id="autor" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Tipo de Obra ACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Tipo De Obra Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="tipo" style="border: none;" value="tipo" id="tipo" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Separacion con un h4-->
                    <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
                    <br>
                    <!--Formualrio para editar las Obras de Arte-->
                    <form method="POST" action="Servlet_ObraDeArte?op=3">
                        <!--Codigo y Titulo-->
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Titulo</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v2" required/>
                            </div>
                        </div>
                        <!--Fecha de creacion-->
                        <div class="row">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">F.Creacion</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v3"  required/>
                            </div>
                        </div>
                        <br>
                        <!--Fecha de Ingreso-->
                        <div class="row">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">F.Ingreso</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v4"  required/>
                            </div>
                        </div>
                        <br>
                        <!--autor-->
                        <div class="row">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Autor</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v5">
                                    <c:forEach items="${listaA}" var="fila">
                                        <option  value="${fila.cod_autor}"><c:out value="${fila.nom_autor}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        <br>
                        <!--Tipo de Obra-->
                        <div class="row">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Tipo de Obra</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v6">
                                    <c:forEach items="${listaT}" var="fila">
                                        <option  value="${fila.cod_tipoO}"><c:out value="${fila.nom_tipoO}"/></option>
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
                var titu=$(e.relatedTarget).data().titu;
                var fec=$(e.relatedTarget).data().fec;
                var fing=$(e.relatedTarget).data().fing;
                var aut=$(e.relatedTarget).data().aut;
                var tip=$(e.relatedTarget).data().tip;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#titulo').val(titu);
                $(e.currentTarget).find('#fcrea').val(fec);
                $(e.currentTarget).find('#fing').val(fing);
                $(e.currentTarget).find('#autor').val(aut);
                $(e.currentTarget).find('#tipo').val(tip);
            })
    });
</script>
