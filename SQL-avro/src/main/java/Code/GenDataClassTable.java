package Code;

import com.opencsv.CSVWriter;
import model.NameGroup;
import model.Subjects;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.io.DatumReader;
import org.apache.avro.specific.SpecificDatumReader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DeClassSubject {


    public static void main(String[] args) throws IOException {

        Path currentRelativePath = Paths.get("");
        String s = currentRelativePath.toAbsolutePath().toString();
        String PATH = s+"/src/main/java/FileSave/Subject.avro";
        String pathcsv = s+"/src/main/java/Csv/class.csv";
        File file = new File(pathcsv);
        FileWriter outputfile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputfile,
                CSVWriter.DEFAULT_SEPARATOR,
                CSVWriter.NO_QUOTE_CHARACTER,
                CSVWriter.NO_ESCAPE_CHARACTER,
                CSVWriter.DEFAULT_LINE_END);
        String [] header = {"idTeacher","idSubject","group"};
        writer.writeNext(header);
        writer.flush();

        DatumReader<Subjects> empDatumReader = new SpecificDatumReader<>(Subjects.class);

        //Instantiating DataFileReader
        DataFileReader<Subjects> dataFileReader = new DataFileReader<>(new
                File(PATH), empDatumReader);
        Subjects em = null;
        int sum = 0;
        int k = 0;
        List<Subjects> subjectsList = new ArrayList<>();
        while(dataFileReader.hasNext()){
            em = dataFileReader.next();
            k+=1;
//            subjectsList.add(em);
            System.out.println(em);
            int idTeacher = em.getTeacher();
            int idSubject = em.getSubject();
            for (int i = 1 ; i <= 5 ; i++){
                String[] x = {String.valueOf(idTeacher), String.valueOf(idSubject), String.valueOf(i)};
                writer.writeNext(x);
                writer.flush();
            }

//            sum += em.getSoluongGroup() * em.getSlStudent();
        }
        writer.close();
//        System.out.println(sum);
//        System.out.println(k);
//        for (Subjects sj : subjectsList){
//            System.out.println(sj);
//        }
    }
}
