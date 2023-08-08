package com.springboot.nestedquery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class State {

    @Id
    private String id;

    private String opportunityId;
}
