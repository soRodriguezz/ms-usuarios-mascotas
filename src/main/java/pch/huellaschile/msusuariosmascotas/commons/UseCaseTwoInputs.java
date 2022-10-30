package pch.huellaschile.msusuariosmascotas.commons;

public interface UseCaseTwoInputs<Input, Input2, Output> {
    Output execute(Input input, Input2 input2);
}
