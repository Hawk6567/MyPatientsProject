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

@WebServlet(value = "/read-patient")
public class ReadPatientController extends HttpServlet {

    private PatientRepositoryDB patientRepository;

    @Override
    public void init() throws ServletException {

        patientRepository = PatientRepositoryDB.getpRepositoryDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int patientId = Integer.parseInt(req.getParameter("id"));
        Patient patient = null;
        try {
            patient = patientRepository.findByID(patientId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        req.setAttribute("patient", patient);
        req.getRequestDispatcher("/WEB-INF/pages/read-patient.jsp").forward(req,resp);
    }
}
