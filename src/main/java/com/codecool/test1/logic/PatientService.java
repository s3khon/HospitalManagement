package com.codecool.test1.logic;

import com.codecool.test1.data.Patient;
import com.codecool.test1.data.Specialization;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.List;

public class PatientService {

    public List<Patient> getPatientsByDoctorSpecialization(List<Patient> patients, Specialization specialization) {


        return patients.stream()
                .filter(p -> p.appointments().stream()
                                .anyMatch(a -> a.date().isAfter(LocalDate.now())
                                        && a.doctor().specialization().equals(specialization))).toList();

    }

    public Patient getPatientWithMostAppointments(List<Patient> patients){

        return patients.stream().reduce((p1,p2)->
                p1.appointments().stream().filter(p -> ChronoUnit.DAYS.between(p.date(),LocalDate.now()) < 30 ).count() >
                        p2.appointments().stream().filter(p -> ChronoUnit.DAYS.between(p.date(),LocalDate.now()) < 30 ).count() ? p1 : p2).orElse(null);

    }
}