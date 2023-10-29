package com.codecool.test1.data;

import java.time.LocalDate;
import java.util.List;

public record Patient(int id, String name, LocalDate birthday, List<Appointment> appointments) {
}
