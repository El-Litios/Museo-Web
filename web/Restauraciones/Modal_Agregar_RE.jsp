<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--agregar nuevos Restauraciones-->
<div class="modal fade" id="nuevarestauracion" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Agregar Nuevo Registro</h4></center>
            </div>
            <div class="modal-body">
                <div class="container-fluid">
                    <form method="POST" action="Servlet_Restauraciones?op=3">
                        <!--Fecha de Restauracion-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha de Restauracion</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v1"/>
                            </div>
                        </div>
                        <!--Fecha Estimada de Retorno-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Fecha de Retorno</label>
                            </div>
                            <div class="col-sm-10">
                                <input type="date" class="form-control" value="" name="v2"/>
                            </div>
                        </div>
                        <!--Obra de Arte-->
                        <div class="row form-group">
                            <div class="col-sm-2">
                                <label class="control-label" style="position: relative; top: 7px;">Obra de Arte</label>
                            </div>
                            <div class="col-sm-10">
                                <select class="form-control" name="v3">
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