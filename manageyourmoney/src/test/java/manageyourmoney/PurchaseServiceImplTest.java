package manageyourmoney;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.manageyourmoney.config.mvc.AppConfig;
import com.manageyourmoney.service.PurchaseService;

import junit.framework.TestCase;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { AppConfig.class })
public class PurchaseServiceImplTest {

	@Autowired
	@Qualifier("ps")
	PurchaseService purchaseService;

	@Test
	public void testPurchaseService() {
		//https://www.mkyong.com/unittest/junit-spring-integration-example/
	}

//	public void testAllPurchase() {
//		assertNotNull(purchaseService.getAllPurchase());
//	}

}
