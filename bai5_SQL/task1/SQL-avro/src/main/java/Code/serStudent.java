package Code;

import model.NameGroup;
import model.NameGroupStudent;
import model.Student;
import model.Subjects;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class serStudent {
    public static void main(String[] args) throws IOException {
        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String PATH = s+"/src/main/java/FileSave/Subject.avro";
        DatumReader<Subjects> empDatumReader = new SpecificDatumReader<>(Subjects.class);
        List<Subjects> listSubject = new ArrayList<>();
        //Instantiating DataFileReader
        DataFileReader<Subjects> dataFileReader = new DataFileReader<>(new
                File(PATH), empDatumReader);

        while(dataFileReader.hasNext()){
            Subjects em = new Subjects();
            em = dataFileReader.next(em);
            listSubject.add(em);
//            System.out.println(em);
        }
//        -----------------------------------
        Student student1 = new Student();
        DatumWriter<Student> DatumWriter = new SpecificDatumWriter<Student>(Student.class);
        DataFileWriter<Student> FileWriter = new DataFileWriter<Student>(DatumWriter);
        FileWriter.create(student1.getSchema(), new File(s+"/src/main/java/FileSave/student.avro"));
        System.out.println("oke");
//        -----------------------------------------
        for (int ids = 1; ids <= 21260; ids ++){
            List<Integer> listSubjectCheck = new ArrayList<>() ;
            Student student = new Student();
            List<NameGroupStudent> listGroupSubjectStudent = new ArrayList<>();
            student.setIdStuden(ids);
            student.setSlSubject(5);
            int sl = 5;
            while (sl > 0){
                for(Subjects sj : listSubject){
                    if (!listSubjectCheck.contains(sj.getSubject())){
                        listSubjectCheck.add(sj.getSubject());
                        for (NameGroup ng : sj.getListNameGroup()){
                            if (ng.getSlStudenr() > 0){
                                ng.setSlStudenr(ng.getSlStudenr()-1);
                                NameGroupStudent nameGroupSubject = new NameGroupStudent();
                                nameGroupSubject.setGroup(ng.getGroup());
                                nameGroupSubject.setClassRegistration(sj.getSubject());
                                listGroupSubjectStudent.add(nameGroupSubject);
                                Random rd = new Random();
                                nameGroupSubject.setScore((float) Math.ceil(rd.nextFloat()*10 * 100) / 100);
                                sl -= 1;
                                break;
                            }
                        }
                        break;
                    }
                }
            }
            student.setListSubject(listGroupSubjectStudent);
            FileWriter.append(student);
            System.out.println(student);
        }
        FileWriter.close();
        System.out.println("data successfully serialized");
    }
}
