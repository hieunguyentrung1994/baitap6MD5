package ra.springbanhang.service.imbl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ra.springbanhang.model.domain.Catagory;
import ra.springbanhang.model.dto.reponse.CatagoryReponse;
import ra.springbanhang.model.dto.request.CatagoryRequest;
import ra.springbanhang.repository.ICatagoryRepository;
import ra.springbanhang.service.ICatagorySercice;
import ra.springbanhang.service.mapper.CatagoryMapper;

import java.net.CacheRequest;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CatagoryService implements ICatagorySercice {
    @Autowired
    private ICatagoryRepository catagoryRepository;
    @Autowired
    private CatagoryMapper catagoryMapper;

    @Override
    public List<CatagoryReponse> finAll() {
        List<Catagory> catagoryList = catagoryRepository.findAll();
        List<CatagoryReponse> result = catagoryList.stream()
                .map(catagory -> catagoryMapper.toResponse(catagory))
                .collect(Collectors.toList());
        return result;
    }

    @Override
    public CatagoryReponse findById(Long id) {
        Optional<Catagory> catagoryOptional = catagoryRepository.findById(id);
        if(catagoryOptional.isPresent()){
            return catagoryMapper.toResponse(catagoryOptional.get());
        }
        return null;
    }

    @Override
    public CatagoryReponse save(CatagoryRequest cacheRequest) {

        Catagory catagory = catagoryMapper.toEntity(cacheRequest);

        return catagoryMapper.toResponse(catagoryRepository.save(catagory));
    }

    @Override
    public CatagoryReponse update(CatagoryRequest cacheRequest, Long id) {
        Catagory catagory = catagoryMapper.toEntity(cacheRequest);
        catagory.setId(id);
        return catagoryMapper.toResponse(catagory);
    }

    @Override
    public CatagoryReponse delete(Long id) {
        Optional<Catagory> catagory = catagoryRepository.findById(id);
        if (catagory.isPresent()) {
            catagoryRepository.delete(catagory.get());
        }
        return null;
    }
}
