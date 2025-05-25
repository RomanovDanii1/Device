package config.master.config.master.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.Objects;

@Entity
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "name_value")),
            @AttributeOverride(name = "status", column = @Column(name = "name_status"))
    })
    private Parameter name = new Parameter();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "description_value")),
            @AttributeOverride(name = "status", column = @Column(name = "description_status"))
    })
    private Parameter description = new Parameter();

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "value", column = @Column(name = "ip_value")),
            @AttributeOverride(name = "status", column = @Column(name = "ip_status"))
    })
    private Parameter ip = new Parameter();

    @ManyToOne
    @JoinColumn(name = "room_id")
    private Room room;

    public Equipment() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameValue() {
        return name != null ? name.getValue() : null;
    }

    public void setNameValue(String value) {
        name.setValue(value);
    }

    public String getNameStatus() {
        return name != null ? name.getStatus().toString() : null;
    }

    public void setNameStatus(String status) {
        name.setStatus(Status.fromString(status));
    }

    public String getDescriptionValue() {
        return description != null ? description.getValue() : null;
    }

    public void setDescriptionValue(String value) {
        description.setValue(value);
    }

    public String getDescriptionStatus() {
        return description != null ? description.getStatus().toString() : null;
    }

    public void setDescriptionStatus(String status) {
        description.setStatus(Status.fromString(status));
    }

    public String getIpValue() {
        return ip != null ? ip.getValue() : null;
    }

    public void setIpValue(String value) {
        ip.setValue(value);
    }

    public String getIpStatus() {
        return ip != null ? ip.getStatus().toString() : null;
    }

    public void setIpStatus(String status) {
        ip.setStatus(Status.fromString(status));
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Equipment equipment = (Equipment) o;
        return Objects.equals(id, equipment.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name=" + (name != null ? name.getValue() : "null") +
                ", description=" + (description != null ? description.getValue() : "null") +
                ", ip=" + (ip != null ? ip.getValue() : "null") +
                '}';
    }

}
