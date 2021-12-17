import java.util.AbstractMap;
import java.util.List;
import java.util.Map;



import java.util.AbstractMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Principal {

    final private Map<Integer, List<Pair<Teacher, Boolean>>> allYearsTeachers = Map.ofEntries(
            new AbstractMap.SimpleImmutableEntry<>(
                    2020,
                    List.of(
                            new Pair<>( new ProfesorTP("Josefina"), true),
                            new Pair<>( new ProfesorTP("Edonisio"), true),
                            new Pair<>( new ProfesorTP("Edufasio"), false)
                    )
            ),
            new AbstractMap.SimpleImmutableEntry<>(
                    2019,
                    List.of(
                            new Pair<>( new ProfesorTP("Eduarda"), false),
                            new Pair<>( new ProfesorTP("Abelardo"), false),
                            new Pair<>( new ProfesorTP("Francisca"), false)
                    )
            )
    );
    private final int yearToCalculate;

    public Principal(int yearToCalculate) {
        this.yearToCalculate = yearToCalculate;
    }
    public float calculateGrades(final List<Pair<Integer, Float>> examsStudents, final boolean hasReachedMinimumClasses) {
        if (!examsStudents.isEmpty()) {


            float gradesSum       = getGradesSum(examsStudents);
            int   gradesWeightSum = getGradesWeightSum(examsStudents);



            if (gradesWeightSum == 100){
                if (hasReachedMinimumClasses){

                    if (isHasToIncreaseOneExtraPoint()) {
                        return Float.min(10f, gradesSum + 1);
                    }else {
                        return gradesSum;
                    }
                }else {
                    return 0f;
                }
            }

            if(gradesWeightSum > 100){
                return -1f;
            }


            return -2f;




        } else {
            return 0f;
        }


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


    private boolean isHasToIncreaseOneExtraPoint() {
        boolean hasToIncreaseOneExtraPoint = false;

        for (Map.Entry<Integer, List<Pair<Teacher, Boolean>>> yearlyTeachers : allYearsTeachers.entrySet()) {
            if (!(yearToCalculate != yearlyTeachers.getKey())) {
                List<Pair<Teacher, Boolean>> teachers = yearlyTeachers.getValue();
                for (Pair<Teacher, Boolean> teacher : teachers) {
                    if (teacher.second() != true) {
                        continue;
                    }
                    hasToIncreaseOneExtraPoint = true;
                }
            } else {
                continue;
            }
        }
        return hasToIncreaseOneExtraPoint;
    }



    public void printTeachersWithExtraPoint(){
        for (List<Pair<Teacher, Boolean>> teachers : this.allYearsTeachers.values()){
            for (Pair<Teacher, Boolean> pair : teachers){
                if(pair.second()){
                    System.out.println(pair.first());
                }
            }
        }
    }



    public static void main(String[] args) {
        System.out.println("Hola");


    }




}
