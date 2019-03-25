
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class CarDealerTest {
	CarDealer carDealer1, carDealer2, carDealer3, carDealer4, carDealer5;
	ArrayList<String> models1, models2, models3, models4, models5;
	
	@Before
	public void setUp() {
		models1 = new ArrayList<String>(Arrays.asList("Civic", "Accord", "Pilot", "CR-V"));
		models2 = new ArrayList<String>(Arrays.asList("Camry", "Prius", "Yaris", "RAV4", "Corolla", "Highlander", "4Runner"));
		models3 = new ArrayList<String>(Arrays.asList("Model X", "Roadster", "Model Y", "Model S", "Model 3"));
		models4 = new ArrayList<String>(Arrays.asList("Focus", "Mustang", "Escape", "Edge", "F-150", "Fusion"));
		models5 = new ArrayList<String>(Arrays.asList("Hardtop", "Countryman", "Clubman"));
				
		carDealer1 = new CarDealer("Honda Dealer", models1, 650, 43, 2500000);
		carDealer2 = new CarDealer("Toyota Dealer", models2, 850, 64, 3900000);
		carDealer3 = new CarDealer("Tesla Motors", models3, 100, 30, 3500000);
		carDealer4 = new CarDealer("Ford Dealer", models4, 800, 58, 3200000);
		carDealer5 = new CarDealer("Mini Cooper Dealer", models5, 300, 20, 2100000);
	
	}
	//Test Cases
	
	@Test
	public void testWorkersPayment() {
		CarDealer cd1 = new CarDealer("Honda Dealer", models1, 650, 43, 2477640);
		int workersPayment1 = carDealer1.workersPayment(2064);
		assertEquals(cd1,carDealer1);
		assertTrue(workersPayment1 == 22360);
		
		CarDealer cd2 = new CarDealer("Toyota Dealer", models2, 850, 64, 3868640);
		int workersPayment2 = carDealer2.workersPayment(2944);
		assertEquals(cd2,carDealer2);
		assertTrue(workersPayment2 == 31360);
		
		CarDealer cd3 = new CarDealer("Tesla Motors", models3, 100, 30, 3488000);
		int workersPayment3 = carDealer3.workersPayment(1200);
		assertEquals(cd3,carDealer3);
		assertTrue(workersPayment3 == 12000);
		
		CarDealer cd4 = new CarDealer("Ford Dealer", models4, 800, 58, 3175930);
		int workersPayment4 = carDealer4.workersPayment(2378);
		assertEquals(cd4,carDealer4);
		assertTrue(workersPayment4 == 24070);		
	}
	
	@Test
	public void testTradeInCar() {
		String[] carsTraded1 = new String[] {"Civic", "CR-V", "Civic", "Civic", "CR-V","Pilot"};
		ArrayList<String> carsOffered1 = new ArrayList<String>(Arrays.asList("Civic", "Camry", "CR-V", "Focus", "Civic", "CR-V", "Hardtop","Model 3","Pilot"));
		CarDealer cd1 = new CarDealer("Honda Dealer", models1, 650, 43, 2465000);
		String[] tradedInCars1 = carDealer1.tradeInCar(carsOffered1);
		assertEquals(cd1,carDealer1);
		assertTrue(Arrays.equals(tradedInCars1,carsTraded1));
		
		String[] carsTraded2 = new String[] {"Hardtop", "Countryman", "Hardtop"};
		ArrayList<String> carsOffered2 = new ArrayList<String>(Arrays.asList("Hardtop", "Camry", "CR-V", "Countryman", "Civic", "CR-V", "Hardtop","Model 3","Pilot"));
		CarDealer cd2 = new CarDealer("Honda Dealer", models1, 650, 43, 2074500);
		String[] tradedInCars2 = carDealer5.tradeInCar(carsOffered2);
		assertEquals(cd2,carDealer5);
		assertTrue(Arrays.equals(tradedInCars2,carsTraded2));
	}
	
	@Test
	public void testCheckInventory() {
		int[] carInventoryAmount1 = new int[]{4,2,1,3};
		ArrayList<String> carInventory1 = new ArrayList<String>(Arrays.asList("Civic", "Pilot", "CR-V", "Accord", "Civic", "CR-V", "CR-V","Civic","Civic"));
		CarDealer carDealer1 = new CarDealer("Honda Dealer", models1, 650, 43, 2500000);
		int[] res1 = carDealer1.checkInventory(carInventory1);
		assertTrue(Arrays.equals(res1,carInventoryAmount1));
		
		int[] carInventoryAmount2 = new int[]{5,3,4,1,2,0,1};
		ArrayList<String> carInventory2 = new ArrayList<String>(Arrays.asList("Camry", "RAV4", "Prius", "4Runner", "Yaris", "Yaris", "Camry","Corolla","Camry","Corolla","Camry","Prius","Yaris","Camry","Prius","Yaris"));
		CarDealer carDealer2 = new CarDealer("Toyota Dealer", models2, 850, 64, 3900000);
		int[] res2 = carDealer2.checkInventory(carInventory2);
		assertTrue(Arrays.equals(res2,carInventoryAmount2));
		
		int[] carInventoryAmount3 = new int[]{3,2,0,3,3};
		ArrayList<String> carInventory3 = new ArrayList<String>(Arrays.asList("Model 3", "Model X", "Model S", "Roadster", "Model X", "Roadster", "Model 3", "Model S","Model X","Model S", "Model 3"));
		CarDealer carDealer3 = new CarDealer("Tesla Motors", models3, 100, 30, 3500000);
		int[] res3 = carDealer3.checkInventory(carInventory3);
		assertTrue(Arrays.equals(res3,carInventoryAmount3));
		
		int[] carInventoryAmount4 = new int[]{4,2,4,2,1,1};
		ArrayList<String> carInventory4 = new ArrayList<String>(Arrays.asList("Fusion", "Focus", "Escape", "F-150", "Mustang", "Edge", "Mustang","Focus","Escape","Escape","Focus","Focus","Escape"));
		CarDealer carDealer4 = new CarDealer("Ford Dealer", models4, 800, 58, 3200000);
		int[] res4 = carDealer4.checkInventory(carInventory4);
		assertTrue(Arrays.equals(res4,carInventoryAmount4));
		
		int[] carInventoryAmount5 = new int[]{3,2,1};
		ArrayList<String> carInventory5 = new ArrayList<String>(Arrays.asList("Hardtop", "Clubman", "Hardtop", "Countryman", "Countryman", "Hardtop"));
		CarDealer carDealer5 = new CarDealer("Mini Cooper Dealer", models5, 300, 20, 2100000);
		int[] res5 = carDealer5.checkInventory(carInventory5);
		assertTrue(Arrays.equals(res5,carInventoryAmount5));
		
		
		
	}
	
	@Test
	public void testCarSellTotal() {
		int[] carModelPrice1 = new int[] {18000,25000,31000,23500};
		CarDealer cd1 = new CarDealer("Honda Dealer", models1, 649, 43, 2500000);
		int carSellTotal1 = carDealer1.carSellTotal("Accord", carModelPrice1);
		assertEquals(cd1,carDealer1);
		assertTrue(carSellTotal1 == 29250);
		
		int[] carModelPrice2 = new int[] {25000,28000,16000,23000,20000,32000,29000};
		CarDealer cd2 = new CarDealer("Toyota Dealer", models2, 849, 64, 3900000);
		int carSellTotal2 = carDealer2.carSellTotal("Corolla", carModelPrice2);
		assertEquals(cd2,carDealer2);
		assertTrue(carSellTotal2 == 23400);
		
		int[] carModelPrice3 = new int[] {60000,89000,35000,56000,33000};
		CarDealer cd3 = new CarDealer("Tesla Motors", models3, 99, 30, 3500000);
		int carSellTotal3 = carDealer3.carSellTotal("Model Y", carModelPrice3);
		assertEquals(cd3,carDealer3);
		assertTrue(carSellTotal3 == 40950);
		
		int[] carModelPrice4 = new int[] {16000,24000,28000,30000,35000,27000};
		CarDealer cd4 = new CarDealer("Ford Dealer", models4, 799, 58, 3200000);
		int carSellTotal4 = carDealer4.carSellTotal("Mustang", carModelPrice4);
		assertEquals(cd4,carDealer4);
		assertTrue(carSellTotal4 == 28080);

		int[] carModelPrice5 = new int[] {24000,32000,36000};
		CarDealer cd5 = new CarDealer("Mini Cooper Dealer", models5, 299, 20, 2100000);
		int carSellTotal5 = carDealer5.carSellTotal("Clubman", carModelPrice5);
		assertEquals(cd5,carDealer5);
		assertTrue(carSellTotal5 == 42120);

	}
	
	@Test
	public void testBuyRivalDealer() {
		CarDealer rivalCarDealer1 = new CarDealer("Carlos Carros", models1, 600, 45, 3000000); 
		CarDealer rivalCarDealer2 = new CarDealer("Luis Auto Shop", models2, 1100, 96, 4100000); 
		CarDealer rivalCarDealer3 = new CarDealer("Pepe's Carros", models3, 120, 20, 1500000); 
		CarDealer rivalCarDealer4 = new CarDealer("Bobby Carros", models4, 960, 80, 4100000);
		CarDealer rivalCarDealer5 = new CarDealer("Tony Carros", models5, 400, 29, 2000000);
		
		assertTrue(carDealer1.buyRivalDealer(rivalCarDealer1));
		assertFalse(carDealer2.buyRivalDealer(rivalCarDealer2));
		assertTrue(carDealer3.buyRivalDealer(rivalCarDealer3));
		assertFalse(carDealer4.buyRivalDealer(rivalCarDealer4));
		assertFalse(carDealer5.buyRivalDealer(rivalCarDealer5));
		
	}

}
