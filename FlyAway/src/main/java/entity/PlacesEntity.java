package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "places", schema = "flyaway")
public class PlacesEntity {
    private int id;
    private String name;
    private Collection<FlightsEntity> flightsById;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PlacesEntity that = (PlacesEntity) o;
        if (id != that.id) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @OneToMany(mappedBy = "destination")
    public Collection<FlightsEntity> getFlightsById() {
        return flightsById;
    }

    public void setFlightsById(Collection<FlightsEntity> flightsById) {
        this.flightsById = flightsById;
    }

}
