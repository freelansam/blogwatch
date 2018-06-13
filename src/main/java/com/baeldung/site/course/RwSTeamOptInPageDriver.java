package com.baeldung.site.course;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.baeldung.site.base.BlogBaseDriver;

@Component
public class RwSTeamOptInPageDriver extends BlogBaseDriver {

    @Override
    @Value("${rws.team.optin.url}")
    protected void setUrl(String url) {
        this.url = this.getBaseURL() + url;
    }

    public void clickOnGetAccessLinkforSmallTeam() {
        this.getWebDriver().findElement(By.xpath("//a[contains(@onclick,'buy_team_small')]")).click();
    }

    public void closePopupOnRwSTeamOptInPage() {
        this.getWebDriver().findElement(By.xpath("//div[contains(@class, 'tve_ea_thrive_leads_form_close')]")).click();
    }

    public boolean theSubmitButtonOnthePopupisDisplayed() {
        try {
            WebDriverWait wait = new WebDriverWait(this.getWebDriver(), 10000);
            WebElement button = wait.until(ExpectedConditions.visibilityOf(this.getWebDriver().findElement(By.xpath("//button[contains(., 'I HAVE QUESTIONS')]"))));
            return button.isDisplayed();
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    public void clickOnGetAccessLinkforMediumTeam() {
        this.getWebDriver().findElement(By.xpath("//a[contains(@onclick,'buy_team_medium')]")).click();
    }

    public void clickOnGetAccessLinkforLargeTeam() {
        this.getWebDriver().findElement(By.xpath("//a[contains(@onclick,'buy_team_large')]")).click();
    }

}
