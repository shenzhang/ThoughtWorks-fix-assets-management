package com.thoughtworks.fam.repository;

import com.thoughtworks.fam.domain.Asset;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//do not modify before you known why
@Repository
public interface AssetRepository extends JpaRepository<Asset, Long> {

    Asset findByNumber(String number);

    List<Asset> findByUserName(String userName);
}
