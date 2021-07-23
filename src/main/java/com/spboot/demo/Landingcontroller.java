package com.spboot.demo;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ldap.core.LdapTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController

public class Landingcontroller {

	@Autowired
	DataSource datasource;
	@Autowired
	LdapTemplate ldaptemplate;
	
	
	@RequestMapping(value = "/landingPage",method = RequestMethod.GET)
	public String landingPage(){
		int i=0;
		try {
			
			Connection conn = datasource.getConnection();
			if(conn!=null) {
				System.out.println("DB Connected");
				i=1;
				
			}
			else {
				System.out.println("Conn is null");
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("BOOT PAGE");
		if(i==1) {
		return "WELCOME TO BOOT DBCONNECTED";
		}
		else {
			return "DB ERROR ";
		}
	}
}
