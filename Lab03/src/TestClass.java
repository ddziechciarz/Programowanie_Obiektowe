import java.util.Date;

public class TestClass {
    int number;
    long creation_time;
    Date date = new Date();
    public TestClass(){
        creation_time = date.getTime();

    }

    public void setter(int x){
        number = x;
    }

    public void display_data() {
        System.out.println(number + "." + creation_time);
    }

        public static void main (String[]args){
            TestClass test = new TestClass();
            test.setter(1);
            test.display_data();
        }


    }