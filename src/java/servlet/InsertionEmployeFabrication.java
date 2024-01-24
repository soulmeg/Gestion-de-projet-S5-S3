/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Vector;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import objet.DureeFabricationProduit;
import objet.EmployeFabrication;
import objet.Meuble;
import objet.Role;
import objet.Style;
import objet.Volume;

/**
 *
 * @author ASUS
 */
public class InsertionEmployeFabrication extends HttpServlet {

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
        Meuble m = new Meuble();
        Volume v = new Volume();
        Role r = new Role();
        try {
            Vector<Meuble> meubles = m.findAll();
            request.setAttribute("meubles", meubles);
            Vector<Volume> volumes = v.findAll();
            Vector<Role> roles = r.findAll();
            request.setAttribute("volumes", volumes);
            request.setAttribute("roles", roles);
            RequestDispatcher rd = request.getRequestDispatcher("InsertionEmployeFabrication.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            String errorMessage = " " + e.getMessage();
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            rd.forward(request, response);
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
        String meuble = request.getParameter("meuble");
        String volume = request.getParameter("volume");
        String role = request.getParameter("role");
        String nombre = request.getParameter("nombre");
        EmployeFabrication fm = new EmployeFabrication();
        try {
            fm.insertDoubleEF(meuble, volume,role , nombre);
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.forward(request, response);
        } catch (Exception e) {
            String errorMessage = " " + e.getMessage();
            request.setAttribute("errorMessage", errorMessage);
            RequestDispatcher rd = request.getRequestDispatcher("Error.jsp");
            rd.forward(request, response);
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
