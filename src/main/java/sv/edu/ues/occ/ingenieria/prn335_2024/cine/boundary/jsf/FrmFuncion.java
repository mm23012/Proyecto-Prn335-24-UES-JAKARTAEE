package sv.edu.ues.occ.ingenieria.prn335_2024.cine.boundary.jsf;


import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.Dependent;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import org.primefaces.model.*;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.AbstractDataPersist;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.ProgramacionBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.control.TipoPeliculaBean;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.Programacion;
import sv.edu.ues.occ.ingenieria.prn335_2024.cine.entity.TipoPelicula;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named
@Dependent
public class FrmFuncion extends AbstractPfFrm<Programacion> implements Serializable {

    List<Programacion> programaciones;
    private ScheduleModel eventModel;
    private ScheduleEvent event = new DefaultScheduleEvent();
    int idSala;
    private String serverTimeZone = ZoneId.systemDefault().toString();

    @Inject
    ProgramacionBean programacionBean;

    @Inject
    FacesContext facesContext;

    @Override
    public FacesContext getFacesContext() {
        return facesContext;
    }

    @Override
    public AbstractDataPersist<Programacion> getDataBean(){
        return programacionBean;
    }

    @Override
    public Programacion createNewEntity(){
        return new Programacion();
    }

    @Override
    public Object getId(Programacion o){
        return o.getIdProgramacion();
    }

    @Override
    public String getTituloPag(){
        return "Programacion";
    }

    @Override
    public Programacion buscarRegistroPorId(String id) {
        return null;
    }

    @Override
    public String buscarIdPorRegistro(Programacion entity) {
        return "";
    }

    @PostConstruct
    public void init(){
        try{
            super.inicializar();
            eventModel = new DefaultScheduleModel();
            programaciones = programacionBean.findRange(0,Integer.MAX_VALUE);
            programaciones = cargar();

            for (Programacion prog : programaciones) {
                LocalDateTime desde = prog.getDesde().toLocalDateTime();
                LocalDateTime hasta = prog.getHasta().toLocalDateTime();

                if (desde != null && hasta != null) {
                    ScheduleEvent<?> event = DefaultScheduleEvent.builder()
                            .title("Sala " + prog.getIdSala().getIdSala() + " - Película " + prog.getIdPelicula().getIdPelicula())
                            .startDate(desde)
                            .endDate(hasta)
                            .description(prog.getComentarios())
                            .build();
                    eventModel.addEvent(event);
                }

            }
        }catch (Exception e){
            Logger.getLogger(FrmFuncion.class.getName()).log(Level.SEVERE, null, e);
        }


    }
    public List<Programacion> cargar(){
        return programacionBean.findByIdSala(this.idSala);
    }


    public String getServerTimeZone() {
        return serverTimeZone;
    }

    public void setServerTimeZone(String serverTimeZone) {
        this.serverTimeZone = serverTimeZone;
    }

    public ProgramacionBean getProgramacionBean() {
        return programacionBean;
    }

    public void setProgramacionBean(ProgramacionBean programacionBean) {
        this.programacionBean = programacionBean;
    }

    public void setFacesContext(FacesContext facesContext) {
        this.facesContext = facesContext;
    }

    public List<Programacion> getProgramaciones() {
        return programaciones;
    }

    public void setProgramaciones(List<Programacion> programaciones) {
        this.programaciones = programaciones;
    }

    public void setEventModel(ScheduleModel eventModel) {
        this.eventModel = eventModel;
    }

    public ScheduleModel getEventModel() {
        return eventModel;
    }

    public ScheduleEvent getEvent() {
        return event;
    }

    public void setEvent(ScheduleEvent event) {
        this.event = event;
    }

    public void addEvent() {
        if (event.getId() == null) {
            eventModel.addEvent(event);
        } else {
            eventModel.updateEvent(event);
        }
        event = new DefaultScheduleEvent();
    }

    public void deleteEvent() {
        eventModel.deleteEvent(event);
        event = new DefaultScheduleEvent();
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }
}


