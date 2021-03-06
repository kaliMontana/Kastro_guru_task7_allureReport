package com.demoqa.formTests;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import com.demoqa.formPages.FormPage;
import com.demoqa.formPages.FormPageStep;
import com.demoqa.formPages.components.ResultTableFormPage;
import com.demoqa.formPages.components.ResultTableFormPageSteps;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selenide.open;
import static com.demoqa.dataProviders.OtherStudentData.*;
import static com.demoqa.dataProviders.StudentData.*;
import static io.qameta.allure.Allure.step;

@Owner("Kastro B.")
@Severity(SeverityLevel.BLOCKER)
@Feature("Registration Form")
@Story("Filling Student's Registration Form")
@Link(value = "Testing", url = "https://demoqa.com/automation-practice-form")
public class demoqaTest extends TestSetup {
    FormPage formPage = new FormPage();
    ResultTableFormPage tableFormPage = new ResultTableFormPage();
    FormPageStep formPageStep = new FormPageStep();
    ResultTableFormPageSteps resultTableFormPageSteps = new ResultTableFormPageSteps();


    @Test
    @DisplayName("Student Registration Form with Listener")
    void fillFormWithListenerTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        open("/automation-practice-form");

        formPage.setFirstNameStep(firstName);
        formPage.setLastNameStep(lastName);

        formPage.setMailStep(email);

        formPage.chooseGenderStep(gender);

        formPage.setMobileStep(mobile);

        formPage.setDateOfBirthStep(DOB_MONTH.getValue(), DOB_YEAR.getValue(), DOB_DAY.getValue());

        formPage.setSubjectsStep(SUBJECT.getValue());

        formPage.chooseHobbiesStep();

        formPage.upLoadPictureStep();

        formPage.setCurrentAddressStep(currentAddress);

        formPage.setStateStep();
        formPage.setCityStep();

        formPage.clickOnSubmitStep();

        tableFormPage.checkSubmittedBlockTitleStep();
        tableFormPage.checkResultTableStep(
                firstName,
                lastName,
                email,
                gender,
                mobile,
                DOB_DAY.getValue(),
                DOB_MONTH.getValue(),
                DOB_YEAR.getValue(),
                SUBJECT.getValue(),
                HOBBIES.getValue(),
                PICTURE_NAME.getValue(),
                currentAddress,
                STATE_AND_CITY.getValue()
        );
    }

    @Test
    @DisplayName("Student Registration Form with Lambda")
    void fillFormWithLambdaTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        step("?????????????? ???????????????? ????????????", () -> {
            open("/automation-practice-form");
        });

        step("?????????????? ?????? ????????????????", () -> {
            formPage.setFirstNameStep(firstName);
            formPage.setLastNameStep(lastName);
        });

        step("?????????????? email", () -> {
            formPage.setMailStep(email);
        });

        step("?????????????? ?????? ????????????????", () -> {
            formPage.chooseGenderStep(gender);
        });

        step("?????????????? ?????????? ???????????????? ????????????????", () -> {
            formPage.setMobileStep(mobile);
        });

        step("?????????????? ???????? ???????????????? ????????????????", () -> {
            formPage.setDateOfBirthStep(DOB_MONTH.getValue(), DOB_YEAR.getValue(), DOB_DAY.getValue());
        });

        step("?????????????? ?????????????? ????????????????", () -> {
            formPage.setSubjectsStep(SUBJECT.getValue());
        });

        step("???????????????? ??????????????????", () -> {
            formPage.chooseHobbiesStep();
        });

        step("?????????????????? ??????????????????????", () -> {
            formPage.upLoadPictureStep();
        });

        step("?????????????? ?????????????? ??????????", () -> {
            formPage.setCurrentAddressStep(currentAddress);
        });

        step("???????????????? ???????? ?? ??????????", () -> {
            formPage.setStateStep();
            formPage.setCityStep();

            Allure.getLifecycle().addAttachment(
                    "?????????????????? ????????????????",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });

        step("?????????????????? ?????????????????????? ??????????", () -> {
            formPage.clickOnSubmitStep();
        });

        step("?????????????????? ?????????????? ???????????????????????? ????????????", () -> {
            tableFormPage.checkSubmittedBlockTitleStep();
            tableFormPage.checkResultTableStep(
                    firstName,
                    lastName,
                    email,
                    gender,
                    mobile,
                    DOB_DAY.getValue(),
                    DOB_MONTH.getValue(),
                    DOB_YEAR.getValue(),
                    SUBJECT.getValue(),
                    HOBBIES.getValue(),
                    PICTURE_NAME.getValue(),
                    currentAddress,
                    STATE_AND_CITY.getValue()
            );
        });
    }

    @Test
    @DisplayName("Student Registration Form with steps")
    void fillFormWithStepsTest() {
        SelenideLogger.addListener("allure", new AllureSelenide());

        formPageStep.openFormPageStep();

        formPageStep.setFirstNameStep(firstName);
        formPageStep.setLastNameStep(lastName);

        formPageStep.setMailStep(email);

        formPageStep.chooseGenderStep(gender);

        formPageStep.setMobileStep(mobile);

        formPageStep.setDateOfBirthStep(DOB_MONTH.getValue(), DOB_YEAR.getValue(), DOB_DAY.getValue());

        formPageStep.setSubjectsStep(SUBJECT.getValue());

        formPageStep.chooseHobbiesStep();

        formPageStep.upLoadPictureStep();

        formPageStep.setCurrentAddressStep(currentAddress);

        formPageStep.setStateStep();
        formPageStep.setCityStep();

        formPageStep.clickOnSubmitStep();

        resultTableFormPageSteps.checkSubmittedBlockTitleStep();
        resultTableFormPageSteps.checkResultTableStep(
                firstName,
                lastName,
                email,
                gender,
                mobile,
                DOB_DAY.getValue(),
                DOB_MONTH.getValue(),
                DOB_YEAR.getValue(),
                SUBJECT.getValue(),
                HOBBIES.getValue(),
                PICTURE_NAME.getValue(),
                currentAddress,
                STATE_AND_CITY.getValue()
        );
    }
}
