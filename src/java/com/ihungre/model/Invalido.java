/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ihungre.model;

/**
 *
 * @author jeferson
 */

import javax.servlet.ServletException;

public class Invalido extends ServletException {
	 
    public Invalido(String message){
		  super(message);
	  }

}