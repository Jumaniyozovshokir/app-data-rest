package uz.pdp.appdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appdatarest.entity.*;

import javax.persistence.Column;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Projection(types = OutputProduct.class)
public interface CustomOutputProduct {

    Integer getId();

    Integer getProduct();

    Double getAmount();

    Double getPrice();

    Integer getOutput();

}
