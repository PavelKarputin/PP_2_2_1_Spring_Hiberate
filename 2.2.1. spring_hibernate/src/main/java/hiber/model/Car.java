package hiber.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String model;

    @Column
    private int series;

    @OneToOne(mappedBy = "car")
    private User user;

    public Car() { }

    public Car(String model, int series) {
        this.series = series;
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;

        if (model != null ? !model.equals(car.model) : car.model != null) return false;
        return Objects.equals(series, car.series);
    }

    @Override
    public int hashCode() {
        int result = model != null ? model.hashCode() : 0;
        result = (31 * result + 0);
        return result;
    }

    @Override
    public String toString() {
        return "Car {" +
                "id" + id +
                ", model" + model +
                ", series" + series +
                "}";
    }

    public User getUser(User user) {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

}

