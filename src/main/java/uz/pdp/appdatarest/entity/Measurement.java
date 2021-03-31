package uz.pdp.appdatarest.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import uz.pdp.appdatarest.entity.template.AbstractEntity;

import javax.persistence.Entity;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
public class Measurement extends AbstractEntity {

}
