package co.influential.dev.SignUp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SignUpPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver,10);
    }

    @FindBy(css = "[href = \"/signup/talent#form-anchor\"]")
    private WebElement formAnchor;

    @FindBy(id = "name-first")
    private WebElement nameFirst;

    @FindBy(id = "name-last")
    private WebElement nameLast;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "company-name")
    private WebElement nameCompany;

    @FindBy(id = "username")
    private WebElement nameUser;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(id = "password-confirm")
    private WebElement passwordConfirm;

    @FindBy(css = "button[type = \"submit\"]")
    private WebElement submit;

    private By formLocator = By.cssSelector("form");
    private By signupComplete = By.id("signup-complete");

    public void openSignUpForm(){
        formAnchor.click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(formLocator));
    }

    public void fillFirstName(String firstName){
        nameFirst.sendKeys(firstName);
    }

    public void fillLastName(String lastName){
        nameLast.sendKeys(lastName);
    }

    public void fillEmail(String Email){
        email.sendKeys(Email);
    }

    public void fillCompanyName(String companyName){
        nameCompany.sendKeys(companyName);
    }

    public void fillUserName(String userName){
        nameUser.sendKeys(userName);
    }

    public void fillPassword(String Password){
        password.sendKeys(Password);
    }

    public void fillConfirmPassword(String confirmPassword){
        passwordConfirm.sendKeys(confirmPassword);
    }

    public void submitForm(){
        submit.click();
    }

    public void checkSignUpSuccess(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(signupComplete));
    }

    //Errors
    private By errorMessageLocator = By.cssSelector("[class=\"error error-msg\"]");

    public void checkErrorRequiredField(){
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(errorMessageLocator));
    }

    public String getErrorFirstName(){
        WebElement nameFirstParent =  nameFirst.findElement(By.xpath("..")); //Переход на роительский элемент
        return nameFirstParent.findElement(By.cssSelector("p")).getText();
    }

    public String getErrorLastName(){
        WebElement nameLastParent =  nameLast.findElement(By.xpath("..")); //Переход на роительский элемент
        return nameLastParent.findElement(By.cssSelector("p")).getText();
    }

    public String getErrorEmail(){
        WebElement EmailParent =  email.findElement(By.xpath("..")); //Переход на роительский элемент
        return EmailParent.findElement(By.cssSelector("p")).getText();
    }

    public String getErrorCompanyName(){
        WebElement CompanyNameParent =  nameCompany.findElement(By.xpath("..")); //Переход на роительский элемент
        return CompanyNameParent.findElement(By.cssSelector("p")).getText();
    }

    public String getErrorUserName(){
        WebElement UserNameParent =  nameUser.findElement(By.xpath("..")); //Переход на роительский элемент
        return UserNameParent.findElement(By.cssSelector("p")).getText();
    }

    public String getErrorPassword(){
        WebElement PasswordParent =  password.findElement(By.xpath("..")); //Переход на роительский элемент
        return PasswordParent.findElement(By.cssSelector("p")).getText();
    }

    public String getErrorConfirmPassword(){
        WebElement ConfirmPasswordParent =  passwordConfirm.findElement(By.xpath("..")); //Переход на роительский элемент
        return ConfirmPasswordParent.findElement(By.cssSelector("p")).getText();
    }


}
