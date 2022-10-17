package com.terminal.service;

public interface AbstractService {
    default String checkNull(String value) {
        return value == null ? "" : value.trim();
    }
}