package com.Inheritance.Mapping.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ContractEmployee extends Employee{

    private Integer wages_per_hour;

    private Integer hours_worked;
}
