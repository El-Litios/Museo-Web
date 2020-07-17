/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import CONTROLADOR.Control_Especialidades;
import CONTROLADOR.Control_ObrasDeArte;
import CONTROLADOR.Control_Restauraciones;
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
public class Servlet_Restauraciones extends HttpServlet {
    Control_Restauraciones crr=new Control_Restauraciones();
    Control_ObrasDeArte cro=new Control_ObrasDeArte();
    Control_Especialidades cre=new Control_Especialidades();
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
                //listar los estados de la restauracion
                case 1:
                    request.getSession().setAttribute("lista", crr.ListaEstadosRes());
                    request.getRequestDispatcher("Restauraciones/Restauraciones.jsp").forward(request, response);
                break;
                
                //detalles
                case 2:
                    request.getSession().setAttribute("codigo", request.getParameter("codigo"));
                    request.getSession().setAttribute("listaDetalle", cre.Detalles(request.getParameter("codigo")));
                    request.getSession().setAttribute("listaR", crr.ListarRestauraciones(request.getParameter("codigo")));
                    request.getSession().setAttribute("listaO", cro.listaObras());
                    request.getSession().setAttribute("listaRES", crr.ListaEspUsu());
                    request.getRequestDispatcher("Restauraciones/Detalles.jsp").forward(request, response);                   
                break;    
                
                //insertar restauraciones
                case 3:
                    String cod_es=(String)request.getSession().getAttribute("codigo");
                    crr.InsertarRestauraciones(Date.valueOf(request.getParameter("v1")), 
                            Date.valueOf(request.getParameter("v2")), 
                            Integer.parseInt(request.getParameter("v3")), 
                            cod_es);
                    request.getRequestDispatcher("Servlet_Restauraciones?op=2&codigo="+cod_es).forward(request, response);
                break;
                
                //editar restauraciones
                case 4:
                    cod_es=(String)request.getSession().getAttribute("codigo");
                    crr.EditarRestauraciones(Integer.parseInt(request.getParameter("v1")), 
                            Date.valueOf(request.getParameter("v2")), 
                            Date.valueOf(request.getParameter("v3")), 
                            Integer.parseInt(request.getParameter("v4")), 
                            cod_es);
                    request.getRequestDispatcher("Servlet_Restauraciones?op=2&codigo="+cod_es).forward(request, response);
                break;
                
                //eliminar restauraiones
                case 5:
                    cod_es=(String)request.getSession().getAttribute("codigo");
                    if (cru.claveADM(request.getParameter("clave"))) {
                        crr.EliminarRestauraciones(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("Restauraciones/Detalles.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    
                    request.getRequestDispatcher("Servlet_Restauraciones?op=2&codigo="+cod_es).forward(request, response);
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
