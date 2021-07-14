package com.codegym.model.entity;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id")
    private Integer id;

    @NotBlank(message = "Can't not empty")
    @Size(min = 5,max = 45,message = "From 5 to 45 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @DateTimeFormat(pattern = "dd/mm/yyyy")
//    @Past
    @Column(name = "birthday", columnDefinition = "Date", nullable = false)
    private String birthday;

    @NotEmpty(message = "ID CARD can not empty")
    @Pattern(regexp = "^\\d{9}$" , message = "(ID Card must be 9 digit number XXXXXXXXX)")
    @Column(name = "id_card", nullable = false)
    private String idCard;

    @NumberFormat(pattern = "#.##")
//    @Pattern(regexp = "^\\d*.\\d*$")
    @Column(name = "salary", nullable = false)
    private Double salary;

    @NotEmpty(message = "Phone number can not empty")
    @Pattern(regexp = "^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$",message = "(ex 090xxxxxxx or 091xxxxxxx or (+84)90xxxxxxx or (+84)91xxxxxxx)")
    @Column(name = "phone", nullable = false)
    private String phone;

    @NotEmpty(message = "Email can not empty")
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z]{2,}(\\.[a-z]{2,4}){1,2}$",
            message = "Email not valid ( ex : abc@abc.abc) ")
    private String email;

    private String address;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @ManyToOne
    @JoinColumn(name = "education_background_id")
    private EducationBackground educationBackground;

    @ManyToOne
    @JoinColumn(name = "department_id")
    private Department department;

    @OneToMany(mappedBy = "employee")
    private Set<Contract> contracts;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;

    public Employee() {
    }

    public Employee(@NotBlank(message = "Can't not empty") @Size(min = 5, max = 45, message = "From 5 to 45 characters") String name, String birthday, @NotEmpty(message = "ID CARD can not empty") @Pattern(regexp = "^\\d{9}$", message = "(ID Card must be 9 digit number XXXXXXXXX)") String idCard, Double salary, @NotEmpty(message = "Phone number can not empty") @Pattern(regexp = "^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$", message = "(ex 090xxxxxxx or 091xxxxxxx or (+84)90xxxxxxx or (+84)91xxxxxxx)") String phone, @NotEmpty(message = "Email can not empty") @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z]{2,}(\\.[a-z]{2,4}){1,2}$",
            message = "Email not valid ( ex : abc@abc.abc) ") String email, String address, Position position, EducationBackground educationBackground, Department department, Set<Contract> contracts, User user) {
        this.name = name;
        this.birthday = birthday;
        this.idCard = idCard;
        this.salary = salary;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.position = position;
        this.educationBackground = educationBackground;
        this.department = department;
        this.contracts = contracts;
        this.user = user;
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

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public EducationBackground getEducationBackground() {
        return educationBackground;
    }

    public void setEducationBackground(EducationBackground educationBackground) {
        this.educationBackground = educationBackground;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
