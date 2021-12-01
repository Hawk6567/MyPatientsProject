package learn.home.controller;

import learn.home.model.Patient;
import learn.home.repository.PatientRepositoryDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(value = "/create-patient")
public class CreatePatientController extends HttpServlet  {
    private PatientRepositoryDB patientRepository;

    @Override
    public void init(){

        patientRepository = PatientRepositoryDB.getpRepositoryDB();
    }


    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/create-patient.jsp");
        requestDispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String cEmail = req.getParameter("cEmail");
        String phoneNumber = req.getParameter("phoneNumber");
        Patient patient = new Patient(fName,lName,cEmail,phoneNumber);
        try {
            patientRepository.create(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/patients-list");
    }
}
