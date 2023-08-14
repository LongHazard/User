package com.ncsgroup.login.repository;

import com.ncsgroup.login.entity.FullName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FullNameRepository extends JpaRepository<FullName, Long> {
}
