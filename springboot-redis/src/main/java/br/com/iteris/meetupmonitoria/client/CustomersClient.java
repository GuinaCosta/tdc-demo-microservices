package br.com.iteris.meetupmonitoria.client;

import br.com.iteris.meetupmonitoria.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "CustomersClient", url = "${integration.client.customer.url}")
public interface CustomersClient {

    @GetMapping(value = "/v1/costumer/all", consumes = MediaType.ALL_VALUE)
    List<CustomerDto> listAllCustomers();
}
