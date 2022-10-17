package com.terminal.entity;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class AbstractEntity {
    public abstract Long getId();

    @Override
    public boolean equals(Object obj) {
        if (obj == null)
            return false;
        if (!(obj instanceof AbstractEntity))
            return false;

        Class<? extends AbstractEntity> myClass = this.getClass();
        Class<? extends Object> targetClass = obj.getClass();

        AbstractEntity targetObject = (AbstractEntity) obj;
        if (myClass.equals(targetClass) && this.getId() != null && this.getId().equals(targetObject.getId())) {
            return true;
        }
        return false;
    }
}
