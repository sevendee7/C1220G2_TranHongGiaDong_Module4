package com.codegym.model.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Integer id;

    @Pattern(regexp = "^(KH-)\\d{4}$",
            message = "Customer's code incorrect ! ( ex : KH-1234 ) ")
    @Column(name = "customer_code", nullable = false)
    private String customerCode;

    @NotBlank(message = "Can't not empty")
    @Size(min = 5,max = 45,message = "From 5 to 45 characters")
    @Column(name = "name", nullable = false)
    private String name;

    @NotBlank(message = "Can't not empty")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    @Column(name = "birthday", nullable = false, columnDefinition = "date")
    private String birthday;

    @Column(name = "gender", nullable = false)
    private Boolean gender;

    @NotEmpty(message = "ID CARD can not empty")
    @Pattern(regexp = "^\\d{9}$" , message = "(ID Card must be 9 digit number XXXXXXXXX)")
    @Column(name = "id_card", nullable = false)
    private String idCard;

    @NotEmpty(message = "Phone number can not empty")
    @Pattern(regexp = "^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$",message = "(ex 090xxxxxxx or 091xxxxxxx or (+84)90xxxxxxx or (+84)91xxxxxxx)")
    @Column(name = "customer_phone", nullable = false)
    private String phone;

    @NotEmpty(message = "Email can not empty")
    @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z]{2,}(\\.[a-z]{2,4}){1,2}$",
            message = "Email not valid ( ex : abc@abc.abc) ")
    @Column(unique = true)
    private String email;

    private String address;

    @ManyToOne
    @JoinColumn(name = "customer_type_id")
    private CustomerType customerType;

    @OneToMany(mappedBy = "customer",cascade = CascadeType.ALL)
    private Set<Contract> contracts;

    public Customer() {
    }

    public Customer(@Pattern(regexp = "^(KH-)\\d{4}$",
            message = "Customer's code incorrect ! ( ex : KH-1234 ) ") String customerCode, @NotBlank(message = "Can't not empty") @Size(min = 5, max = 45, message = "From 5 to 45 characters") String name, @NotBlank(message = "Can't not empty") String birthday, Boolean gender, @NotEmpty(message = "ID CARD can not empty") @Pattern(regexp = "^\\d{9}$", message = "(ID Card must be 9 digit number XXXXXXXXX)") String idCard, @NotEmpty(message = "Phone number can not empty") @Pattern(regexp = "^(090|091|\\(\\+84\\)90|\\(\\+84\\)91)\\d{7}$", message = "(ex 090xxxxxxx or 091xxxxxxx or (+84)90xxxxxxx or (+84)91xxxxxxx)") String phone, @NotEmpty(message = "Email can not empty") @Pattern(regexp = "^[a-z][a-z0-9_\\.]{5,32}@[a-z]{2,}(\\.[a-z]{2,4}){1,2}$",
            message = "Email not valid ( ex : abc@abc.abc) ") String email, String address, CustomerType customerType, Set<Contract> contracts) {
        this.customerCode = customerCode;
        this.name = name;
        this.birthday = birthday;
        this.gender = gender;
        this.idCard = idCard;
        this.phone = phone;
        this.email = email;
        this.address = address;
        this.customerType = customerType;
        this.contracts = contracts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
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

    public Boolean getGender() {
        return gender;
    }

    public void setGender(Boolean gender) {
        this.gender = gender;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
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

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
        this.customerType = customerType;
    }

    public Set<Contract> getContracts() {
        return contracts;
    }

    public void setContracts(Set<Contract> contracts) {
        this.contracts = contracts;
    }
}
