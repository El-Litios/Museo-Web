/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Servlet;

import CONTROLADOR.Control_ObrasDeArte;
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
public class Servlet_ObraDeArte extends HttpServlet {
    Control_ObrasDeArte cob=new Control_ObrasDeArte();
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
            case 1://lista de obras
                request.getSession().setAttribute("lista", cob.lista_Obras());
                request.getSession().setAttribute("listaA", cob.listaAutores());
                request.getSession().setAttribute("listaT", cob.listaTipoObra());
                request.getRequestDispatcher("C_ObrasDeArte/ObrasDeArte.jsp").forward(request, response);
                break;
                
                
            case 2://insertar
                cob.insrtarObraDeArte(request.getParameter("v1"), 
                        String.valueOf(request.getParameter("v2")), 
                        String.valueOf(request.getParameter("v3")), 
                        request.getParameter("v4"), 
                        request.getParameter("v5"));
                request.getRequestDispatcher("Servlet_ObraDeArte?op=1").forward(request, response);
                break;
                
                
            case 3://editar
                cob.editarObras(request.getParameter("v1"), 
                        request.getParameter("v2"), 
                        String.valueOf(request.getParameter("v3")), 
                        String.valueOf(request.getParameter("v4")), 
                        request.getParameter("v5"), 
                        request.getParameter("v6"));
                request.getRequestDispatcher("Servlet_ObraDeArte?op=1").forward(request, response);
                break;
                
                
            case 4://eliminar
                if (cru.claveADM(request.getParameter("clave"))) {
                    cob.eliminarObraDeArte(request.getParameter("codigo"));
                }else{
                    request.getRequestDispatcher("C_ObrasDeArte/ObrasDeArte.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                }
                
                request.getRequestDispatcher("Servlet_ObraDeArte?op=1").forward(request, response);
                break;
                
                
            case 5:
                request.getSession().setAttribute("lista", cob.buscarObras(request.getParameter("buscar")));
                request.getRequestDispatcher("C_ObrasDeArte/ObrasDeArte.jsp").forward(request, response);
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
