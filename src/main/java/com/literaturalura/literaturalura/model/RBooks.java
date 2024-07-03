package com.literaturalura.literaturalura.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RBooks(
                @JsonAlias("title") String titleOfBook,
                @JsonAlias("authors") List<RAuthor> author,
                @JsonAlias("languages") List<String> language,
                @JsonAlias("download_count") Double downloadCount,
                @JsonAlias("subjects") List<String> subjects,
                @JsonAlias("bookshelves") List<String> bookshelves) {
}