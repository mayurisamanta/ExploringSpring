package com.springboot.nestedquery.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Account {

    @Id
    private String id;

    private String opportunityId;
}
