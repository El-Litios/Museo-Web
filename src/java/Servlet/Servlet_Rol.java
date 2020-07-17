/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import CONTROLADOR.Control_Roles;
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
public class Servlet_Rol extends HttpServlet {
    Control_usuarios cru=new Control_usuarios();
    Control_Roles crol=new Control_Roles();
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
                //lista de roles
                case 1://leer
                    request.getSession().setAttribute("lista", crol.lista_roles());
                    request.getRequestDispatcher("C_Usuarios/Roles.jsp").forward(request, response);
                break;
                case 2://eliminar
                    if (cru.claveADM(request.getParameter("clave"))) {
                        crol.eliminar_rol(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("C_Usuarios/Roles.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    
                    request.getRequestDispatcher("Servlet_Rol?op=1").forward(request, response);
                break;
                case 4://grabar roles editados
                    crol.editar_rol(Integer.parseInt(request.getParameter("v1")), 
                            request.getParameter("v2"));
                    request.getRequestDispatcher("Servlet_Rol?op=1").forward(request, response);
                break;
                case 6:
                    crol.insertar_rol(request.getParameter("v1"));
                    request.getRequestDispatcher("Servlet_Rol?op=1").forward(request, response);
                break;
                case 7:
                     request.getSession().setAttribute("lista", crol.Buscar_Rol(request.getParameter("buscar")));
                    request.getRequestDispatcher("C_Usuarios/Roles.jsp").forward(request, response);
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
