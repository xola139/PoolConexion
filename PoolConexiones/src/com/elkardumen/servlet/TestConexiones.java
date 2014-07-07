package com.elkardumen.servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class TestConexiones
 */
@WebServlet(description = "Tester de Conexiones Pools", urlPatterns = { "/TestConexiones" })
public class TestConexiones extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TestConexiones() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
try{
		Context initContext = new InitialContext();
		Context envContext  = (Context)initContext.lookup("java:/comp/env");
		DataSource ds = (DataSource)envContext.lookup("jdbc/myoracle");
		Connection conn = ds.getConnection();
		
		System.out.println("Oracle>>>"+conn+""+conn.isClosed());
		System.out.println("Oracle 3>>>"+conn+""+conn.isClosed());
		System.out.println("Oracle 4>>>"+conn+""+conn.isClosed());
		
		
		Context initContextMySql = new InitialContext();
		Context envContextMySql  = (Context)initContextMySql.lookup("java:/comp/env");
		DataSource dsMySql = (DataSource)envContextMySql.lookup("jdbc/mysql");
		Connection connMySql = dsMySql.getConnection();
		
		System.out.println("MySql>>>"+connMySql+""+connMySql.isClosed());
		
}catch(Exception e){
	e.printStackTrace();
	
}	
		
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
