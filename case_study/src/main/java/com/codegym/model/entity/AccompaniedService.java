package com.codegym.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "accompanied_service")
public class AccompaniedService {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "accompanied_service_id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    private Double cost;
    private Integer unit;
    private String status;

    @OneToMany(mappedBy = "accompaniedService",cascade = CascadeType.ALL)
    private Set<ContractDetail> contractDetails;

    public AccompaniedService() {
    }

    public AccompaniedService(String name, Double cost, Integer unit, String status, Set<ContractDetail> contractDetails) {
        this.name = name;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.contractDetails = contractDetails;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public Integer getUnit() {
        return unit;
    }

    public void setUnit(Integer unit) {
        this.unit = unit;
    }

    public Set<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(Set<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
