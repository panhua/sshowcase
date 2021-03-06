package repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import domain.EntTag;

public interface TagRepository extends JpaRepository<EntTag, Long>, TagMoreRep{
	EntTag findByTagName(String tagName);
	
	@Query("select tags from EntTag tags where id in (:tagids)")
	List<EntTag> findByTagIds(@Param("tagids") Long[] tagids);
	
	@Query("select tags from EntTag tags where tagName in (:tagNames)")
	List<EntTag> findByTagNames(@Param("tagNames") String[] tagNames);
}
