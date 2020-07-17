/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import CONTROLADOR.Control_Prestamos;
import CONTROLADOR.Control_SegPres;
import CONTROLADOR.Control_SeguroPrestamo;
import CONTROLADOR.Control_usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark-
 */
public class Servlet_SeguroPrestamos extends HttpServlet {
    Control_SeguroPrestamo crs=new Control_SeguroPrestamo();
    Control_usuarios cru=new Control_usuarios();
    Control_SegPres csp=new Control_SegPres();
    Control_Prestamos crp=new Control_Prestamos();
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
        try (PrintWriter out = response.getWriter()) {
            int opc = Integer.parseInt(request.getParameter("op"));
            switch (opc){
            
                //listar seguros 
                case 1:
                    request.getSession().setAttribute("lista", crs.ListarSeguro());
                    request.getRequestDispatcher("SeguroPrestamos/SeguroPrestamos.jsp").forward(request, response);
                break;
                
                //insertar seguros
                case 2:
                    crs.InsertarSeguro(request.getParameter("v1"), 
                            Date.valueOf(request.getParameter("v2")), 
                            Integer.parseInt(request.getParameter("v3")));
                    request.getRequestDispatcher("Servlet_SeguroPrestamos?op=1").forward(request, response);
                break;
                
                //editar seguros
                case 3:
                    crs.EditarSeguro(Integer.parseInt(request.getParameter("v1")), 
                            request.getParameter("v2"), 
                            Date.valueOf(request.getParameter("v3")), 
                            Integer.parseInt(request.getParameter("v4")));
                    request.getRequestDispatcher("Servlet_SeguroPrestamos?op=1").forward(request, response);
                break;
                
                //eliminar seguros
                case 4:
                     if (cru.claveADM(request.getParameter("clave"))) {
                        crs.EliminarSeguro(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("SeguroPrestamos/SeguroPrestamos.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    
                    request.getRequestDispatcher("Servlet_SeguroPrestamos?op=1").forward(request, response);
                break;
                
                //-------------------------------------------------------------//
                
                //detalles
                case 5:
                    request.getSession().setAttribute("codigo", request.getParameter("codigo"));
                    request.getSession().setAttribute("listaDetalles", crs.ListaDetalle(request.getParameter("codigo")));
                    request.getSession().setAttribute("listaSP", csp.ListarPresSeg(request.getParameter("codigo")));
                    request.getSession().setAttribute("listaP", crp.ComboboxPrestamo());
                    request.getRequestDispatcher("SeguroPrestamos/Detalles.jsp").forward(request, response);
                break;
                
                //insertar proestamos a seguros
                case 6:
                    String cod_seg=(String)request.getSession().getAttribute("codigo");
                    csp.InsertarPresSeg(request.getParameter("v1"), cod_seg);
                    request.getRequestDispatcher("Servlet_SeguroPrestamos?op=5&codigo="+cod_seg).forward(request, response);
                break;
                
                //editar prestamos a seguros
                case 7:
                    cod_seg=(String)request.getSession().getAttribute("codigo");
                    csp.EditarPresSeg(Integer.parseInt(request.getParameter("v1")), 
                            request.getParameter("v2"), 
                            cod_seg);
                    request.getRequestDispatcher("Servlet_SeguroPrestamos?op=5&codigo="+cod_seg).forward(request, response);
                break;
                
                //eliminar prestamos a seguros
                case 8:
                    cod_seg=(String)request.getSession().getAttribute("codigo");
                    if (cru.claveADM(request.getParameter("clave"))) {
                        csp.EliminarPresSeg(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("SeguroPrestamos/Detalles.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    request.getRequestDispatcher("Servlet_SeguroPrestamos?op=5&codigo="+cod_seg).forward(request, response);
                break;
            }
        }
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
