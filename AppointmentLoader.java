package com.stc.appointment.bootstrap;

import com.stc.appointment.dao.AppointmentRepository;
import com.stc.appointment.entity.Appointment;
import com.stc.appointment.entity.enums.AppointmentStatus;
import org.springframework.boot.CommandLineRunner;

public class AppointmentLoader implements CommandLineRunner {

    public final AppointmentRepository appointmentRepository;

    public AppointmentLoader(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        loadAppointments();
    }

    private void loadAppointments() {
        if (appointmentRepository.count() == 0) {
            appointmentRepository.save(
                    Appointment.builder()
                            .title("Go to doctor")
                            .description("Get some medicine")
                            .appointmentStatus(AppointmentStatus.NOT_COMPLETED)
                            .build()
            );
            appointmentRepository.save(
                    Appointment.builder()
                            .title("Go to clinic 14")
                            .description("Complete treatment")
                            .appointmentStatus(AppointmentStatus.NOT_COMPLETED)
                            .build()
            );
            System.out.println("Sample Appointments Loaded");
        }
    }
}