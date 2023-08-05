package dao;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.List;
import util.DbUtil;


public abstract class BaseDao {	
		/**
		 * 执行增删改最原始操作
		 * 
		 * @param sql update
		 * @param args
		 * @return
		 * @throws Exception
		 */	
	//update
	public boolean update(String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		} finally {
			DbUtil.close(conn, ps, null);
		}
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public <T> T getById(Class clazz,String sql, Object... args) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		T s = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			rs = ps.executeQuery();			
			if (rs.next()) {			
				ResultSetMetaData rsmd = rs.getMetaData();
				s=(T)clazz.newInstance();				
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String columnName = rsmd.getColumnName(i + 1);
					Object columnValue = rs.getObject(i + 1);
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(s, columnValue);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn, ps, rs);
		}
		return s;
	}
	
	public <T> List<T> getList(Class<T> clazz,String sql, Object...args){
		List<T> list=new ArrayList<>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		T s = null;
		try {
			conn = DbUtil.getConnection();
			ps = conn.prepareStatement(sql);
			for (int i = 0; i < args.length; i++)
				ps.setObject(i + 1, args[i]);
			rs = ps.executeQuery();			
			while (rs.next()) {				
				ResultSetMetaData rsmd = rs.getMetaData();
				s = clazz.newInstance();
				for (int i = 0; i < rsmd.getColumnCount(); i++) {
					String columnName = rsmd.getColumnName(i + 1);
					Object columnValue = rs.getObject(i + 1);
					Field field = clazz.getDeclaredField(columnName);
					field.setAccessible(true);
					field.set(s, columnValue);
				}
				list.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbUtil.close(conn, ps, rs);
		}				
		return list;
	}
}
