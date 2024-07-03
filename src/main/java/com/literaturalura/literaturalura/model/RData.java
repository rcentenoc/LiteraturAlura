package com.literaturalura.literaturalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RData(
        @JsonAlias("count") int totalBooks,
        @JsonAlias("results") List<RBooks> data) {

}
