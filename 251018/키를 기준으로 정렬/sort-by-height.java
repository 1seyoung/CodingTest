import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Student[] students = new Student[n];

        // Please write your code here.
        for(int i = 0; i < n; i++){
            String name = sc.next();
            int height = sc.nextInt();
            int weight = sc.nextInt();

            
            students[i] = new Student(name, height, weight);
        }

        Arrays.sort(students);

        for(int i = 0; i < n; i++){
            students[i].printStudentInfo();
        }

    }
}

class Student implements Comparable<Student> {
    String name;
    int height;
    int weight;

    public Student(String name, int height, int weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
    }

    @Override
    public int compareTo(Student e) {
        return this.height - e.height;
    }

    public void printStudentInfo(){
        System.out.println(this.name +" "+ this.height+" "+ this.weight);
    }
}