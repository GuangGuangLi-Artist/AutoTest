package com.course.code.deepshallowcopy;

public class DeepCopy  implements Cloneable{

    private String name;

    public DeepCopy(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public DeepCopy clone(){
        try {
            return (DeepCopy) super.clone();
        }catch (CloneNotSupportedException e){
            throw new AssertionError();
        }
    }
}

class PersonDeep implements Cloneable{

    private DeepCopy deepCopy;

    public PersonDeep(DeepCopy deepCopy) {
        this.deepCopy = deepCopy;
    }

    public DeepCopy getDeepCopy() {
        return deepCopy;
    }

    public void setDeepCopy(DeepCopy deepCopy) {
        this.deepCopy = deepCopy;
    }

    public PersonDeep clone(){

        try {
            PersonDeep pd = (PersonDeep) super.clone();
            pd.setDeepCopy(pd.getDeepCopy().clone());
            return pd;

        }catch (CloneNotSupportedException e){
            throw  new AssertionError();
        }
    }
}
