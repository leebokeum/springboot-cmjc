package info.ildong.com.vo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity
@Data 
public class Item { 
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ITEM_SEQ")
	@SequenceGenerator(name="ITEM_SEQ",sequenceName="ITEM_SEQ",allocationSize=1)
	int id;
	
	String itemName;
	int itemNo;
}
