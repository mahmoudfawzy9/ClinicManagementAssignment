package com.stc.appointment.entity;

import com.stc.appointment.entity.enums.Gender;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import java.sql.Timestamp;

import javax.persistence.*;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "appointment")
@Data
public class Patient {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "patient_id", updatable = false, nullable = true)
    private Long id;

    @Column(name = "title", length = 5)
    private String title;

    @Basic(optional = false)
    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;

    @Column(name = "middle_name", length = 100)
    private String middleName;

    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;

    @Column(name = "pps_number", length = 100, nullable = false, unique = true)
    private String ppsNumber;

    @Column(name = "DATE_OF_BIRTH", nullable = false)
//    @Convert(converter = LocalDateAttributeConverter.class)
//    @XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate dateOfBirth;

    @Enumerated(EnumType.STRING)
    @Column(name = "GENDER", nullable = false, length = 6)
    private Gender gender;

    @Column(name = "EMAIL", length = 255)
    private String email;

    @Column(name = "MOBILE_PHONE", nullable = false, length = 50)
    private String mobilePhone;

    @Column(name = "HOME_PHONE", length = 50)
    private String homePhone;

    @Column(name = "NEXT_OF_KIN_NAME", nullable = false, length = 200)
    private String nextOfKinName;

    @Column(name = "NEXT_OF_KIN_CONTACT", nullable = false, length = 100)
    private String nextOfKinContact;

    @Column(name = "CREATED_AT")
    @CreationTimestamp
    private Timestamp createdAt;

    @Column(name = "UPDATED_AT")
    @UpdateTimestamp
    private Timestamp updatedAt;

//    @OneToMany(cascade = CascadeType.ALL)
//    @JoinColumn(name = "pPATIENT_ID", referencedColumnName = "PATIENT_ID", nullable = true, updatable = true, insertable = true)
//    private List<Allergy> allergyCollection;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "patient_id", referencedColumnName = "patient_id", nullable = true, updatable = true, insertable = true)
    private List<Appointment> appointmentCollection;

    //to be done later
//    @OneToOne(mappedBy = "patient", cascade = CascadeType.ALL)
//    private PatientAddress patientAddress;
}
