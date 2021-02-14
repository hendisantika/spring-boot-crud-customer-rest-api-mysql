package com.hendisantika.springbootcrudcustomerrestapimysql.repository;

import com.hendisantika.springbootcrudcustomerrestapimysql.entity.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by IntelliJ IDEA.
 * Project : spring-boot-crud-customer-rest-api-mysql
 * User: hendisantika
 * Email: hendisantika@gmail.com
 * Telegram : @hendisantika34
 * Date: 15/02/21
 * Time: 05.56
 */
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
}
