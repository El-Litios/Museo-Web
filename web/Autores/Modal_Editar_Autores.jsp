<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevas galerias-->
<div class="modal fade" id="editar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
             <button type="button" class="close" dat-dismiss="modal" aria-hidden="true">&time;</button>
             <center><h4 class="modal-title" id="ModalLabel1">Formulario Autores</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Nombre actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="nom" style="border: none;" value="nom" id="nom" style="border: none;" readonly/>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Pseudonimo Actual</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="pseu" style="border: none;" value="pseu" id="pseu" style="border: none;" readonly/>
                        </div>
                    </div>
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">F. Nacimiento</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="fnac" style="border: none;" value="fnac" id="fnac" style="border: none;" readonly/>
                        </div>  
                    </div>
                    <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">F. Defuncion</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="fdef" style="border: none;" value="fdef" id="fdef" style="border: none;" readonly/>
                        </div>
                    </div>
                     <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Nacionalidad</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="nac" style="border: none;" value="nac" id="nac" style="border: none;" readonly/>
                        </div>
                    </div>
                     <div class="row form-group">
                        <div class="col-sm-2">
                            <label class="control-label" style="position: relative; top: 7px;">Pais</label>
                        </div>
                        <div class="col-sm-10">
                            <input type="text" class="form-control text-center" name="pais" style="border: none;" value="pais" id="pais" style="border: none;" readonly/>
                        </div>
                    </div>
                    <center><h4 class="modal-body" id="ModalLabel1">Editar Registros</h4></center>
                    <form method="POST" action="Servlet_Autores?op=4">
                        <div class="row form-group">
                            <input type="text" name="v1" id="codigo" value="codigo" hidden/>
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Nombre</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Pseudonimo</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v3"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">F. Nacimiento</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v4"/>
                            </div>
                        </div>
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">F. Defuncion</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="text" class="form-control" value="" name="v5"/>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-sm-2">
                                <label  style="position: relative; top: 7px;">Nacionalidad</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v6">
                                    <c:forEach items="${listaN}" var="fila">
                                        <option  value="${fila.cod_nac}"><c:out value="${fila.nom_nac}"/></option>
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
                var pseu=$(e.relatedTarget).data().pseu;
                var fnac=$(e.relatedTarget).data().fnac;
                var fdef=$(e.relatedTarget).data().fdef;
                var nac=$(e.relatedTarget).data().nac;
                var pais=$(e.relatedTarget).data().pais;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#nom').val(nom);
                $(e.currentTarget).find('#pseu').val(pseu);
                $(e.currentTarget).find('#fnac').val(fnac);
                $(e.currentTarget).find('#fdef').val(fdef);
                $(e.currentTarget).find('#nac').val(nac);
                $(e.currentTarget).find('#pais').val(pais);
                
            })
    });
</script>