package uz.pdp.appdatarest.projection;

import org.springframework.data.rest.core.config.Projection;
import uz.pdp.appdatarest.entity.Category;

@Projection(types = Category.class)
public interface CustomCategory {

    Integer getId();

    String getName();

    boolean isActive();

    Integer getParentCategory();

    /*@Value("#{target.parentCategory?.id ?: null}")
    Integer getParentCategoryId();*/

}
