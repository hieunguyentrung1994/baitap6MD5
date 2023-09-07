package ra.springbanhang.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ra.springbanhang.model.domain.Catagory;

@Repository
public interface ICatagoryRepository extends JpaRepository<Catagory,Long> {
}
