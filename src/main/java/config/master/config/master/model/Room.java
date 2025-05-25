package config.master.config.master.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(length = 3000)
    private String comment;

    @ManyToOne
    @JoinColumn(name = "branch_id")
    private Branch branch;

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Equipment> equipments = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Network> networks = new ArrayList<>();

    @OneToMany(mappedBy = "room", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<FileEntity> files = new ArrayList<>();

    public Room() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    public List<Equipment> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<Equipment> equipments) {
        this.equipments = equipments;
    }

    public List<Network> getNetworks() {
        return networks;
    }

    public void setNetworks(List<Network> networks) {
        this.networks = networks;
    }

    public List<FileEntity> getFiles() {
        return files;
    }

    public void setFiles(List<FileEntity> files) {
        this.files = files;
    }

    public void addEquipment(Equipment equipment) {
        equipments.add(equipment);
        equipment.setRoom(this);
    }

    public void removeEquipment(Equipment equipment) {
        equipments.remove(equipment);
        equipment.setRoom(null);
    }

    public void addNetwork(Network network) {
        networks.add(network);
        network.setRoom(this);
    }

    public void removeNetwork(Network network) {
        networks.remove(network);
        network.setRoom(null);
    }

    public void addFile(FileEntity file) {
        files.add(file);
        file.setRoom(this);
    }

    public void removeFile(FileEntity file) {
        files.remove(file);
        file.setRoom(null);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return Objects.equals(id, room.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
