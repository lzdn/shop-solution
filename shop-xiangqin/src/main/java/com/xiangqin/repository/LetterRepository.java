package com.xiangqin.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.xiangqin.domain.Letter;
import com.xiangqin.repository.base.BaseRepository;

public interface LetterRepository extends BaseRepository<Letter, Integer>, JpaRepository<Letter, Integer> {

	@Query(value = "select t.* from t_letter t where t.from_id= :fromId", nativeQuery = true)
	List<Letter> mList(@Param("fromId") Integer fromId);

	@Query(value = "select t.* from t_letter t where t.to_id= :toId", nativeQuery = true)
	List<Letter> sList(@Param("toId") Integer toId);
}
