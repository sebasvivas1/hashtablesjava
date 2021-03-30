/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_3_diaz_vivas;

public class Nodo {

    private VECINO habitante, siguiente;

    /**
     * Constructores de la clase.
     */
    public Nodo(VECINO habitante) {
        this.habitante = habitante;
    }

    public Nodo(VECINO habitante, VECINO siguiente) {
        this.habitante = habitante;
        this.siguiente = siguiente;
    }

    /**
     * Getters y setters.
     */
    public VECINO getHabitante() {
        return habitante;
    }

    public void setHabitante(VECINO habitante) {
        this.habitante = habitante;
    }

    public VECINO getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(VECINO siguiente) {
        this.siguiente = siguiente;
    }

}
