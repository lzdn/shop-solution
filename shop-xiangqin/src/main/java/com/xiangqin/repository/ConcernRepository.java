package com.xiangqin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xiangqin.domain.Concern;
import com.xiangqin.repository.base.BaseRepository;

public interface ConcernRepository extends BaseRepository<Concern, Integer>, JpaRepository<Concern, Integer>{

	@Query(value = "select t.* from t_concern t where t.owner_id= :ownerId", nativeQuery = true)
	List<Concern> ownerList(@Param("ownerId") Integer ownerId);// t_concern
}
