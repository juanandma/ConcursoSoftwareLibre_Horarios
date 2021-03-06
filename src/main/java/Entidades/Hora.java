package Entidades;
// Generated 14-abr-2019 22:38:10 by Hibernate Tools 4.3.1

import Entidades.Asignatura;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Locale;

/**
 * Hora generated by hbm2java
 */
public class Hora implements java.io.Serializable {

    private HoraId id;
    private Asignatura asignatura;
    private int dia;
    private Date horaInicio;
    private Date horaFin;
    private int tipo;

    public Hora() {
    }

    public Hora(HoraId id, Asignatura asignatura, int dia, Date horaInicio, Date horaFin, int tipo) {
        this.id = id;
        this.asignatura = asignatura;
        this.dia = dia;
        this.horaInicio = horaInicio;
        this.horaFin = horaFin;
        this.tipo = tipo;
    }

    public HoraId getId() {
        return this.id;
    }

    public void setId(HoraId id) {
        this.id = id;
    }

    public Asignatura getAsignatura() {
        return this.asignatura;
    }

    public void setAsignatura(Asignatura asignatura) {
        this.asignatura = asignatura;
    }

    public int getDia() {
        return this.dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public Date getHoraInicio() {
        return this.horaInicio;
    }

    public void setHoraInicio(Date horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Date getHoraFin() {
        return this.horaFin;
    }

    public void setHoraFin(Date horaFin) {
        this.horaFin = horaFin;
    }

    public int getTipo() {
        return this.tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public LocalTime getHInicio() {

        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(horaInicio);   // assigns calendar to given date 
        
        return LocalTime.of(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
    }

    public LocalTime getHFin() {

        Calendar calendar = GregorianCalendar.getInstance(); // creates a new calendar instance
        calendar.setTime(horaFin);   // assigns calendar to given date 
        
        return LocalTime.of(calendar.get(Calendar.HOUR_OF_DAY), calendar.get(Calendar.MINUTE));
    }

}
