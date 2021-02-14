package com.hendisantika.springbootcrudcustomerrestapimysql.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-crud-customer-rest-api-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 15/02/21
 * Time: 05.54
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    @Size(min = 3, max = 50)
    private String name;

    @Column(name = "phone")
    @Size(min = 10, max = 30)
    private String phone;
}