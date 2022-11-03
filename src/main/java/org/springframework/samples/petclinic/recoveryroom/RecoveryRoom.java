package org.springframework.samples.petclinic.recoveryroom;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.PositiveOrZero;
import javax.validation.constraints.Size;

import org.springframework.samples.petclinic.model.BaseEntity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "recovery_rooms")
public class RecoveryRoom extends BaseEntity{
 
	@NotNull
    @Column(name = "name")
    @Size(min = 3, max = 50)
    private String name;
	@NotNull
	@PositiveOrZero
	@Column(name = "size")
    private double size;
	@NotNull
	@Column(name = "secure")
    private boolean secure;
	@ManyToOne
	@JoinColumn(name = "recovery_room_type_id")
	private RecoveryRoomType roomType;
    
   
}
