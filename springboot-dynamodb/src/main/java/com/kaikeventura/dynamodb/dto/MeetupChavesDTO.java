package com.kaikeventura.dynamodb.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.kaikeventura.dynamodb.model.MeetupChaves;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class MeetupChavesDTO implements Serializable {

    private static final long serialVersionUID = 6318931228062100559L;

    @JsonProperty("id")
    @NotNull
    private Integer id;

    @JsonProperty("name")
    @NotNull
    @NotBlank
    private String name;

    @JsonProperty("city_code")
    @NotNull
    @NotBlank
    private String cityCode;

    @JsonProperty("likes_chocolate")
    @NotNull
    private Boolean likesChocolate;

    public MeetupChavesDTO( String name, String cityCode, Boolean likesChocolate) {
        this.name = name;
        this.cityCode = cityCode;
        this.likesChocolate = likesChocolate;
    }

    public MeetupChaves dtoToModel() {
        return new MeetupChaves(
            this.id,
            this.name,
            this.cityCode,
            this.likesChocolate
        );
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

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public Boolean getLikesChocolate() {
        return likesChocolate;
    }

    public void setLikesChocolate(Boolean likesChocolate) {
        this.likesChocolate = likesChocolate;
    }
}
