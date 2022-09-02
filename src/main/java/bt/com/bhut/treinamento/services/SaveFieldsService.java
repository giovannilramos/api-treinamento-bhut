package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Fields;
import bt.com.bhut.treinamento.repositories.FieldsRepository;
import bt.com.bhut.treinamento.repositories.TypesRepository;
import bt.com.bhut.treinamento.requests.FieldsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class SaveFieldsService {
    private final FieldsRepository fieldsRepository;
    private final TypesRepository typesRepository;

    public void save(final List<FieldsRequest> fieldsRequestList) {
        if (fieldsRequestList.size() > 0) {
            fieldsRequestList.forEach(fieldsRequest -> {
                final var field = new Fields();
                field.setName(fieldsRequest.getName());
                field.setDescription(fieldsRequest.getDescription());
                field.setTitle(fieldsRequest.getTitle());
                field.setType(typesRepository.getById(UUID.fromString(fieldsRequest.getType())));
                fieldsRepository.save(field);
            });
        }
    }
}
