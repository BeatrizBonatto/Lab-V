package Calculadora;

public class CalculadoraSalario {

    public Double calcular(Funcionario funcionario) {
        if (funcionario == null || funcionario.getCargo() == null || funcionario.getSalarioBase() == null)
            return 0.0;

        Double salarioBase = funcionario.getSalarioBase();
        CargoEnum cargo = funcionario.getCargo();
        return salarioBase * (salarioBase >= cargo.getLimite() ? cargo.getTaxaSuperior() : cargo.getTaxaInferior());
    }
}
