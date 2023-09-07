package ra.springbanhang.service;

import java.util.List;

public interface IGenericService<T,K,E>{
    List<T> finAll();
    T findById(E id);
    T save(K k);
    T update(K k, E id);
    T delete(E id);

}
