package entity;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table(name = "airline", schema = "flyaway")
public class AirlineEntity {
    private int id;
    private String name;
    private Collection<FlightsEntity> flights;

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

        AirlineEntity that = (AirlineEntity) o;

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

    @OneToMany(mappedBy = "airline")
    public Collection<FlightsEntity> getFlights() {
        return flights;
    }

    public void setFlights(Collection<FlightsEntity> flights) {
        this.flights = flights;
    }
}
