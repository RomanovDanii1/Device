package config.master.config.master.model;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

@Embeddable
public class Parameter {

    private String value;

    @Enumerated(EnumType.STRING)
    private Status status = Status.NEED;

    public Parameter() {}

    public Parameter(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Parameter{" +
                "value='" + value + '\'' +
                ", status=" + status +
                '}';
    }
}