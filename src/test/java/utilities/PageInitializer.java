package utilities;

import Pages.commonPage;
import Pages.myAccountPage;

public class PageInitializer extends Driver {

	public static commonPage cp;
	public static myAccountPage myAPage;

	public static void initialize() {
		cp = new commonPage();
		myAPage = new myAccountPage();
	}
}
