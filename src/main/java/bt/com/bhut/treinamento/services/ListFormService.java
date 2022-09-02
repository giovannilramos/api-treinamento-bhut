package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.repositories.FormRepository;
import bt.com.bhut.treinamento.responses.FieldsResponse;
import bt.com.bhut.treinamento.responses.FormResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListFormService {
    private final FormRepository formRepository;

    public List<FormResponse> listForms() {
        final var formList = formRepository.findAll();
        if (formList.size() > 0) {
            return formList.stream().map(form -> {
                final var formResponse = new FormResponse();

                formResponse.setTitle(form.getTitle());
                formResponse.setFields(
                        form.getFields().stream().map(fields -> {
                            final var fieldsResponse = new FieldsResponse();

                            fieldsResponse.setUuid(fields.getUuid());
                            fieldsResponse.setName(fields.getName());
                            fieldsResponse.setTitle(fields.getTitle());
                            fieldsResponse.setType(fields.getType().getType());

                            return fieldsResponse;
                        }).collect(Collectors.toList())
                );

                return formResponse;
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
