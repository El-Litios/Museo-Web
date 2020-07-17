<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas galerias-->
<div class="modal fade" id="editarevento" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Editar Eventos</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <!--NombreACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Nombre Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="nombre" style="border: none;" value="nombre" id="nombre" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Fecha Inicio ACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">F.Inicio Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="date" class="form-control text-center" name="ini" style="border: none;" value="ini" id="ini" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Fecha Fin ACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">F.fin Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="date" class="form-control text-center" name="fin" style="border: none;" value="fin" id="fin" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Tipo de Evento ACTUAL-->
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Tipo De Obra Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="tev" style="border: none;" value="tev" id="tev" style="border: none;" readonly/>
                        </div>
                    </div>
                    <!--Separacion con un h4-->
                    <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
                    <br>
                    <!--Formualrio para editar las Obras de Arte-->
                    <form method="POST" action="Servlet_Galerias?op=10">
                        <!--Codigo y Nombre-->
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Nombre</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v2" required/>
                            </div>
                        </div>
                        <!--Fecha de Inicio-->
                        <div class="row">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">F.Inicio</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v3"  required/>
                            </div>
                        </div>
                        <br>
                        <!--Fecha de Fin-->
                        <div class="row">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">F.Fin</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v4"  required/>
                            </div>
                        </div>
                        <br>
                        <!--Tipo de Evento-->
                        <div class="row">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Tipo de Evento</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v5">
                                    <c:forEach items="${listaTEV}" var="fila">
                                        <option  value="${fila.cod_tev}"><c:out value="${fila.nom_tev}"/></option>
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
            $('#editarevento').on('show.bs.modal',function(e){
                var id=$(e.relatedTarget).data().id;
                var nom=$(e.relatedTarget).data().nom;
                var ini=$(e.relatedTarget).data().ini;
                var fin=$(e.relatedTarget).data().fin;
                var tev=$(e.relatedTarget).data().tev;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#nombre').val(nom);
                $(e.currentTarget).find('#ini').val(ini);
                $(e.currentTarget).find('#fin').val(fin);
                $(e.currentTarget).find('#tev').val(tev);
            })
    });
</script>