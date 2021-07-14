package com.codegym.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "service")
public class Service {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "service_id")
    private Integer id;

    @Column(name = "service_code", nullable = false)
    private String serviceCode;

    @Column(name = "name", nullable = false)
    private String name;

    private Double area;

    @Column(name = "cost", nullable = false)
    private Double cost;

    private Integer capacity;

    @Column(name = "room_standard")
    private String roomStandard;

    @Column(name = "room_amenity")
    private String roomAmenity;

    @Column(name = "pool_area")
    private Double poolArea;

    @Column(name = "number_of_floors")
    private Integer numberOfFloors;

    @ManyToOne
    @JoinColumn(name = "rent_type_id")
    private RentType rentType;

    @ManyToOne
    @JoinColumn(name = "service_type_id")
    private ServiceType serviceType;

    public Service() {
    }

    public Service(String serviceCode, String name, Double area, Double cost, Integer capacity, String roomStandard, String roomAmenity, Double poolArea, Integer numberOfFloors, RentType rentType, ServiceType serviceType) {
        this.name = name;
        this.area = area;
        this.cost = cost;
        this.capacity = capacity;
        this.roomStandard = roomStandard;
        this.roomAmenity = roomAmenity;
        this.poolArea = poolArea;
        this.numberOfFloors = numberOfFloors;
        this.rentType = rentType;
        this.serviceType = serviceType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getArea() {
        return area;
    }

    public void setArea(Double area) {
        this.area = area;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getCapacity() {
        return capacity;
    }

    public String getServiceCode() {
        return serviceCode;
    }

    public void setServiceCode(String serviceCode) {
        this.serviceCode = serviceCode;
    }

    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getRoomAmenity() {
        return roomAmenity;
    }

    public void setRoomAmenity(String roomAmenity) {
        this.roomAmenity = roomAmenity;
    }

    public Double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(Double poolArea) {
        this.poolArea = poolArea;
    }

    public Integer getNumberOfFloors() {
        return numberOfFloors;
    }

    public void setNumberOfFloors(Integer numberOfFloors) {
        this.numberOfFloors = numberOfFloors;
    }

    public RentType getRentType() {
        return rentType;
    }

    public void setRentType(RentType rentType) {
        this.rentType = rentType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceTypes(ServiceType serviceType) {
        this.serviceType = serviceType;
    }
}
