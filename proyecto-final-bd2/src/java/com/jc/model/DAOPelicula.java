/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.jc.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author T202
 */
public class DAOPelicula {
    
    
    public static String guardarPelicula(String titulo, String sinopsis)throws Exception{
     Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call GUARDAR_PELICULA(?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,titulo);
        callate.setString(3,sinopsis);
      
        callate.execute();
        int pk=callate.getInt(1);
        return "Se guardo la pelicula con id:"+pk;
        
    }
public  static String buscarTodasPeliculas(){
// primero nos canectamos a oracle
    String resultado="no hay nada ";
    try{ 
    Connection con= Conexion.conectarse();
        Statement st= con.createStatement();
        // Con el statement realizamos los querry
         ResultSet res= st.executeQuery("select * from pelicula");
         
         // Iterar el resultset para ver los resultados de my query
         int contador =0;
         ArrayList<Pelicula> peliculas=new ArrayList<Pelicula>();
         while(res.next()){
             Pelicula p=new Pelicula();
                p.setId(res.getInt(1));
                p.setTitulo(res.getString(2));
                p.setSinopsis(res.getString(3));
                peliculas.add(p);
         }
        resultado="encontramos "+ peliculas.toString()+ "registros";
            }catch (Exception e){
                resultado=e.getMessage();
            }
    return resultado;
}
}

