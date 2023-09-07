package ra.springbanhang.model.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import ra.springbanhang.model.domain.Catagory;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductRequest {

    private String productName;

    private double productPrice;

    private String productStatus;

    private Long catagory;
}
