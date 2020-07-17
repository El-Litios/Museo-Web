/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import CONTROLADOR.Control_Ubicaciones;
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
public class Servlet_Ubicaciones extends HttpServlet {
    Control_Ubicaciones crub=new Control_Ubicaciones();
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
        int opcion=Integer.parseInt(request.getParameter("op"));
        switch (opcion){
            case 1://leer
                request.getSession().setAttribute("lista", crub.lista_ubi());
                request.getRequestDispatcher("Galerias/Ubicaciones.jsp").forward(request, response);
            break;
            case 3://insertar
                crub.insertar_ubi(request.getParameter("v1"));
                request.getRequestDispatcher("Servlet_Ubicaciones?op=1").forward(request, response);
            break;
            case 4://editar
                crub.editar_ubi(Integer.parseInt(request.getParameter("v1")), request.getParameter("v2"));
                request.getRequestDispatcher("Servlet_Ubicaciones?op=1").forward(request, response);
            break; 
            case 6://eliminar
                if (cru.claveADM(request.getParameter("clave"))) {
                    crub.eliminar_ubi(request.getParameter("codigo"));
                }else{
                    request.getRequestDispatcher("Galerias/Ubicaciones.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                }
                request.getRequestDispatcher("Servlet_Ubicaciones?op=1").forward(request, response);
            break;
            case 7:
                request.getSession().setAttribute("lista", crub.Buscar_ubi(request.getParameter("buscar")));
                request.getRequestDispatcher("Galerias/Ubicaciones.jsp").forward(request, response);
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
