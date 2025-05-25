package config.master.config.master.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name must be not empty")
    @Size(min=2, max=100, message = "Name must be more then 2 and less then 100")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @OneToMany(mappedBy = "branch", cascade = jakarta.persistence.CascadeType.ALL)
    private List<Room> rooms = new ArrayList<>();

    public Branch() {
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public void addRoom(Room room) {
        if (room != null) {
            rooms.add(room);
            room.setBranch(this);
        }
    }

    public void removeRoom(Room room) {
        if (room != null) {
            rooms.remove(room);
            room.setBranch(null);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Branch branch = (Branch) o;
        return Objects.equals(id, branch.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    @Override
    public String toString() {
        return "Branch{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

}
