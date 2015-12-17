package com.yourbank.data.model.user;


import com.yourbank.data.model.common.AbstractEntity;
import java.util.Collections;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author admin.
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
public class Group extends AbstractEntity {

    @Column(unique = true)
    private String groupName;

    @OneToMany(fetch = FetchType.EAGER, mappedBy = "group", targetEntity = GroupAuthority.class)
    private Set<GroupAuthority> authorities = Collections.emptySet();
}