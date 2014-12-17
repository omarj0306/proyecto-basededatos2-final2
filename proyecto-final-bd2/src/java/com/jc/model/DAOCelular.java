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


public class DAOCelular {
     public static String guardarCelular(String marca_cel, String modelo,String precio, String compania)throws Exception{
     Conexion c=new Conexion();
        Connection con=c.conectarse();
     CallableStatement callate=con.prepareCall("{call GUARDAR_CELULAR(?,?,?,?,?)}");
        callate.registerOutParameter(1,java.sql.Types.INTEGER);
        callate.setString(2,marca_cel);
        callate.setString(3,modelo);
        callate.setString(4,precio);
        callate.setString(5,compania);
      
        callate.execute();
        int pk=callate.getInt(1);
        return "Se guardo celular con id:"+pk;
        
    }
     
     public  static String buscarTodosCelulares() {
     // primero nos canectamos a oracle
    String resultado="no hay nada ";
    try{ 
    Connection con= Conexion.conectarse();
        Statement st= con.createStatement();
        // Con el statement realizamos los querry
         ResultSet res= st.executeQuery("select * from celular");
         
         // Iterar el resultset para ver los resultados de la consulta
         int contador =0;
         ArrayList<Celular> celulares=new ArrayList<Celular>();
         while(res.next()){
             Celular p=new Celular();
                p.setId_cel(res.getInt(1));
                p.setMarca_cel(res.getString(2));
                p.setModelo(res.getString(3));
                p.setPrecio(res.getString(4));
                p.setCompania(res.getString(5));
                
                Celular.add(p);
         }
        resultado="encontramos "+ celulares.toString()+ "registrados";
            }catch (Exception e){
                resultado=e.getMessage();
            }
    return resultado;
     
     
     
     }
}
