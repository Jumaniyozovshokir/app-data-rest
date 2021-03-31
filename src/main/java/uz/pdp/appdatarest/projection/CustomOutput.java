package uz.pdp.appdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appdatarest.entity.*;
import java.sql.Timestamp;

@Projection(types = Output.class)
public interface CustomOutput {

    Integer getId();

    Timestamp getDate();

    Integer getWarehouse();

    Integer getClient();

    Integer getCurrency();

    String getFactureNumber();

    String getCode();

}
