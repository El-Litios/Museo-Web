<!--eliminar Obras en galerias-->
<div class="modal fade"  id="eliminar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" dat-dismiss="modal" aria-hidden="true">&time;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Borrar Obras en Galerias</h4></center>
            </div>
            <div class="modal-body">
                <p class="text-center">Seguro de Eliminar el Registro?</p>
                <input type="text" class="form-control text-center" name="obra" style="border: none;" value="obra" id="obra" style="border: none;"/>
                <input type="text" class="form-control text-center" name="gal" style="border: none;" value="gal" id="gal" style="border: none;"/>
                <form method="POST" action="Servlet_GaleriasObras?op=4">
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
            $('#eliminar').on('show.bs.modal',function(e){
                var id=$(e.relatedTarget).data().id;
                var obra=$(e.relatedTarget).data().obra;
                var gal=$(e.relatedTarget).data().gal;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#obra').val(obra);
                $(e.currentTarget).find('#gal').val(gal);
            })
    });
</script>