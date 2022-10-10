package managers;

import org.openqa.selenium.WebDriver;
import pageObject.*;

public class PageObjectManager {

    private WebDriver driver;
    public PageObjectManager(WebDriver driver) {
        this.driver = driver;
    }
    public WebDriver getDriver() {
        return driver;
    }

    private Atlas_Login_page atlas_login_page;
    private CarSaverSearch_page search_page;
    private CSE_Accessories_page CSE_accessories_page;
    private CSE_Deal_Contact_Dealer_page csEcomContactDealer_page;
    private CSE_Registration_SignIn_page csEcommerce_page;
    private CSE_Garage_Address_page csEcomGarageAddress_page;
    private CSE_Get_Approved_page cseGetApproved_page;
    private CSE_Garage_Certificate_page csEcomGarageCertificate_page;
    private CSE_Garage_MyAccount_page csEcomGarageMyAccount_page;
    private CSE_Garage_Appointments_page cseEcomGarageAppointments_page;
    private CSE_Recently_Viewed_page cseEcomGarageRecentlyViewed_page;
    private CSE_Garage_Saved_Deals_page cseEcomGarageSavedDeals_page;
    private CSE_Garage_Password_page csEcomGarageMyPassword_page;
    private CSE_My_Trades_page csEcomMyTrades_page;
    private CSE_Garage_Hamburger_page csEcomHamburger_page;
    private Portal_Login_page portal_login_page;
    private Portal_Customers_page portal_customers_page;
    private Upgrade_Registration_SignIn_page Upgrade_page;
    private Upgrade_Appointments_page Upgrade_Appointments_page;
    private Upgrade_Account_page Upgrade_Account_page;
    private Upgrade_Address_page Upgrade_Address_page;
    private Upgrade_Password_page Upgrade_Password_page;
    private Upgrade_Pin_page upgrade_pin_page;
    private Upgrade_Trades_page Upgrade_Trades_page;
    private Upgrade_Finalize_Purchase_page Upgrade_Finalize_Purchase_page;
    private Upgrade_SavedDeals_page Upgrade_SavedDeals_page;
    private Upgrade_Recently_Viewed_page Upgrade_Recently_Viewed_page;
    private Upgrade_Contact_Dealer_page Upgrade_Contact_Dealer_page;
    private Upgrade_Vehicle_Details_page Upgrade_Vehicle_Details_page;
    private Upgrade_Offer_Details_page Upgrade_Offer_Details_page;

    /** Atlas **/
    public Atlas_Login_page getAtlas_login_page() {
        return (atlas_login_page == null) ? atlas_login_page= new Atlas_Login_page(driver) : atlas_login_page;
    }

    /** CarSaver **/
    public CarSaverSearch_page getSearchPage() {
        return (search_page == null) ? search_page = new CarSaverSearch_page(driver) : search_page;
    }

    /** eCommerce **/
    public CSE_Accessories_page getCSE_accessories_page() {
        return (CSE_accessories_page == null) ? CSE_accessories_page= new CSE_Accessories_page(driver) : CSE_accessories_page;
    }
    public CSE_Deal_Contact_Dealer_page getCsEcomContactDealer_page() {
        return (csEcomContactDealer_page == null) ? csEcomContactDealer_page= new CSE_Deal_Contact_Dealer_page(driver) : csEcomContactDealer_page;
    }
    public CSE_Garage_Address_page getCsEcomGarage(){
        return (csEcomGarageAddress_page == null) ? csEcomGarageAddress_page = new CSE_Garage_Address_page(driver) : csEcomGarageAddress_page;
    }
    public CSE_Garage_MyAccount_page getCsEcomGarageMyAccount() {
        return (csEcomGarageMyAccount_page == null) ? csEcomGarageMyAccount_page = new CSE_Garage_MyAccount_page(driver) : csEcomGarageMyAccount_page;
    }
    public CSE_Garage_Hamburger_page csEcomHamburgerpage(){
        return (csEcomHamburger_page == null) ? csEcomHamburger_page = new CSE_Garage_Hamburger_page(driver) : csEcomHamburger_page;
    }
    public CSE_Garage_Appointments_page getCsEcomGarageAppointments(){
        return (cseEcomGarageAppointments_page == null) ? cseEcomGarageAppointments_page = new CSE_Garage_Appointments_page(driver) : cseEcomGarageAppointments_page;
    }
    public CSE_Get_Approved_page getGetApproved(){
        return (cseGetApproved_page == null) ? cseGetApproved_page = new CSE_Get_Approved_page(driver) : cseGetApproved_page;
    }
    public CSE_Recently_Viewed_page getCseRecentViewed() {
        return (cseEcomGarageRecentlyViewed_page == null) ? cseEcomGarageRecentlyViewed_page = new CSE_Recently_Viewed_page(driver) : cseEcomGarageRecentlyViewed_page;
    }
    public CSE_Garage_Certificate_page getCsEcomGarageCertificate(){
        return (csEcomGarageCertificate_page == null) ? csEcomGarageCertificate_page = new CSE_Garage_Certificate_page(driver) : csEcomGarageCertificate_page;
    }
    public CSE_Garage_Password_page csCsGarageMyPasswordPage() {
        return (csEcomGarageMyPassword_page == null) ? csEcomGarageMyPassword_page = new CSE_Garage_Password_page(driver) : csEcomGarageMyPassword_page;
    }
    public CSE_My_Trades_page getCsEcomMyTrades(){
        return (csEcomMyTrades_page == null) ? csEcomMyTrades_page = new CSE_My_Trades_page(driver) : csEcomMyTrades_page;
    }
    public CSE_Registration_SignIn_page getCsEcommercePage() {
        return (csEcommerce_page == null) ? csEcommerce_page = new CSE_Registration_SignIn_page(driver) : csEcommerce_page;
    }
    public CSE_Garage_Saved_Deals_page getCseSavedDealsPage() {
        return (cseEcomGarageSavedDeals_page == null) ? cseEcomGarageSavedDeals_page = new CSE_Garage_Saved_Deals_page(driver) : cseEcomGarageSavedDeals_page;
    }

    /** Upgrade **/
    public Upgrade_Appointments_page getUpgrade_Appointments_page() {
        return (Upgrade_Appointments_page == null) ? Upgrade_Appointments_page= new Upgrade_Appointments_page(driver) : Upgrade_Appointments_page;
    }
    public CSE_Garage_Address_page getNissanEcomGarage(){
        return (csEcomGarageAddress_page == null) ? csEcomGarageAddress_page = new CSE_Garage_Address_page(driver) : csEcomGarageAddress_page;
    }
    public Upgrade_Registration_SignIn_page getUpgrade_page() {
        return (Upgrade_page == null) ? Upgrade_page= new Upgrade_Registration_SignIn_page(driver) : Upgrade_page;
    }
    public Upgrade_Account_page getUpgrade_Account_page() {
        return (Upgrade_Account_page == null) ? Upgrade_Account_page= new Upgrade_Account_page(driver) : Upgrade_Account_page;
    }
    public Upgrade_Address_page getUpgrade_Address_page() {
        return (Upgrade_Address_page == null) ? Upgrade_Address_page= new Upgrade_Address_page(driver) : Upgrade_Address_page;
    }
    public Upgrade_Password_page getUpgrade_Password_page() {
        return (Upgrade_Password_page == null) ? Upgrade_Password_page= new Upgrade_Password_page(driver) : Upgrade_Password_page;
    }
    public Upgrade_Pin_page getUpgrade_pin_page() {
        return (upgrade_pin_page == null) ? upgrade_pin_page= new Upgrade_Pin_page(driver) : upgrade_pin_page;
    }
    public Upgrade_Trades_page getUpgrade_Trades_page() {
        return (Upgrade_Trades_page == null) ? Upgrade_Trades_page= new Upgrade_Trades_page(driver) : Upgrade_Trades_page;
    }
    public Upgrade_SavedDeals_page getUpgrade_SavedDeals_page() {
        return (Upgrade_SavedDeals_page == null) ? Upgrade_SavedDeals_page= new Upgrade_SavedDeals_page(driver) : Upgrade_SavedDeals_page;
    }
    public Upgrade_Recently_Viewed_page getUpgrade_Recently_Viewed_page() {
        return (Upgrade_Recently_Viewed_page == null) ? Upgrade_Recently_Viewed_page= new Upgrade_Recently_Viewed_page(driver) : Upgrade_Recently_Viewed_page;
    }
    public Upgrade_Contact_Dealer_page getUpgrade_Contact_Dealer_page() {
        return (Upgrade_Contact_Dealer_page == null) ? Upgrade_Contact_Dealer_page= new Upgrade_Contact_Dealer_page(driver) : Upgrade_Contact_Dealer_page;
    }
    public Upgrade_Finalize_Purchase_page getUpgrade_Finalize_Purchase_page() {
        return (Upgrade_Finalize_Purchase_page == null) ? Upgrade_Finalize_Purchase_page= new Upgrade_Finalize_Purchase_page(driver) : Upgrade_Finalize_Purchase_page;
    }
    public Upgrade_Vehicle_Details_page getUpgrade_Vehicle_Details_page() {
        return (Upgrade_Vehicle_Details_page == null) ? Upgrade_Vehicle_Details_page= new Upgrade_Vehicle_Details_page(driver) : Upgrade_Vehicle_Details_page;
    }
    public Upgrade_Offer_Details_page getUpgrade_Offer_Details_page() {
        return (Upgrade_Offer_Details_page == null) ? Upgrade_Offer_Details_page= new Upgrade_Offer_Details_page(driver) : Upgrade_Offer_Details_page;
    }

    /** Portal **/
    public Portal_Login_page getPortal_login_page() {
        return (portal_login_page == null) ? portal_login_page= new Portal_Login_page(driver) : portal_login_page;
    }
    public Portal_Customers_page getPortal_customers_page() {
        return (portal_customers_page == null) ? portal_customers_page= new Portal_Customers_page(driver) : portal_customers_page;
    }
}