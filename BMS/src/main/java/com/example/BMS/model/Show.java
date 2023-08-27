package com.example.BMS.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "shows")
public class Show extends BaseModel{

    @ManyToOne
    private Movie movie;
    @ManyToOne
    private Screen screen;
    public LocalDateTime startTime;

    @ElementCollection
    @Enumerated(value = EnumType.ORDINAL)
    private List<Features> features;
}
