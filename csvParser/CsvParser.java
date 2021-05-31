package csvParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CsvParser {
    private  static  CsvParser csvParser =null;

    private CsvParser(){

    }
    public static CsvParser getInstance(){
        if(csvParser==null){
            csvParser=new CsvParser();
        }
        return csvParser;
    }
    public List<csvParser.Data> openCsvAndGetData(String path){
        File file = new File(path);
        Scanner inputStream;
        List<csvParser.Data> data=  new ArrayList<>();
        List<List<String> > insertList = new ArrayList<List<String>>();
        try {
            inputStream= new Scanner(file);
            while (inputStream.hasNextLine()){
                String line = inputStream.nextLine();
                String value[] = line.split(",");
                Data data1 = new Data(Integer.valueOf(value[0]),value[1],Integer.valueOf(value[2]),Integer.valueOf(value[3]),value[4]);
                data.add(data1);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(data==null || data.size()==0) return null;
        return data;
    }

    public List<Data> fGrep(String path, String content){
        File file = new File(path);
        Scanner inputStream;
        List<Data> data=  new ArrayList<>();
        List<List<String> > insertList = new ArrayList<List<String>>();
        try {
            inputStream= new Scanner(file);
            while (inputStream.hasNextLine()){
                String line = inputStream.nextLine();
                if(!line.contains(content)) continue;
                String value[] = line.split(",");
                Data data1 = new Data(Integer.valueOf(value[0]),value[1],Integer.valueOf(value[2]),Integer.valueOf(value[3]),value[4]);
                data.add(data1);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if(data==null || data.size()==0) return null;
        return data;
    }
}
