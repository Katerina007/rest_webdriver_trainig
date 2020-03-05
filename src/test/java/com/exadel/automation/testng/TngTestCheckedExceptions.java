package com.exadel.automation.testng;

import org.testng.annotations.*;

import com.exadel.automation.stubs.order.*;

public class TngTestCheckedExceptions {

	  protected OrderBo orderBo;
	  protected Order data;

	  @BeforeTest
	  void setup() {
		orderBo = new OrderBo();

		data = new Order();
		data.setId(1);
		data.setCreatedBy("exadel");
	  }

	  @Test(expectedExceptions = OrderSaveException.class)
	  public void throwIfOrderIsNull() throws OrderSaveException {
		orderBo.save(null);
	  }

	  /*
	   * Example : Multiple expected exceptions
	   * Test is success if either of the exception is thrown
	   */
	  @Test(expectedExceptions = { OrderUpdateException.class, OrderNotFoundException.class })
	  public void throwIfOrderIsNotExists() throws OrderUpdateException, OrderNotFoundException {
		orderBo.update(data);
	  }
		
	}
