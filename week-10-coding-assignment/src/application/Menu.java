package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import dao.GpuDao;
import entity.Gpu;

public class Menu {

	/*
	 * Classes for instantiating User input with menu for direction
	 * and the Data access object for the database table.
	 */
	private GpuDao gpuDao = new GpuDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Create an entry",
			"Read entries",
			"Update an entry",
			"Delete an entry",
			"Delete all entries");
	
	/*
	 * Menu is printed to console then scanned for the users 
	 * input to decide operation to happen.
	 */
	public void start() {
		String selection = "";
		
		do {
			printMenu();
			System.out.println("Type a number and press enter to confirm selection.");
			selection = scanner.nextLine();

			try {
			if (selection.equals("1")) {
				createGpu();
			} else if (selection.equals("2")) {
				readGpus();
			} else if (selection.equals("3")) {
				updateGpu();
			} else if (selection.equals("4")) {
				deleteGpu();
			} else if (selection.equals("5")) {
				deleteAll();
			} 
			}catch (SQLException e) {
				e.printStackTrace();
			}
			
			
		} while (!selection.equals("-1"));
	}
	
	/*
	 * Method to print menu to console from stored 
	 * list of options.
	 */
	private void printMenu() {
		System.out.println("\nSelect one of the following.\n-------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ". " + options.get(i));
		}
	}
	
	/*
	 * Method to direct user to enter name for Create query
	 * then do so to the database
	 */
	private void createGpu() throws SQLException {
		System.out.println("Enter name of GPU.");
		String name = scanner.nextLine();
		gpuDao.createNewEntry(name);
	}
	
	/*
	 * Method to read the table of entries.
	 */
	private void readGpus() throws SQLException {
		gpuDao.readGpuEntries();
				}
	
	/*
	 * Method to update Gpu entry in table and 
	 * and directed to select what index to be updated.
	 */
	private void updateGpu() throws SQLException {
		System.out.println("Enter ID you want to modify. ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter data to be amended");
		String name = scanner.nextLine();
		gpuDao.updateGpuEntry(name, id);
	}
	
	/*
	 * Method to delete Gpu entry directing the user what index do 
	 * they want to delete.
	 */
	private void deleteGpu() throws SQLException {
		System.out.println("Enter ID of entry you want to delete. ");
		int id = Integer.parseInt(scanner.nextLine());
		gpuDao.deleteGpuEntry(id);
	}
	
	/*
	 * Method to delete all entries in the database table.
	 */
	private void deleteAll() throws SQLException {
		System.out.println("All GPU entires deleted. \n");
		gpuDao.deleteAllEntries();
	}
	
}
