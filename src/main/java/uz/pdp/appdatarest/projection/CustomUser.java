package uz.pdp.appdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appdatarest.entity.User;
import uz.pdp.appdatarest.entity.Warehouse;

import java.util.Set;

@Projection(types = User.class)
public interface CustomUser {

    Integer getId();

    String getFirstname();

    String getLastname();

    String getPhoneNumber();

    String getCode();

    String getPassword();

    boolean isActive();

    Set<Warehouse> getWarehouses();

}
