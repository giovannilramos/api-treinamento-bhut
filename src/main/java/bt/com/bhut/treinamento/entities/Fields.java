package bt.com.bhut.treinamento.entities;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "FIELDS")
@Data
@RequiredArgsConstructor
public class Fields implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Type(type = "uuid-char")
    private UUID uuid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String title;
    private String description;

    @ManyToOne(optional = false)
    private Types type;
}
