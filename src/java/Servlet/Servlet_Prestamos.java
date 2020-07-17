/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import CONTROLADOR.Control_DetallesPrestamos;
import CONTROLADOR.Control_Devoluciones;
import CONTROLADOR.Control_Museos;
import CONTROLADOR.Control_ObrasDeArte;
import CONTROLADOR.Control_Prestamos;
import CONTROLADOR.Control_SegPres;
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
public class Servlet_Prestamos extends HttpServlet {
    Control_Prestamos crp=new Control_Prestamos();
    Control_Museos cm= new Control_Museos();
    Control_usuarios cru=new Control_usuarios();
    Control_DetallesPrestamos cdp=new Control_DetallesPrestamos();
    Control_Devoluciones crd=new Control_Devoluciones();
    Control_SegPres crs=new Control_SegPres();
    Control_ObrasDeArte cro=new Control_ObrasDeArte();
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
        int opc= Integer.parseInt(request.getParameter("op"));
            switch (opc) {                
                //listar prestamos
                case 1:
                    request.getSession().setAttribute("lista", crp.ListarPrestamos());
                    request.getSession().setAttribute("listaM", crp.ListarMuseos());
                    request.getSession().setAttribute("listaE", crp.ListarEstadoPrestamos());
                    request.getRequestDispatcher("Prestamos/Prestamos.jsp").forward(request, response);
                break;
        
                //insertar prestamos
                case 2:
                crp.InsertarPrestamos(Date.valueOf(request.getParameter("v1")), 
                    request.getParameter("v2"), 
                    Integer.parseInt(request.getParameter("v3")), 
                    Integer.parseInt(request.getParameter("v4")), 
                    Integer.parseInt(request.getParameter("v5")));
                request.getRequestDispatcher("Servlet_Prestamos?op=1").forward(request, response);
                break;
        
                //editar prestamos
                case 3:
                crp.EditarPrestamos(Integer.parseInt(request.getParameter("v1")), 
                    Date.valueOf(request.getParameter("v2")), 
                    request.getParameter("v3"), 
                    Integer.parseInt(request.getParameter("v4")), 
                    Integer.parseInt(request.getParameter("v5")), 
                    Integer.parseInt(request.getParameter("v6")));
                request.getRequestDispatcher("Servlet_Prestamos?op=1").forward(request, response);
                break;
        
                //eliminar prestamos
                case 4:
                if (cru.claveADM(request.getParameter("clave"))) {
                        crp.EliminarPrestamos(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("Prestamos/Prestamos.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    
                    request.getRequestDispatcher("Servlet_Prestamos?op=1").forward(request, response);
                break;
                
                //buscar
                case 5:
                    request.getSession().setAttribute("lista", crp.BuscarPrestamos(request.getParameter("buscar")));
                    request.getRequestDispatcher("Prestamos/Prestamos.jsp").forward(request, response);
                break;
                
                //detalles
                case 6:
                    request.getSession().setAttribute("codigo", request.getParameter("codigo"));
                    request.getSession().setAttribute("listaDetalles", crp.ListarDetalles(request.getParameter("codigo")));
                    request.getSession().setAttribute("ListaD", cdp.ListarDetallesPrestamos(request.getParameter("codigo")));
                    request.getSession().setAttribute("listaDev", crd.ListaDevoEnPrestamos(request.getParameter("codigo")));
                    request.getSession().setAttribute("ListaS", crs.ListaSegPresEnPrestamos(request.getParameter("codigo")));
                    request.getSession().setAttribute("ListaO", cro.listaObras());
                    request.getSession().setAttribute("ListaSeg", crs.ListarSeguro());
                    request.getRequestDispatcher("Prestamos/Detalles.jsp").forward(request, response);
                break;
                
                //insertar detalles de prestamos en Prestamos
                case 7:
                    String cod_prestamo=(String)request.getSession().getAttribute("codigo");
                    cdp.InsertarDetallesPrestamos(request.getParameter("v1"), 
                            cod_prestamo, 
                            Integer.parseInt(request.getParameter("v2")));
                    request.getRequestDispatcher("Servlet_Prestamos?op=6&codigo="+cod_prestamo).forward(request, response);
                break;
                
                //editar detalles de prestamos en Prestamos
                case 8:
                    cod_prestamo=(String)request.getSession().getAttribute("codigo");
                    cdp.EditarDetallesPrestamos(Integer.parseInt(request.getParameter("v1")), 
                            request.getParameter("v2"), 
                            cod_prestamo, 
                            Integer.parseInt(request.getParameter("v3")));
                    request.getRequestDispatcher("Servlet_Prestamos?op=6&codigo="+cod_prestamo).forward(request, response);
                break;
                
                //eliminar detalles de prestamos en Prestamos
                case 9:
                    cod_prestamo=(String)request.getSession().getAttribute("codigo");
                    if (cru.claveADM(request.getParameter("clave"))) {
                        cdp.EliminarDetallesPrestamos(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("Prestamos/Detalles.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    request.getRequestDispatcher("Servlet_Prestamos?op=6&codigo="+cod_prestamo).forward(request, response);
                break;
                
                //insertar devoluciones en Prestamos
                case 10:
                    cod_prestamo=(String)request.getSession().getAttribute("codigo");
                    crd.InsertarDevoluciones(Date.valueOf(request.getParameter("v1")), 
                            request.getParameter("v2"), 
                            request.getParameter("v3"), 
                            cod_prestamo);
                    request.getRequestDispatcher("Servlet_Prestamos?op=6&codigo="+cod_prestamo).forward(request, response);
                break;
                
                //editar devoluciones en Prestamo
                case 11:
                    cod_prestamo=(String)request.getSession().getAttribute("codigo");
                    crd.EditarDevoluciones(Integer.parseInt(request.getParameter("v1")), 
                            Date.valueOf(request.getParameter("v2")), 
                            request.getParameter("v3"), 
                            request.getParameter("v4"), cod_prestamo);
                    request.getRequestDispatcher("Servlet_Prestamos?op=6&codigo="+cod_prestamo).forward(request, response);
                break;
                
                //eliminar devoluciones en Prestamos
                case 12:
                    cod_prestamo=(String)request.getSession().getAttribute("codigo");
                    if (cru.claveADM(request.getParameter("clave"))) {
                        crd.EliminarDevoluciones(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("Prestamos/Detalles.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    request.getRequestDispatcher("Servlet_Prestamos?op=6&codigo="+cod_prestamo).forward(request, response);
                break;
                
                //insertar PrestamosSeguros en Prestamos
                case 13:
                    cod_prestamo=(String)request.getSession().getAttribute("codigo");
                    crs.InsertarPresSeg(cod_prestamo, 
                            request.getParameter("v1"));
                    request.getRequestDispatcher("Servlet_Prestamos?op=6&codigo="+cod_prestamo).forward(request, response);
                break;
                
                //editar PrestamosSeguros en Prestamos
                case 14:
                    cod_prestamo=(String)request.getSession().getAttribute("codigo");
                    crs.EditarPresSeg(Integer.parseInt(request.getParameter("v1")), 
                            cod_prestamo, 
                            request.getParameter("v2"));
                    request.getRequestDispatcher("Servlet_Prestamos?op=6&codigo="+cod_prestamo).forward(request, response);
                break;
                
                //eliminar PrestamosSeguros en Prestamos
                case 15:
                    cod_prestamo=(String)request.getSession().getAttribute("codigo");
                    if (cru.claveADM(request.getParameter("clave"))) {
                        crs.EliminarPresSeg(Integer.parseInt(request.getParameter("codigo")));
                    }else{
                        request.getRequestDispatcher("Prestamos/Detalles.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    request.getRequestDispatcher("Servlet_Prestamos?op=6&codigo="+cod_prestamo).forward(request, response);
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
