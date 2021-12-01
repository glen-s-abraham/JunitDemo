package com.glen.JunitDemo;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


class ProductDAOTest {
	
	
	ProductDAO productDao;
	@BeforeEach
	void setUp() {
		productDao=new ProductDAO();
	}
	
	@Nested
	class ProductAdditionTests{
		@Test
		void shouldReturnTrueWhenPassedinRightArguements() {
			assertTrue(productDao.addProduct(null, "phone", 10D, 5000D));
			assertEquals(productDao.count(), 1);
		}
		
		@ParameterizedTest
		@CsvSource({
			"-1,ABCD,10,2000",
			"1,A,10,2000",
			"1,ABCD,-10,2000",
			"1,ABCD,10,-2000"
		})
		void shouldThrowExceptionWhenPassedInWrongArguements(
				Long id,String name,Double qty,Double price
		) {
			assertThrows(IllegalArgumentException.class,
					()->productDao.addProduct(id,name,qty,price));
		}
	}
	
	@Nested
	class ProdcutDeletionTests{
		@Test
		void shouldReturnTrueWhenGivenExisitngId() {
			productDao.addProduct(123L, "String", 1000D, 100000D);
			assertTrue(productDao.deleteProduct(123L));
		}
		@Test
		void shouldReturnFalseWhenGivenNonExisitngId() {
			assertFalse(productDao.deleteProduct(123L));
		}
	}
	
	@Nested
	class ProductSearchTests{
		@Test
		void shouldReturnObjectWhenGiverRightId() {
			productDao.addProduct(123L,"Test",25D,1000D);
			Product expected = new Product(123L,"Test",25D,1000D);
			Product result=productDao.findProductById(123L);
			assertAll(
					()->assertEquals(expected.getId(), result.getId()),
					()->assertEquals(expected.getName(), result.getName()),
					()->assertEquals(expected.getQty(), result.getQty()),
					()->assertEquals(expected.getPrice(), result.getPrice())
			);
		}
		
		@Test
		void shouldReturnNullWhenGivenWrongId() {
			assertNull(productDao.findProductById(123L));
		}
	}

}
