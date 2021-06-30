package me.studybook.dto;

import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
public class ResponseData {
    private String message;
    private Object data;

    @Builder
    public ResponseData(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
