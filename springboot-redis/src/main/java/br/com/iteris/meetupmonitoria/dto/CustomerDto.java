package br.com.iteris.meetupmonitoria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomerDto {
    private String name;
    private String city_code;
    private Boolean likes_chocolate;

}
