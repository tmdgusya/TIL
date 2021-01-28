package Week4.DB;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class App {

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    Employee employee = new Employee();


    public void start() throws IOException {
        employee.init();
        while(true){
            employee.print();
            String order = br.readLine();
            if(order.equals("new")){
                System.out.println("자리 할당을 시작합니다.");
                System.out.print("고유아이디를 입력해주세요 : ");
                int userId = Integer.parseInt(br.readLine());
                employee.assign(userId);
            }else if(order.equals("stop")){
                System.out.println("자리 비할당을 시작합니다.");
                System.out.print("고유아이디를 입력해주세요 : ");
                int userId = Integer.parseInt(br.readLine());
                employee.stop(userId);
            }
        }
    }
}
