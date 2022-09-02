package bt.com.bhut.treinamento.controllers;


import bt.com.bhut.treinamento.requests.FormRequest;
import bt.com.bhut.treinamento.services.SaveFormService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/form")
@CrossOrigin(origins = "*", maxAge = 3600)
@RequiredArgsConstructor
public class FormController {
    private final SaveFormService saveFormService;

    @PostMapping
    public ResponseEntity<Void> createForm(@RequestBody final FormRequest formRequest) {
        saveFormService.save(formRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
}
