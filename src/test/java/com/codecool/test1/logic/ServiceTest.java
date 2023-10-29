package com.codecool.test1.logic;

import com.codecool.test1.data.Appointment;
import com.codecool.test1.data.Doctor;
import com.codecool.test1.data.Patient;
import com.codecool.test1.data.Specialization;
import org.junit.jupiter.api.Test;

import javax.print.Doc;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ServiceTest {

    @Test
    void getPatientsWithFutureAppointments() {
        Service service = new Service();
        Doctor doctor1 = new Doctor(null, Specialization.INTERNAL,0);
        Doctor doctor2 = new Doctor(null, Specialization.SURGERY,0);
        Appointment appointment1 =new Appointment(0, LocalDate.now().plusDays(3),null,doctor1);
        Appointment appointment2 =new Appointment(0, LocalDate.now().plusDays(3),null,doctor2);
        Appointment appointment3 =new Appointment(0, LocalDate.now().minusDays(3),null,doctor1);
        Patient patient1 = new Patient(0,null,null, List.of(appointment1));
        Patient patient2= new Patient(0,null,null, List.of(appointment2));
        Patient patient3 = new Patient(0,null,null, List.of(appointment3));
        List<Patient> patients = List.of(patient1,patient2,patient3);
        List<Patient> expected = List.of(patient1);
        Specialization specialization = Specialization.INTERNAL;
        List<Patient> result = service.getPatientsWithFutureAppointments(patients,specialization);
        assertEquals(expected,result);



    }

    @Test
    void getPatientWithMostAppointment() {
        Service service = new Service();
        Appointment appointment1 = new Appointment(0,LocalDate.now().minusDays(31),null,null);
        Appointment appointment2 = new Appointment(0,LocalDate.now().minusDays(29),null,null);
        Appointment appointment3 = new Appointment(0,LocalDate.now().minusDays(28),null,null);

        Patient patient1 = new Patient(0,null,null,List.of(appointment2,appointment3));
        Patient patient2 = new Patient(0,null,null,List.of(appointment1,appointment2));
        List<Patient> patients = List.of(patient1,patient2);
        Patient expected = patient1;
        Patient result = service.getPatientWithMostAppointment(patients);
        assertEquals(expected,result);



    }

    @Test
    void getDoctorWithMostExperience() {
        Service service = new Service();
        Doctor doctor1 = new Doctor(null,null,5);
        Doctor doctor2 = new Doctor(null,null,4);
        Doctor doctor3 = new Doctor(null,null,3);
        List<Doctor> doctors = List.of(doctor1,doctor2,doctor3);
        Doctor expected = doctor1;
        Doctor result = service.getDoctorWithMostExperience(doctors);
        assertEquals(expected,result);

    }
}