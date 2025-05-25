package config.master.config.master.dto.branch;

import config.master.config.master.dto.room.RoomDto;

import java.util.ArrayList;
import java.util.List;

public class BranchDto {
    private Long id;
    private String name;
    private Long companyId;
    private List<RoomDto> rooms = new ArrayList<>();

    public BranchDto() {
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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public List<RoomDto> getRooms() {
        return rooms;
    }

    public void setRooms(List<RoomDto> rooms) {
        this.rooms = rooms;
    }
}
