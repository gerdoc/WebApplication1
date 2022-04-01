/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.proyecto1;

import java.util.List;

/**
 *
 * @author Alumno
 */
public class Negocio 
{
    private String nombre1;
    private String nombre2;
    private Integer edad1;
    private Integer edad2;
    private int opcion = 0;
    
    public boolean procesa( List<String> lista )
    {
        if( lista == null  || lista.size() == 0  || lista.size( ) < 4)
        {
            return false;
        }
        nombre1 = lista.get( 0 );
        nombre2 = lista.get( 2 );
        if( isEdadOk( lista.get(1) ) )
        {
            edad1 = getEdad( lista.get(1) );
        }
        else
        {
            return false;
        }
        if( isEdadOk( lista.get(3) ) )
        {
            edad2 = getEdad( lista.get(3) );
        }
        else
        {
            return false;
        }
        opcion = edad1.compareTo(edad2);
        return true;
    }
    
    public boolean isEdadOk( String valor )
    {
        try
        {
            return Integer.valueOf(valor) != null;
        }
        catch( NumberFormatException e)
        {
            return false;
        }
    }
    
    public Integer getEdad( String valor )
    {
        try
        {
            return Integer.valueOf(valor);
        }
        catch( NumberFormatException e)
        {
            return null;
        }
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getNombre2() {
        return nombre2;
    }

    public void setNombre2(String nombre2) {
        this.nombre2 = nombre2;
    }

    public Integer getEdad1() {
        return edad1;
    }

    public void setEdad1(Integer edad1) {
        this.edad1 = edad1;
    }

    public Integer getEdad2() {
        return edad2;
    }

    public void setEdad2(Integer edad2) {
        this.edad2 = edad2;
    }

    public int getOpcion() {
        return opcion;
    }

    public void setOpcion(int opcion) {
        this.opcion = opcion;
    }
    
    
    
}
