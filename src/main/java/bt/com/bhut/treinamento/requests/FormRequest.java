package bt.com.bhut.treinamento.requests;

import lombok.Data;

import java.util.List;

@Data
public class FormRequest {
    private String title;
    private List<FieldsRequest> fields;
}
