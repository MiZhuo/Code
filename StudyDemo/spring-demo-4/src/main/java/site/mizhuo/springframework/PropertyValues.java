package site.mizhuo.springframework;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName PropertyValue
 * @Description:
 * @Author: MiZhuo
 * @Create: 2021-09-29 17:19
 * @Version 1.0
 **/
public class PropertyValues {

   private List<PropertyValue> propertyValueList = new ArrayList<PropertyValue>();

   public void addPropertyValue(PropertyValue propertyValue){
       this.propertyValueList.add(propertyValue);
   }

   public PropertyValue[] getPropertyValues(){
       return this.propertyValueList.toArray(new PropertyValue[0]);
   }

   public PropertyValue getPropertyValue(String name){
       for (PropertyValue propertyValue : propertyValueList) {
           if(propertyValue.getName().equals(name)){
               return propertyValue;
           }
       }
       return null;
   }
}
