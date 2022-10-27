import java.util.Date;

public class TestClass {
    int number;
    long creation_time;

    public TestClass(){
        Date date = new Date();
        creation_time = date.getTime();

    }

    public void setter(int x){
        number = x;
    }

    public void display_data() {
        System.out.println(number + "." + creation_time);
    }

        public static void main (String[]args){;
        TestClass[] classTable = new TestClass[3];
            //TestClass[] classTable = new TestClass[3];
            for (int i = 1; i <=3; i++){
                classTable[i-1] = new TestClass();
                classTable[i-1].setter(i);
                classTable[i-1].display_data();
            }
        }
    }
