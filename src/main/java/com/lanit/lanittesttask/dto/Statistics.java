package com.lanit.lanittesttask.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Statistics {
    @JsonProperty("personcount")
    private long personCount;
    @JsonProperty("carcount")
    private long carCount;
    @JsonProperty("uniquevendorcount")
    private long uniqueVendorCount;
}
