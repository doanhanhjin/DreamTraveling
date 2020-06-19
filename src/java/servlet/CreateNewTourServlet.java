/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import jpa.blo.TourBLO;
import jpa.entity.Tour;

/**
 *
 * @author user
 */
public class CreateNewTourServlet extends HttpServlet {

    private final String homePage = "home.jsp";
    private final String invalidPage = "invalid.html";
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
        PrintWriter out = response.getWriter();
        try {
            /* TODO output your page here. You may use following sample code. */
            String url = invalidPage;
            String name = request.getParameter("txtTourName");
            String toPlace = request.getParameter("txtToPlace");
            String fromDate = request.getParameter("txtFromDate");
            String toDate = request.getParameter("txtToDate");
            String price = request.getParameter("txtPrice");
            String quota = request.getParameter("txtQuota");
            String image = request.getParameter("txtImage");
            System.out.println("FROMDATE" + fromDate);
            System.out.println("TODATE" + toDate);
            Date fDate = new SimpleDateFormat("MM/dd/yyyy").parse(fromDate);
            Date tDate = new SimpleDateFormat("MM/dd/yyyy").parse(toDate);
            
            long millis = System.currentTimeMillis();
            java.sql.Date dateImport = new java.sql.Date(millis);
            
//            Tour tour = new Tour(name, fDate, tDate, Double.valueOf(price), Integer.valueOf(quota), image, fromPlace, toPlace, "new", dateImport);
            Tour tour = new Tour(name, fDate, tDate, Integer.valueOf(price), Integer.valueOf(quota), image, toPlace, "new", dateImport);
            TourBLO tourBLO = new TourBLO();
            boolean result = tourBLO.createNewTour(tour);
            if (result) {
                url = homePage;
                System.out.println("Create success!!");
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);
        } catch (ParseException ex) {
            Logger.getLogger(CreateNewTourServlet.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            out.close();
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
