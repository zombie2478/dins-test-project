package com.dins.test.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class Post {
    @JsonProperty(required = true)
    private Integer userId;
    @JsonProperty(required = true)
    private Integer id;
    @JsonProperty(required = true)
    private String title;
    @JsonProperty(required = true)
    private String body;

}
