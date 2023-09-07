package ra.springbanhang.model.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "Catagorys")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Catagory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "CatagoryName", length = 50)
    private String catagoryName;
}
