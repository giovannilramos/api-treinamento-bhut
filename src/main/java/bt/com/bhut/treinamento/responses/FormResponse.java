package bt.com.bhut.treinamento.responses;

import lombok.Data;

import java.util.List;

@Data
public class FormResponse {
    private String title;
    private List<FieldsResponse> fields;
}
