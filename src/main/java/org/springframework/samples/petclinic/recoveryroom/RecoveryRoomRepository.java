package org.springframework.samples.petclinic.recoveryroom;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface RecoveryRoomRepository extends CrudRepository<RecoveryRoom, Integer>{
	@Query("SELECT r FROM RecoveryRoom r")
	List<RecoveryRoom> findAll();
    Optional<RecoveryRoom> findById(int id);
    RecoveryRoom save(RecoveryRoom p);
    
    @Query("SELECT rt FROM RecoveryRoomType rt WHERE rt.name = :namep")
    RecoveryRoomType findRecoveryRoomType(@Param("namep")String name);
    
    @Query("SELECT rt FROM RecoveryRoomType rt")
    List<RecoveryRoomType> findAllRecoveryRoomTypes();
    //RecoveryRoomType getRecoveryRoomType(String name);
}
