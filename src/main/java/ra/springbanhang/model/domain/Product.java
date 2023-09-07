package ra.springbanhang.model.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "Products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long productId;
    @Column(name = "productName", length = 100)
    private String productName;
    @Column(name = "productPrice")
    private double productPrice;
    @Column(name = "productStatus")
    private String productStatus;

    @ManyToOne
    @JoinColumn(name = "catagory_id")
    private Catagory catagory;

}
