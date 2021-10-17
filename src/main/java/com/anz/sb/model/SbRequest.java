package com.anz.sb.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class SbRequest {
    @Valid
    @NotEmpty(message = "requestBlockList cannot be null or empty")
    @Size(max = 100, message = "Maximum of 100 blocks can be part of the request")
    private List<RequestBlock> requestBlockList;
}
