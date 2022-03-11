package com.example.jpa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jpa.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer>{
	
	
	//  "select a  from CustomerProductLink a  where a.productName=:productName ")
	  public Product findById( int  productid);


	public Product findByProductNameContainingAndIndInd(String name, boolean b);
	  
//	  public Product findByProduct__name( String  product_name);

/*	  public Product findByProductName( String  productName);

	  @Query(value = "select a  from Product a  where  a.ind_ind=true" )
	public List<Product> getProductRRR();


	  @Query(value = "select a  from Product a  where  a.ind_ind=true and a.password_active_ind=true" )
		public List<Product> getProductListByLive_indAndPass_ind();

	  @Query(value = "select a  from Product a  where  a.ind_ind=:d and a.password_active_ind=:p" )
		public List<Product> getProductByLive_indAndPass_ind(@Param(value = "d")boolean dg, @Param(value = "p")boolean ps);

	  
//	  public Product findByProduct__name( String  product_name);
	 //@Query(value = "select a  from Product a  where a.product_id=:addressId and a.productName='laptop' and a.ind=true" )
	//  @Query(value = "select a  from Product a  where a.product_id=:addressId and a.product_price between 200 and 550000 and a.ind=true" )
	//  public Product getdetails( @Param(value = "addressId")int  productId);
*/
	
//	  public Product findByProduct__name( String  product_name);

}
