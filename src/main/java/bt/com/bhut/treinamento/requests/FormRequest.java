package bt.com.bhut.treinamento.requests;

import bt.com.bhut.treinamento.entities.Fields;
import lombok.Data;

import java.util.List;

@Data
public class FormRequest {
    private String title;
    private List<Fields> fields;
}
