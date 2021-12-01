package learn.home.controller;

import learn.home.repository.PatientRepositoryDB;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


@WebServlet("/patients-list")
public class PatientsListController extends HttpServlet {

    private PatientRepositoryDB patientRepository;

    @Override
    public void init() throws ServletException {
        patientRepository = PatientRepositoryDB.getpRepositoryDB();
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/WEB-INF/pages/patients-list.jsp");

        try {
            req.setAttribute("patients", patientRepository.getAllPatients());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        requestDispatcher.forward(req, resp);

    }
}
