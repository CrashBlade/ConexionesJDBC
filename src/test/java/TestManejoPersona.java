import DataModel.PersonaDAO;
import domain.Persona;

import java.util.List;

public class TestManejoPersona {

    public static void main(String[] args) {
        PersonaDAO personaDao = new PersonaDAO();

        //-- Creacion de objetos.
        Persona persona1 = new Persona(1,"Juan","Yela","jy@dk.com","987");
        Persona persona2 = new Persona(2,"Carlos","Ramirez","cr@dk.com","765");
        Persona persona3 = new Persona(3,"Ana","Alema","aa@dk.com","545");

        /*  - Inserta objetos en la base de datos
            - La funcion insertar devuelve un int del numero de registros actualizados
            - Por ello puede imprimir directamente la funcion asi: System.out.println(personaDao.insertar(persona1)); */
        personaDao.insertar(persona1);
        personaDao.insertar(persona2);
        personaDao.insertar(persona3);

        /*  - Modifica el segundo objeto ingresado
            - La funcion actualizar devuelve un int del numero de registros actualizados
            - Por ello se puede imprimir directamente la funcion como en insertar */
        Persona personaModficar = new Persona(2,"Alex","Mena","am@dk.com","963");
        personaDao.actualizar(personaModficar);

        /*  - ELiminando el ultimo objeto ingresado
            - La funcion borrar  devuelve un int del numero de registros borrados
            - Por ello se puede imprimir directamente la funcion como en insertar */
        Persona personaBorrar = new Persona(3);
        personaDao.borrar(personaBorrar);

        //  - Imprime el listado de objetos persona
        List<Persona> personas = personaDao.seleccionar();

        //--Expresion lambda
       /*personas.forEach(persona -> {``
           System.out.println("persona: "+persona);
        });/*
        */
        for (Persona persona : personas
        ) {
            System.out.println(persona);
        }

    }
}
