/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import CONTROLADOR.Control_Museos;
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
public class Servlet_Museos extends HttpServlet {
    Control_Museos cm=new Control_Museos();
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
            switch (opc){
                //listar museos
                case 1:
                  request.getSession().setAttribute("lista", cm.ListarMuseos());
                  request.getSession().setAttribute("listaP", cm.ListarPaisDeMuseo());
                  request.getRequestDispatcher("Prestamos/Museos.jsp").forward(request, response);
                break;
                
                //insertar museos
                case 2:
                    cm.InsertarMuseos(request.getParameter("v1"), 
                            request.getParameter("v2"), 
                            request.getParameter("v3"), 
                            Integer.parseInt(request.getParameter("v4")));
                    request.getRequestDispatcher("Servlet_Museos?op=1").forward(request, response);
                break;
                
                //editar museos
                case 3:
                    cm.EditarMuseos(Integer.parseInt(request.getParameter("v1")), 
                            request.getParameter("v2"), 
                            request.getParameter("v3"), 
                            request.getParameter("v4"), 
                            Integer.parseInt(request.getParameter("v5")));
                    request.getRequestDispatcher("Servlet_Museos?op=1").forward(request, response);
                break;
                
                //eliminar museos
                case 4:
                    if (cru.claveADM(request.getParameter("clave"))) {
                        cm.EliminarMuseos(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("Prestamos/Museos.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    request.getRequestDispatcher("Servlet_Museos?op=1").forward(request, response);
                break;
                
                //buscar museos
                case 5:
                    request.getSession().setAttribute("lista", cm.BuscarMuseos(request.getParameter("buscar")));
                    request.getRequestDispatcher("Prestamos/Museos.jsp").forward(request, response);
                break;
                
                //detalles
                
                //agregar prestamos desde museos
                
                //editar prestamos desde museos
                
                //eliminar prestamos desde museos
                
                
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
