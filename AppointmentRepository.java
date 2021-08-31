package com.stc.appointment.dao;

import com.stc.appointment.entity.Appointment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestParam;

@CrossOrigin("http://localhost:4200")
@Repository
public interface AppointmentRepository extends CrudRepository<Appointment, Long> {
    
    @Query("SELECT a FROM Appointment a WHERE a.name LIKE %?1%")
    public List<Appointment> findAll(String keyword);

    Page<Appointment> findByAppointmentId(@RequestParam("id") Long id, Pageable pageable);

    Page<Appointment> findByNameContaining(@RequestParam("name") String name, Pageable pageable);
}
