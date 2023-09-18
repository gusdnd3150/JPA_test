package kr.co.sinbuya.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.co.sinbuya.entity.Staff;

public interface StaffRepository extends JpaRepository<Staff, Long> {
	
}
