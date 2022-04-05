/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.proyecto1.negocio;

import java.io.Serializable;

/**
 *
 * @author Alumno
 */
public class Negocio implements Serializable
{
    private String nombre1;
    private String nombre2;
    private String cal1;
    private String cal2;
    private Integer calf1;
    private Integer calf2;
    private int respuesta;

    public Negocio() 
    {
    }
    
    public boolean isValido( )
    {
        if( nombre1 == null || "".equals(nombre1) )
        {
            return false;
        }
        if( nombre2 == null || "".equals(nombre2) )
        {
            return false;
        }
        if( cal1 == null || "".equals(cal1) )
        {
            return false;
        }
        if( cal2 == null || "".equals(cal2) )
        {
            return false;
        }
        if( !isNumber(cal1) || !isNumber(cal2) )
        {
            return false;
        }
        return true;
    }
    
    public boolean procesa( )
    {
        calf1 = getNumber( cal1 );
        calf2 = getNumber( cal2 );
        if( calf1 == null || calf2 == null )
        {
            return false;
        }
        respuesta = calf1.compareTo(calf2);
        return true;
    }
    
    public String getNombreMayor( )
    {
        switch( respuesta )
        {
            case -1:
                return nombre2;
            case 0:
                return nombre1 + " " + nombre2 + " Son iguales";
            case 1:
                return nombre1;
            default:
                return "";
        }
    }
    
    public Integer getCalifMayor( )
    {
        switch( respuesta )
        {
            case -1:
                return calf2;
            case 0:
                return calf2;
            case 1:
                return calf1;
            default:
                return 0;
        }
    }
    
    public boolean isNumber( String numero )
    {
        if( numero == null || "".equals(numero) )
        {
            return false;
        }
        try
        {
            Integer.getInteger(numero);
            return true;
        }
        catch(NumberFormatException e)
        {
            return false;
        }
    }
    
    public Integer getNumber( String numero )
    {
        if( numero == null || "".equals(numero) )
        {
            return null;
        }
        try
        {
            return Integer.parseInt( numero);
        }
        catch(NumberFormatException e)
        {
            return null;
        }
    }
    
    

    public String getNombre1()
    {
        return nombre1;
    }

    public void setNombre1(String nombre1) 
    {
        this.nombre1 = nombre1;
    }

    public String getNombre2() 
    {
        return nombre2;
    }

    public void setNombre2(String nombre2) 
    {
        this.nombre2 = nombre2;
    }

    public String getCal1() 
    {
        return cal1;
    }

    public void setCal1(String cal1) 
    {
        this.cal1 = cal1;
    }

    public String getCal2() 
    {
        return cal2;
    }

    public void setCal2(String cal2) 
    {
        this.cal2 = cal2;
    }
    
    
    
}
