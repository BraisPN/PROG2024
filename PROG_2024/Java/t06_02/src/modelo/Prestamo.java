package modelo;

import java.io.Serializable;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

import modelo.libro.Exemplar;
import modelo.usuarios.Lector;

public class Prestamo implements Serializable {
    private Exemplar exemplar;
    private LocalDate dataPrestamo;
    private LocalDate dataLimiteDevolucion;
    private boolean estaDevolto;
    private LocalDate dataDevolucion;
    private Lector usuario;

    /**
     * Creamos un préstamo
     * @param exemplar
     * @param usuario
     */
    public Prestamo(Exemplar exemplar, Lector usuario) {
        this.exemplar = exemplar;
        this.usuario = usuario;
        this.dataPrestamo = LocalDate.now();
        this.dataLimiteDevolucion = this.dataPrestamo.plus(2, ChronoUnit.WEEKS);
        if(this.dataLimiteDevolucion.getDayOfWeek() == DayOfWeek.SUNDAY)
            this.dataLimiteDevolucion = this.dataLimiteDevolucion.plus(1, ChronoUnit.DAYS);
        
        this.estaDevolto = false;
        this.dataDevolucion = null;

        this.exemplar.addPrestamo(this);
        this.usuario.addPrestamo(this);
    }

    /**
     * Indica se está devolto o preśtamo
     * @return
     */
    public boolean devolto(){
        return this.estaDevolto;
    }

    /**
     * Indica se o préstamo é do último ano
     * @return
     */
    public boolean eDoUltimoAno() {
        LocalDate haiUnAno = LocalDate.now().minus(1, ChronoUnit.YEARS);
        if(dataPrestamo.isAfter(haiUnAno)) return true;
        return false;
    }

    /**
     * Indica se un préstamo se devolveu tarde
     * @return
     */
    public boolean devoltoTarde(){
        if(!this.estaDevolto) return false;

        if (this.dataDevolucion.isAfter(dataLimiteDevolucion)) return true;
        return false;
    }

    /**
     * Devolve un preśtamo
     */
    public void devolver(){
        this.dataDevolucion = LocalDate.now();
        this.estaDevolto = true;
    }

    /**
     * Indica a data límite de préstamo
     * @return
     */
    public String getDataLimiteDevolucion() {
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataLimiteDevolucion.format(formato);
    }


    public Lector getUsuario() {
        return usuario;
    }

    

    


}
