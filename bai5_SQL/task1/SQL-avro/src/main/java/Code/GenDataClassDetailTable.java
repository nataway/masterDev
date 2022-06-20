package Code;

import com.opencsv.CSVWriter;
import model.NameGroupStudent;
import model.Student;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class GenDataClassDetailTable {
    public static void main(String[] args) throws IOException {

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String PATH = s+"/src/main/java/FileSave/student.avro";

        String pathcsv = s+"/src/main/java/Csv/classDetail.csv";
        File file = new File(pathcsv);
        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile,
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.NO_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        String [] header = {"idClass","idStudent","score"};
        writer.writeNext(header);
        writer.flush();
        DatumReader<Student> empDatumReader = new SpecificDatumReader<>(Student.class);
        DataFileReader<Student> dataFileReader = new DataFileReader<>(new
                File(PATH), empDatumReader);
        Student em = null;
        while(dataFileReader.hasNext()){
            em = dataFileReader.next();
            List<NameGroupStudent> listSubject = em.getListSubject();
            for (NameGroupStudent i : listSubject){
                String[] x = {String.valueOf(i.getClassRegistration()), String.valueOf(em.getIdStuden()), String.valueOf(i.getScore())};
                writer.writeNext(x);
                writer.flush();
            }
        }
        writer.close();
    }
}
