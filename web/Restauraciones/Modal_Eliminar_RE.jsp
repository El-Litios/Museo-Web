<!--eliminar EVENTO-->
<div class="modal fade"  id="eliminarrest" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Borrar Evento</h4></center>
            </div>
            <div class="modal-body">
                <p class="text-center">Seguro de Eliminar el Registro?</p>
                <form method="POST" action="Servlet_Restauraciones?op=5">
                <p class="text-center">Clave Secreta de Administrador</p>
                <input type="text" class="form-control text-center" name="clave"/>
            </div>
            <div class="modal-footer">
                
                    <button type="button" class="btn btn-default" data-dismiss="modal">Cancelar</button>
                    <input type="text" name="codigo" id="codigo" value="codigo" hidden/>
                    <button type="submit" name="eliminar" class="btn btn-danger"><span class="glyphicon glyphicon-trash"></span> Si.</button>
                </form>
            </div>
        </div>
    </div>
</div>
<!--CREAR SCRIPT (FUNCION) PARA RECIBIR DATOS UTILIZANDO JAVASCRIPT-->
<script>
    $(document).ready(function (e){
            $('#eliminarrest').on('show.bs.modal',function(e){
                var id=$(e.relatedTarget).data().id;
                $(e.currentTarget).find('#codigo').val(id);
            })
    });
</script>
