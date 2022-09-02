package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.repositories.FieldsRepository;
import bt.com.bhut.treinamento.responses.FieldsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListFieldsService {
    private final FieldsRepository fieldsRepository;

    public List<FieldsResponse> listAllFields() {

        final var fieldList = fieldsRepository.findAll();
        if (fieldList.size() > 0) {
            return fieldList.stream().map(fields -> {
                final var fieldResponse = new FieldsResponse();
                fieldResponse.setUuid(fields.getUuid());
                fieldResponse.setName(fields.getName());
                fieldResponse.setTitle(fields.getTitle());
                fieldResponse.setType(fields.getType().getType());
                return fieldResponse;
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
