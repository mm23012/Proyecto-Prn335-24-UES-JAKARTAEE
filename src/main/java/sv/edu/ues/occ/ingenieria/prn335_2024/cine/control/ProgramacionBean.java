package sv.edu.ues.occ.ingenieria.prn335_2024.cine.control;


import jakarta.ejb.LocalBean;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.PeliculaCaracteristica;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Programacion;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Stateless
@LocalBean
public class ProgramacionBean extends AbstractDataPersist<Programacion>  implements Serializable {

    @PersistenceContext(unitName = "CinePU")
    EntityManager em;

    public ProgramacionBean() {
        super(Programacion.class);
    }

    @Override
    public EntityManager getEntityManager() {
        return em;
    }

    public int countProgramacion(final int idSala){
        try {
            TypedQuery<Long> q = em.createNamedQuery("Programacion.countByIdSala", Long.class);
            q.setParameter("idSala", idSala);
            return q.getSingleResult().intValue();
        }catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return 0;
    }

    public List<Programacion> findByIdSala(final int idSala){
        try {
            TypedQuery<Programacion> q = em.createNamedQuery("Programacion.findByIdSala", Programacion.class);
            q.setParameter("idSala", idSala);
            return q.getResultList();
        }catch (Exception e) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
        return List.of();
    }
}
