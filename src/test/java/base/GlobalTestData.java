package base;

import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class GlobalTestData {
    // CarSaver
    public static String carSaver_API_baseURL;
    public static String carSaver_API_user;
    public static String carSaver_API_password;

    // eCommerce
    public static String ECOM_REGISTRATION_FIRST_NAME;
    public static String ECOM_REGISTRATION_LAST_NAME;
    public static String ECOM_REGISTRATION_ADDRESS = "701 Brickell Avenue";
    public static String ECOM_REGISTRATION_ZIPCODE = "33131";
    public static String ECOM_REGISTRATION_CITY = "Miami";
    public static String ECOM_REGISTRATION_STATE = "FL";
    public static String ECOM_REGISTRATION_MOBILE = "6155673525";
    public static String ECOM_REGISTRATION_MOBILE_FORMATTED = "(615) 567-3525";
    public static String ECOM_REGISTRATION_MOBILE_UPDATED = "6155674444";
    public static String ECOM_REGISTRATION_EMAIL;
    public static String ECOM_REGISTRATION_OLD_EMAIL;
    public static String ECOM_REGISTRATION_PASSWORD = "Test$1234";
    public static String ECOM_LOGIN_EMAIL;
    public static String ECOM_LOGIN_PASSWORD;
    public static String ECOM_ADDRESS_LOGIN_STREET_UPDATE = "1875 Lawrence Street";
    public static String ECOM_ADDRESS_LOGIN_CITY_UPDATE = "Denver";
    public static String ECOM_ADDRESS_LOGIN_STATE_UPDATE = "CO";
    public static String ECOM_ADDRESS_LOGIN_ZIP_UPDATE = "80202";
    public static String ECOM_ADDRESS_STREET_VAGUE = "701 Brickell";

    //CSE
    public static String CSE_NON_SSO_LOGIN_EMAIL;
    public static String CSE_NON_SSO_LOGIN_PASSWORD;
    public static String CSE_TRADE_IN_VEHICLE_TRIM;
    public static String CSE_TRADE_IN_VEHICLE_TRANSMISSION;
    public static String CSE_TRADE_IN_VEHICLE_COLOR;
    public static String CSE_TRADE_IN_VEHICLE_MILES;
    public static List<String> VEHICLE_FEATURES = new ArrayList<>();
    public static String CSE_TRADE_OFFER_AMOUNT;
    public static String CSE_TRADE_OLD_OFFER_AMOUNT;
    public static String CSE_TRADE_OFFER_EXPIRES;
    public static String CSE_TRADE_OFFER_TYPE;
    public static String[][] OLD_VEHICLE_INFO;
    public static String SCHEDULE_TEST_DRIVE_CONF_NUMBER;
    public static String SCHEDULE_TEST_DRIVE_DATE;
    public static String SCHEDULE_TEST_DRIVE_TIME;
    public static String SCHEDULE_TEST_DRIVE_LONG_DATE;
    public static String CSE_BUY_HOME_PRICE;
    public static String CSE_DEAL_VALUE;
    public static String CSE_DOWN_PAYMENT_VALUE = "$ 1,200";
    public static String CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_1ST;
    public static String CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_2ND;
    public static String CSE_DEAL_VALUE_ORIG;
    public static String CSE_DOWN_PAYMENT_VALUE_ORIG;
    public static String CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_1ST_ORIG;
    public static String CSE_DEAL_PAGE_CHECK_BOX_LABEL_TEXT_2ND_ORIG;
    public static String CSE_BUY_HOME_PRICE_1;
    public static String CSE_BUY_HOME_PRICE_2;
    public static String CSE_STOCK_TYPE_1;
    public static String CSE_DEAL_PAGE_VEHICLE_COLOR_1;
    public static String CSE_STOCK_TYPE_2;
    public static String CSE_DEAL_PAGE_VEHICLE_COLOR_2;
    public static String CSE_DEAL_PAGE_VEHICLE_INFO;
    public static String[] checkBoxes;

    //UpGrade
    public static String UPGRADE_EXISTING_PROFILE_EMAIL;
    public static String UPGRADE_EXISTING_PROFILE_PASSWORD;
    public static String UPGRADE_EXISTING_FIRST_NAME;
    public static String[][] UPGRADE_PIN_INFO;

    // Portal
    public static String PORTAL_BASE_URL;
    public static String PORTAL_ADMIN_EMAIL;
    public static String PORTAL_ADMIN_PASSWORD;

    // Atlas
    public static String ATLAS_DEALER_EMAIL;
    public static String ATLAS_DEALER_PASSWORD;
    public static String ATLAS_PROGRAM_USER_EMAIL;
    public static String ATLAS_PROGRAM_USER_PASSWORD;

    /** DB connection information **/
    public static String DB_DRIVER;
    public static String DB_USER;
    public static String DB_PWD;
    public static String DB_URL;
    public static String DB_URL_TUNNEL;
    public static int DB_PORT;
    /** SSH connection information **/
    public static String SSH_HOST = "ec2-3-230-68-161.compute-1.amazonaws.com";
    public static Short SSH_PORT = 22;
    public static String SSH_LOGIN = "calford";
    /** DB query strings **/
    public static String[][] SQL_QUERY;
    public static int SQL_ROW;
    public static int SQL_COL;

}