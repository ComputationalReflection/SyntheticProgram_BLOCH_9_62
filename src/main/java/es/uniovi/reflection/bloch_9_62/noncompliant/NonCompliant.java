package es.uniovi.reflection.bloch_9_62.noncompliant;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class NonCompliant {

    public void justOne() throws Throwable {
        new BufferedReader(new FileReader("file.txt"));
    }// 1

    public void threeWithSubtype() throws IOException{
        BufferedReader br =new BufferedReader(new FileReader("file.txt"));
        br.readLine();
        new URL("spec");
    }//2

    public void threeReflectiveOp()
            throws ReflectiveOperationException {
       if(toString().contains("M"))
           throw new ClassNotFoundException();
        this.getClass().newInstance();
    }//3
    public void threeReflectiveNoThrow ()
            throws ReflectiveOperationException,InstantiationException, IllegalAccessException {
        if(toString().contains("M"))
            throw new ClassNotFoundException();
        this.getClass().newInstance();
    }//4
    public void threeReflectiveNoMayThrow ()
            throws Exception,ClassNotFoundException, IllegalAccessException {
        if(toString().contains("M"))
            throw new ClassNotFoundException();
        this.getClass().newInstance();
    }//5
    public void mixed() throws IllegalStateException{

    }
    public void m() throws ClassNotFoundException{
    }
    public void poorCatch ()
            throws ReflectiveOperationException {
            try {
                if(toString().contains("M"))
                throw new ClassNotFoundException();

                this.getClass().newInstance();
            } catch (IllegalAccessException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
    }
}
