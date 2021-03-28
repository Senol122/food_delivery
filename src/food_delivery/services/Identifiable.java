package food_delivery.services;
import java.util.UUID;

public interface Identifiable {
    default String genID ()
    {
        return UUID.randomUUID().toString();
    }

    String getID();
}
