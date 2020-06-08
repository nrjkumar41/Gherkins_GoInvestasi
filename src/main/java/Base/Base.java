package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base {
public  WebDriver driver;
public  WebDriverWait wait = new WebDriverWait(driver,30);
public void database() {
//	DB_METHODS_Users.db_connect();
//	DB_METHODS_gold_transactions.db_connect();
}
}
