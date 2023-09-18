package kr.co.sinbuya.www.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import kr.co.sinbuya.entity.ProductArticle;
import kr.co.sinbuya.repository.ProductArticleRepository;

@Service("ProductArticleService")
public class ProductArticleServiceImpl implements ProductArticleService {
	
	@Autowired private ProductArticleRepository productArticleRepository;

	@Transactional
	@Override
	public ProductArticle findArticleById(long id) {
		return productArticleRepository.findOne(id);
	}			
}
