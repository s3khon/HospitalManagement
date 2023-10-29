package com.codecool.test1.logic;

import com.codecool.test1.data.Appointment;
import com.codecool.test1.data.Doctor;
import com.codecool.test1.data.Patient;
import com.codecool.test1.data.Specialization;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class PatientServiceTest {

    @Test
    void getPatientsByDoctorSpecialization() {
        PatientService patientService = new PatientService();
        Doctor doctor1 = new Doctor(null, Specialization.INTERNAL,5);
        Doctor doctor2 = new Doctor(null, Specialization.SURGERY,5);
        Doctor doctor3 = new Doctor(null, Specialization.INTERNAL,5);
        Appointment appointment1 = new Appointment(0, LocalDate.of(2023,5,2),null,doctor1);
        Appointment appointment2 = new Appointment(0,LocalDate.of(2023,5,2),null,doctor2);
        Appointment appointment3= new Appointment(0,LocalDate.of(2023,4,2),null,doctor3);
        List<Appointment> appointments1 = List.of(appointment1,appointment3);
        List<Appointment> appointments2 = List.of(appointment2,appointment3);
        Patient patient1 = new Patient(0,null,null,appointments1);
        Patient patient2 = new Patient(0,null,null,appointments2);

        List<Patient> patients = List.of(patient1,patient2);
        List<Patient> expected = List.of(patient1);
        Specialization specialization = Specialization.INTERNAL;
        List<Patient> result = patientService.getPatientsByDoctorSpecialization(patients,specialization);

        assertEquals(expected,result);

    }

    @Test
    void getPatientWithMostAppointments() {
        PatientService patientService = new PatientService();
        Appointment appointment1 = new Appointment(0,LocalDate.of(2023,2,2),null,null);
        Appointment appointment2 = new Appointment(0,LocalDate.of(2023,5,2),null,null);
        Appointment appointment3 = new Appointment(0,LocalDate.of(2023,4,2),null,null);

        Patient patient1 = new Patient(0,null,null,List.of(appointment1,appointment2,appointment3));
        Patient patient2 = new Patient(0,null,null,List.of(appointment1,appointment2));

        List<Patient> patients = List.of(patient1,patient2);

        Patient expected = patient1;
        Patient result = patientService.getPatientWithMostAppointments(patients);
        assertEquals(expected,result);


    }
}