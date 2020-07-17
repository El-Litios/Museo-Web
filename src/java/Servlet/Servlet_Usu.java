/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import CONTROLADOR.Control_Seguridad;
import CONTROLADOR.Control_usuarios;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mark-
 */
public class Servlet_Usu extends HttpServlet {
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
            throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            int opc=Integer.parseInt(request.getParameter("op"));
            switch(opc){
                //lista de roles
                case 1://leer
                    request.getSession().setAttribute("lista", cru.lista_usus());//llama la lista de usuarios
                    request.getSession().setAttribute("listaR", cru.listaRoles());
                    request.getRequestDispatcher("C_Usuarios/Usuarios.jsp").forward(request, response);
                break;
                case 3://agregar nuevo usuario
                    cru.insrtarUsu(request.getParameter("v1"), 
                            request.getParameter("v2"), 
                            request.getParameter("v3"), 
                            request.getParameter("v4"), 
                            request.getParameter("v5"));
                    request.getRequestDispatcher("Servlet_Usu?op=1").forward(request, response);
                break;
                case 4://buscar
                    request.getSession().setAttribute("lista", cru.buscarUsu(request.getParameter("buscar")));
                    request.getRequestDispatcher("C_Usuarios/Usuarios.jsp").forward(request, response);
                break;
                case 5://grabar los datos que se editaran
                    cru.editarUsu(request.getParameter("v1"), 
                            request.getParameter("v2"), 
                            request.getParameter("v3"), 
                            request.getParameter("v4"), 
                            request.getParameter("v5"),
                            request.getParameter("v6"));
                    request.getRequestDispatcher("Servlet_Usu?op=1").forward(request, response);
                break;
                case 6://eliminar usuario
                    if (cru.claveADM(request.getParameter("clave"))) {
                        cru.eliminarUsu(request.getParameter("codigo"));
                    }else{
                        request.getRequestDispatcher("C_Usuarios/Usuarios.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    
                    request.getRequestDispatcher("Servlet_Usu?op=1").forward(request, response);
                break;
                case 7://verificar login y password del susuario
                    boolean nombre=cru.verificar(request.getParameter("v1"), Control_Seguridad.sha1(request.getParameter("v2")));
                    if (nombre)  {
                        //crear parametro de sesion
                        request.getSession().setAttribute("nombre", cru.getNombre());
                        request.getSession().setAttribute("rol", cru.getRol_nom());
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                    }else{
                    request.getRequestDispatcher("Login.jsp?mnsj=USUARIO O PASSWORD INCORRECTO").forward(request, response);
                    }
                    
                break;
                case 8://cerrar sesion
                    request.getSession().invalidate();
                    request.getRequestDispatcher("index.jsp").forward(request, response);
                break;
                case 9://registro de usuarios publico
                    cru.RegistrarUsu(request.getParameter("usuario"), 
                           Control_Seguridad.sha1(request.getParameter("Contraseña")),
                           request.getParameter("nombre"),
                           request.getParameter("email"));
                            
                    request.getRequestDispatcher("index.jsp").forward(request, response);
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
    try {
        processRequest(request, response);
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(Servlet_Usu.class.getName()).log(Level.SEVERE, null, ex);
    }
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
    try {
        processRequest(request, response);
    } catch (NoSuchAlgorithmException ex) {
        Logger.getLogger(Servlet_Usu.class.getName()).log(Level.SEVERE, null, ex);
    }
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
