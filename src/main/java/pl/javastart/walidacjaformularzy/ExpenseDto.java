package pl.javastart.walidacjaformularzy;

import javax.validation.constraints.*;
import java.math.BigDecimal;

public class ExpenseDto {
    //nie mamy bazy danych więc bez encji

    @NotBlank // sprawdza czy nie zostały użyte same spacje, puste znaki
    @NotEmpty(message = "Nazwa nie może być pusta") //nazwa nie może być pusta, zmieniamy wiadomosc na nasza, notnull w przypadku nazwy nie ma sensu bo jesli nie uzupelnimy to jest pustym ciagiem znakow
    private String name;

    @NotNull(message = "Wartość nie może być pusta")
    @Positive (message = "Wartość musi być większe od 0") // muszą być dodatnie
    private BigDecimal value;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value) {
        this.value = value;
    }
}
