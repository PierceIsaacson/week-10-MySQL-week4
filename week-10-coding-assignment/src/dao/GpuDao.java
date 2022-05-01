package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import entity.Gpu;

public class GpuDao {

	/*
	 * String classes are instantiated to be used 
	 * on user based database queries. 
	 */
	private Connection connection;
	private final String CREATE_NEW_ENTRY_QUERY = "INSERT INTO discrete_gpu(name) VALUES (?)";
	private final String READ_TABLE = "SELECT * FROM discrete_gpu";
	private final String UPDATE_TABLE = "UPDATE discrete_gpu set name = ? WHERE id = ?";
	private final String DELETE_ENTRY = "DELETE FROM discrete_gpu WHERE id = ?";
	private final String DELETE_ALL = "DELETE FROM discrete_gpu";
	private final String RESET_INCREMENT = "ALTER TABLE discrete_gpu AUTO_INCREMENT = 1";
	
	public GpuDao() {
		connection = DBConnection.getConnection();
	}
	/*
	 * create query is pushed to connected database
	 */
	public void createNewEntry(String name) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(CREATE_NEW_ENTRY_QUERY);
		ps.setString(1, name);
		ps.executeUpdate();
	}
	/*
	 * read query is pushed to connected database
	 */
	public void readGpuEntries() throws SQLException{
		PreparedStatement ps = connection.prepareStatement(READ_TABLE);
		ResultSet rs = ps.executeQuery();
		System.out.println();
		
		while (rs.next()) {
			System.out.println("GPU ID: " + rs.getInt(1) + " Name: " + rs.getString(2));
		}
		System.out.println();
	}
	/*
	 * update query is pushed to connected database
	 */
	public void updateGpuEntry(String name, int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(UPDATE_TABLE);
		ps.setString(1, name);
		ps.setInt(2, id);
		ps.executeUpdate();
	}
	/*
	 * delete entry query is pushed to connected database
	 */
	public void deleteGpuEntry(int id) throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ENTRY);
		ps.setInt(1, id);
		ps.executeUpdate();
	}
	/*
	 * Delete All query is pushed to connected database
	 */
	public void deleteAllEntries() throws SQLException {
		PreparedStatement ps = connection.prepareStatement(DELETE_ALL);
		ps.executeUpdate();
		PreparedStatement ps1 = connection.prepareStatement(RESET_INCREMENT);
		ps1.executeUpdate();
	}
	
}
