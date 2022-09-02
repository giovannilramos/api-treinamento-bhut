package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.entities.Form;
import bt.com.bhut.treinamento.repositories.FieldsRepository;
import bt.com.bhut.treinamento.requests.FormRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SaveFormService {
    private final SaveFieldsService saveFieldsService;
    private final FieldsRepository fieldsRepository;

    public void save(final FormRequest formRequest) {
        final var form = new Form();
        final var fieldsUuid = saveFieldsService.save(formRequest.getFields());
        final var fieldsList = fieldsUuid.stream().map(field -> fieldsRepository.findById(field).orElse(null)).collect(Collectors.toList());

        form.setTitle(formRequest.getTitle());
        form.setFields(fieldsList);
    }
}
