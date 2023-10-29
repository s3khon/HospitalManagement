package com.codecool.test1.logic;

import com.codecool.test1.data.Doctor;
import com.codecool.test1.data.Patient;
import com.codecool.test1.data.Specialization;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class Service {

    public List<Patient> getPatientsWithFutureAppointments(List<Patient> patients, Specialization specialization){
        return patients.stream()
                .filter( p -> p.appointments().stream()
                        .anyMatch(a ->a.doctor().specialization().equals(specialization) && a.date().isAfter(LocalDate.now()))).toList();
    }

    public Patient getPatientWithMostAppointment(List<Patient> patients){
     return patients.stream().reduce((p1,p2)->
             p1.appointments().stream().filter( a -> ChronoUnit.DAYS.between(a.date(),LocalDate.now())< 30).count() >
             p2.appointments().stream().filter( a-> ChronoUnit.DAYS.between(a.date(),LocalDate.now()) < 30).count()? p1 : p2).orElse(null);
    }

    public Doctor getDoctorWithMostExperience(List<Doctor> doctors){

     return doctors.stream().reduce((d1,d2)-> d1.experience() > d2.experience() ? d1 : d2).orElse(null);
    }

}
