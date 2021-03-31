package uz.pdp.appdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appdatarest.entity.*;

import java.sql.Timestamp;

@Projection(types = Input.class)
public interface CustomInput {

    Integer getId();

    Timestamp getDate();

    Integer getWarehouse();

    Integer getSupplier();

    Integer getCurrency();

    String getFactureNumber();

    String getCode();

}
