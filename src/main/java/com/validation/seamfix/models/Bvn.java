package com.validation.seamfix.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Bvn {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//
//    @PrimaryKey
//    @CassandraType(type = CassandraType.Name.UUID)
//    private UUID uid = UUID.randomUUID();

    private String bvn;
}
