package uz.pdp.appdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appdatarest.entity.Supplier;
import uz.pdp.appdatarest.entity.User;
import uz.pdp.appdatarest.entity.Warehouse;

import java.util.Set;

@Projection(types = Supplier.class)
public interface CustomSupplier {

    Integer getId();

    String getName();

    String getPhoneNumber();

    boolean isActive();

}
