/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.gerdoc.proyecto1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alumno
 */
@WebServlet(name = "MayorMenorServlet", urlPatterns = {"/MayorMenorServlet"})
public class MayorMenorServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) 
        {
            List<String>list = new ArrayList<String>( );
            String tmp = null;
            Negocio negocio = new Negocio();
            
            tmp = getParameter( "nombre1" , request);
            if( isValid( tmp ) )
            {
                list.add( tmp );
            }
            tmp = getParameter( "edad1" , request);
            if( isValid( tmp ) )
            {
                list.add( tmp );
            }
            tmp = getParameter( "nombre2" , request);
            if( isValid( tmp ) )
            {
                list.add( tmp );
            }
            tmp = getParameter( "edad2" , request);
            if( isValid( tmp ) )
            {
                list.add( tmp );
            }
            
            
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet MayorMenorServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            
            if( !negocio.procesa(list) )
            {
                out.println("<h1>Error</h1>");
            }
            else
            {
                switch( negocio.getOpcion() )
                {
                    case -1:
                        out.println("<h1>El mayor es " + negocio.getNombre2() +"</h1>");
                        break;
                    case 0:
                        out.println("<h1>Son iguales</h1>");
                        break;
                    case 1:
                        out.println("<h1>El mayor es " + negocio.getNombre1() +"</h1>");
                        break;
                }
            }
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    
    public String getParameter( String name , HttpServletRequest request )
    {
        return request.getParameter( name );
    }
    
    public boolean isValid( String valor )
    {
        return valor != null && valor != "";
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
