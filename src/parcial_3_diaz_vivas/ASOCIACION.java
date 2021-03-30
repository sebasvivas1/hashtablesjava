/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parcial_3_diaz_vivas;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;

public class ASOCIACION {

    VECINO[] vecinos = new VECINO[269];
    Nodo[] habitantes = new Nodo[169];

    /**
     * Constructor de la clase.
     */
    public ASOCIACION() {
        vecinos = new VECINO[269];
        inicializarTabla();
    }

    public int hashCedula(int cedula, int tamanio) {
        int hashVal = 0;

        String cedulaToString = String.valueOf(cedula);

        for (int i = 0; i < cedulaToString.length(); i++) {
            char c = cedulaToString.charAt(i);
            int num = c - '0';

            hashVal += (num * i);

        }

        return hashVal;
    }

    public int hashHabitantes(String edificio, String apto, int tamanio) {
        int hashVal = 0;

        int p = 53;
        int p_pow = 1;
        String conc = edificio + apto;

        for (int i = 0; i < conc.length(); i++) {
            hashVal = (hashVal + (conc.charAt(i) * p_pow)) % tamanio;
            p_pow = (p_pow * p) % tamanio;
        }
        return hashVal;
    }

    public void leer_datos(String ruta) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(ruta);
        BufferedReader br = new BufferedReader(fr);
        String line = br.readLine();

        while (line != null) {

            String[] array = line.split(",");

            int indice;
            int indiceApto;

            VECINO infoVecino = crearVecino(array);
            Nodo infoApto = crearApto(infoVecino);
            indice = hashCedula(infoVecino.getCedula(), 269);
            indiceApto = hashHabitantes(infoApto.getHabitante().getEdificio(),
                    infoApto.getHabitante().getApartamento(), 169);
            infoApto.getHabitante().setIndiceApto(indiceApto);

            llenarAptos(indiceApto, infoApto);

            System.out.println("Apto: " + habitantes[indiceApto].getHabitante().getApartamento()
                    + " Edificio: " + habitantes[indiceApto].getHabitante().getEdificio() + " Indice en tabla: " + indiceApto);

            if (revisarDisponibilidad(indice) == true) {
                llenarTabla(indice, infoVecino);
                infoVecino.setIndice(indice);
            } else {
                indice = buscarOpcion(infoVecino.cedula);
                llenarTabla(indice, infoVecino);
                infoVecino.setIndice(indice);
            }
            line = br.readLine();
        }
    }

    private static VECINO crearVecino(String[] metadata) {
        int cedula = Integer.parseInt(metadata[0]);
        String nombre = metadata[1];
        String telefono = metadata[2];
        String edificio = metadata[3];
        String apartamento = metadata[4];

        return new VECINO(cedula, nombre, telefono, edificio, apartamento);

    }

    private Nodo crearApto(VECINO vecino) {
        Nodo apto = new Nodo(vecino);
        return apto;
    }

    public void introducirCI() {
        try {
            int cedula = Integer.parseInt(JOptionPane.showInputDialog(null, "Por favor introduzca la cedula del inquilino:  ", "INTRODUCIR CEDULA", 3));
            VECINO buscado = buscarVecino(cedula);

            JOptionPane.showMessageDialog(null, "La direccion de memoria es: " + buscado);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Se ha producido un error. Vuelva a intentar.", "ERROR!", 2);
        }

    }

    public VECINO buscarVecino(int ci) {

        int indice = hashCedula(ci, 269);
        int cedula = ci;
        if (vecinos[indice].getCedula() == ci) {
            return vecinos[indice];
        }
        indice = buscarVecinoCorrecto(cedula);
        return vecinos[indice];
    }

    public void buscarHabitantes(String edificio, String apto) {
        int indiceApto = hashHabitantes(edificio, apto, 169);

//        unirHabitantes(indiceApto);
    }

    public void llenarTabla(int n, VECINO vecino) {
        vecinos[n] = vecino;

    }

    public void llenarAptos(int n, Nodo nodo) {
        habitantes[n] = nodo;
    }

    public void inicializarTabla() {
        for (int i = 0; i < vecinos.length; i++) {
            vecinos[i] = null;
        }
    }

    public void inicializarAptos() {
        for (int i = 0; i < habitantes.length; i++) {
            habitantes[i] = null;

        }
    }

    public boolean revisarDisponibilidad(int indice) {
        if (vecinos[indice] == null) {
            return true;
        } else {
            return false;
        }
    }

    public int buscarOpcion(int x) {
        int aux = 1;
        int posicionActual = hashCedula(x, 269);

        while (revisarDisponibilidad(posicionActual) == false /**
                 * && vecinos[posicionActual].getCedula() == x
                 */
                ) {
            posicionActual += aux;
            aux += 1;
            if (posicionActual >= vecinos.length) {
                posicionActual -= vecinos.length;
            }
        }
        return posicionActual;
    }

    public int buscarVecinoCorrecto(int x) {
        int aux = 1;
        int posicionActual = hashCedula(x, 269);

        while (vecinos[posicionActual].getCedula() != x) {
            posicionActual += aux;
            aux += 1;
            if (posicionActual >= vecinos.length) {
                posicionActual -= vecinos.length;
            }
        }
        return posicionActual;
    }

//    public void unirHabitantes(int x) {
//        
//        for (int i = 0; i < habitantes.length; i++) {
//            if (habitantes[i].getHabitante().getIndiceApto() == x) {
//                JOptionPane.showMessageDialog(null, "Hola");
//            }
//            
//        }
//    }
}
