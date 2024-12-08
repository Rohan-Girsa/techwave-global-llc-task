package com.techwave.techwavegloballlc.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class StatusDescription {
    private Integer statusCode;
    private String statusMessage;
}
