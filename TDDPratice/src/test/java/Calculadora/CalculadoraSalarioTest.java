package Calculadora;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class CalculadoraSalarioTest {

    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValues")
    public void validarCalculoSalarioDesenvolvedor(String nome, String email, Double salarioBase, CargoEnum cargo, Double salarioExperado) {
        Funcionario funcionario = new Funcionario(nome, email, salarioBase, cargo);
        CalculadoraSalario cut = new CalculadoraSalario();
        Double salarioFinal = cut.calcular(funcionario);
        Assertions.assertEquals(salarioExperado, salarioFinal);
    }

    private static Stream<Arguments> provideInputAndExpectedValues() {
        return Stream.of(
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, null, 0.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, CargoEnum.DESENVOLVEDOR, 900.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 4000.0, CargoEnum.DESENVOLVEDOR, 3200.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, CargoEnum.DESENVOLVEDOR, 2400.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, CargoEnum.DBA, 850.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 2000.0, CargoEnum.DBA, 1500.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, CargoEnum.DBA, 2250.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, CargoEnum.TESTADOR, 850.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 2000.0, CargoEnum.TESTADOR, 1500.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 3000.0, CargoEnum.TESTADOR, 2250.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 1000.0, CargoEnum.GERENTE, 800.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 5000.0, CargoEnum.GERENTE, 3500.0),
                Arguments.of("Nome 1", "nome1@lp2.com", 6000.0, CargoEnum.GERENTE, 4200.0),
                Arguments.of("Nome 2", "nome2@lp2.com", 0.0, CargoEnum.DESENVOLVEDOR, 0.0),
                Arguments.of("Nome 3", "nome3@lp2.com", -1000.0, CargoEnum.DESENVOLVEDOR, -900.0),
                Arguments.of("Nome 4", "nome4@lp2.com", null, CargoEnum.DESENVOLVEDOR, 0.0),

                Arguments.of("Nome 5", "nome5@lp2.com", 2000.0, CargoEnum.GERENTE, 1600.0),
                Arguments.of("Nome 6", "nome6@lp2.com", 5000.0, CargoEnum.TESTADOR, 3750.0),
                Arguments.of("Nome 7", "nome7@lp2.com", 5000.0, CargoEnum.DBA, 3750.0),

                Arguments.of("Nome 8", "nome8@lp2.com", 2999.99, CargoEnum.DESENVOLVEDOR, 2699.991),
                Arguments.of("Nome 9", "nome9@lp2.com", 2000.01, CargoEnum.DBA, 1500.0075),
                Arguments.of("Nome 10", "nome10@lp2.com", 4999.99, CargoEnum.GERENTE, 3999.992),
                Arguments.of("Nome 11", "nome11@lp2.com", 2000.01, CargoEnum.TESTADOR, 1500.0075),
                Arguments.of("Nome 12", "nome12@lp2.com", 0.0, null, 0.0),
                Arguments.of(null, 0.0)
        );
    }
}
