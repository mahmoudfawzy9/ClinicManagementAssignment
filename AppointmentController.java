package com.stc.appointment.controller;

import com.stc.appointment.entity.Appointment;
import com.stc.appointment.services.AppointmentService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class AppointmentController {
    AppointmentService appointmentService;

    public AppointmentController(AppointmentService appointmentService) {
        this.appointmentService = appointmentService;
    }

    //The function receives a GET request, processes it and gives back a list of Appointment as a response.
    @GetMapping
    public ResponseEntity<List<Appointment>> getAllappointments() {
        List<Appointment> appointments = appointmentService.getAppointments();
        return new ResponseEntity<>(appointments, HttpStatus.OK);
    }
    //The function receives a GET request, processes it, and gives back a list of Appointment as a response.
    @GetMapping({"/{appointmentId}"})
    public ResponseEntity<Appointment> getTodo(@PathVariable Long appointmentId) {
        return new ResponseEntity<>(appointmentService.getAppointmentById(appointmentId), HttpStatus.OK);
    }
    //The function receives a POST request, processes it, creates a new Appointment and saves it to the database, and returns a resource link to the created appointment.
    @PostMapping({"/{appointmentId}"})
    public ResponseEntity<Appointment> saveTodo(@RequestBody Appointment todo) {
        Appointment appointment1 = appointmentService.insert(todo);
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.add("appointment", "/api/v1/appointment/" + appointment1.getId().toString());
        return new ResponseEntity<>(appointment1, httpHeaders, HttpStatus.CREATED);
    }
    //The function receives a PUT request, updates the Appointment with the specified Id and returns the updated Appointment
    @PutMapping({"/{appointmentId}"})
    public ResponseEntity<Appointment> updateAppointment(@PathVariable("appointmentId") Long appointmentId, @RequestBody Appointment appointment) {
        appointmentService.updateAppointment(appointmentId, appointment);
        return new ResponseEntity<>(appointmentService.getAppointmentById(appointmentId), HttpStatus.OK);
    }
    //The function receives a DELETE request, deletes the Appointment with the specified Id.
    @DeleteMapping({"/{appointmentId}"})
    public ResponseEntity<Appointment> deleteTodo(@PathVariable("appointmentId") Long appointmentId) {
        appointmentService.deleteAppointment(appointmentId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
