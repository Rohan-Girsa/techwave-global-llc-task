package com.techwave.techwavegloballlc.repository;

import com.techwave.techwavegloballlc.entity.TblNews;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TblNewsRepository extends JpaRepository<TblNews,Integer> {
}
