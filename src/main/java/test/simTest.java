package test;

import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


public class simTest {

    @Test
    public void MyTest() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        List<Integer> list1 =  list.stream().filter(integer -> {
            if (integer==2){
                return false;
            }else {
                return true;
            }
        }).collect(Collectors.toList());
        System.out.println(list1);
    }
}
