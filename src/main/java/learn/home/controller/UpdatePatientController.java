package learn.home.controller;

import learn.home.model.Patient;
import learn.home.repository.PatientRepositoryDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/edit-patient")
public class UpdatePatientController extends HttpServlet {

    private PatientRepositoryDB patientRepository;
    private Patient patient;

    @Override
    public void init()throws ServletException {
        patientRepository = PatientRepositoryDB.getpRepositoryDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int patientId = Integer.parseInt(req.getParameter("id"));
        try {
            patient = patientRepository.findByID(patientId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("patient",patient);
        req.getRequestDispatcher("/WEB-INF/pages/edit-patient.jsp").forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        patient.setfName(req.getParameter("fName"));
        patient.setlName(req.getParameter("lName"));
        patient.setEmail(req.getParameter("cEmail"));
        patient.setPhoneNumber(req.getParameter("phoneNumber"));
        try {
            patientRepository.update(patient);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/patients-list");
    }
}
