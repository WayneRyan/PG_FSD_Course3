package entity;

import javax.persistence.*;

@Entity
@Table(name = "products", schema = "project_two")
public class ProductsEntity {
    private int id;
    private String details;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "details", nullable = true, length = 255)
    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ProductsEntity that = (ProductsEntity) o;

        if (id != that.id) return false;
        if (details != null ? !details.equals(that.details) : that.details != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (details != null ? details.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ProductsEntity{" +
                "id=" + id +
                ", details='" + details + '\'' +
                '}';
    }
}
