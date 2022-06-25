package com.example.RentalServiceProject.repo;

import com.example.RentalServiceProject.model.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AssetRepo extends JpaRepository<Asset, Long>, JpaSpecificationExecutor<Asset> {

    public List<Asset> findByStatus(String type);
    public Asset findByAssetIdAndStatus(Long id, String type);
}
