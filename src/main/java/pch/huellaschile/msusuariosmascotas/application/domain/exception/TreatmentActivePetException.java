package pch.huellaschile.msusuariosmascotas.application.domain.exception;

public class TreatmentActivePetException extends Exception {
    private static final long serialVersionUID = -8890080495441147845L;

    private String message;
    private Object[] args;

    public TreatmentActivePetException(String name) {
        this.message = String.format("There is already a pet with the name - %s", name);
    }

    public TreatmentActivePetException(Object[] args) {
        this.args = args;
    }

    public TreatmentActivePetException(String message, Object[] args) {
        this.message = message;
        this.args = args;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
