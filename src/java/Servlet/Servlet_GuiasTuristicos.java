/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import CONTROLADOR.Control_GuiaTuristico;
import CONTROLADOR.Control_usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.Time;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark-
 */
public class Servlet_GuiasTuristicos extends HttpServlet {
    Control_GuiaTuristico crgt=new Control_GuiaTuristico();
    Control_usuarios cru=new Control_usuarios();
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
            int opc=Integer.parseInt(request.getParameter("op"));
            switch(opc){
                //listar los Guias Turisticos
                case 1:
                    request.getSession().setAttribute("lista", crgt.ListarGuias());
                    request.getRequestDispatcher("GuiasTuristicos/GuiasTuristicos.jsp").forward(request, response);
                break;
                
                //detalles
                case 2:
                    request.getSession().setAttribute("codigo", request.getParameter("codigo"));
                    request.getSession().setAttribute("listaDetalle", crgt.ListarDetalles(request.getParameter("codigo")));
                    request.getSession().setAttribute("listaTours", crgt.ListarTours(request.getParameter("codigo")));
                    request.getSession().setAttribute("listaE", crgt.SelectEventos());
                    request.getSession().setAttribute("listaS", crgt.SelectVisita());
                    request.getRequestDispatcher("GuiasTuristicos/Detalles.jsp").forward(request, response);                   
                break;    
                
                //insertar Tours 
                case 3:
                    String cod_g=(String)request.getSession().getAttribute("codigo");
                    crgt.InsertarTours(Date.valueOf(request.getParameter("v1")), 
                            request.getParameter("v2"), 
                            request.getParameter("v3"), 
                            Integer.parseInt(request.getParameter("v4")), 
                            cod_g, 
                            Integer.parseInt(request.getParameter("v5")));
                    request.getRequestDispatcher("Servlet_GuiasTuristicos?op=2&codigo="+cod_g).forward(request, response);
                break;
                
                //editar Tours
                case 4:
                    cod_g=(String)request.getSession().getAttribute("codigo");
                    crgt.EditarTours(Integer.parseInt(request.getParameter("v1")), 
                            Date.valueOf(request.getParameter("v2")), 
                            request.getParameter("v3"), 
                            request.getParameter("v4"), 
                            Integer.parseInt(request.getParameter("v5")), 
                            cod_g, 
                            Integer.parseInt(request.getParameter("v6")));
                    request.getRequestDispatcher("Servlet_GuiasTuristicos?op=2&codigo="+cod_g).forward(request, response);
                break;
                
                //eliminar Tours
                case 5:
                    cod_g=(String)request.getSession().getAttribute("codigo");
                    if (cru.claveADM(request.getParameter("clave"))) {
                        crgt.EliminarTours(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("GuiasTuristicos/Detalles.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    
                    request.getRequestDispatcher("Servlet_GuiasTuristicos?op=2&codigo="+cod_g).forward(request, response);
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
