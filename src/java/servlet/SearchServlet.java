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
import java.util.List;
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
public class SearchServlet extends HttpServlet {

    private final String INVALIDPAGE = "invalid.html";
    private final String HOMEPAGE = "home.jsp";

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
            String url = INVALIDPAGE;
            String place = request.getParameter("txtPlace");
            String date = request.getParameter("txtDate");
            String price = request.getParameter("dropDownPrice");
            System.out.println("DATE" + date);

            List<Tour> tour;
            TourBLO tourBLO = new TourBLO();
            if (!place.isEmpty()) {
                tour = tourBLO.searchByPlace(place);
                if (tour != null) {
                    request.setAttribute("TOUR", tour);
                    url = HOMEPAGE;
                }
            }
            if (!date.isEmpty()) {
                Date searchDate = new SimpleDateFormat("MM/dd/yyyy").parse(date);
                tour = tourBLO.searchByDate(searchDate);
                if (tour != null) {
                    request.setAttribute("TOUR", tour);
                    url = HOMEPAGE;
                }
            }
            if (!price.isEmpty()) {
                int min = 0;
                int max = 0;
                switch (price) {
                    case "1":
                        min = 1000;
                        max = 2000;
                        break;
                    case "2":
                        min = 2000;
                        max = 3000;
                        break;
                    case "3":
                        min = 3000;
                        max = 5000;
                        break;
                    case "4":
                        min = 5000;
                        max = 10000;
                        break;
                }
                if (max > 0) {
                    tour = tourBLO.searchByPrice(min, max);
                    url = HOMEPAGE;
                    if (tour != null) {
                        request.setAttribute("TOUR", tour);
                    } else {
                        request.setAttribute("NOTFOUND", "Tour is not found!");
                    }
                }
            }
            RequestDispatcher rd = request.getRequestDispatcher(url);
            rd.forward(request, response);

        } catch (ParseException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
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
