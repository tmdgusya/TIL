package Chapter03.Item01.ExampleCode;

public class Main {

    public static void main(String[] args) {
        Grade JSH = GradeFactory.getGradeInstance("jsh",300000);
        Grade KIM = GradeFactory.getGradeInstance("kim", 180000);
        Grade DOD = GradeFactory.getGradeInstance("dod", 500000);
        System.out.println(JSH.getGrade());
        System.out.println(KIM.getGrade());
        System.out.println(DOD.getGrade());
    }
}
