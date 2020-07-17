/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import CONTROLADOR.Control_Especialidades;
import CONTROLADOR.Control_usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark-
 */
public class Servlet_Especialidad extends HttpServlet {
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
                //listar especialidades
                case 1:
                    request.getSession().setAttribute("lista", cre.ListarEspecialUsu());
                    request.getSession().setAttribute("listaU", cre.ListarUsuarios());
                    request.getSession().setAttribute("listaE", cre.ListarEspecialidades());
                    request.getRequestDispatcher("Especialidades/Especialidades.jsp").forward(request, response);
                break;
                
                //inseertar especialidades
                case 2:
                    cre.InsertarEspecialUsu(request.getParameter("v1"), request.getParameter("v2"));
                    request.getRequestDispatcher("Servlet_Especialidad?op=1").forward(request, response);
                break;
                
                //editar especialidades
                case 3:
                    cre.EditarEspecialUsu(request.getParameter("v1"), 
                            request.getParameter("v2"), 
                            request.getParameter("v3"));
                    request.getRequestDispatcher("Servlet_Especialidad?op=1").forward(request, response);
                break;
                
                //eliminar especialidades
                case 4:
                    if (cru.claveADM(request.getParameter("clave"))) {
                        cre.EliminarEspecialUsu(request.getParameter("codigo"));
                    }else{
                    request.getRequestDispatcher("Especialidades/Especialidades.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    } 
                    request.getRequestDispatcher("Servlet_Especialidad?op=1").forward(request, response);
                break;
                
                //buscar especialidades
                case 5:
                    request.getSession().setAttribute("lista", cre.BuscarEspcialUsu(request.getParameter("buscar")));
                    request.getRequestDispatcher("Especialidades/Especialidades.jsp").forward(request, response);
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
