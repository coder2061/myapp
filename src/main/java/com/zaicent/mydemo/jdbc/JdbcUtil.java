package com.zaicent.mydemo.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcUtil {
	//数据库用户名  
    public static final String USERNAME = "root";  
    //数据库密码  
    public static final String PASSWORD = "root";  
    //驱动信息   
    public static final String DRIVER = "com.mysql.jdbc.Driver";  
    //数据库地址  
    public static final String URL = "jdbc:mysql://localhost:3306/customer";  
    public static final String URL2 = "jdbc:mysql://localhost:3306/goal";
	
    /**
     * 初始化加载驱动
     */
	/*static{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Success loading Mysql Driver!");
		}catch(Exception e) {
			System.out.println("Error loading Mysql Driver!");
			e.printStackTrace();
		} 
	}*/
	
	/**
     * 加载数据库驱动
     */
	public static void setDriver(String driver) {
		try{
			Class.forName(driver);
			System.out.println("Success loading Mysql Driver!");
		}catch(Exception e) {
			System.out.println("Error loading Mysql Driver!");
			e.printStackTrace();
		}
	}
	
	/** 
     * 获得数据库的连接 
     */ 
	public static Connection getConn(String url,String userName,String password){
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, userName, password);
			System.out.println("Success Connection Mysql!");
			return conn;
		} catch (SQLException e) {
			System.out.println("Error Connection Mysql!");
			e.printStackTrace();
		}
		return conn;
	}
	
	/** 
     * 关闭结果集对象
     */  
    public static void closeRs(ResultSet rs){  
        if(rs != null){  
            try{  
            	rs.close();  
            }catch(SQLException e){  
                e.printStackTrace();  
            }  
        }  
    }

    /** 
     * 关闭预处理对象 
     */  
    public static void closePstmt(PreparedStatement pstmt){  
        if(pstmt != null){  
            try{  
            	pstmt.close();  
            }catch(SQLException e){  
                e.printStackTrace();  
            }  
        }  
    }
    
    /** 
     * 关闭数据库连接 
     */  
    public static void closeConn(Connection conn){  
    	if(conn != null){  
    		try{  
    			conn.close();  
    		}catch(SQLException e){  
    			e.printStackTrace();  
    		}  
    	}  
    }
}
