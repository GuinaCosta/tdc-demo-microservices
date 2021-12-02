package br.com.iteris.meetupmonitoria.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserSalesDto extends UserDto {

    private String price;
}
