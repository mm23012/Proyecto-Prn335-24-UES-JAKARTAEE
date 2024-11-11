package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;


import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersist;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.ReservaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoProductoBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Reserva;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoProducto;

import java.io.Serializable;

@Named
@ViewScoped
public class FrmReserva extends AbstractPfFrm<Reserva> implements Serializable {


    @Inject
    ReservaBean reservaBean;

    @Inject
    FacesContext facesContext;

    @Override
    public FacesContext getFacesContext() {
        return facesContext;
    }

    @Override
    public AbstractDataPersist<Reserva> getDataBean(){
        return reservaBean;
    }

    @Override
    public Reserva createNewEntity(){
        return new Reserva();
    }

    @Override
    public Object getId(Reserva o){
        return o.getIdReserva();
    }

    @Override
    public String getTituloPag(){
        return "Tipo Producto";
    }

    @Override
    public Reserva buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String buscarIdPorRegistro(Reserva entity) {
        return "";
    }



}
