/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import CONTROLADOR.Control_Visitas;
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
public class Servlet_Visitas extends HttpServlet {
    Control_Visitas crv=new Control_Visitas();
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
            //listar visitantes
            case 1:
                request.getSession().setAttribute("lista", crv.ListarVisitantes());
                request.getRequestDispatcher("Visitas/Visitas.jsp").forward(request, response);
            break;
            
            //insertar visitantes
            case 2:
                crv.InsertarVisitante(request.getParameter("v1"), 
                        request.getParameter("v2"), 
                        request.getParameter("v3"), 
                        Integer.parseInt(request.getParameter("v4")));
                request.getRequestDispatcher("Servlet_Visitas?op=1").forward(request, response);
            break;
               
            //editar visitantes    
            case 3:
                crv.EditarVisitantes(Integer.parseInt(request.getParameter("v1")), request.getParameter("v2"), 
                        request.getParameter("v3"), 
                        request.getParameter("v4"), 
                        Integer.parseInt(request.getParameter("v5")));
                request.getRequestDispatcher("Servlet_Visitas?op=1").forward(request, response);
            break;
            
            //eliminar visitantes    
            case 4:
                    if (cru.claveADM(request.getParameter("clave"))) {
                        crv.EliminarVisitantes(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("Visitas/Visitas.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    request.getRequestDispatcher("Servlet_Visitas?op=1").forward(request, response);
            break;
            
            //buscar visitantes    
            case 5:
                request.getSession().setAttribute("lista", crv.BuscarVisitantes(request.getParameter("buscar")));
                request.getRequestDispatcher("Visitas/Visitas.jsp").forward(request, response);
            break;
                
                
                
            //listar detalles (tours asociados)    
            case 6:
                request.getSession().setAttribute("codigo", request.getParameter("codigo"));
                request.getSession().setAttribute("listaDetalle", crv.ListarDetalles(request.getParameter("codigo")));
                request.getSession().setAttribute("listaTour", crv.ListarTourVisita(request.getParameter("codigo")));
                request.getSession().setAttribute("listaGuia", crv.ComboGuias());
                request.getSession().setAttribute("listaE", crv.SelectEventos());
                request.getRequestDispatcher("Visitas/Detalles.jsp").forward(request, response);
            break;
            
            //insertar Tours    
            case 7:
                String cod_visita=(String)request.getSession().getAttribute("codigo");
                    crv.InsertarTours(Date.valueOf(request.getParameter("v1")), 
                            Time.valueOf(request.getParameter("v2")), 
                            request.getParameter("v3"), 
                            Integer.parseInt(cod_visita), 
                            Integer.parseInt(request.getParameter("v4")), 
                            Integer.parseInt(request.getParameter("v5")));
                    request.getRequestDispatcher("Servlet_Visitas?op=6&codigo="+cod_visita).forward(request, response);
            break;
                
           //Editar Tours    
            case 8:
                cod_visita=(String)request.getSession().getAttribute("codigo");
                crv.EditarTours(Integer.parseInt(request.getParameter("v1")), 
                            Date.valueOf(request.getParameter("v2")), 
                            Time.valueOf(request.getParameter("v3")), 
                            request.getParameter("v4"), 
                            Integer.parseInt(cod_visita), 
                            Integer.parseInt(request.getParameter("v5")), 
                            Integer.parseInt(request.getParameter("v6")));
                request.getRequestDispatcher("Servlet_Visitas?op=6&codigo="+cod_visita).forward(request, response);
            break;
            
            //Eliminar Tours 
            case 9:
                cod_visita=(String)request.getSession().getAttribute("codigo");
                if (cru.claveADM(request.getParameter("clave"))) {
                        crv.EliminarTours(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("Visitas/Detalles.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }                   
                    request.getRequestDispatcher("Servlet_Visitas?op=6&codigo="+cod_visita).forward(request, response);
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
