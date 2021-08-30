package com.stc.appointment.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author mahmoud
 */

@Entity
@Table(name = "allergy")
@Data
public class Allergy {

    @Id
    @Column(name = "patient_id")
    private Long patientId;

    @Id
    @Column(name = "allergy_type")
    private String allergyType;

    public Allergy(Long patientId, String allergyType) {
        this.patientId = patientId;
        this.allergyType = allergyType;
    }
}
