package main;

import learn.home.model.Patient;
import learn.home.repository.PatientRepositoryDB;

import java.sql.SQLException;

public class Appl {
    public static void main(String[] args) throws SQLException {
        PatientRepositoryDB patientRepository = PatientRepositoryDB.getpRepositoryDB();

            patientRepository.create("Olena","Invsteasd","Invwq@gmail.com","02123112421");

        System.out.println(patientRepository.getAllPatients());
    }
}
