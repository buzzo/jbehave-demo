package br.com.buzzo.jbehave;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;
import org.jbehave.web.selenium.WebDriverProvider;
import org.junit.Assert;

public class ExampleSteps {

    private final HomePage home;

    public ExampleSteps(final WebDriverProvider webdriver) {
        this.home = new HomePage(webdriver);
    }

    @Given("o usuario esta na tela de cadastro")
    public void givenOUsuarioEstaNaTelaDeCadastro() {
        this.home.open();
    }

    @When("ele digita corretamente o nome")
    public void whenEleDigitaCorretamenteONome() {
        this.home.type_name("andre");
    }

    @When("ele digita corretamente o email")
    public void whenEleDigitaCorretamenteOEmail() {
        this.home.type_email("andre@buzzo.com.br");
    }

    @When("ele digita corretamente o numero do telefone")
    public void whenEleDigitaCorretamenteONumeroDoTelefone() {
        this.home.type_phone("12345678901");
    }

    @When("ele pressiona o botao de registro")
    public void whenElePressionaOBotaoDeRegistro() {
        this.home.register();
    }

    @Then("o cadastro eh realizado com sucesso")
    public void thenOCadastroEhRealizadoComSucesso() {
        Assert.assertEquals("Registered!", this.home.getRegisterMessage());
    }

}
