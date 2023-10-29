package com.codecool.test1.data;

import javax.print.Doc;
import java.time.LocalDate;
import java.time.LocalTime;

public record Appointment(int id, LocalDate date, LocalTime time, Doctor doctor) {
}
