/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.proyecto1.service;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

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
        if( !testDriver() )
        {
            System.out.println("Mysql Test Driver Not ok");
            return;
        }
        System.out.println("Mysql Test Driver Ok");
        connection = getConnection("test", "1234", "EmMax", "192.168.50.187" );
        if( connection == null )
        {
            System.out.println("MySqlConnection.getConnection not ok");
            return;
        }
        System.out.println("MySqlConnection.getConnection ok");
        closeConnection(connection);
        System.out.println("MySqlConnection.closeConnection ok");
    }
}
