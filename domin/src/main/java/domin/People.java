package domin;

import lombok.Data;

@Data
public class People {
    private String id;
    private String name;
    private Integer age;

    @Override
    public String toString() {
        return "[id:"+id+",name:"+name+",age:"+age+"]";
    }
}
