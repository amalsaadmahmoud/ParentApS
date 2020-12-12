package TCS;

import org.testng.Assert;
import org.testng.annotations.Test;

import Pages.Events;

public class EventsTCs {
	@Test
	public static void verifyLoginSuccessfull() throws InterruptedException {
		Events events = new Events();
		events.login();
		Assert.assertTrue(events.isElementDisplayed());
	}
}
