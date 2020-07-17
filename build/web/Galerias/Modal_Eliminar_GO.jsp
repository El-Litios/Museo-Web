<!--eliminar Obras en galerias-->
<div class="modal fade"  id="EliminarGaleriasObras" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&timea;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Borrar Obras en Galerias</h4></center>
            </div>
            <div class="modal-body">
                <p class="text-center">Seguro de Eliminar el Registro?</p>
                <input type="text" class="form-control text-center" name="obra" style="border: none;" value="obra" id="obra" style="border: none;"/>
                <form method="POST" action="Servlet_Galerias?op=14">
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
            $('#EliminarGaleriasObras').on('show.bs.modal',function(e){
                var id=$(e.relatedTarget).data().id;
                var titulo=$(e.relatedTarget).data().titulo;
                
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#titulo').val(titulo);
                
            })
    });
</script>