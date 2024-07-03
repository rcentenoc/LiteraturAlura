package com.literaturalura.literaturalura.service;

public interface IConvertData {
    <T> T convertData(String json, Class<T> clazz);
}
