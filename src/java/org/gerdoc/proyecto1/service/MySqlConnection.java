/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.proyecto1.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.gerdoc.proyecto1.dao.Alumno;
import org.gerdoc.proyecto1.dao.Alumno2;

/**
 *
 * @author gerdoc
 */
public class MySqlConnection implements Serializable
{
    public static boolean testDriver( )
    {
        try 
        {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance( );
            return true;
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
        }
        return false;
    }
    
    public static Connection getConnection( String user, String password , String db , String server )
    {
        String url = null;
        if( user == null || password == null || db == null || server == null )
        {
            return null;
        }
        if( "".equals(user) || "".equals(password) || "".equals(db) || "".equals(server) )
        {
            return null;
        }
        url = String.format( "jdbc:mysql://%s/%s?user=%s&password=%s" , server , db , user , password );
        try 
        {
            return DriverManager.getConnection(url);
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static Connection getConnection( )
    {
        return getConnection("TEST", "1234", "Gerdoc", "127.0.0.1" );
    }
    
    public static List<Alumno2> getAlumnosList( )
    {
        List<Alumno2>alumno2s = null;
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        Alumno2 alumno2 = null;
        
        try 
        {
            connection = getConnection( );
            if( connection == null )
            {
                return null;
            }
            statement = connection.createStatement( );
            if( statement == null )
            {
                return null;
            }
            resultSet = statement.executeQuery( "SELECT * FROM TBL_ALUMNO" );
            if( resultSet == null )
            {
                return null;
            }
            alumno2s = new ArrayList<>();
            while( resultSet.next() )
            {
                alumno2 = new Alumno2();
                alumno2.setId( resultSet.getInt(1) );
                alumno2.setNombre( resultSet.getString(2) );
                alumno2.setApellidoP(resultSet.getString(3) );
                alumno2.setApellidoM(resultSet.getString(4) );
                alumno2s.add(alumno2);
            }
            resultSet.close();
            closeConnection(connection);
            return alumno2s;
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
        return null;
    }
    
    public static void printAlumno2s( List<Alumno2> alumno2s )
    {
        if( alumno2s == null || alumno2s.size() == 0)
        {
            return;
        }
        for( Alumno2 alumno2 : alumno2s )
        {
            System.out.println("ID=" +alumno2.getId());
            System.out.println("NOMBRE="+alumno2.getNombre());
            System.out.println("APELLIDO P="+alumno2.getApellidoP());
            System.out.println("APELLIDO M="+alumno2.getApellidoM());
            
        }
    }
    public static void closeConnection( Connection connection )
    {
        try 
        {
            if( connection == null )
            {
                return;
            }
            if(connection.isClosed() )
            {
                return;
            }
            connection.close();
        } 
        catch (SQLException ex) 
        {
            ex.printStackTrace();
        }
    }
    
    
    public static void main( String a[] )
    {
        Connection connection = null;
        List<Alumno2>alumno2s = null;
        if( !testDriver() )
        {
            System.out.println("Mysql Test Driver Not ok");
            return;
        }
        System.out.println("Mysql Test Driver Ok");
        connection = getConnection("TEST", "1234", "Gerdoc", "127.0.0.1" );
        if( connection == null )
        {
            System.out.println("MySqlConnection.getConnection not ok");
            return;
        }
        System.out.println("MySqlConnection.getConnection ok");
        alumno2s = getAlumnosList();
        printAlumno2s(alumno2s);
        closeConnection(connection);
        System.out.println("MySqlConnection.closeConnection ok");
    }
}
