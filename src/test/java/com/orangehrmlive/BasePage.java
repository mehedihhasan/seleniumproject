package com.orangehrmlive;

public abstract class BasePage {
    public String applicationUrl = "https://opensource-demo.orangehrmlive.com/";
    public String userName = "Admin";
    public String password = "admin123";

    public abstract String getPageTitle();


}
