package learn.home.repository;

import learn.home.model.Patient;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static learn.home.repository.ConnectToDB.*;
import static learn.home.repository.DatabaseCommands.*;

public class PatientRepositoryDB {

    private static PatientRepositoryDB pRepositoryDB = null;

    public static Connection conn = null;
    public static Statement stmt = null;
    public static PreparedStatement pstmt = null;

    public static void main(String[] args) {

    }
    private PatientRepositoryDB() {
    }

    public static PatientRepositoryDB getpRepositoryDB() {
        if (pRepositoryDB == null) {
            pRepositoryDB = new PatientRepositoryDB();
        }
        return pRepositoryDB;
    }

    //static connection to DataBase.
    static {
        try {
            connectToDB();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }

    }

    //connection to DB

    public static void connectToDB() throws ClassNotFoundException, SQLException {
        Class.forName(JDBC_DRIVER);
        System.out.println("Connecting to database...");
        conn = DriverManager.getConnection(DB_URL, USER, PASS);
    }

    //Creating SCHEMA in Postgre
    public static void createDB() throws SQLException, NullPointerException {
        System.out.println("Create DataBase");
        String sql = CREATE_SCHEMA;
        stmt.executeUpdate(sql);
        System.out.println("DB was Created!");
    }

    //Create Table.
    public static void createTable() throws SQLException {
        System.out.println("Creating table Patients...");
        String sql = CREATE_TABLE;
        stmt.executeUpdate(sql);
        System.out.println("Table of patient was created");
    }

    //CRUD
    //Creating patient
    //++
    public static void create(String fName, String lName, String cEmail, String phoneNumber) throws SQLException {
        System.out.println("Adding patient to the table...");
        String sql = ADD_PATIENT;
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, fName);
        pstmt.setString(2, lName);
        pstmt.setString(3, cEmail);
        pstmt.setString(4, phoneNumber);
        pstmt.executeUpdate();
        System.out.println("Patient's name:" + fName + " " + lName + " was added");
    }
    //++
    public void create(Patient patient) throws SQLException {
        create(patient.getfName(), patient.getfName(), patient.getEmail(), patient.getPhoneNumber());
    }
    //++
    public List<Patient> getAllPatients() throws SQLException {
        stmt = conn.createStatement();
        String sql = GET_ALL;
        ResultSet rs = stmt.executeQuery(sql);
        printResultSet(rs);
        return convertToPatients(rs);
    }
    //++
    public Patient findByName(String name) throws SQLException {
        String sql = FIND_BY_NAME;
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        return convertToPatient(rs);
    }
    //++
    public Patient findBySurname(String surname) throws SQLException {
        String sql = FIND_BY_SURNAME;
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, surname);
        ResultSet rs = pstmt.executeQuery();
        return convertToPatient(rs);
    }
    //++
    public Patient findByID(Integer id) throws SQLException {

        String sql = FIND_BY_ID;
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        return convertToPatient(rs);
    }
//++
    public boolean delete(Integer id) throws SQLException{
        stmt = conn.createStatement();
        String sql = "DELETE FROM patients.patient WHERE id = "+id;
        return stmt.execute(sql);
    }
//++
    public boolean update(Patient patient)throws SQLException{
        stmt = conn.createStatement();
        String sql = "UPDATE patients.patient set \"fName\" = '"+patient.getfName()+"' , \"lName\" = '"+patient.getlName()+"' " +
                "WHERE id = "+patient.getId();
        return stmt.execute(sql);
    }


    //UTILS
    private List<Patient> convertToPatients(ResultSet rs) throws SQLException {
        List<Patient> patients = new ArrayList<Patient>();
        Patient patient;
        while (rs.next()) {
            patient = new Patient();
            patient.setId(rs.getInt("id"));
            patient.setfName(rs.getString("fName"));
            patient.setlName(rs.getString("lName"));
            patient.setEmail(rs.getString("cEmail"));
            patient.setPhoneNumber(rs.getString("phoneNumber"));
            System.out.println(patient);
            patients.add(patient);
        }
        return patients;
    }

    private Patient convertToPatient(ResultSet rs)throws SQLException{
        Patient patient = new Patient();
        printResultSet(rs);
        if (rs.next()){
            patient.setId(rs.getInt("id"));
            patient.setfName(rs.getString("fName"));
            patient.setlName(rs.getString("lName"));
            patient.setEmail(rs.getString("cEmail"));
            patient.setPhoneNumber(rs.getString("phoneNumber"));
        }
        System.out.println(patient);
        return patient;
    }
    //++
    private static void printResultSet(ResultSet rs) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("id");
            String fName = rs.getString("fName");
            String lName = rs.getString("lName");
            String cEmail = rs.getString("cEmail");
            String phoneNumber = rs.getString("phoneNumber");

            System.out.print("id: " + id);
            System.out.print(",name: " + fName);
            System.out.print(",Surname: " + lName);
            System.out.print(",Email: " + cEmail);
            System.out.println(",Phone number: " + phoneNumber);
        }
        rs.beforeFirst();
    }
}

//----------------------------------

  /*  public static void addPatient(String fName, String lName, String cEmail, String phoneNumber) throws SQLException {
    System.out.println("Adding patient to the table...");
    String sql = ADD_PATIENT;
    pstmt = conn.prepareStatement(sql);
    pstmt.setString(1, fName);
    pstmt.setString(2, lName);
    pstmt.setString(3, cEmail);
    pstmt.setString(4, phoneNumber);
    pstmt.executeUpdate();
    System.out.println("Patient's name:" + fName + " " + lName + " was added");
}

    public static void getAllPatients() throws SQLException {
        System.out.println("Searching for all patients!");
        stmt = conn.createStatement();
        String sql = GET_ALL;
        ResultSet rs = stmt.executeQuery(sql);
        printResultSet(rs);
        System.out.println("End of a list!");
    }

    public static void findByName(String name) throws SQLException {
        System.out.println("Search by name.");
        System.out.println("Search result: ");
        String sql = FIND_BY_NAME;
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, name);
        ResultSet rs = pstmt.executeQuery();
        printResultSet(rs);
    }

    public static void findBySurname(String surname) throws SQLException {
        System.out.println("Search by last name.");
        System.out.println("Search result: ");
        String sql = FIND_BY_SURNAME;
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, surname);
        ResultSet rs = pstmt.executeQuery();
        printResultSet(rs);
    }

    public static void findByID(Integer id) throws SQLException {
        System.out.println("Search by ID.");
        System.out.println("Search result: ");
        String sql = FIND_BY_ID;
        pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, id);
        ResultSet rs = pstmt.executeQuery();
        printResultSet(rs);
    }

    public static void findByNumber(String phoneNumber) throws SQLException {
        System.out.println("Search by phone number.");
        System.out.println("Search result: ");
        String sql = FIND_BY_PHONENUMBER;
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, phoneNumber);
        ResultSet rs = pstmt.executeQuery();
        printResultSet(rs);
    }


    private static void printResultSet(ResultSet rs) throws SQLException {
        while (rs.next()) {
            int id = rs.getInt("id");
            String fName = rs.getString("fName");
            String lName = rs.getString("lName");
            String cEmail = rs.getString("cEmail");
            String phoneNumber = rs.getString("phoneNumber");

            System.out.print("id: " + id);
            System.out.print(",name: " + fName);
            System.out.print(",Surname: " + lName);
            System.out.print(",Email: " + cEmail);
            System.out.println(",Phone number: " + phoneNumber);
        }
    }*/