package bt.com.bhut.treinamento.responses;

import lombok.Data;

import java.util.UUID;

@Data
public class FieldsResponse {
    private UUID uuid;
    private String name;
    private String title;
    private String type;
}
