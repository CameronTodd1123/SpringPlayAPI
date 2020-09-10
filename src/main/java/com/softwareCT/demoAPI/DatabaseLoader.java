package com.softwareCT.demoAPI;

import com.softwareCT.demoAPI.model.Employee;
import com.softwareCT.demoAPI.model.Order;
import com.softwareCT.demoAPI.model.Status;
import com.softwareCT.demoAPI.repository.EmployeeRepository;
import com.softwareCT.demoAPI.repository.OrderRepository;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;


@Component
public class DatabaseLoader implements CommandLineRunner {

    private final EmployeeRepository employeeRepository;
    private final OrderRepository orderRepository;
    private static final Logger log = LoggerFactory.getLogger(DatabaseLoader.class);

    @Autowired
    public DatabaseLoader(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        this.employeeRepository = employeeRepository;
        this.orderRepository= orderRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        log.info("Clearing DB ");
        this.employeeRepository.deleteAll();
        log.info("Preloading " + this.employeeRepository.save(new Employee("Frodo", "Baggins", "ring bearer")));
        log.info("Preloading " + this.employeeRepository.save(new Employee("Cam", "Todd", "developer")));

        log.info("Preloading " + this.orderRepository.save(new Order("test description", Status.IN_PROGRESS)));

    }

}
