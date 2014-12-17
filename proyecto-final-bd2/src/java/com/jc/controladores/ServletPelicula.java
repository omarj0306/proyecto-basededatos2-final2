/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jc.controladores;

import com.jc.model.DAOPelicula;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author T202
 */
public class ServletPelicula extends HttpServlet {

 // METODO HTTP    SENTENCIA SQL
    //  POST- PARA INSERTAR DATOS
    //GET- BUSCAR  POR ID O TODOS 
    // PUT- PARA HACER UN UPDATE EN LA BASE DE DATOS
    // DELETE- PARA BORRAR
            
    protected void doPost (HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        //PEDIMOS DATOS DE CLIENTE
        String titulo=request.getParameter("titulo");
        String sinopsis=request.getParameter("sinopsis");
        try{
        //SE INVOCA EL PROCEDIMIENTO
         out.println(DAOPelicula.guardarPelicula(titulo, sinopsis));
        }catch(Exception e){}
        
        
    }
}