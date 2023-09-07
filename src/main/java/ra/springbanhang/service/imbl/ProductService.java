package ra.springbanhang.service.imbl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.springbanhang.model.domain.Catagory;
import ra.springbanhang.model.domain.Product;
import ra.springbanhang.model.dto.reponse.ProductReponse;
import ra.springbanhang.model.dto.request.ProductRequest;
import ra.springbanhang.repository.ICatagoryRepository;
import ra.springbanhang.repository.IProductRepository;
import ra.springbanhang.service.IProductService;
import ra.springbanhang.service.mapper.PrductMapper;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService implements IProductService {

    @Autowired
    private IProductRepository productRepository;
    @Autowired
    private PrductMapper productMapper;
    @Override
    public List<ProductReponse> finAll() {
        List<Product> list = productRepository.findAll();
        List<ProductReponse> res = list.stream().map(product -> productMapper.toResponse(product))
                .collect(Collectors.toList());
        return res;
    }

    @Override
    public ProductReponse findById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
           return productMapper.toResponse(product.get());
        }
        return null;
    }

    @Override
    public ProductReponse save(ProductRequest productRequest) {
            Product product = productMapper.toEntity(productRequest);
        return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    public ProductReponse update(ProductRequest productRequest, Long id) {
        Product product = productMapper.toEntity(productRequest);
        product.setProductId(id);
        return productMapper.toResponse(productRepository.save(product));
    }

    @Override
    public ProductReponse delete(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()){
             productRepository.delete(product.get());
        }
        return null;
    }
}
