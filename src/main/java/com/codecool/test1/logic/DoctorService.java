package com.codecool.test1.logic;

import com.codecool.test1.data.Appointment;
import com.codecool.test1.data.Doctor;
import com.codecool.test1.data.Patient;
import com.codecool.test1.data.Specialization;

import java.time.LocalDate;
import java.util.List;

public class DoctorService {

    public Doctor getDoctorWithMostExperience(List<Doctor> doctors){
        return doctors.stream().reduce((d1,d2)-> d1.experience() > d2.experience() ? d1 : d2).orElse(null);
    }

}