package com.literaturalura.literaturalura.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ConvertData implements IConvertData {

    private ObjectMapper objectMapper = new ObjectMapper();

    // private ObjectMapper objectMapper;

    // public ConvertData() {
    // this.objectMapper = new ObjectMapper();
    // }

    @Override
    public <T> T convertData(String json, Class<T> clazz) {
        try {
            return objectMapper.readValue(json, clazz);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
    }
}
