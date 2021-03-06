package kr.co.hohocompany.uahage.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
public class ResponseBodyForm {
    private String message;
    private Object data;

    @Builder
    public ResponseBodyForm(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
