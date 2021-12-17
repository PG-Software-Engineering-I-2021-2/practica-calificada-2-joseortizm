import java.util.*;
import java.util.logging.Logger;

public class Principal {

    public final Logger logger = Logger.getLogger(Principal.class.getName());

    private final  Map<Integer, List<Pair<Teacher, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>( new TeacherTC(1,"Josefina"), true),
                            new Pair<>( new TeacherTC(1,"Edonisio"), true),
                            new Pair<>( new TeacherTC(1,"Edufasio"), false),
                            new Pair<>( new TeacherTC(0,"Juan"), true)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>( new TeacherTC(1,"Eduarda"), false),
                            new Pair<>( new TeacherTC(1,"Abelardo"), true),
                            new Pair<>( new TeacherTC(1,"Francisca"), false)
                    )
            )
    );
    private final int yearToCalculate;

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }

    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (!examsStudents.isEmpty()) {
            boolean hasToIncreaseOneExtraPoint = isHasToIncreaseOneExtraPoint();
            float gradesSum       = getGradesSum(examsStudents);
            int   gradesWeightSum = getGradesWeightSum(examsStudents);




            return computeGrades(hasReachedMinimumClasses, hasToIncreaseOneExtraPoint, gradesSum, gradesWeightSum);
        } else {
            return 0f;
        }
    }

    private float computeGrades(boolean hasReachedMinimumClasses,
                                boolean hasToIncreaseOneExtraPoint,
                                float gradesSum,
                                int gradesWeightSum) {

        if (gradesWeightSum == 100) {
            if (hasReachedMinimumClasses) {
                if (hasToIncreaseOneExtraPoint) {
                    return Float.min(10f, gradesSum + 1);
                } else {
                    return gradesSum;
                }
            } else {
                return 0f;
            }
        }

        if (gradesWeightSum > 100) {
            return -1f;
        }else {
            return -2f;
        }



    }

    private boolean isHasToIncreaseOneExtraPoint() {
        boolean hasToIncreaseOneExtraPoint = false;

        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (yearToCalculate == yearlyTeachers.getKey()) {
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<Teacher, Boolean> teacher : teachers) {
                    if (teacher.first().getTipo() == 1) {
                        if (teacher.second()) {
                            hasToIncreaseOneExtraPoint = true;
                        }
                    }
                }
            }
        }
        return hasToIncreaseOneExtraPoint;
    }

    private int getGradesWeightSum(List<Pair<Integer, Float>> examsStudents) {
        int   gradesWeightSum = 0;
        for (Pair<Integer, Float> examGrade : examsStudents) {
            gradesWeightSum += examGrade.first();
        }
        return gradesWeightSum;
    }


    private float getGradesSum(List<Pair<Integer, Float>> examsStudents) {
        float gradesSum       = 0f;
        for (Pair<Integer, Float> examGrade : examsStudents) {
            gradesSum += (examGrade.first() * examGrade.second() / 100);
        }
        return gradesSum;
    }


    public List<String> imprimirProfesorOtorgaextra(){
        List<String> teachersThatIncrease = new LinkedList<String>(Arrays.asList());
        for (List<Pair<Teacher, Boolean>> teachers : this.allYearsTeachers.values()){
            for (Pair<Teacher, Boolean> pair : teachers){
                if(pair.second()) {
                    teachersThatIncrease.add(pair.first().getNombre());
                }
            }
        }

        return teachersThatIncrease;
    }

    public static void main(String[] args) {
        System.out.println("Hola");
        }
    }

