$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/register.feature");
formatter.feature({
  "name": "register new individual on Saraiva website",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "register new individual on Saraiva website successfully",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user is on Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "RegisterStep.userIsOnHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he clicks to register on the site",
  "keyword": "When "
});
formatter.match({
  "location": "RegisterStep.heClicksToRegisterOnTheSite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "choose the correct option for register",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterStep.chooseTheCorrectOptionForRegister()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he clicks on Cadastrar",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterStep.heClicksOnCadastrar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter the required data",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterStep.enterTheRequiredData()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "user is registered",
  "keyword": "Then "
});
formatter.match({
  "location": "RegisterStep.userIsRegistered()"
});
formatter.result({
  "status": "passed"
});
formatter.scenario({
  "name": "register new individual on Saraiva website with invalid CPF",
  "description": "",
  "keyword": "Scenario"
});
formatter.step({
  "name": "user is on Home Page",
  "keyword": "Given "
});
formatter.match({
  "location": "RegisterStep.userIsOnHomePage()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he clicks to register on the site",
  "keyword": "When "
});
formatter.match({
  "location": "RegisterStep.heClicksToRegisterOnTheSite()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "choose the correct option for register",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterStep.chooseTheCorrectOptionForRegister()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he clicks on Cadastrar",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterStep.heClicksOnCadastrar()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "enter the required data with an existing email",
  "keyword": "And "
});
formatter.match({
  "location": "RegisterStep.enterTheRequiredDataWithAnExistingEmail()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "then the error message is displayed",
  "keyword": "Then "
});
formatter.match({
  "location": "RegisterStep.thenTheErrorMessageIsDisplayed()"
});
formatter.result({
  "status": "passed"
});
});