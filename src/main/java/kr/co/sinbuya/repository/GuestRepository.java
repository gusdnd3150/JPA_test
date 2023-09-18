package kr.co.sinbuya.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import kr.co.sinbuya.entity.Guest;

public interface GuestRepository extends CrudRepository<Guest, Long> {

	@Query("select g from Guest g WHERE g.mtel like :tel OR g.ftel like :tel")
	Guest findByMtelOrFtel(@Param("tel") String tel);

}
