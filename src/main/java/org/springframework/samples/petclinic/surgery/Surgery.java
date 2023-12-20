package org.springframework.samples.petclinic.surgery;

import java.time.LocalDate;
import java.util.Set;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.samples.petclinic.model.BaseEntity;
import org.springframework.samples.petclinic.vet.Vet;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Transient;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Entity
@Setter
public class Surgery extends BaseEntity {
    @NotNull
    @NotBlank
    @Size(min=3, max=50)
    String name;
    
    String description;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    @NotNull
    @Column(name="surgery_date")
    LocalDate date;
    
    @Transient
    Set<Vet> surgeryTeam;  
      
    @Transient
    OperatingRoom room;
}
