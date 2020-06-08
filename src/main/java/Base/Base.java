package Base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import DataBase.DB_METHODS_Users;
import DataBase.DB_METHODS_gold_transactions;

public class Base {
public static WebDriver driver;
public static WebDriverWait wait = new WebDriverWait(driver,30);
public void database() {
	DB_METHODS_Users.db_connect();
	DB_METHODS_gold_transactions.db_connect();
}
}
