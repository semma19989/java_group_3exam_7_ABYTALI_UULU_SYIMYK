package kg.attaractor.exam7.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Document(collection = "orders")
@Data
@Builder
public class Order {
    @Id
    private String id;
    @DBRef
    private UserClient client;
    @DBRef
    private Food dish;
    private LocalDateTime date;
    private LocalDate dateTime;

    public static Order addOrder(){
        return Order.builder()
                .date(LocalDateTime.now())
                .build();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDate dateTime) {
        this.dateTime = dateTime;
    }

    public List<Plate> getPlates() {
        return plates;
    }

    public void setPlates(List<Plate> plates) {
        this.plates = plates;
    }


    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }

    public static long getSerialversionuid() {
        return serialVersionUID;
    }

}
}
