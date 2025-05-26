package config.master.config.master.dto.room;

import config.master.config.master.dto.equipment.EquipmentDto;
import config.master.config.master.dto.file.FileDto;
import config.master.config.master.dto.network.NetworkDto;

import java.util.ArrayList;
import java.util.List;

public class RoomDto {
    private Long id;
    private String name;
    private String comment;
    private Long branchId;
    private List<EquipmentDto> equipments = new ArrayList<>();
    private List<NetworkDto> networks = new ArrayList<>();
    private List<FileDto> files = new ArrayList<>();

    public RoomDto() {
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

    public Long getBranchId() {
        return branchId;
    }

    public void setBranchId(Long branchId) {
        this.branchId = branchId;
    }

    public List<EquipmentDto> getEquipments() {
        return equipments;
    }

    public void setEquipments(List<EquipmentDto> equipments) {
        this.equipments = equipments;
    }

    public List<NetworkDto> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworkDto> networks) {
        this.networks = networks;
    }

    public List<FileDto> getFiles() {
        return files;
    }

    public void setFiles(List<FileDto> files) {
        this.files = files;
    }
}
