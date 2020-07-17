<!--eliminar Visitantes-->
<div class="modal fade"  id="eliminar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Borrar Visitante</h4></center>
            </div>
            <div class="modal-body">
                <p class="text-center">Seguro de Eliminar el Registro?</p>
                <input type="text" class="form-control text-center" name="nom" style="border: none;" value="nom" id="nom" style="border: none;"/>
                <input type="text" class="form-control text-center" name="enc" style="border: none;" value="enc" id="enc" style="border: none;"/>
                <input type="text" class="form-control text-center" name="curso" style="border: none;" value="curso" id="curso" style="border: none;"/>
                <input type="text" class="form-control text-center" name="cant" style="border: none;" value="cant" id="cant" style="border: none;"/>
                <form method="POST" action="Servlet_Visitas?op=4">
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
                var nom=$(e.relatedTarget).data().nom;
                var enc=$(e.relatedTarget).data().enc;
                var curso=$(e.relatedTarget).data().curso;
                var cant=$(e.relatedTarget).data().cant;
                $(e.currentTarget).find('#codigo').val(id);
                $(e.currentTarget).find('#nom').val(nom);
                $(e.currentTarget).find('#enc').val(enc);
                $(e.currentTarget).find('#curso').val(curso);
                $(e.currentTarget).find('#cant').val(cant);
            })
    });
</script>