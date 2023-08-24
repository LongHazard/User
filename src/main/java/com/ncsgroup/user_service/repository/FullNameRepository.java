package com.ncsgroup.user_service.repository;

import com.ncsgroup.user_service.entity.FullName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullNameRepository extends JpaRepository<FullName, Long> {
}
