/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_3_diaz_vivas;

public class VECINO {

    private String nombre, telefono, edificio;
    public String apartamento;
    public int cedula, indice, indiceApto;
    VECINO vecino;

    /**
     * Constructor de la clase.
     */
    public VECINO(int cedula, String nombre, String telefono, String edificio, String apartamento) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.telefono = telefono;
        this.edificio = edificio;
        this.apartamento = apartamento;
        this.indice = 0;
        this.indiceApto = 0;

    }

    public int getIndiceApto() {
        return indiceApto;
    }

    public void setIndiceApto(int indiceApto) {
        this.indiceApto = indiceApto;
    }

    /**
     * Getters y setters.
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEdificio() {
        return edificio;
    }

    public void setEdificio(String edificio) {
        this.edificio = edificio;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getApartamento() {
        return apartamento;
    }

    public void setApartamento(String apartamento) {
        this.apartamento = apartamento;
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }

}
