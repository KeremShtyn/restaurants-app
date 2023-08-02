package com.example.pizzarestaurants.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

@SQLDelete(sql = "UPDATE Restaurant SET DELETED_AT = CURRENT_TIMESTAMP WHERE id =? and version =? ")
@Where(clause = "DELETED_DATE is null")
@Entity(name = "Restaurant")
@Table(name= "Restaurant", indexes = {@Index(columnList = "ID", name = "id_indx")}, uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
@Data
@EqualsAndHashCode(callSuper = false)
@ToString(callSuper = true)
public class Restaurant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "ID", nullable = false)
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "LATITUDE")
    private double latitude;

    @Column(name = "LONGITUDE")
    private double longitude;

    @Column(name = "DISTANCE")
    private double distance;

}
