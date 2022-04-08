package entity;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "flights", schema = "flyaway")
public class FlightsEntity {
    private int id;
    private String price;
    private Timestamp departureTime;
    private AirlineEntity airline;
    private PlacesEntity destination;
    private PlacesEntity source;

    @Id
    @Column(name = "ID", nullable = false, insertable = false, updatable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "price", nullable = false)
    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Basic
    @Column(name = "departure_time", nullable = false)
    public Timestamp getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(Timestamp departureTime) {
        this.departureTime = departureTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        FlightsEntity that = (FlightsEntity) o;

        if (id != that.id) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;
        if (departureTime != null ? !departureTime.equals(that.departureTime) : that.departureTime != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (price != null ? price.hashCode() : 0);
        result = 31 * result + (departureTime != null ? departureTime.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "airline", referencedColumnName = "ID", nullable = false)
    public AirlineEntity getAirline() {
        return airline;
    }

    public void setAirline(AirlineEntity airline) {
        this.airline = airline;
    }

    @ManyToOne
    @JoinColumn(name = "destination", referencedColumnName = "ID", nullable = false)
    public PlacesEntity getDestination() {
        return destination;
    }

    public void setDestination(PlacesEntity placesByDestination) {
        this.destination = placesByDestination;
    }

    @ManyToOne
    @JoinColumn(name = "source", referencedColumnName = "ID", nullable = false)
    public PlacesEntity getSource() {
        return source;
    }

    public void setSource(PlacesEntity placesBySource) {
        this.source = placesBySource;
    }

    @Override
    public String toString() {
        return "FlightsEntity{" +
                "id=" + id +
                ", price='" + price + '\'' +
                ", departureTime=" + departureTime +
                ", airline=" + airline +
                ", destination=" + destination +
                ", source=" + source +
                '}';
    }
}
