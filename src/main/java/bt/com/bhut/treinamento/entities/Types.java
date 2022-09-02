package bt.com.bhut.treinamento.entities;

import bt.com.bhut.treinamento.enums.TypesEnum;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TYPES")
@Data
@RequiredArgsConstructor
public class Types implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID uuid;
    @Column(nullable = false)
    private String type;
}
