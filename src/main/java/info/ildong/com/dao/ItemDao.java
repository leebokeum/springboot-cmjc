package info.ildong.com.dao;
   
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
 
import info.ildong.com.vo.Item;
 

public interface ItemDao extends JpaRepository<Item, Integer>{
	Page<Item> findAll(Pageable pageble);
	List<Item> findByItemNameAndItemNo(String itemName, int itemNo); 
}
