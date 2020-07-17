<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--editar tours-->
<div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Editar Seguros</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">

                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Fecha Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="fecha" style="border: none;" value="fecha" id="fecha" style="border: none;" readonly/>
                        </div>
                    </div>
                    

                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Hora Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="hora" style="border: none;" value="hora" id="hora" style="border: none;" readonly/>
                        </div>
                    </div>
                    

                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Insumos Actuales</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="insumo" style="border: none;" value="insumo" id="insumo" style="border: none;" readonly/>
                        </div>
                    </div>
                    
                    
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Evento Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="evento" style="border: none;" value="evento" id="evento" style="border: none;" readonly/>
                        </div>
                    </div>
                    
                    
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Visitante Actuales</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="visitanom" style="border: none;" value="visitanom" id="visitanom" style="border: none;" readonly/>
                        </div>
                    </div>
                    
                    
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Visitante Actuales</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="encargadonom" style="border: none;" value="encargadonom" id="encargadonom" style="border: none;" readonly/>
                        </div>
                    </div>
                    
                    
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Visitante Actuales</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="cantidad" style="border: none;" value="cantidad" id="cantidad" style="border: none;" readonly/>
                        </div>
                    </div>
                    
                    
                    
                    <!--Separacion con un h4-->
                    <center><h4 class="modal-title" id="ModalLabel1">Editar Registro</h4></center>
                    <br>
                    
                    
                    <!--Formualrio para editar Seguros-->
                    <form method="POST" action="Servlet_GuiasTuristicos?op=4">
                        <!--Codigo y Descripcion-->
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha de Inicio</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" name="v2" class="form-control" value="" />
                            </div>
                        </div>   

                        
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Hora de Inicio</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="time" name="v3" class="form-control" value="" />
                            </div>
                        </div>

                        
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Insumos</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" name="v4" class="form-control" value="" />
                            </div>
                        </div>
                        
                        
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Visitante</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v5">
                                    <c:forEach items="${listaS}" var="fila">
                                        <option  value="${fila.cod_visita}"><c:out value="${fila.nom_visita}"/></option>
                                    </c:forEach>
                                </select>
                            </div>
                        </div>
                        
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Visitante</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v6">
                                    <c:forEach items="${listaE}" var="fila">
                                        <option  value="${fila.cod_ev}"><c:out value="${fila.nom_ev}"/></option>
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
                var fec=$(e.relatedTarget).data().fec;
                var hora=$(e.relatedTarget).data().hora;
                var ins=$(e.relatedTarget).data().ins;
                var ev=$(e.relatedTarget).data().ev;
                var nomv=$(e.relatedTarget).data().nomv;
                var nome=$(e.relatedTarget).data().nome;
                var cant=$(e.relatedTarget).data().cant;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#fecha').val(fec);
                $(e.currentTarget).find('#hora').val(hora);
                $(e.currentTarget).find('#insumo').val(ins);
                $(e.currentTarget).find('#evento').val(ev);
                $(e.currentTarget).find('#visitanom').val(nomv);
                $(e.currentTarget).find('#encargadonom').val(nome);
                $(e.currentTarget).find('#cantidad').val(cant);
                
                
            })
    });
</script>