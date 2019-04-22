import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class MyDriver {
    public static void main(String[] args) {
        System.out.println("Starting driver");

        List<CustomerPractice> customerList = new ArrayList();

        CustomerPractice cust1 = new CustomerPractice("phil", 3);
        CustomerPractice cust2 = new CustomerPractice("james", 5);
        CustomerPractice cust3 = new CustomerPractice("jim", 10);
        CustomerPractice cust4 = new CustomerPractice("cathy", 2);

        customerList.add(cust1);
        customerList.add(cust2);
        customerList.add(cust3);
        customerList.add(cust4);

        System.out.println(avgOfAll(customerList));

    }

//    Query 1: What is the average age of all customers?
        public static double avgOfAll(List<CustomerPractice> customerList) {
            double avgAgeOfAllCustomers = customerList
                    .stream()
                    .mapToInt(CustomerPractice::getAge)
                    .average()
                    .getAsDouble();

            return avgAgeOfAllCustomers;
        }


}
