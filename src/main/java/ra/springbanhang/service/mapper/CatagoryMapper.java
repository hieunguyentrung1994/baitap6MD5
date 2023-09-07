package ra.springbanhang.service.mapper;

import org.springframework.stereotype.Component;
import ra.springbanhang.model.domain.Catagory;
import ra.springbanhang.model.dto.reponse.CatagoryReponse;
import ra.springbanhang.model.dto.request.CatagoryRequest;
import ra.springbanhang.service.IGenericMapper;
@Component
public class CatagoryMapper implements IGenericMapper<Catagory, CatagoryRequest, CatagoryReponse> {
    @Override
    public Catagory toEntity(CatagoryRequest catagoryRequest) {
        return Catagory.builder().catagoryName(catagoryRequest.getCatagoryName()).build();
    }

    @Override
    public CatagoryReponse toResponse(Catagory catagory) {
        return CatagoryReponse.builder().catagoryName(catagory.getCatagoryName()).id(catagory.getId()).build();
    }
}
