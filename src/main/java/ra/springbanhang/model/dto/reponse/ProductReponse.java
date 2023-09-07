package ra.springbanhang.model.dto.reponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.springbanhang.model.domain.Catagory;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductReponse {

    private Long productId;

    private String productName;

    private double productPrice;

    private String productStatus;

    private Long catagory;
}

