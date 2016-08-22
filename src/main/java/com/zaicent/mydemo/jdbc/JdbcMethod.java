package com.zaicent.mydemo.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JdbcMethod {
	private Connection conn;  
    private PreparedStatement pstmt;  
    private ResultSet rs;
    
    /**
     * 查询多条记录
     * @param driver
     * @param url
     * @param userName
     * @param password
     * @param sql 
     * @param params 
     * @return List<Map<String, Object>>
     * @throws SQLException 
     */  
    public List<Map<String, Object>> getRecordList(String driver, String url, 
    		String userName, String password, String sql, List<Object> params) throws SQLException{  
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();  
        int index = 1;
        JdbcUtil.setDriver(JdbcUtil.DRIVER);
        conn = JdbcUtil.getConn(url, userName, password);
        pstmt = conn.prepareStatement(sql);  
        if(params!=null && !params.isEmpty()){  
            for(int i = 0; i<params.size(); i++){  
                pstmt.setObject(index++, params.get(i));  
            }  
        }  
        rs = pstmt.executeQuery();  
        ResultSetMetaData metaData = rs.getMetaData();  
        int cols_len = metaData.getColumnCount();  
        while(rs.next()){  
            Map<String, Object> map = new HashMap<String, Object>();  
            for(int i=0; i<cols_len; i++){  
                String cols_name = metaData.getColumnName(i+1);  
                Object cols_value = rs.getObject(cols_name);  
                if(cols_value == null){  
                    cols_value = "";  
                }  
                map.put(cols_name, cols_value);  
            }  
            list.add(map);  
        }
        JdbcUtil.closeRs(rs);
        JdbcUtil.closePstmt(pstmt);
        JdbcUtil.closeConn(conn);
        return list;  
    }
    
    
    
    
    /**
     * 获取同步数据
     * @param sql 
     * @param params 
     * @return List<List<Object>>
     * @throws SQLException 
     */  
    public List<List<Object>> getDataList(String sql, List<Object> params) throws SQLException{  
        List<List<Object>> list = new ArrayList<List<Object>>();  
        int index = 1; 
        conn = JdbcUtil.getConn(JdbcUtil.URL, JdbcUtil.USERNAME, JdbcUtil.PASSWORD);
        pstmt = conn.prepareStatement(sql);  
        if(params!=null && !params.isEmpty()){  
            for(int i = 0; i<params.size(); i++){  
                pstmt.setObject(index++, params.get(i));  
            }  
        }  
        rs = pstmt.executeQuery();  
        ResultSetMetaData metaData = rs.getMetaData();  
        int cols_len = metaData.getColumnCount();  
        while(rs.next()){  
        	List<Object> valList = new ArrayList<Object>();  
            for(int i=0; i<cols_len; i++){  
                String cols_name = metaData.getColumnName(i+1);  
                Object cols_value = rs.getObject(cols_name);  
                if(cols_value == null){  
                    cols_value = "";  
                }  
                valList.add(cols_value);  
            }  
            list.add(valList);  
        }
        JdbcUtil.closeRs(rs);
        JdbcUtil.closePstmt(pstmt);
        JdbcUtil.closeConn(conn);
        return list;  
    }
    
    /**
     * 插入同步数据
     * @param tableName 
     * @param List<List<Object>> list 
     * @return boolean
     */
    public boolean cloneData(String tableName, List<List<Object>> list) {
    	boolean flag = false;
    	if (list!=null && list.size()>0 && list.get(0).size()>0) {
    		int cols_len = list.get(0).size();
    		String sql = "insert into " + tableName + " values(";
    		for (int i = 0; i < cols_len; i++) {
    			sql += "?,";
    		}
			sql = sql.substring(0,sql.lastIndexOf(","))+")";
			for (List<Object> params : list) {
				try {
					flag = this.updateByPreparedStatement(sql, params);
				} catch (SQLException e) {
					e.printStackTrace();
					try {
						conn.rollback();
		            } catch (SQLException e1) {
		                System.out.println("SQLException in rollback : " + e.getMessage());
		            }
				}
			}
		}
    	JdbcUtil.closePstmt(pstmt);
        JdbcUtil.closeConn(conn);
		return flag;
    }
    
    /** 
     * 增加、删除、修改 
     * @param sql 
     * @param params 
     * @return boolean
     * @throws SQLException 
     */  
    public boolean updateByPreparedStatement(String sql, List<Object> params) throws SQLException{  
        boolean flag = false;  
        int result = -1;
        conn = JdbcUtil.getConn(JdbcUtil.URL2, JdbcUtil.USERNAME, JdbcUtil.PASSWORD);
        pstmt = conn.prepareStatement(sql);  
        int index = 1;  
        if(params!=null && !params.isEmpty()){  
            for(int i=0; i<params.size(); i++){  
                pstmt.setObject(index++, params.get(i));  
            }  
        }  
        result = pstmt.executeUpdate();  
        flag = result > 0 ? true : false;
        return flag;  
    }
    
    public void transferData(String tableName, String sql, List<Object> params) throws SQLException{  
        if (sql == null) {
			sql = "select * from " + tableName;
		}
    	conn = JdbcUtil.getConn(JdbcUtil.URL, JdbcUtil.USERNAME, JdbcUtil.PASSWORD);
        pstmt = conn.prepareStatement(sql);  
        if(params!=null && !params.isEmpty()){  
            for(int i = 0; i<params.size(); i++){  
                pstmt.setObject(++i, params.get(i));  
            }  
        }  
        rs = pstmt.executeQuery();
        
        ResultSetMetaData metaData = rs.getMetaData();  
        int cols_len = metaData.getColumnCount();
        
        Connection conn2 = JdbcUtil.getConn(JdbcUtil.URL2, JdbcUtil.USERNAME, JdbcUtil.PASSWORD);
        sql = "insert into " + tableName + " values(";
		for (int i = 0; i < cols_len; i++) {
			sql += "?,";
		}
		sql = sql.substring(0,sql.lastIndexOf(","))+")";
        while(rs.next()){  
        	PreparedStatement pstmt2 = conn2.prepareStatement(sql);
        	int index = 1;
            for(int i=0; i<cols_len; i++){  
                String cols_name = metaData.getColumnName(i+1);  
                Object cols_value = rs.getObject(cols_name);  
                if(cols_value == null){  
                    cols_value = "";  
                }
                pstmt2.setObject(index++, params.get(i));
            }  
            pstmt2.executeUpdate();
            JdbcUtil.closePstmt(pstmt2);
        }
        
        JdbcUtil.closeRs(rs);
        JdbcUtil.closePstmt(pstmt);
        JdbcUtil.closeConn(conn);
        JdbcUtil.closeConn(conn2);
    }
    
    public static void main(String[] args) throws SQLException {
    	JdbcMethod jdbcMethod = new JdbcMethod();
    	jdbcMethod.transferData("userinfo", null, null);
	}

}
