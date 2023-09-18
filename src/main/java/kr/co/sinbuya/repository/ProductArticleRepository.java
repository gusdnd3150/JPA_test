package kr.co.sinbuya.repository;

//import java.util.List;

//import org.springframework.data.domain.Pageable;
//import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.Repository;
//import org.springframework.data.repository.query.Param;

import kr.co.sinbuya.entity.ProductArticle;

public interface ProductArticleRepository extends Repository<ProductArticle, Long> {

	ProductArticle findOne(Long id);

//	@Query("select a from ProductArticle a WHERE a.id IN (SELECT o.article.id FROM ProductOption o WHERE o.mode = :m) AND a.categoryId = :cid AND a.id <> :id AND a.status > 0")
//	List<ProductArticle> findByOptionMode(@Param("m") String m, @Param("id") Long id, @Param("cid") long categoryId, Pageable pageable);

//	@Query("select a from ProductArticle a WHERE a.title like :term AND a.categoryId = :categoryId AND a.status >= 0")
//	List<ProductArticle> findByLikeTitleAndCategoryId(@Param("term") String term, @Param("categoryId") long categoryId, Pageable pageable);

	//윤주주석
	
}
