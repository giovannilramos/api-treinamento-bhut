package bt.com.bhut.treinamento.services;

import bt.com.bhut.treinamento.repositories.TypesRepository;
import bt.com.bhut.treinamento.responses.TypesResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ListTypesService {
    private final TypesRepository typesRepository;
    public List<TypesResponse> listTypes() {
        final var listFields = typesRepository.findAll();
        if (listFields.size() > 0) {
            return listFields.stream().map(types -> {
                final var typesResponse = new TypesResponse();
                typesResponse.setTypes(types.getType());
                typesResponse.setUuid(types.getUuid());
                return typesResponse;
            }).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }
}
