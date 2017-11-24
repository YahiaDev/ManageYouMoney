package manageyourmoney;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.manageyourmoney.mongodb.document.Purchase;
import com.manageyourmoney.mongodb.repository.PurchaseCategoriesRepo;
import com.manageyourmoney.mongodb.repository.PurchaseRepo;
import com.manageyourmoney.service.PurchaseService;
import com.manageyourmoney.service.impl.PurchaseServiceImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration
public class PurchaseServiceTest {

	@Configuration
	static class PurchaseServiceTestContextConfiguration {
		@Bean
		public PurchaseService purchaseService() {
			return new PurchaseServiceImpl(Mockito.mock(PurchaseCategoriesRepo.class),
					Mockito.mock(PurchaseRepo.class));
		}

		@Bean
		public PurchaseRepo purchaseRepo() {
			return Mockito.mock(PurchaseRepo.class);
		}
	}

	@Autowired
	PurchaseService purchaseService;

	@Autowired
	PurchaseRepo purchaseRepo;

	@Before
	public void setup() {
		List<Purchase> purchaseList = new ArrayList<Purchase>();
		Mockito.when(purchaseRepo.findAll()).thenReturn(purchaseList);
	}

	@Test
	public void contextLoader() {
		assertNotNull(purchaseService);
	}

	@Test
	public void purchaseServiceTest() {
		assertEquals("class com.manageyourmoney.service.impl.PurchaseServiceImpl",
				this.purchaseService.getClass().toString());
	}

	@Test
	public void getAllPurchaseTest() {
		List<Purchase> purchaseList = purchaseService.getAllPurchase();
		assertNull(purchaseList);
	}

}
