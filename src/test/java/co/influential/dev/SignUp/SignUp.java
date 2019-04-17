package co.influential.dev.SignUp;

import co.influential.dev.WebDriverSetting;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.Random;

public class SignUp extends WebDriverSetting {

    @Test
    public void signUpPositive() {

        HomePage homePage = PageFactory.initElements(driver, HomePage.class);

        homePage.open();

        homePage.getStarted();

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);

        signUpPage.openSignUpForm();

        Random rand = new Random();
        int n = rand.nextInt(100) + 1;
        String email = "jonsmith" + n + "@gmail.com";
        String username = "jonsmith" + n;
        System.out.println(email);
        System.out.println(username);


        signUpPage.fillFirstName("Jon");
        signUpPage.fillLastName("Smith");
        signUpPage.fillEmail(email);
        signUpPage.fillCompanyName("IBM");
        signUpPage.fillUserName(username);
        signUpPage.fillPassword("123123qwe");
        signUpPage.fillConfirmPassword("123123qwe");

        signUpPage.submitForm();
        signUpPage.checkSignUpSuccess();

    }



    @Test
    public void signUpFailure() {
        driver.get("https://portal.dev.influential.co/");
        WebElement header = driver.findElement(By.id("header"));
        header.findElement(By.cssSelector("[href=\"/signup\"]")).click();



        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("main-signup")));

        driver.findElement(By.cssSelector("[href=\"/signup/talent#form-anchor\"]")).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("form")));

        driver.findElement(By.cssSelector("[type = \"submit\"]")).click();

        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("[class=\"error error-msg\"]")));

        WebElement nameFirst = driver.findElement(By.id("name-first"));
        WebElement nameFirstParent =  nameFirst.findElement(By.xpath("..")); //Переход на роительский элемент

        String nameFirstError = nameFirstParent.findElement(By.cssSelector("p")).getText();
        Assert.assertEquals(nameFirstError, "PLEASE ADD A FIRST NAME");

        WebElement nameLast = driver.findElement(By.id("name-last"));
        WebElement nameLastParent = nameLast.findElement(By.xpath(".."));
        Assert.assertEquals(nameLastParent.findElement(By.cssSelector("p")).getText(), "PLEASE ADD A LAST NAME");

        WebElement email = driver.findElement(By.id("email"));
        WebElement emailParent = email.findElement(By.xpath(".."));
        Assert.assertEquals(emailParent.findElement(By.cssSelector("p")).getText(), "PLEASE ADD AN EMAIL ADDRESS");

        WebElement company = driver.findElement(By.id("company-name"));
        WebElement companyParent = company.findElement(By.xpath(".."));
        Assert.assertEquals(companyParent.findElement(By.cssSelector("p")).getText(), "PLEASE ADD A COMPANY NAME");

        WebElement username = driver.findElement(By.id("username"));
        WebElement usernameParent = username.findElement(By.xpath(".."));
        Assert.assertEquals(usernameParent.findElement(By.cssSelector("p")).getText(), "PLEASE ADD A USERNAME");

        WebElement password = driver.findElement(By.id("password"));
        WebElement passwordParent = password.findElement(By.xpath(".."));
        Assert.assertEquals(passwordParent.findElement(By.cssSelector("p")).getText(), "PLEASE ADD A PASSWORD");

        WebElement confirm = driver.findElement(By.id("password-confirm"));
        WebElement confirmParent = confirm.findElement(By.xpath(".."));
        Assert.assertEquals(confirmParent.findElement(By.cssSelector("p")).getText(), "PLEASE CONFIRM YOUR PASSWORD");

    }

    @Test
    public void patternSignUpFailure(){
        HomePage homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.open();
        homePage.getStarted();

        SignUpPage signUpPage = PageFactory.initElements(driver, SignUpPage.class);
        signUpPage.openSignUpForm();
        signUpPage.submitForm();

        signUpPage.checkErrorRequiredField();

        String nameFirstError = signUpPage.getErrorFirstName();
        Assert.assertEquals(nameFirstError, "PLEASE ADD A FIRST NAME");

        String nameLastError = signUpPage.getErrorLastName();
        Assert.assertEquals(nameLastError, "PLEASE ADD A LAST NAME");

        String emailError = signUpPage.getErrorEmail();
        Assert.assertEquals(emailError, "PLEASE ADD AN EMAIL ADDRESS");

        String companyNameError = signUpPage.getErrorCompanyName();
        Assert.assertEquals(companyNameError, "PLEASE ADD A COMPANY NAME");

        String userNameError = signUpPage.getErrorUserName();
        Assert.assertEquals(userNameError, "PLEASE ADD A USERNAME");

        String passwordError = signUpPage.getErrorPassword();
        Assert.assertEquals(passwordError, "PLEASE ADD A PASSWORD");

        String passwordConfirmError = signUpPage.getErrorConfirmPassword();
        Assert.assertEquals(passwordConfirmError, "PLEASE CONFIRM YOUR PASSWORD");
    }



}
