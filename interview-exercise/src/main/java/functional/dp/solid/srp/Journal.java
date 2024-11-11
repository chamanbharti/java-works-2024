package functional.dp.solid.srp;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Journal {
    private final List<String> entries = new ArrayList<>();
    private static int count = 0;
    public void addEntry(String text){
        entries.add(""+(++count)+": "+text);
    }

    public void removeEntry(int index){
        entries.remove(index);
    }

    @Override
    public String toString() {
        return String.join(System.lineSeparator(),entries);
    }

    // below line break SRP
    public void save(String filename) throws FileNotFoundException {
        try(PrintStream out = new PrintStream(filename)){
            out.println(toString());
        }
    }

    public void load(String filename){}
    public void load(URL url){}

    public static void main(String[] args) throws FileNotFoundException {
        Journal journal = new Journal();
        journal.addEntry("I cried today");
        journal.addEntry("I ate a bug");
        System.out.println(journal);

        Persistence p = new Persistence();
        String filename = "C:\\Users\\2230849\\java_works\\NamedMethodParameters.java";
        p.saveToFile(journal,filename,true);
    }
}
class Persistence{
    public void saveToFile(Journal journal,String filename, boolean overwrite) throws FileNotFoundException {
       if(overwrite || new File(filename).exists()){
           try(PrintStream out = new PrintStream(filename)){
               out.println(toString());
           }
       }
    }
    public void load(String filename){}
    public void load(URL url){}
}
