package ra.springbanhang.service.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ra.springbanhang.model.domain.Catagory;
import ra.springbanhang.model.domain.Product;
import ra.springbanhang.model.dto.reponse.ProductReponse;
import ra.springbanhang.model.dto.request.ProductRequest;
import ra.springbanhang.repository.ICatagoryRepository;
import ra.springbanhang.service.IGenericMapper;

import javax.swing.text.html.Option;
import java.util.Optional;

@Component
public class PrductMapper implements IGenericMapper<Product, ProductRequest, ProductReponse> {
@Autowired
   private ICatagoryRepository catagoryRepository;
    @Override
    public Product toEntity(ProductRequest productRequest) {
        Optional<Catagory> catagory = catagoryRepository.findById(productRequest.getCatagory());
        return Product.builder().productName(productRequest.getProductName())
                .productPrice(productRequest.getProductPrice())
                .productStatus(productRequest.getProductStatus())
                .catagory(catagory.get()).build();
    }

    @Override
    public ProductReponse toResponse(Product product) {
        Optional<Catagory> catagory = catagoryRepository.findById(product.getProductId());
        return ProductReponse.builder().productId(product.getProductId()).productName(product.getProductName())
                .productPrice(product.getProductPrice())
                .productStatus(product.getProductStatus())
                .catagory(catagory.get().getId()).build();
    }
}
