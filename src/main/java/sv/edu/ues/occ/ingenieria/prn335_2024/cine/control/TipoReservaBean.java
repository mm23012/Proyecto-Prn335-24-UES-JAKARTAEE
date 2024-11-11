package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;

import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.enterprise.context.Dependent;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoReserva;

import java.io.Serializable;
import java.util.Collections;

@Stateless
@LocalBean
public class TipoReservaBean  extends AbstractDataPersist<TipoReserva> implements Serializable {

    @PersistenceContext(unitName="CinePU")
    EntityManager em;

    public TipoReservaBean() {
        super(TipoReserva.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }


}
