package common;

import javax.persistence.Id;

/**
 * Created by admin on 11/2/2015.
 */
public abstract class AbstractEntity {

    @Id
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
