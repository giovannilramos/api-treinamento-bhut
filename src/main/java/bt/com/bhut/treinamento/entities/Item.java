package bt.com.bhut.treinamento.entities;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@AllArgsConstructor
public class Item {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Integer quantity;
    @Column(nullable = false)
    private Double price;

    @ManyToOne
    private Purchase purchase;

    @OneToOne
    private Car car;

    public Item() {

    }
}
