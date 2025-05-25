package config.master.config.master.dto.parameter;

import config.master.config.master.model.Status;

public class ParameterDto {
    private String value;
    private Status status = Status.NEED;

    public ParameterDto() {}

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
}
