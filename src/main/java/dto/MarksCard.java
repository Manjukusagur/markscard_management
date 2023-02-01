package dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MarksCard {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	String Class;
	double science;
	double maths;
	double kannada;

}
