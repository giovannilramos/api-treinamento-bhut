package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Fields;
import bt.com.bhut.treinamento.repositories.FieldsRepository;
import bt.com.bhut.treinamento.repositories.TypesRepository;
import bt.com.bhut.treinamento.requests.FieldsRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaveFieldsService {
    private final FieldsRepository fieldsRepository;
    private final TypesRepository typesRepository;

    public List<UUID> save(final List<FieldsRequest> fieldsRequestList) {
        if (fieldsRequestList.size() > 0) {
            return fieldsRequestList.stream().map(fieldsRequest -> {
                final var field = new Fields();
                field.setName(fieldsRequest.getName());
                field.setDescription(fieldsRequest.getDescription());
                field.setTitle(fieldsRequest.getTitle());
                field.setType(typesRepository.getById(UUID.fromString(fieldsRequest.getType())));
                fieldsRepository.save(field);
                return field.getUuid();
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
