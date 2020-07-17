/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlet;

import CONTROLADOR.Control_Eventos;
import CONTROLADOR.Control_GaleriaObra;
import CONTROLADOR.Control_Galerias;
import CONTROLADOR.Control_ObrasDeArte;
import CONTROLADOR.Control_TipoEvento;
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
public class Servlet_Galerias extends HttpServlet {
    Control_Galerias crg=new Control_Galerias();
    Control_usuarios cru=new Control_usuarios();
    Control_Eventos cre=new Control_Eventos();
    Control_GaleriaObra cgo=new Control_GaleriaObra();
    Control_TipoEvento crt=new Control_TipoEvento();
    Control_ObrasDeArte cob=new Control_ObrasDeArte();
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
                case 1://leer lista de galerias y redirigir a pagina de galerias
                    request.getSession().setAttribute("lista", crg.lista_gal());
                    request.getSession().setAttribute("listau", crg.listaUbi());
                    request.getRequestDispatcher("Galerias/Galerias.jsp").forward(request, response);
                break;

                case 3:
                    crg.insrtarGal(request.getParameter("v1"), 
                            request.getParameter("v2")); 
                    request.getRequestDispatcher("Servlet_Galerias?op=1").forward(request, response);
                break;
                case 5:
                     crg.editarGal(request.getParameter("v1"), 
                            request.getParameter("v2"),
                            request.getParameter("v3"));
                    request.getRequestDispatcher("Servlet_Galerias?op=1").forward(request, response);
                break;
                
                case 6://eliminar comparando si existe o no existe una clave secreta de administrador
                    if (cru.claveADM(request.getParameter("clave"))) {
                        crg.eliminarGal(request.getParameter("codigo"));
                    }else{
                        request.getRequestDispatcher("Galerias/Galerias.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    
                    request.getRequestDispatcher("Servlet_Galerias?op=1").forward(request, response);
                break;
                
                case 7://BUSCAR
                    request.getSession().setAttribute("lista", crg.buscarGal(request.getParameter("buscar")));
                    request.getRequestDispatcher("Galerias/Galerias.jsp").forward(request, response);
                break;
                
                case 8://detalle
                    request.getSession().setAttribute("codigo", request.getParameter("codigo"));
                    request.getSession().setAttribute("listaDetalle", crg.listaDetalles(request.getParameter("codigo")));
                    request.getSession().setAttribute("listaEventos", cre.lista_EveEnGal(request.getParameter("codigo")));
                    request.getSession().setAttribute("listaTEV", crt.lista_tipEv());
                    request.getSession().setAttribute("listaGO", cgo.lista_ObrasEnGal(request.getParameter("codigo")));
                    request.getSession().setAttribute("listaO", cob.listaObras());
                    request.getRequestDispatcher("Galerias/detalles.jsp").forward(request, response);
                break;
                
                case 9://insertar eventos en galerias
                    String cod_galeria=(String)request.getSession().getAttribute("codigo");
                    cre.insrtarEvento(request.getParameter("v1"), 
                            Date.valueOf(request.getParameter("v2")), 
                            Date.valueOf(request.getParameter("v3")), 
                            cod_galeria, 
                            request.getParameter("v4"));
                    request.getRequestDispatcher("Servlet_Galerias?op=8&codigo="+cod_galeria).forward(request, response);
                break;
                
                case 10://Editar eventos desde galerias
                    cod_galeria=(String)request.getSession().getAttribute("codigo");
                    cre.editarEventos(request.getParameter("v1"), 
                            request.getParameter("v2"), 
                            Date.valueOf(request.getParameter("v3")), 
                            Date.valueOf(request.getParameter("v4")), 
                            cod_galeria, 
                            request.getParameter("v5"));
                    request.getRequestDispatcher("Servlet_Galerias?op=8&codigo="+cod_galeria).forward(request, response);
                break;
                
                case 11://eliminar eventos desde galerias
                    cod_galeria=(String)request.getSession().getAttribute("codigo");
                    if (cru.claveADM(request.getParameter("clave"))) {
                        cre.eliminarEventos(request.getParameter("codigo"));
                    }else{
                        request.getRequestDispatcher("Galerias/detalles.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    
                    request.getRequestDispatcher("Servlet_Galerias?op=8&codigo="+cod_galeria).forward(request, response);
                break;
                
                case 12://agregar obras en Galerias, desde el mantenedor de Galerias.
                    cod_galeria=(String)request.getSession().getAttribute("codigo");
                    cgo.insrtarGaleriaObra(request.getParameter("v1"), 
                            cod_galeria);
                    request.getRequestDispatcher("Servlet_Galerias?op=8&codigo="+cod_galeria).forward(request, response);
                break;
                
                case 13://editar obras en Galerias, desde el mantenedor de Galerias.
                    cod_galeria=(String)request.getSession().getAttribute("codigo");
                    cgo.editarGalObras(request.getParameter("v1"), 
                            cod_galeria, 
                            request.getParameter("v2"));
                    request.getRequestDispatcher("Servlet_Galerias?op=8&codigo="+cod_galeria).forward(request, response);
                break;
                
                case 14://eliminar obras en Galerias, desde el mantenedor de Galerias.
                    cod_galeria=(String)request.getSession().getAttribute("codigo");
                    if (cru.claveADM(request.getParameter("clave"))) {
                        cgo.eliminarGalObras(request.getParameter("codigo"));
                    }else{
                        request.getRequestDispatcher("Galerias/detalles.jsp?mnsj=Clave Secreta Incorrecta").forward(request, response);
                    }
                    request.getRequestDispatcher("Servlet_Galerias?op=8&codigo="+cod_galeria).forward(request, response);
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
