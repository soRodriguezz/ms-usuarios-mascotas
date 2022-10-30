package pch.huellaschile.msusuariosmascotas.commons;

public interface UseCase<Input, Output> {

    Output execute(Input input);

}
