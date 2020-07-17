<!--eliminar devseg-->
<div class="modal fade"  id="eliminar" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" dat-dismiss="modal" aria-hidden="true">&time;</button>
                <center><h4 class="modal-title" id="ModalLabel1">Borrar Devolucion Asociada</h4></center>
            </div>
            <div class="modal-body">
                <p class="text-center">Seguro de Eliminar el Registro?</p>
                <input type="text" class="form-control text-center" name="fecha" style="border: none;" value="fecha" id="fecha" style="border: none;"/>
                <input type="text" class="form-control text-center" name="hora" style="border: none;" value="hora" id="hora" style="border: none;"/>
                <input type="text" class="form-control text-center" name="insumo" style="border: none;" value="insumo" id="insumo" style="border: none;"/>
                <input type="text" class="form-control text-center" name="evento" style="border: none;" value="evento" id="evento" style="border: none;"/>
                <input type="text" class="form-control text-center" name="visitanom" style="border: none;" value="visitanom" id="visitanom" style="border: none;"/>
                <input type="text" class="form-control text-center" name="encargadonom" style="border: none;" value="encargadonom" id="encargadonom" style="border: none;"/>
                <input type="text" class="form-control text-center" name="cantidad" style="border: none;" value="cantidad" id="cantidad" style="border: none;"/>
                <form method="POST" action="Servlet_GuiasTuristicos?op=5">
                <br>
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
<script>
    $(document).ready(function (e){
            $('#eliminar').on('show.bs.modal',function(e){
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
