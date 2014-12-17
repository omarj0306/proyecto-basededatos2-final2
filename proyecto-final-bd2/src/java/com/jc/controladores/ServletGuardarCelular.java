/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jc.controladores;

import com.jc.model.DAOCelular;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author T-205
 */
public class ServletGuardarCelular extends HttpServlet {

    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
    String marca_cel=    request.getParameter("marca_cel");
     String modelo=    request.getParameter("modelo");
      String precio=    request.getParameter("precio");
       String compania=    request.getParameter("compania");
        try {
            DAOCelular.guardarCelular(marca_cel, modelo, precio, compania);
        } catch (Exception ex) {
            Logger.getLogger(ServletGuardarCelular.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
}