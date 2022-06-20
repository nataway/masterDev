package Code;

import model.NameGroup;
import model.Subjects;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GenDataClassTable {
    public static void main(String[] args) throws IOException {
        DatumWriter<Subjects> empDatumWriter = new SpecificDatumWriter<Subjects>(Subjects.class);
        DataFileWriter<Subjects> empFileWriter = new DataFileWriter<Subjects>(empDatumWriter);
        Path currentRelativePath = Paths.get("");
        Subjects subject = new Subjects();
        String s = currentRelativePath.toAbsolutePath().toString();
        empFileWriter.create(subject.getSchema(), new File(s+"/src/main/java/FileSave/Subject.avro"));


        for (int j = 1; j <= 1000; j++) {

            Subjects subjects = new Subjects();
            List<NameGroup> ListNameGroup = new ArrayList<>();
            Random rd = new Random();
            int id_Teacher = j;
            int SlGroup = 5;
            int SlStudent = 60 +rd.nextInt(100);
            int nameSubject = 1 + rd.nextInt(200);
            for (int i = 1; i <= SlGroup ; i++ ){
                NameGroup nameGroup = new NameGroup();
                nameGroup.setGroup(i);
                nameGroup.setSlStudenr(SlStudent);
                ListNameGroup.add(nameGroup);
            }
            subjects.setTeacher(id_Teacher);
            subjects.setSubject(nameSubject);
            subjects.setSlStudent(SlStudent);
            subjects.setSoluongGroup(SlGroup);
            subjects.setListNameGroup(ListNameGroup);
            empFileWriter.append(subjects);

        }
        empFileWriter.close();
        System.out.println("data successfully serialized");
    }
}
