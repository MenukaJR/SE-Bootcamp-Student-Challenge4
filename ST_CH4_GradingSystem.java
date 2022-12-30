import java.util.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

class Student {
    private String fname, lname, course;

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getCourse() {
        return course;
    }

}

class EnglishStudent extends Student {
    final int TPAPERTOT = 30;
    final int MIDTERM = 30;
    final int FEXAM = 40;
    float total, netTotal, avg;

    private int tPaperMarks, midTMarks, fExamMarks;

    public int gettPaperMarks() {
        return tPaperMarks;
    }

    public void settPaperMarks(int tPaperMarks) {
        this.tPaperMarks = tPaperMarks;
    }

    public int getMidTMarks() {
        return midTMarks;
    }

    public void setMidTMarks(int midTMarks) {
        this.midTMarks = midTMarks;
    }

    public int getfExamMarks() {
        return fExamMarks;
    }

    public void setfExamMarks(int fExamMarks) {
        this.fExamMarks = fExamMarks;
    }

    public float Calculate_Scores() {
        total = 0;

        try {

            netTotal = (float) tPaperMarks / 100 * TPAPERTOT;
            total = (float) total + netTotal; // storing total of all calculations to "total" variable

            netTotal = (float) midTMarks / 100 * MIDTERM;
            total = (float) total + netTotal;

            netTotal = (float) fExamMarks / 100 * FEXAM;
            total = (float) total + netTotal;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e);
        }
        return (float) Math.round(total);
    }

    public String findAverage() {
        avg = (float) total / 3;
        return String.format("%.2f", avg);
    }
}

class ScienceStudent extends Student {
    final int ATTENDANCE = 10;
    final int PROJECT = 30;
    final int MIDTERM = 30;
    final int FINAL_EXAM = 30;

    private int attd, proj, mTerm, fExam;
    private float total, netTotal, avg;

    public int getAttd() {
        return attd;
    }

    public void setAttd(int attd) {
        this.attd = attd;
    }

    public int getProj() {
        return proj;
    }

    public void setProj(int proj) {
        this.proj = proj;
    }

    public int getmTerm() {
        return mTerm;
    }

    public void setmTerm(int mTerm) {
        this.mTerm = mTerm;
    }

    public int getfExam() {
        return fExam;
    }

    public void setfExam(int fExam) {
        this.fExam = fExam;
    }

    public float Calculate_Scores() {
        total = 0;

        try {

            netTotal = (float) attd / 100 * ATTENDANCE;
            total = total + netTotal;

            netTotal = (float) mTerm / 100 * MIDTERM;
            total = total + netTotal;

            netTotal = (float) proj / 100 * PROJECT;
            total = total + netTotal;

            netTotal = (float) fExam / 100 * FINAL_EXAM;
            total = total + netTotal;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e);
        }
        return (float) Math.round(total);
    }

    public String findAverage() {
        avg = (float) total / 4;
        return String.format("%.2f", avg);
    }

}

class MathsStudent extends Student {
    final int QUIZ = 15;
    final int TEST1 = 30;
    final int TEST2 = 20;
    final int FINAL_EXAM = 35;

    private int quizMarks, test1Marks, test2Marks, fExam;
    private float total, netTotal, avg;

    public int getQuizMarks() {
        return quizMarks;
    }

    public void setQuizMarks(int quizMarks) {
        this.quizMarks = quizMarks;
    }

    public int getTest1Marks() {
        return test1Marks;
    }

    public void setTest1Marks(int test1Marks) {
        this.test1Marks = test1Marks;
    }

    public int getTest2Marks() {
        return test2Marks;
    }

    public void setTest2Marks(int test2Marks) {
        this.test2Marks = test2Marks;
    }

    public int getfExam() {
        return fExam;
    }

    public void setfExam(int fExam) {
        this.fExam = fExam;
    }

    public float Calculate_Scores() {
        try {

            netTotal = (float) quizMarks / 100 * QUIZ;
            total = total + netTotal;

            netTotal = (float) test1Marks / 100 * TEST1;
            total = total + netTotal;

            netTotal = (float) test2Marks / 100 * TEST2;
            total = total + netTotal;

            netTotal = (float) fExam / 100 * FINAL_EXAM;
            total = total + netTotal;
        } catch (ArithmeticException e) {
            System.out.println("Error: " + e);
        }

        return (float) Math.round(total);
    }

    public String findAverage() {

        avg = (float) total / 4;
        return String.format("%.2f", avg);
    }

}

public class ST_CH4_GradingSystem {

    public static String placeGrades(float d) {
        String grade = "";
        int num;

        num = (int) (Math.round(d));
        if (num < 59) {
            grade = "F";
        } else if (num >= 60 && num <= 69) {
            grade = "D";
        } else if (num >= 70 && num <= 79) {
            grade = "C";
        } else if (num >= 80 && num <= 89) {
            grade = "B";
        } else if (num >= 90 && num <= 100) {
            grade = "A";
        }
        return grade;
    }

    /**
     * @param args
     * @throws IOException
     */
    public static void main(String[] args) throws IOException {
        String line, subLine, studentSubj;
        String[] subGrade;
        String[] st_Name;
        String stu_name;
        String record;
        int StuCount;
        int mQuizTot;
        float finalMarks;
        int StuIndex = 1;
        Boolean flag = true;

        ArrayList<String> TxtLines = new ArrayList<>();
        ArrayList<String> outputList = new ArrayList<>();

        Path outputFile = Paths.get("C:\\[SPECIFY PATH]\\OUTPUT_Example.txt"); //output file location

        File file = new File("C:\\[SPECIFY PATH]\\INPUT_Example.txt");// input file location
        BufferedReader BR = new BufferedReader(new FileReader(file));

        while (flag == true) {
            try {
                if ((line = BR.readLine()) != null) {
                    TxtLines.add(line);// each line stored to an array list
                } else {
                    flag = false;
                }

            } catch (IOException e) {

                e.printStackTrace();
            }
        }

        System.out.println(TxtLines);

        StuCount = Integer.parseInt(TxtLines.get(0));
        subGrade = new String[9];

        for (int x = 1; x <= StuCount; x++) { // going to repeat for each student

            System.out.println("Student " + x);// student number identification for easy understanding

            // index starts at 1
            // because 1st index is No. of students

            stu_name = TxtLines.get(StuIndex);
            StuIndex++; // index incremented to get Student subject

            subLine = TxtLines.get(StuIndex);
            subGrade = subLine.split(" ");
            StuIndex++; // incremented again for the next student record
            studentSubj = subGrade[0];
            st_Name = stu_name.split(",");

            switch (studentSubj) {

                case "English":

                    EnglishStudent eStudent = new EnglishStudent();

                    try {

                        eStudent.setLname(st_Name[0]);
                        eStudent.setFname(st_Name[1]);
                        eStudent.setCourse(studentSubj);
                        eStudent.settPaperMarks(Integer.parseInt(subGrade[1]));
                        eStudent.setMidTMarks(Integer.parseInt(subGrade[2]));
                        eStudent.setfExamMarks(Integer.parseInt(subGrade[3]));

                        finalMarks = (float) eStudent.Calculate_Scores();

                        /* = creating record of data in order, as specified= */
                        record = eStudent.getFname() + " " + eStudent.getLname() + "\n" +
                                "Final Exam Grade: " + finalMarks + "| " + "Average: " + eStudent.findAverage() + "| "
                                + "Grade: " + placeGrades((float) finalMarks) + "\n" +
                                "Subject: " + eStudent.getCourse()+"\n";
                        System.out.println("");
                        System.out.println(record);
                        outputList.add(record);

                    }

                    catch (Exception e) {
                        System.out.println("");
                        System.out.println("Error in Student Record: " + st_Name[0] + " " + st_Name[1] + "\n"
                                + "Error Details: \n" + e);
                        flag = false;
                    }

                    break;

                case "Science":

                    ScienceStudent scStudent = new ScienceStudent();

                    try {
                        scStudent.setCourse(studentSubj);
                        scStudent.setLname(st_Name[0]);
                        scStudent.setFname(st_Name[1]);
                        scStudent.setAttd(Integer.parseInt(subGrade[1]));
                        scStudent.setProj(Integer.parseInt(subGrade[2]));
                        scStudent.setmTerm(Integer.parseInt(subGrade[3]));
                        scStudent.setfExam(Integer.parseInt(subGrade[4]));

                        finalMarks = (float) scStudent.Calculate_Scores();

                        record = scStudent.getFname() + " " + scStudent.getLname() + "\n" +
                                "Final Exam Grade: " + finalMarks + "| " + "Average: " + scStudent.findAverage() + "| "
                                + "Grade: " + placeGrades((float) finalMarks) + "\n" +
                                "Subject: " + scStudent.getCourse()+"\n";
                        System.out.println("");
                        System.out.println(record);

                        outputList.add(record);

                    } catch (Exception e) {
                        System.out.println("");
                        System.out.println("Error in Student Record: " + st_Name[0] + " " + st_Name[1] + "\n"
                                + "Error Details: \n" + e);
                        flag = false;
                    }
                    break;

                case "Maths":
                    try {

                        MathsStudent mStudent = new MathsStudent();

                        mQuizTot = Integer.parseInt(subGrade[1]) + Integer.parseInt(subGrade[2]) +
                                Integer.parseInt(subGrade[3]) + Integer.parseInt(subGrade[4]) +
                                Integer.parseInt(subGrade[5]);

                        mStudent.setCourse(studentSubj);
                        mStudent.setLname(st_Name[0]);
                        mStudent.setFname(st_Name[1]);
                        mStudent.setQuizMarks(mQuizTot);
                        mStudent.setTest1Marks(Integer.parseInt(subGrade[6]));
                        mStudent.setTest2Marks(Integer.parseInt(subGrade[7]));
                        mStudent.setfExam(Integer.parseInt(subGrade[8]));

                        finalMarks = (float) mStudent.Calculate_Scores();

                        record = mStudent.getFname() + " " + mStudent.getLname() + "\n" +
                                "Final Exam Grade: " + finalMarks + "| " + "Average: " + mStudent.findAverage() + "| "
                                + "Grade: " + placeGrades((float) finalMarks) + "\n" +
                                "Subject: " + mStudent.getCourse()+"\n";
                        System.out.println("");

                        System.out.println(record);

                        outputList.add(record);

                    } catch (Exception e) {
                        System.out.println("");
                        System.out.println("Error in Student Record: " + st_Name[0] + " " + st_Name[1] + "\n"
                                + "Error Details: \n" + e);
                        flag = false;
                    }
                    break;

            }

            if(x == StuCount){
                String gradingChart;

                gradingChart = " -=Grading Scale=-\n\n"+
                                "    100-90 = A \n"+
                                "    89-80 = B \n"+
                                "    79-70 = C \n"+
                                "    69-60 = D \n"+
                                "    59-0 = f \n";
                outputList.add(gradingChart);
            }
        }
        BR.close();
        try {
            Files.write(outputFile,outputList);
        } catch (Exception e) {
            System.out.println("Error during writing to OUTPUT File: \n" +e );
        }
        
    }

}
