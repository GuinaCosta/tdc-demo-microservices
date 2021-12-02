package br.com.iteris.meetupmonitoria.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "SalesClient", url = "${integration.client.sales.url}")
public interface SalesClient {

    @GetMapping(value = "/cotacoes/{currencyCode}", consumes = MediaType.ALL_VALUE)
    String getCurrencyPrice(@PathVariable("currencyCode") String currencyCode);
}
