package com.example.util;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.Data;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "result",
        "status",
        "traceId"
})
@Data
public class CustomApiResponse<T> {

    @JsonProperty("result")
    private T result;
    
    @JsonProperty("status")
    private Integer status;
    
    @JsonProperty("total")
    private Long total;
    
    @JsonProperty("from")
    private Integer from;
    
    @JsonProperty("size")
    private Integer size;
        
    private Long successCount;
    
    private Long failedCount;
    
    public CustomApiResponse() {}

    public CustomApiResponse(T result, Integer status) {
        this.result = result;
        this.status = status;
    }

}

