package com.vinickiy.breweryclient.client;

import com.vinickiy.breweryclient.web.model.CustomerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.net.URI;
import java.util.UUID;
import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
class CustomerClientTest {

    @Autowired
    CustomerClient customerClient;


    @Test
    void getCustomer() {
      CustomerDto customerDto = customerClient.getCustomer(UUID.randomUUID());
      assertNotNull(customerDto);
    }

    @Test
    void saveNewCustomer() {
        CustomerDto savedCustomerDto = CustomerDto.builder().name("Rich customer").build();
        URI testCreatedURI = customerClient.saveNewCustomer(savedCustomerDto);
        assertNotNull(testCreatedURI.toString());
        System.out.println(testCreatedURI.toString());
    }

    @Test
    void updateCustomer() {
        CustomerDto savedCustomerDto = CustomerDto.builder().name("Updated customer").build();
        customerClient.updateCustomer(UUID.randomUUID(), savedCustomerDto );

    }

    @Test
    void deleteCustomer() {
        customerClient.deleteCustomer(UUID.randomUUID());
    }
}