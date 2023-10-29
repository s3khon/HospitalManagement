package com.codecool.test1.logic;

import com.codecool.test1.data.Doctor;
import org.junit.jupiter.api.Test;

import javax.print.Doc;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class DoctorServiceTest {

    @Test
    void getDoctorWithMostExperience() {
        DoctorService doctorService = new DoctorService();
        Doctor doctor1 = new Doctor(null,null,3);
        Doctor doctor2 = new Doctor(null,null,5);
        Doctor doctor3 = new Doctor(null,null,8);
        List<Doctor> doctors = List.of(doctor1,doctor2,doctor3);
        Doctor expected = doctor3;
        Doctor result = doctorService.getDoctorWithMostExperience(doctors);
        assertEquals(expected,result);
    }
}